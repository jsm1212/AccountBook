package com.example.accountbook

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val context: Context) : RecyclerView.Adapter<ItemViewHolder>(){

    var dataList = mutableListOf<Account>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textType = itemView.findViewById<TextView>(R.id.textType)
    private val textDate = itemView.findViewById<TextView>(R.id.textDate)
    private val textPay = itemView.findViewById<TextView>(R.id.textPay)
    private val textContent = itemView.findViewById<TextView>(R.id.textContent)

    fun bind(account:Account, context: Context){
        textType.text = account.type
        textDate.text = account.date
        textPay.text = account.pay.toString()
        textContent.text = account.content

        itemView.setOnClickListener{

            // ProfileDetailActivity 로 이동
            Intent(context, ProfileDetailActivity::class.java).apply {

                // 짐싸!
                putExtra("data", account)

                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.run { context.startActivity(this) }
        }
    }
}