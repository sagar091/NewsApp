package com.example.newsapp.utility

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Parcelable
import android.os.SystemClock
import android.text.Editable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.appcompat.widget.AppCompatTextView
import java.text.SimpleDateFormat
import java.util.*

// to check email id is valid or  not
fun emailNotValid(email: String?): Boolean {
    val matcher = Patterns.EMAIL_ADDRESS.matcher(email)
    return !matcher.matches()
}

fun String.onlyDigits(): Boolean {
    return this.all { c: Char -> c.isDigit() } ?: false
}

// to show toast
fun Context.toast(message: CharSequence) {
    if (!Utility.isNullOrEmpty(message.toString())) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

// intent function from Activity, clearAll will clean the stack
@SuppressLint("ResourceType")
fun Activity.fireIntent(cls: Class<*>, clearAll: Boolean = false) {
    val i = Intent(this, cls)
    if (clearAll) {
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    } else {
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }

    startActivity(i)
    // this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
}

// intent function from Context, clearAll will clean the stack
fun Context.fireIntent(cls: Class<*>, clearAll: Boolean = false) {
    val i = Intent(this, cls)
    if (clearAll) {
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    } else {
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    startActivity(i)
    /*(this as Activity).overridePendingTransition(
        R.anim.slide_in_right,
        R.anim.slide_out_left
    )*/
}

fun Context.fireIntent(cls: Class<*>, clearAll: Boolean = false, bundle: Bundle, key: String) {
    val i = Intent(this, cls)
    if (clearAll) {
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    } else {
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    i.putExtra(key, bundle)
    startActivity(i)
    /*(this as Activity).overridePendingTransition(
        R.anim.slide_in_right,
        R.anim.slide_out_left
    )*/
}

fun Context.fireIntent(cls: Class<*>, clearAll: Boolean = false, bundle: Bundle) {
    val i = Intent(this, cls)
    if (clearAll) {
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    } else {
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    i.putExtras(bundle)
    startActivity(i)
    /*(this as Activity).overridePendingTransition(
        R.anim.slide_in_right,
        R.anim.slide_out_left
    )*/
}

// finish the screen
fun Activity.closeScreen() {
    this.finish()
    // overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left)
//overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
}

// get string from EditText
fun EditText.toStr(): String {
    return this.text.toString().trim()
}

// close keyboard
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

// screen touch close keyboard
@SuppressLint("ClickableViewAccessibility")
fun setupUI(var0: Context?, var1: View) {
    if (var1 !is EditText) {
        var1.setOnTouchListener { var1, var2 ->
            (var0 as Activity).closeKeyPad()
            false
        }
    }
    if (var1 is ViewGroup) {
        for (var2 in 0 until var1.childCount) {
            setupUI(var0, var1.getChildAt(var2))
        }
    }
}

// for text-watcher for EditText
fun EditText.afterTextChanged(callback: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(
            s: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            callback.invoke(editable.toString())
        }
    })
}

// for EditText done button called
fun EditText.onDone(callback: () -> Unit) {
    imeOptions = EditorInfo.IME_ACTION_DONE // android:imeOptions="actionDone"
    maxLines = 1
    setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            callback.invoke()
            true
        }
        false
    }
}

//for camel case
fun Context.toCamelCase(string: String?): String? {

    // Check if String is null
    if (string == null) {
        return null
    }
    var whiteSpace = true
    val builder = StringBuilder(string) // String builder to store string
    val builderLength = builder.length

    // Loop through builder
    for (i in 0 until builderLength) {
        val c = builder[i] // Get character at builders position
        if (whiteSpace) {

            // Check if character is not white space
            if (!Character.isWhitespace(c)) {

                // Convert to title case and leave whitespace mode.
                builder.setCharAt(i, c.titlecaseChar())
                whiteSpace = false
            }
        } else if (Character.isWhitespace(c)) {
            whiteSpace = true // Set character is white space
        } else {
            builder.setCharAt(i, c.lowercaseChar()) // Set character to lowercase
        }
    }
    return builder.toString() // Return builders text
}

// for append spans
fun SpannableStringBuilder.spansAppend(
    text: CharSequence,
    flags: Int,
    vararg spans: Any
): SpannableStringBuilder {
    val start = length
    append(text)

    spans.forEach { span ->
        setSpan(span, start, length, flags)
    }

    return this
}

fun AppCompatAutoCompleteTextView.afterTextChanged(callback: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(
            s: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            callback.invoke(editable.toString())
        }
    })
}

fun Context.openGoogleMap(latitude: Double, longitude: Double) {
    //"https://www.google.com/maps/search/?api=1&query=\(latitude),\(longitude)"
    try {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/search/?api=1&query=$latitude,$longitude")
            ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        )
    } catch (e: Exception) {
        e.printStackTrace()
    }
    /*    val uri: String = java.lang.String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        startActivity(intent)*/
}

fun Context.openIntentUrl(url: String) {
    var newUrl = url
    if (!newUrl.startsWith("https://") && !newUrl.startsWith("http://")) {
        newUrl = "https://$newUrl"
    }
    try {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(newUrl)
            ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        )
    } catch (e: Exception) {
        e.printStackTrace()
    }
}


fun String.toDate(
    dateFormat: String = "yyyy-MM-dd HH:mm:ss",
    timeZone: TimeZone = TimeZone.getTimeZone("UTC")
): Date {
    val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
    parser.timeZone = TimeZone.getTimeZone("UTC")
    return parser.parse(this)
}

fun Date.changeTimeZone(
    dateFormat: String = "yyyy-MM-dd HH:mm:ss",
    timeZone: TimeZone = TimeZone.getDefault()
): Date {
    val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
    parser.timeZone = timeZone
    return parser.parse(parser.format(this))
}

fun Date.toDate(
    dateFormat: String = "yyyy-MM-dd HH:mm:ss",
    timeZone: TimeZone = TimeZone.getDefault()
): String {
    val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
    parser.timeZone = timeZone
    return parser.format(this)
}

fun Date.formatTo(dateFormat: String, timeZone: TimeZone = TimeZone.getDefault()): String {
    val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
    formatter.timeZone = timeZone
    return formatter.format(this)
}

fun View.blink(
    times: Int = Animation.INFINITE,
    duration: Long = 1000,
    offset: Long = 5L,
    minAlpha: Float = 0.0f,
    maxAlpha: Float = 1.0f,
    repeatMode: Int = Animation.REVERSE
) {
    startAnimation(AlphaAnimation(minAlpha, maxAlpha).also {
        it.duration = duration
        it.startOffset = offset
        it.repeatMode = repeatMode
        it.repeatCount = times
    })
}

fun Int.getBookingStatus(): String {
    return when (this) {
        1 -> "Pending"
        2 -> "Approved"
        3 -> "Rejected"
        4 -> "Cancelled"
        else -> "Unknown"
    }
}

// countdown timer for specific millis
fun countDownTimer(millis: Long, callback: () -> Unit) {
    object : CountDownTimer(millis, 1000) {
        override fun onTick(p0: Long) {

        }

        override fun onFinish() {
            callback.invoke()
        }
    }.start()
}

fun EditText.isBlank(): Boolean {
    return text.toString().trim().isEmpty()
}

fun AppCompatTextView.isBlank(): Boolean {
    return text.toString().trim().isEmpty()
}

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

fun Intent.putParcel(key: String = "parcel_key", parcel: Parcelable) {
    val bundle = Bundle()
    bundle.putParcelable(key, parcel)
    this.putExtra("parcel_bundle", bundle)
}

fun <T : Parcelable> Intent.getParcel(key: String = "parcel_key"): T? {
    return this.getBundleExtra("parcel_bundle")?.getParcelable(key)
}