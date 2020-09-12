package com.example.mads_calculator.helper

import java.lang.Exception
import java.math.BigDecimal
import java.math.MathContext
import java.util.*

class MADSCalculator {
    private val operationList = listOf('*', '+', '/', '-')
    private val importanceList = listOf(0, 1, 2, 3)

    fun evaluate(expression: String): BigDecimal {
        try {
            val expressionArray = expression.toCharArray()
            //Used to store operator with lowest importance operator at last
            val operatorStack = Stack<Char>()
            //store number in a stack
            val numberStack = Stack<BigDecimal>()
            var i = 0
            while (i < expressionArray.size) {
                if (expressionArray[i] == ' ') continue
                if (!isOperator(expressionArray[i])) {
                    //storing consecutive number in a stack
                    val numberString = StringBuilder()
                    while (i < expressionArray.size && expressionArray[i] != ' ' && !isOperator(
                            expressionArray[i]
                        )
                    )
                        numberString.append(expressionArray[i++])
                    --i
                    numberStack.add(numberString.toString().toBigDecimal())
                    //doing arithmetic operation
                } else if (isOperator(expressionArray[i])) {
                    while (!operatorStack.empty() && checkImportance(
                            expressionArray[i],
                            operatorStack.peek()
                        )
                    )
                        numberStack.push(
                            calculateArithmeticValue(
                                operatorStack.pop(),
                                numberStack.pop(),
                                numberStack.pop()
                            )
                        )
                    operatorStack.push(expressionArray[i])
                }
                i++
            }
            while (!operatorStack.empty())
                numberStack.push(
                    calculateArithmeticValue(
                        operatorStack.pop(),
                        numberStack.pop(),
                        numberStack.pop()
                    )
                )
            return numberStack.pop()
        } catch (e: Exception) {
            e.printStackTrace()
            return BigDecimal.ZERO
        }
    }

    private fun getImportance(operator: Char): Int {
        return importanceList[operationList.indexOf(operator)]

    }

    //check importance of the operator from the importanceList
    private fun checkImportance(operatorA: Char, operatorB: Char): Boolean {
        return getImportance(operatorB) <= getImportance(operatorA)
    }

    private fun calculateArithmeticValue(
        operation: Char,
        numberA: BigDecimal,
        numberB: BigDecimal
    ): BigDecimal {
        return when (operation) {
            '*' -> numberB.multiply(numberA,MathContext.DECIMAL128)
            '+' -> numberB.add(numberA,MathContext.DECIMAL128)
            '/' -> numberB.divide(numberA,MathContext.DECIMAL128)
            '-' -> numberB.subtract(numberA, MathContext.DECIMAL128)
            else -> BigDecimal.ZERO
        }
    }

    private fun isOperator(char: Char): Boolean {
        return operationList.contains(char)
    }

}