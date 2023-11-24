package com.example.newsapp.utility.extensions

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Parcelable

/*
* Definition - This extension is used to open activity from any Context
* Usage - fireIntent(DetailActivity::class.java)
* */
fun Context.fireIntent(cls: Class<*>, clearAll: Boolean = false) {
    val i = Intent(this, cls)
    if (clearAll) {
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    } else {
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    startActivity(i)
    /*(this as Activity).overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)*/
}


/*
* Definition - This extension is used to pass any parcelable object from first view to second view
* Usage - intent.putParcelableObject("news", data)
* */
fun Intent.putParcelableObject(key: String, value: Parcelable) {
    putExtra(key, value)
}


/*
* Definition - This extension is used to get parcelable object from second view to first view
* Usage - data = intent.getParcelableObject("news") as Data
* */
fun Intent.getParcelableObject(key: String): Parcelable? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelableExtra(key, Parcelable::class.java)
    } else {
        getParcelableExtra(key)
    }
}


/*
* Definition - This extension is used to open activity from any Context with bundle values
* Usage - fireIntent(DetailActivity::class.java)
* */
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