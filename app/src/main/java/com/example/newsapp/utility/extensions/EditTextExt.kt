package com.example.newsapp.utility.extensions

import android.graphics.drawable.GradientDrawable
import android.util.Patterns
import android.view.inputmethod.EditorInfo
import androidx.appcompat.widget.AppCompatEditText


/*
* Definition - This extension is used to customize AppCompatEditText
* Usage - edtSearch.makeCustom(
            resources.getDimension(R.dimen.dimen_8dp),
            ContextCompat.getColor(this, R.color.pale_grey),
            ContextCompat.getColor(this, R.color.app_color),
            resources.getDimension(R.dimen.dimen_1dp)
        )
* */
fun AppCompatEditText.makeCustom(
    cornerRadius: Float = 0F,
    fillColor: Int = 0,
    strokeColor: Int = 0,
    strokeThickNess: Float = 0F
) {

    if (cornerRadius != 0f || fillColor != 0 || (strokeColor != 0 && strokeThickNess != 0f)) {
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.RECTANGLE

        if (cornerRadius != 0f) {
            shape.cornerRadius = cornerRadius
        }
        if (fillColor != 0) {
            shape.setColor(fillColor)
        }
        if (strokeThickNess != 0F && strokeColor != 0) {
            shape.setStroke(strokeThickNess.toInt(), strokeColor)
        }

        this.background = shape

        setPadding(16, 24, 16, 24)
    }

}


/*
* Definition - This extension is used to check entered email id is valid or not
* Usage - edtEmail.checkValidEmail() will return true of the email-id is valid
* */
fun AppCompatEditText.checkValidEmail(): Boolean {
    val matcher = Patterns.EMAIL_ADDRESS.matcher(this.text.toString().trim())
    return matcher.matches()
}


/*
* Definition - This extension is used to get the entered value without pre/post whitespace
* Usage - edtText.getValue() will the return the string entered in edtText
* */
fun AppCompatEditText.getValue(): String {
    return this.text.toString().trim()
}


/*
* Definition - This extension is used to check if the value is entered or not
* Usage - edtText.isBlank() will return true if no value entered in edtText
* */
fun AppCompatEditText.isBlank(): Boolean {
    return this.text.toString().trim().isEmpty()
}


/*
* Definition - This extension is used to trigger android:imeOptions="actionDone" event
* Usage - edtSearch.onDone {
            // perform operation if user tap on Done from keypad for edtSearch
        }
* */
fun AppCompatEditText.onDone(callback: () -> Unit) {
    imeOptions =
        EditorInfo.IME_ACTION_DONE // this line is equivalent to android:imeOptions="actionDone". Do not need to write this line in XML
    maxLines = 1
    setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            callback.invoke()
            return@setOnEditorActionListener true
        }
        return@setOnEditorActionListener false
    }
}