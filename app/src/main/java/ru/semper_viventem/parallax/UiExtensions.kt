package ru.semper_viventem.parallax

import android.content.res.Resources
import android.os.Build
import android.support.annotation.LayoutRes
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun View.visible(visible: Boolean, useGone: Boolean = true) {
    this.visibility = if (visible) View.VISIBLE else if (useGone) View.GONE else View.INVISIBLE
}

fun Resources.color(colorRes: Int) =
    if (Build.VERSION.SDK_INT >= 23) {
        this.getColor(colorRes, null)
    } else {
        this.getColor(colorRes)
    }

fun spannedFromHtml(source: String): Spanned =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(source, Html.FROM_HTML_MODE_COMPACT)
    } else {
        Html.fromHtml(source)
    }