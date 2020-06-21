package com.danielvilha.luasapp.utils.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danielvilha.luasapp.data.model.Tram

/**
 * Created by danielvilha on 21/06/20
 */
class TramAdapter(private var list: List<Tram>): RecyclerView.Adapter<TramViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TramViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TramViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: TramViewHolder, position: Int) {
        val item: Tram = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size

    fun update(list: List<Tram>?) {
        this.list = list ?: ArrayList()
        notifyDataSetChanged()
    }
}