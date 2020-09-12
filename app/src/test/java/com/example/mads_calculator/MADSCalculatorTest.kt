package com.example.mads_calculator

import com.example.mads_calculator.helper.MADSCalculator
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class MADSCalculatorTest {
    @Test
    fun testEvaluate() {
    }

    fun testGetImportance() {}

    @Test
    fun testCheckImportance() {
//
//        val madsCalculator = MADSCalculator()
//        Assert.assertEquals(2.0f, madsCalculator.evaluate("50/20+5"))
        val a = BigDecimal.valueOf(5.8)
        val b = BigDecimal.valueOf(5.6)
        val sub = a.subtract(b)
        Assert.assertEquals(sub, BigDecimal.valueOf(0.2))
    }
}