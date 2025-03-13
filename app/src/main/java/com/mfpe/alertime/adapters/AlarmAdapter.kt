package com.mfpe.alertime.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mfpe.alertime.R
import com.mfpe.alertime.databinding.AlarmaItemBinding
import com.mfpe.alertime.model.Alarm

class AlarmAdapter(private var alarms: List<Alarm>, private val selectionListener: SelectionListener) : RecyclerView.Adapter<AlarmAdapter.ViewHolder>() {

    private val selectedItems = mutableSetOf<Int>()

    interface SelectionListener {
        fun onSelectionChanged(selectedCount: Int)
    }

    inner class ViewHolder(val binding: AlarmaItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmAdapter.ViewHolder {
        val bind = AlarmaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(bind)
    }

    override fun onBindViewHolder(holder: AlarmAdapter.ViewHolder, position: Int) {
        with(holder) {
            with(alarms[position]) {
                binding.alarmName.text = this.name
                binding.alarmSubtitle.text = this.subtitle
                binding.alarmEnabled.isChecked = this.isEnabled
                if (position == alarms.size - 1) {
                    binding.cardDivider.visibility = View.GONE
                } else {
                    binding.cardDivider.visibility = View.VISIBLE
                }

                if (selectedItems.contains(position)) {
                    holder.binding.card.backgroundTintList = ContextCompat.getColorStateList(holder.itemView.context, R.color.highlight_color)
                } else {
                    holder.binding.card.backgroundTintList = ContextCompat.getColorStateList(holder.itemView.context, R.color.white)
                }

                binding.card.setOnLongClickListener {
                    if (selectedItems.contains(position)) {
                        selectedItems.remove(position)
                        holder.binding.card.backgroundTintList = ContextCompat.getColorStateList(holder.itemView.context, R.color.white)
                    } else {
                        selectedItems.add(position)
                        holder.binding.card.backgroundTintList = ContextCompat.getColorStateList(holder.itemView.context, R.color.highlight_color)
                    }
                    selectionListener.onSelectionChanged(selectedItems.size)
                    true
                }

                binding.card.setOnClickListener {
                    if (selectedItems.contains(position)) {
                        selectedItems.remove(position)
                        holder.binding.card.backgroundTintList = ContextCompat.getColorStateList(holder.itemView.context, R.color.white)
                        selectionListener.onSelectionChanged(selectedItems.size)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int = alarms.size

    fun clearSelection() {
        selectedItems.clear()
        notifyDataSetChanged()
        selectionListener.onSelectionChanged(0)
    }

}