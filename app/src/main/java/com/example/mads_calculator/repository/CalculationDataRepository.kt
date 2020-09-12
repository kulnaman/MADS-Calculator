package com.example.mads_calculator.repository

import androidx.lifecycle.LiveData
import com.example.mads_calculator.database.CalculatorDao
import com.example.mads_calculator.database.CalculatorEntity

class CalculationDataRepository(private val calculatorDao: CalculatorDao) {
    fun getlastTenWords(userId: String): LiveData<List<CalculatorEntity>> {
        return calculatorDao.getLastTenRecords(userId)
    }

    suspend fun insert(calculatorEntity: CalculatorEntity) {
        calculatorDao.insert(calculatorEntity)
    }
}