package com.example.helsanf.recyclerviewarray

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class RecyclerViewAdapter(private val context: Context,private val items:List<Item> , private val listener:(Item)->Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
    override fun onCreateViewHolder(viewgroup: ViewGroup, viewType: Int) =
            ViewHolder(ItemListAnko().createView(AnkoContext.create(viewgroup.context, viewgroup)))

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position],listener)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {
        private val name = containerView.findViewById<TextView>(ItemListAnko.name)
        private val image = containerView.findViewById<ImageView>(ItemListAnko.imageBola)

        fun bindItem(items:Item , listener: (Item) -> Unit){
            name.text = items.name
            items.image?.let { Picasso.get().load(it).into(image) }
            itemView.setOnClickListener { listener(items) }
        }
    }

}