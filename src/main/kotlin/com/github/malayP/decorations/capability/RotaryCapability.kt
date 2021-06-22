package com.github.malayP.decorations.capability

import com.github.malayP.decorations.Decorations.Companion.logger
import com.github.malayP.decorations.block.machine.engine.EnergySource
import com.github.malayP.decorations.block.machine.relay.*
import com.github.malayP.decorations.capability.RotaryCapability.RotaryCapabilityContentImpl
import com.github.zomb_676.fantasySoup.EnumShaftMaterial
import com.github.zomb_676.fantasySoup.capability.ICapability
import com.github.zomb_676.fantasySoup.capability.InnerClass
import com.github.zomb_676.fantasySoup.getBooleanArray
import com.github.zomb_676.fantasySoup.putBooleanArrayToSingle
import com.github.zomb_676.fantasySoup.unsafeGet
import net.minecraft.nbt.CompoundNBT
import net.minecraft.nbt.INBT
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.Direction
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.Capability.IStorage
import net.minecraftforge.common.capabilities.CapabilityInject
import java.util.concurrent.Callable

@InnerClass(RotaryCapabilityContentImpl::class)
object RotaryCapability : ICapability<RotaryCapabilityContentImpl> {

    abstract class RotaryCapabilityContent {
        abstract fun canInputFrom(side: Direction): Boolean
        abstract fun canOutputFrom(side: Direction): Boolean

        /**
         * @param side the input face that need change
         * @param torque don't set it if not need to set it
         * @param speed don't set it if not need to set it
         * @return true if success
         */
        abstract fun setInputFrom(side: Direction, torque: Int? = null, speed: Int? = null): Boolean
        abstract fun getOutputFrom(side: Direction): Energy
        abstract fun getOutputTorqueFrom(side: Direction): Int
        abstract fun getOutputSpeedFrom(side: Direction): Int
        abstract val energySource: EnergySource
        abstract fun hardnessTorqueTest(torqueIn: Int): Boolean
        abstract fun hardnessSpeedTest(speedIn: Int): Boolean
        abstract fun hardnessEnergyTest(torqueIn: Int, speedIn: Int): Boolean
        abstract fun getShaftMaterial(): EnumShaftMaterial

        /**
         * override this method for you want to change IO direction , other wise it will throw an exception
         * @param inOrOut true if the modification is in
         * @return modification success or not
         */
        open fun modifyIoDirection(inOrOut: Boolean, origin: Direction, target: Direction): Boolean =
            throw RuntimeException("the block didn't support IO modification")

        /**
         * calculate input value to output value
         */
        abstract fun calculate()

        /**
         * @param direction if parameter is null , update all directions
         */
        abstract fun getInputData(direction: Direction? = null)

        /**
         * notify the specify direction's block update
         */
        abstract fun updateOutputData(direction: Direction)

        /**
         * update the all update facing to notify other blocks
         */
        abstract fun updateOutputDataFromAllFaces()

        /**
         * call this method when the combined tileEntity is invalid
         */
        open fun invalid() {}
    }

    /**
     * most logical is written , only need to implement some method , NICE!
     */
    abstract class RotaryCapabilityContentImpl(
        private val combinedShaftMaterial: EnumShaftMaterial,
        private val combinedTileEntity: TileEntity,
    ) : RotaryCapabilityContent() {
        var indexInArray: BooleanArray = booleanArrayOf(false, false, false, false, false, false)
        var indexOutArray: BooleanArray = booleanArrayOf(false, false, false, false, false, false)
        var indexTorqueArray: IntArray = intArrayOf(0, 0, 0, 0, 0, 0)
        var indexSpeedArray: IntArray = intArrayOf(0, 0, 0, 0, 0, 0)
        override val energySource: EnergySource = EnergySource()

        override fun canInputFrom(side: Direction): Boolean = indexInArray[side.index]

        override fun canOutputFrom(side: Direction): Boolean = indexOutArray[side.index]

        override fun setInputFrom(side: Direction, torque: Int?, speed: Int?): Boolean {
            if (torque == null && speed == null) return false
            if (canInputFrom(side)) {
                torque?.let { indexTorqueArray[side.index] = it }
                speed?.let { indexSpeedArray[side.index] = it }
                calculate()
                updateOutputDataFromAllFaces()
                return true
            } else throw RuntimeException("can't set input from ${side.name}")
        }

        override fun getOutputFrom(side: Direction): Energy =
            if (canOutputFrom(side)) Energy(indexTorqueArray[side.index], indexSpeedArray[side.index], energySource)
            else throw RuntimeException("can't get output from ${side.name}")

        override fun getOutputTorqueFrom(side: Direction): Int =
            if (canOutputFrom(side)) indexTorqueArray[side.index] else
                throw RuntimeException("can't get output from ${side.name}")

        override fun getOutputSpeedFrom(side: Direction): Int =
            if (canOutputFrom(side)) indexSpeedArray[side.index] else
                throw RuntimeException("can't get output from ${side.name}")

//        override fun getEnergySource(): EnergySource = energySources

        override fun hardnessTorqueTest(torqueIn: Int): Boolean = combinedShaftMaterial.maxTorture > torqueIn
        override fun hardnessSpeedTest(speedIn: Int): Boolean = combinedShaftMaterial.maxSpeed > speedIn
        override fun hardnessEnergyTest(torqueIn: Int, speedIn: Int): Boolean =
            hardnessTorqueTest(torqueIn) && hardnessSpeedTest(speedIn)

        override fun getShaftMaterial(): EnumShaftMaterial = combinedShaftMaterial
        override fun modifyIoDirection(inOrOut: Boolean, origin: Direction, target: Direction): Boolean {
            if (inOrOut) {
                return if (canInputFrom(origin)) {
                    if (!indexInArray[target.index]) {
                        indexInArray[origin.index] = false
                        indexInArray[target.index] = true
                        getInputData(target)
                        calculate()
                        updateOutputDataFromAllFaces()
                        true
                    } else {
                        logger.error(" origin block can't set input energy from ${origin.name2} ")
                        false
                    }
                } else {
                    logger.error(" origin block can't input energy from ${origin.name2} ")
                    false
                }
            } else {
                return if (canOutputFrom(origin)) {
                    if (!indexOutArray[target.index]) {
                        indexOutArray[origin.index] = false
                        indexOutArray[target.index] = true
                        indexSpeedArray[target.index] = indexSpeedArray[origin.index]
                        indexTorqueArray[target.index] = indexSpeedArray[origin.index]
                        indexSpeedArray[origin.index] = 0
                        indexTorqueArray[origin.index] = 0
                        calculate()
                        updateOutputDataFromAllFaces()
                        true
                    } else {
                        logger.error(" origin block can't set output energy from ${origin.name2} ")
                        false
                    }
                } else {
                    logger.error(" origin block can't output energy from ${origin.name2} ")
                    false
                }
            }
        }

        //TODO shaft material tier differ
        //TODO energy source check
        /**
         * @param direction the direction to detect
         * @return direction : the capability's face
         */
        private tailrec fun tractSource(pos: BlockPos, direction: Direction, world: World): FaceCapabilityPair? {
            val blockPos = combinedTileEntity.pos.offset(direction)
            val blockState = world.getBlockState(blockPos)
            if (blockState.block is ShaftBlock) {
                return tractSource(blockPos, direction, world)
            }
            if (blockState.block is ShaftCross) {
                return tractSource(blockPos, direction, world)
            }
//            if (blockState.block is BevelGear){
//                return track()
//            }
            val capability = world.getTileEntity(blockPos)?.getCapability(ROTARY__CAPABILITY!!)
            if (capability?.isPresent == true) {
                return FaceCapabilityPair(direction.opposite, capability.unsafeGet())
            }
            return null
        }

        //TODO shaft material tier differ
        //TODO energy source check
        /**
         * @param targetDirection the direction to detect
         * @return direction : the capability's face
         */
        private tailrec fun trackTarget(
            pos: BlockPos,
            originDirection: Direction,
            targetDirection: Direction,
            world: World
        ): FaceCapabilityPair? {
            val blockPos = pos.offset(targetDirection)
            val blockState = world.getBlockState(blockPos)
            if (blockState.block is ShaftBlock) {
                val shaftTileEntity = world.getTileEntity(blockPos) as ShaftTileEntity
                shaftTileEntity.energySource = energySource
                shaftTileEntity.torque = indexTorqueArray[originDirection.index]
                shaftTileEntity.speed = indexSpeedArray[originDirection.index]
                return trackTarget(blockPos, originDirection, targetDirection, world)
            }
            if (blockState.block is ShaftCross) {
                return trackTarget(blockPos, originDirection, targetDirection, world)
            }
            if (blockState.block is BevelGear) {
                val bevelGearTileEntity = world.getTileEntity(pos) as BevelGearTileEntity
                if (bevelGearTileEntity.getInputSide() == targetDirection.opposite) {
                    return trackTarget(blockPos, originDirection, bevelGearTileEntity.getOutputSide(), world)
                } else return null
            }
            val capability = world.getTileEntity(blockPos)?.getCapability(ROTARY__CAPABILITY!!)
            if (capability?.isPresent == true) {
                return FaceCapabilityPair(targetDirection.opposite, capability.unsafeGet())
            }
            return null
        }

        override fun getInputData(direction: Direction?) {
            if (direction == null) {
                Direction.values().forEach { dir ->
                    tractSource(combinedTileEntity.pos, dir, combinedTileEntity.world!!)?.run {
                        indexSpeedArray[dir.index] = this.capability.getOutputSpeedFrom(this.direction)
                        indexTorqueArray[dir.index] = this.capability.getOutputTorqueFrom(this.direction)
                    }
                }
            } else {
                tractSource(combinedTileEntity.pos, direction, combinedTileEntity.world!!)?.run {
                    indexSpeedArray[direction.index] = this.capability.getOutputSpeedFrom(this.direction)
                    indexTorqueArray[direction.index] = this.capability.getOutputTorqueFrom(this.direction)
                }
            }
        }

        override fun updateOutputData(direction: Direction) {
            trackTarget(combinedTileEntity.pos, direction, direction, combinedTileEntity.world!!)?.run {
                capability.setInputFrom(this.direction, getOutputTorqueFrom(direction), getOutputSpeedFrom(direction))
                capability.calculate()
                capability.updateOutputDataFromAllFaces()
            }
        }

        override fun updateOutputDataFromAllFaces() {
            Direction.values().forEach { updateOutputData(it) }
        }

        override fun invalid() {
            indexTorqueArray = intArrayOf(0, 0, 0, 0, 0, 0)
            indexTorqueArray = intArrayOf(0, 0, 0, 0, 0, 0)
            energySource.clear()
            updateOutputDataFromAllFaces()
        }
    }

    @JvmField
    @CapabilityInject(RotaryCapabilityContent::class)
    var ROTARY__CAPABILITY: Capability<RotaryCapabilityContent>? = null

    override fun storageGuide(): IStorage<RotaryCapabilityContentImpl> =
        object : IStorage<RotaryCapabilityContentImpl> {
            override fun writeNBT(
                capability: Capability<RotaryCapabilityContentImpl>,
                instance: RotaryCapabilityContentImpl,
                side: Direction?,
            ): INBT {
                val nbt = CompoundNBT()
                nbt.putBooleanArrayToSingle("indexInArray", instance.indexInArray)
                nbt.putBooleanArrayToSingle("indexOutArray", instance.indexOutArray)
                nbt.putIntArray("indexSpeedArray", instance.indexSpeedArray)
                nbt.putIntArray("indexTorqueArray", instance.indexTorqueArray)
                return nbt
            }

            override fun readNBT(
                capability: Capability<RotaryCapabilityContentImpl>,
                instance: RotaryCapabilityContentImpl,
                side: Direction?,
                nbt: INBT?,
            ) {
                instance.indexInArray = (nbt as CompoundNBT).getBooleanArray("indexInArray")
                instance.indexOutArray = nbt.getBooleanArray("indexOutArray")
                instance.indexSpeedArray = nbt.getIntArray("indexSpeedArray")
                instance.indexTorqueArray = nbt.getIntArray("indexTorqueArray")
            }

        }

    override fun factory(): Callable<RotaryCapabilityContentImpl> =
        Callable {
            object : RotaryCapabilityContentImpl(EnumShaftMaterial.BEDROCK, null as TileEntity) {
                override fun calculate() {
                    TODO("Not yet implemented")
                }
            }
        }


}

data class Energy(var torque: Int, var speed: Int, val energySource: EnergySource)
data class FaceCapabilityPair(var direction: Direction, var capability: RotaryCapability.RotaryCapabilityContent)