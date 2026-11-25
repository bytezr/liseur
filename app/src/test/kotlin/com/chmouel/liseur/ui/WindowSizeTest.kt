package com.chmouel.liseur.ui

import androidx.compose.ui.unit.dp
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class WindowSizeTest {

    @Test
    fun `a phone is compact`() {
        assertEquals(WidthClass.COMPACT, widthClassOf(360.dp))
        assertEquals(WidthClass.COMPACT, widthClassOf(411.dp))
        assertEquals(WidthClass.COMPACT, widthClassOf(599.dp))
    }

    @Test
    fun `a small tablet or e-ink reader is medium`() {
        assertEquals(WidthClass.MEDIUM, widthClassOf(600.dp))
        // Boox Go 7, 1264px at 300dpi.
        assertEquals(WidthClass.MEDIUM, widthClassOf(674.dp))
        assertEquals(WidthClass.MEDIUM, widthClassOf(839.dp))
    }

    @Test
    fun `a tablet is expanded`() {
        assertEquals(WidthClass.EXPANDED, widthClassOf(840.dp))
        assertEquals(WidthClass.EXPANDED, widthClassOf(1280.dp))
    }

    @Test
    fun `a phone keeps the cover size it had`() {
        assertEquals(108.dp, coverMinSize(411.dp))
    }

    @Test
    fun `covers grow with the screen`() {
        assertTrue(coverMinSize(674.dp) > coverMinSize(411.dp))
        assertTrue(coverMinSize(1280.dp) > coverMinSize(674.dp))
    }

    @Test
    fun `a phone caps nothing, so sheets stay full width`() {
        assertEquals(androidx.compose.ui.unit.Dp.Unspecified, contentWidthCap(411.dp))
    }

    @Test
    fun `wider screens cap sheet content`() {
        assertEquals(560.dp, contentWidthCap(1280.dp))
    }
}
