package com.example.newsapp.utility.extensions

/*
* Definition - This extension is used to check the string contains only digits or not
* Usage - strValue.containsOnlyDigits() will return true for "1234", and return false for "A1B2C3"
* */
fun String.containsOnlyDigits(): Boolean {
    return this.all { c: Char -> c.isDigit() } ?: false
}