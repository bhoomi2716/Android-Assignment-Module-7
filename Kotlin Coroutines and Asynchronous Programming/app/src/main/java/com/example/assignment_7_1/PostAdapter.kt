package com.example.assignment_7_1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(val context: Context) : RecyclerView.Adapter<PostAdapter.PostViewHolder>()
{
    private var posts: List<Model> = emptyList()

    fun submitList(list: List<Model>) {
        posts = list
        notifyDataSetChanged()
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val title: TextView = itemView.findViewById(R.id.postTitle)
        val body: TextView = itemView.findViewById(R.id.postBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.design_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int)
    {
        val blackColor = ContextCompat.getColor(context, R.color.black).toString()
        val post = posts[position]
        holder.title.setTextColor(blackColor.toInt())
        holder.body.setTextColor(blackColor.toInt())
        holder.title.text = post.title
        holder.body.text = post.body
    }

    override fun getItemCount(): Int = posts.size
}