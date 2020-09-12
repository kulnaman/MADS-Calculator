package com.example.mads_calculator.calculator

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mads_calculator.R
import com.example.mads_calculator.databinding.CalculatorFragmentBinding
import me.grantland.widget.AutofitHelper

class CalculatorFragment : Fragment() {

    private lateinit var viewModel: CalculatorViewModel
    private lateinit var binding: CalculatorFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CalculatorFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AutofitHelper.create(binding.result)

        viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)
        binding.btn0.setOnClickListener {
            binding.result.text =
                "${binding.result.text}0"
        }
        binding.btn1.setOnClickListener {
            binding.result.text =
                "${binding.result.text}1"
        }
        binding.btn2.setOnClickListener {
            binding.result.text =
                "${binding.result.text}2"
        }
        binding.btn3.setOnClickListener {
            binding.result.text =
                "${binding.result.text}3"
        }
        binding.btn4.setOnClickListener {
            binding.result.text =
                "${binding.result.text}4"
        }
        binding.btn5.setOnClickListener {
            binding.result.text =
                "${binding.result.text}5"
        }
        binding.btn6.setOnClickListener {
            binding.result.text =
                "${binding.result.text}6"
        }
        binding.btn7.setOnClickListener {
            binding.result.text =
                "${binding.result.text}7"
        }
        binding.btn8.setOnClickListener {
            binding.result.text =
                "${binding.result.text}8"
        }
        binding.btn9.setOnClickListener {
            binding.result.text =
                "${binding.result.text}9"
        }
        binding.btnDivide.setOnClickListener {
            if (TextUtils.isEmpty(binding.result.text)) showInvalidInputToast() else {
                if (TextUtils.isDigitsOnly(binding.result.text.takeLast(1)))
                    binding.result.text =
                        "${binding.result.text}/"
            }

        }
        binding.btnPlus.setOnClickListener {
            if (TextUtils.isEmpty(binding.result.text)) showInvalidInputToast() else {
                if (TextUtils.isDigitsOnly(binding.result.text.takeLast(1)))
                    binding.result.text =
                        "${binding.result.text}+"
            }
        }
        binding.btnMinus.setOnClickListener {
            if (TextUtils.isEmpty(binding.result.text)) showInvalidInputToast() else {
                if (TextUtils.isDigitsOnly(binding.result.text.takeLast(1)))
                    binding.result.text =
                        "${binding.result.text}-"
            }
        }
        binding.btnMultiply.setOnClickListener {
            if (TextUtils.isEmpty(binding.result.text)) showInvalidInputToast() else {
                if (TextUtils.isDigitsOnly(binding.result.text.takeLast(1)))
                    binding.result.text =
                        "${binding.result.text}*"
            }
        }
        binding.btnEquals.setOnClickListener {
            if (TextUtils.isEmpty(binding.result.text)) showInvalidInputToast() else {
                if (TextUtils.isDigitsOnly(binding.result.text.takeLast(1)))
                    binding.result.text =
                        viewModel.evaluate(binding.result.text.toString()).toPlainString()
            }
        }
        binding.decimal.setOnClickListener {
            if (TextUtils.isEmpty(binding.result.text)) showInvalidInputToast() else {
                if (TextUtils.isDigitsOnly(binding.result.text.takeLast(1)))
                    binding.result.text =
                        "${binding.result.text}."
            }
        }


        binding.btnClear.setOnClickListener {
            if (TextUtils.isEmpty(binding.result.text)) showInvalidInputToast() else {

                binding.result.text = binding.result.text.dropLast(1)
            }
        }
        binding.btnClear.setOnLongClickListener {
            binding.result.text = ""
            return@setOnLongClickListener true
        }
        // TODO: Use the ViewModel

    }

    fun showInvalidInputToast() {
        Toast.makeText(
            requireContext(),
            this.getString(R.string.invalid_input),
            Toast.LENGTH_LONG
        ).show()
    }
}