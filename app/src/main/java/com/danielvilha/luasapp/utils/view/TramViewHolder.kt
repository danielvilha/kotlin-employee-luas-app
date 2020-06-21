package com.danielvilha.luasapp.utils.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.danielvilha.luasapp.R
import com.danielvilha.luasapp.data.model.Tram

/**
 * Created by danielvilha on 21/06/20
 */
class TramViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.item_tram, parent, false)) {
    private var destination: TextView? = null
    private var dueMins: TextView? = null

    init {
        destination = itemView.findViewById(R.id.txv_destination)
        dueMins = itemView.findViewById(R.id.txv_due_mins)
    }

    fun bind(item: Tram) {
        destination?.text = item.destination
        dueMins?.text = item.dueMins
    }
}