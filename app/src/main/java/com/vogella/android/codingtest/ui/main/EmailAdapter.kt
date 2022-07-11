package com.vogella.android.codingtest.ui.main

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vogella.android.codingtest.databinding.CardLayoutBinding


class EmailAdapter(): RecyclerView.Adapter<EmailAdapter.ViewHolder>() {

    private var mEmailList: List<EmailModel>?  = null


    fun setData(list: List<EmailModel>?) {
        mEmailList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = CardLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val emailViewModel = mEmailList!![position]
        when (emailViewModel.priorityIndicator) {
            0 -> holder.description.text = emailViewModel.emailShortDesc
            1 -> holder.description.text = "*" + emailViewModel.emailShortDesc
        }
        when (emailViewModel.readIndicator) {
            0 -> holder.description.setTypeface(Typeface.DEFAULT_BOLD)
        }
        holder.time.text = emailViewModel.fromDate

    }

    override fun getItemCount(): Int {
        return mEmailList?.size ?: 0
    }


    class ViewHolder(binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        val description: TextView = binding.description
        val time: TextView = binding.time
    }

}
