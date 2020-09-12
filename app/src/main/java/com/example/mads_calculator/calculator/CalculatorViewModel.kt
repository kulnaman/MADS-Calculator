package com.example.mads_calculator.calculator

import androidx.lifecycle.ViewModel
import com.example.mads_calculator.helper.MADSCalculator
import com.example.mads_calculator.model.SearchAndResultQuery
import com.example.mads_calculator.repository.CalculationDataRepository
import java.nio.file.Files.size
import java.util.LinkedHashMap

class CalculatorViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var searchQueryAndResultList = mutableListOf<SearchAndResultQuery>()
    @OptIn(ExperimentalStdlibApi::class)
    fun evaluate(expression: String): Float {
        val madsCalc = MADSCalculator()
        val result = madsCalc.evaluate(expression)
        addResultToResultList(expression, result)
        return result
    }

    @ExperimentalStdlibApi
    fun addResultToResultList(query: String, result: Float) {
        val searchAndResultQuery = SearchAndResultQuery(query, result)
        CalculationDataRepository.addResultToResultList(searchAndResultQuery)
    }
}