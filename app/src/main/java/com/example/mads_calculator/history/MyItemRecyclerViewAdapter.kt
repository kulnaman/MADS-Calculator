package com.example.mads_calculator.history

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mads_calculator.R
import com.example.mads_calculator.database.CalculatorEntity

import me.grantland.widget.AutofitHelper

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val values: List<CalculatorEntity>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_history, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        AutofitHelper.create(holder.idView)
        holder.idView.text = item.expression
        holder.contentView.text = item.result
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.query)
        val contentView: TextView = view.findViewById(R.id.resultItem)


        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}