package com.example.newsapp.utility.extensions

import android.app.Activity
import android.content.Context
import android.os.CountDownTimer
import android.os.SystemClock
import android.view.View
import android.view.inputmethod.InputMethodManager

/*
* Definition - This extension ise used to close keypad when required
* Usage - closeKeyPad from Activity, requireContext().closeKeyPad() from fragment
* */
fun Context.closeKeyPad() {
    try {
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        var view: View? = (this as Activity).currentFocus
        if (view == null) {
            view = View(this)
        }
        inputManager.hideSoftInputFromWindow(
            view.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    } catch (e: Exception) {
        e.printStackTrace()
    }
}


/*
* Definition - This extension is used to run something after some time of inerval
* Usage - countDownTimer(5000) {
            // do something after 5-sec (5 * 1000 in millis)
        }
* */
fun countDownTimer(millis: Long, callback: () -> Unit) {
    object : CountDownTimer(millis, 1000) {
        override fun onTick(p0: Long) {

        }

        override fun onFinish() {
            callback.invoke()
        }
    }.start()
}

/*
* Definition - This extension is used to prevent double-click in fraction of sec on any view
* Usage - binding.btnNext.clickWithThrottle {
                // perform click event
            }
* */
fun View.clickWithThrottle(throttleTime: Long = 1000L, action: () -> Unit) {
    this.setOnClickListener(object : View.OnClickListener {
        private var lastClickTime: Long = 0

        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < throttleTime) return
            else action()

            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}