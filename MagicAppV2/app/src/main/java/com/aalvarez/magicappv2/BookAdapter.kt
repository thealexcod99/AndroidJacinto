package com.aalvarez.magicappv2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class BookAdapter(private val books: List<Book>, val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.bind(book, itemClickListener)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_card, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int = books.size




    inner class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tituloTextView = itemView.findViewById<TextView>(R.id.cardTitulo)
        val photoImageView = itemView.findViewById<ImageView>(R.id.cardPortada)
        val precioTextView = itemView.findViewById<TextView>(R.id.cardPrecio)

        fun bind(book: Book, clickListener: OnItemClickListener) {
            tituloTextView.text = book.titulo
            precioTextView.text = book.precio

            itemView.setOnClickListener {
                clickListener.onClicked(book)
            }
        }
    }

    interface OnItemClickListener {
        fun onClicked(book: Book)
    }
}