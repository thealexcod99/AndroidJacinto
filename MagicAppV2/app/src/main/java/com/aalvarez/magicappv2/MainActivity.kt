package com.aalvarez.magicappv2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_list)

        val provider: ViewModelProvider = ViewModelProviders.of(this)
        val bookViewModel = provider.get(BookViewModel::class.java)

        val bookRecyclerView = findViewById<RecyclerView>(R.id.bookRecyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            //layoutManager = GridLayoutManager(this@MainActivity,4, GridLayoutManager.HORIZONTAL,false)
            adapter = BookAdapter(bookViewModel.books, object : BookAdapter.OnItemClickListener{
                override fun onClicked(book: Book) {
                    val snackbar =
                        Snackbar.make(this@apply, book.titulo, Snackbar.LENGTH_LONG)
                    snackbar.show()
                }

            })
        }
    }
}