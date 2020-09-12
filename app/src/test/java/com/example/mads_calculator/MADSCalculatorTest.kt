package com.example.mads_calculator

import com.example.mads_calculator.helper.MADSCalculator
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class MADSCalculatorTest {
    @Test
    fun testEvaluate() {
    }


    @Test
    fun testCheckImportance() {

        val madsCalculator = MADSCalculator()
        Assert.assertEquals(BigDecimal(2.0), madsCalculator.evaluate("50/20+5"))

    }
    @Test
    fun testCheckImportance2() {

        val madsCalculator = MADSCalculator()
        Assert.assertEquals(BigDecimal(5.0), madsCalculator.evaluate("25-2*10"))

    }
    @Test
    fun testCheckImportance3() {

        val madsCalculator = MADSCalculator()
        Assert.assertEquals(BigDecimal(-15.0), madsCalculator.evaluate("10/2-20"))

    }
    @Test
    fun testCheckImportance4() {

        val madsCalculator = MADSCalculator()
        Assert.assertEquals(BigDecimal(5.0), madsCalculator.evaluate("10-2-3"))

    }
    @Test
    fun testCheckImportance5() {

        val madsCalculator = MADSCalculator()
        Assert.assertEquals(BigDecimal(1.0), madsCalculator.evaluate("10/2/5"))

    }
    @Test
    fun testCheckImportance6() {

        val madsCalculator = MADSCalculator()
        Assert.assertEquals(BigDecimal(1.0), madsCalculator.evaluate("10/2/4+1"))

    }

}