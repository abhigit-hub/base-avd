package com.footinit.baseavd.ui

import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.footinit.baseavd.R
import com.footinit.baseavd.databinding.ItemAvdBinding


class MainGridAdapter(private var callback: Callback?): RecyclerView.Adapter<MainGridAdapter.MainViewHolder>() {
    private val avdList = mutableListOf<Drawable>()

    fun setCallback(callback: Callback) {
        this.callback = callback
    }

    fun removeCallback() {
        this.callback = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_avd, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return avdList.size
    }

    fun addItems(drawables: List<Drawable>) {
        avdList.clear()
        avdList.addAll(drawables)
        notifyDataSetChanged()
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemAvdBinding.bind(itemView)

        private fun clear() {
            binding.ivAvd.setBackgroundDrawable(null)
        }

        fun onBind(position: Int) {
            clear()
            binding.ivAvd.setImageDrawable(avdList[position])
            animateDrawable(binding.ivAvd.drawable)
            itemView.setOnClickListener { view -> animateDrawable(binding.ivAvd.drawable) }
        }
    }

    private fun animateDrawable(drawable: Drawable) {
        (drawable as Animatable).start()
    }

    interface Callback {
        fun onItemSelected(id: Int, message: String)
    }
}