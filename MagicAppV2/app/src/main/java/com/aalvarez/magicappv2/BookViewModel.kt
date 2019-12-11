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
            "MAGIA BLANCA",
                "https://i.ytimg.com/vi/fqgstvoUxOc/maxresdefault.jpg",
                "Magia buena"
            )

        val b2 = Book(
            "MAGIA NEGRA",
                "https://imagenes.20minutos.es/files/image_656_370/uploads/imagenes/2018/10/22/808256.jpg",
                "Magia maligna"
            )

        val b3 = Book(
            "MAGIA ROJA",
            "https://images-na.ssl-images-amazon.com/images/I/51ih7-8g1uL._SX466_.jpg",
                "Magia del sexo"
            )

        val b4 = Book(
            "MAGIA VERDE",
                "https://i.ytimg.com/vi/yC6lHNLmsLg/hqdefault.jpg",
                "Magia de la naturaleza"
            )

        val b5 = Book(
            "MAGIA GRIS",
                "https://1.bp.blogspot.com/-ZqaDDCkQkQo/VQTcNRcRzTI/AAAAAAAAAVw/CAvLDBScNYc/s1600/merlin_mago.jpg",
                "Magia neutra"
            )

        val b6 = Book(
            "MAGIA AZUL",
                "https://vignette.wikia.nocookie.net/yugiohenespanol/images/d/de/Foto_mago_azul_h%C3%A1bil.jpg/revision/latest?cb=20141119181402&path-prefix=es",
                "Magia del agua"
            )

        val b7 = Book(
            "MAGIA ROSA",
                "https://lamonomagazine.com/wp-content/uploads/2018/02/Al-Mefer-1.jpg",
                "Magia del amor"
            )

        val b8 = Book(
            "ILUSIONISMO",
            "https://img.freepik.com/vector-gratis/espectaculo-magia-fondo_1284-13012.jpg?size=338&ext=jpg",
            "Magia falsa"
            )

        books = mutableListOf(b1,b2,b3,b4,b5,b6,b7,b8)

        /*for (i in 0..150) {
            books.add(books[Random.nextInt(5)])
        }*/


    }
}