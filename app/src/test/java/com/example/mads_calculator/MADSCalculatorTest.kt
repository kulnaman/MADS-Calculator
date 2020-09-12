package com.example.mads_calculator

import com.example.mads_calculator.helper.MADSCalculator
import org.junit.Assert
import org.junit.Test

class MADSCalculatorTest {
    @Test
    fun testEvaluate() {
    }

    fun testGetImportance() {}

    @Test
    fun testCheckImportance() {
        val madsCalculator = MADSCalculator()
        Assert.assertEquals(2.0f, madsCalculator.evaluate("50/20+5"))
    }
}