package com.example.helsanf.recyclerviewarray

import android.app.Activity
import android.os.Bundle
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class DetailActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_detail)
        val getItem = intent.getParcelableExtra<Item>(MainActivity.PUTEXTRA_CLUB)
        DetailActivityUIAnko(getItem).setContentView(this)
    }

    class DetailActivityUIAnko(val items : Item) : AnkoComponent<DetailActivity>{
        val descLiga = 1
        val imageLiga = 2
        val nama_liga = 3
        override fun createView(ui: AnkoContext<DetailActivity>)= with(ui) {
           scrollView {
            relativeLayout {
                imageView {
                    id = imageLiga

                    Picasso.get()
                            .load(items.image!!)
                            .into(this)
                }.lparams(width = dip(100), height = dip(100)) {
                    centerHorizontally()
                    topMargin = dip(10)
                }
                textView {
                    id = nama_liga
                    text = items.name
                }.lparams(width = wrapContent, height = wrapContent) {
                    below(imageLiga)
                    centerHorizontally()
                    topMargin = dip(5)
                }
                textView {
                    id = descLiga
                    text = items.desc
                }.lparams(width = wrapContent, height = wrapContent) {
                    below(nama_liga)
                }
            }
        }
    }
    }
}
