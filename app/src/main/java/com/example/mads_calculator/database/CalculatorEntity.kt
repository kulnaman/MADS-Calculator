package com.example.mads_calculator.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "calculator_record_table")
data class CalculatorEntity(
    @PrimaryKey(autoGenerate = true) val id: Int=0,

    @ColumnInfo(name = "userId") val userId: String,
    @ColumnInfo(name = "expression") val expression: String,
    @ColumnInfo(name = "result") val result: String
)
