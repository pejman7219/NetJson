package com.example.netjson.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.netjson.ObjectUser.UserObject
import com.example.netjson.R

class AdapterUser (var user : ArrayList<UserObject>) : RecyclerView.Adapter<AdapterUser.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.simpel_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
            return user.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = user[position].name
        holder.family.text = user[position].family
        holder.email.text = user[position].email
        holder.phone.text = user[position].phene.toString()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var name = itemView.findViewById<TextView>(R.id.textname)
        var family = itemView.findViewById<TextView>(R.id.textfamily)
        var email = itemView.findViewById<TextView>(R.id.textemail)
        var phone = itemView.findViewById<TextView>(R.id.textphone)
    }
}