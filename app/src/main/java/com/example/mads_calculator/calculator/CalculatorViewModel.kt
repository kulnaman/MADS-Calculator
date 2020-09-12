package com.example.mads_calculator.calculator

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mads_calculator.database.CalculatorEntity
import com.example.mads_calculator.database.CalculatorRoomDatabase
import com.example.mads_calculator.helper.MADSCalculator
import com.example.mads_calculator.repository.CalculationDataRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.math.BigDecimal

class CalculatorViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var repository: CalculationDataRepository
    private lateinit var auth: FirebaseAuth

    init {
        val calculatorDao = CalculatorRoomDatabase.getDatabase(application).calculatorDao()
        repository = CalculationDataRepository(calculatorDao)
        auth = FirebaseAuth.getInstance()
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun evaluate(expression: String): BigDecimal {
        val madsCalc = MADSCalculator()
        val result = madsCalc.evaluate(expression)

        insert(CalculatorEntity(0, auth.currentUser!!.uid, expression, result.toString()))

        return result
    }

    fun insert(calculatorEntity: CalculatorEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(calculatorEntity)
    }

//    @ExperimentalStdlibApi
//    fun addResultToResultList(query: String, result: Float) {
//        val searchAndResultQuery = SearchAndResultQuery(query, result)
//        CalculationDataRepository.addResultToResultList(searchAndResultQuery)
//    }
}