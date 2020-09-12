package com.example.mads_calculator.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CalculatorDao {
    @Query("Select * from calculator_record_table")
    fun getAllDetails(): LiveData<List<CalculatorEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(calculatorEntity: CalculatorEntity)

    @Query("DELETE FROM calculator_record_table")
    suspend fun deleteAll()

    @Query("select * from (select * from calculator_record_table where userId=:userId order by id DESC limit 10) order by id ASC;")
    fun getLastTenRecords(userId: String): LiveData<List<CalculatorEntity>>
}
