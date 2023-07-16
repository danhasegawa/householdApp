package com.dh.householdapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Upsert
    suspend fun upsertExpense(expense: Expense)

    @Delete
    suspend fun deleteExpense(expense: Expense)

    @Query("SELECT * FROM expense")
    fun getAllExpense(): Flow<List<Expense>>

    @Query("SELECT * FROM expense ORDER BY description ASC")
    fun getExpenseByDescription(): Flow<List<Expense>>

    @Query("SELECT * FROM expense ORDER BY value ASC")
    fun getExpenseByValue(): Flow<List<Expense>>

}
