package com.fabricmonde.salesapp.traceadapter

import android.view.ViewGroup

interface ViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): androidx.recyclerview.widget.RecyclerView.ViewHolder

    fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, item: ViewType)

}
