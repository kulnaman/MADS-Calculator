package com.example.mads_calculator.history

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mads_calculator.database.CalculatorEntity
import com.example.mads_calculator.database.CalculatorRoomDatabase
import com.example.mads_calculator.repository.CalculationDataRepository
import com.google.firebase.auth.FirebaseAuth

class HistoryViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var repository: CalculationDataRepository
    private lateinit var auth: FirebaseAuth
     lateinit var  lastTenExpressionsAndResults: LiveData<List<CalculatorEntity>>

    init {
        val calculatorDao = CalculatorRoomDatabase.getDatabase(application).calculatorDao()
        repository = CalculationDataRepository(calculatorDao)
        auth = FirebaseAuth.getInstance()
        lastTenExpressionsAndResults= FirebaseAuth.getInstance().uid?.let {
            repository.getlastTenWords(
                it
            )
        }!!
    }


//    @ExperimentalStdlibApi
//    fun addResultToResultList(query: String, result: Float) {
//        val searchAndResultQuery = SearchAndResultQuery(query, result)
//        CalculationDataRepository.addResultToResultList(searchAndResultQuery)
//    }
}