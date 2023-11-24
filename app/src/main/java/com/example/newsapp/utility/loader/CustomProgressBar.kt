package com.example.newsapp.utility.loader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.brokerapp.helper.AppConstants
import com.example.newsapp.R
import com.example.newsapp.databinding.ProgressHudBinding


class CustomProgressBar : DialogFragment() {

    private lateinit var progressView: View
    private lateinit var onCancelCallBack: OnCancelCallBack
    private lateinit var binding: ProgressHudBinding
    fun setOnCancelCallBack(onCancelCallBack: OnCancelCallBack) {
        this.onCancelCallBack = onCancelCallBack
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProgressHudBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
    }

    private fun setUpView(view: View) {
        binding.message.text = arguments?.getString(AppConstants.ALERT_TITLE)
    }

    override fun onStart() {
        super.onStart()
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.ProgressHUD)
    }

    companion object {

        const val TAG = "CustomProgressBar"

        fun with(title: String?): CustomProgressBar {
            val args = Bundle()
            args.putString(AppConstants.ALERT_TITLE, title)
            val fragment = CustomProgressBar()
            fragment.arguments = args
            return fragment
        }
    }

    fun changeText(text: String) {
        binding.message.text = text
    }

    interface OnCancelCallBack {
        fun onCancel()
    }
}