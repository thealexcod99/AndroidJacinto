package com.aalvarez.magicappv2

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class BookViewModel : ViewModel() {

    companion object {
        private const val TAG = "BookViewModel"
    }

    lateinit var books: MutableList<Book>

    init {
        Log.d(TAG, "BookViewModel created")
        mock()
    }

    override fun onCleared() {
        Log.d(TAG, "BookViewModel destroyed")
    }

    fun mock() {

        val b1 = Book(
            "Platero y Yo",
            "https://images-na.ssl-images-amazon.com/images/I/51Np1Xcnh-L._SX330_BO1,204,203,200_.jpg",
            "1234567891234",
            "Juan Ramón Jimenez",
            "Ebook",
            "19/02/2005",
            "Va de un burro",
            "Anaya",
            "120",
            "20")

        val b2 = Book(
            "Platero y Yo",
            "https://images-na.ssl-images-amazon.com/images/I/51Np1Xcnh-L._SX330_BO1,204,203,200_.jpg",
            "1234567891234",
            "Juan Ramón Jimenez",
            "Ebook",
            "19/02/2005",
            "Va de un burro",
            "Anaya",
            "120",
            "20")

        val b3 = Book(
            "Platero y Yo",
            "https://images-na.ssl-images-amazon.com/images/I/51Np1Xcnh-L._SX330_BO1,204,203,200_.jpg",
            "1234567891234",
            "Juan Ramón Jimenez",
            "Ebook",
            "19/02/2005",
            "Va de un burro",
            "Anaya",
            "120",
            "20")

        val b4 = Book(
            "Platero y Yo",
            "https://images-na.ssl-images-amazon.com/images/I/51Np1Xcnh-L._SX330_BO1,204,203,200_.jpg",
            "1234567891234",
            "Juan Ramón Jimenez",
            "Ebook",
            "19/02/2005",
            "Va de un burro",
            "Anaya",
            "120",
            "20")

        val b5 = Book(
            "Platero y Yo",
            "https://images-na.ssl-images-amazon.com/images/I/51Np1Xcnh-L._SX330_BO1,204,203,200_.jpg",
            "1234567891234",
            "Juan Ramón Jimenez",
            "Ebook",
            "19/02/2005",
            "Va de un burro",
            "Anaya",
            "120",
            "20")

        val b6 = Book(
            "Platero y Yo",
            "https://images-na.ssl-images-amazon.com/images/I/51Np1Xcnh-L._SX330_BO1,204,203,200_.jpg",
            "1234567891234",
            "Juan Ramón Jimenez",
            "Ebook",
            "19/02/2005",
            "Va de un burro",
            "Anaya",
            "120",
            "20")


        books = mutableListOf(b1,b2,b3,b4,b5,b6)

        /*for (i in 0..150) {
            books.add(books[Random.nextInt(5)])
        }*/


    }
}