package com.github.malayP.decorations.dataGen

interface IWidgetEditable {
    var relativeX: Double
    var relativeY: Double
    fun onEditClick(mouseX: Double, mouseY: Double) {}
    fun onEditDrag(mouseX: Double, mouseY: Double, dragX: Double, dragY: Double) {}
    fun onEditRelease(mouseX: Double, mouseY: Double) {}

    fun mouseClicked(mouseX: Double, mouseY: Double, button: Int, isEditMode: Boolean): Boolean
    fun mouseReleased(mouseX: Double, mouseY: Double, button: Int, isEditMode: Boolean): Boolean
    fun mouseDragged(
        mouseX: Double,
        mouseY: Double,
        button: Int,
        dragX: Double,
        dragY: Double,
        isEditMode: Boolean
    ): Boolean
}