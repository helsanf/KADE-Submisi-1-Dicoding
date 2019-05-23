package com.example.helsanf.recyclerviewarray

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : Activity() {
    private var items : MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        MainActivityUIAnko(items).setContentView(this)

    }
    companion object {
        var PUTEXTRA_CLUB = "putextra_club"
    }

    class MainActivityUIAnko(val items : List<Item>): AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            constraintLayout{
                lparams(matchParent, matchParent)

                recyclerView {
                    layoutManager = LinearLayoutManager(context)
                    adapter = RecyclerViewAdapter(context,items){
                        startActivity<DetailActivity>(PUTEXTRA_CLUB to it)
                    }
                }.lparams(matchParent, matchParent)
            }
        }
    }
    private fun initData(){
        val name = resources.getStringArray(R.array.liga_name)
        val image = resources.obtainTypedArray(R.array.liga_image)
        val desc = resources.getStringArray(R.array.data_liga)

        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],image.getResourceId(i, 0),desc[i]))
        }

        //Recycle the typed array
        image.recycle()
    }
}
