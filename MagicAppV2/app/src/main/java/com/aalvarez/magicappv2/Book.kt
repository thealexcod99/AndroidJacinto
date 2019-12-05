package com.aalvarez.magicappv2

//import android.os.Parcelable
//import kotlinx.android.parcel.Parcelize

//Título, Portada, ISBN, Autores, Encuadernación, Fecha de publicación, Sinopsis, Editorial,N.º de Páginas, Precio

//@Parcelize
data class Book(
    val titulo: String,
    val portada: String,
    val isbn: String,
    val autores: String,
    val encuadernacion: String,
    val fec_publicacion: String,
    val sinopsis: String,
    val editorial: String,
    val num_paginas: String,
    val precio: String
)//: Parcelable