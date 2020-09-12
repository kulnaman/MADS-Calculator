package com.example.mads_calculator.repository

import com.example.mads_calculator.model.SearchAndResultQuery

object CalculationDataRepository {
    var searchQueryAndResultList = mutableListOf<SearchAndResultQuery>()
    @ExperimentalStdlibApi
    fun addResultToResultList(searchAndResultQuery: SearchAndResultQuery) {
        if (searchQueryAndResultList.size < 10) {
            searchQueryAndResultList.add(0, searchAndResultQuery)
        } else {
            searchQueryAndResultList.removeLast()
            searchQueryAndResultList.add(0, searchAndResultQuery)
        }
    }
}