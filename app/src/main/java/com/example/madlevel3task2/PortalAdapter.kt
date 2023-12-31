package com.example.madlevel3task2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel3task2.databinding.ItemPortalBinding

class PortalAdapter(private val portals: List<Portal>, private val clickListener: (Portal) -> Unit) : RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemPortalBinding.bind(itemView)

        fun dataBind(portal: Portal, clickListener: (Portal) -> Unit) {

            binding.tvPortalTitle.text = portal.portalText
            binding.tvPortalUrl.text = portal.portalUrlText
            itemView.setOnClickListener { clickListener(portal) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return portals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Populate ViewHolder with data that corresponds to the position in the list
        // which we are told to load
        holder.dataBind(portals[position], clickListener)
    }
}