package com.example.helsanf.recyclerviewarray

import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class ItemListAnko : AnkoComponent<ViewGroup> {
    companion object {
        val imageBola = 1
        val name = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>)= with(ui) {
        linearLayout {
            orientation = LinearLayout.HORIZONTAL
            padding = dip(16)

            imageView {
                id = imageBola
                setImageResource(R.drawable.img_liga_inggris)
            }.lparams(width = dip(50), height = dip(50))
            textView {
                id = name
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER_VERTICAL
                margin = dip(10)
            }
        }
    }
}