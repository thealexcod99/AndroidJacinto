package com.aalvarez.proyectomagia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Contenido {

    public static ArrayList<Lista_entrada> ENT_LISTA = new ArrayList<>();
    public static Map<String,Lista_entrada> ENT_LISTA_HASHMAP = new HashMap<>();

    public static class Lista_entrada {
        public String id;
        public int idImagen;
        public String textoEncima;
        public String textoLista;
        public  String textoDebajo;

        public Lista_entrada(String id, int idImagen, String textoEncima, String textoLista, String textoDebajo) {
            this.id = id;
            this.idImagen = idImagen;
            this.textoEncima = textoEncima;
            this.textoLista = textoLista;
            this.textoDebajo = textoDebajo;
        }
    }

    private static void aniadirEntrada(Lista_entrada entrada) {
        ENT_LISTA.add(entrada);
        ENT_LISTA_HASHMAP.put(entrada.id, entrada);
    }

    static {

        aniadirEntrada(new Lista_entrada("0", R.drawable.magia_blanca, "MAGIA BLANCA", "Magia buena", "La magia blanca es buena, porque el blanco representa la pureza. Se aplica con rituales, invocaciones y purificaciones. Funciona para alejar el mal en cualquier forma que aparezca: ya sea un mal de ojo, una maldición o una negatividad de la casa."));
        aniadirEntrada(new Lista_entrada("1", R.drawable.magia_negra, "MAGIA NEGRA", "Magia maligna", "El mal existe al igual que el bien. La magia negra se concentra en hechizos, maldiciones y mal de ojo, así como otras cosas que no vemos y no sabemos. Es la más terrible y la más peligrosa de todas. "));
        aniadirEntrada(new Lista_entrada("2", R.drawable.magia_roja, "MAGIA ROJA", "Magia del sexo", "Con el término magia roja se identifican dos tipos de hechizos: ceremonial y de los sentidos o sexo. La ceremonial es una antigua magia ritualista que se remonta a los egipcios, griegos, romanos, etruscos, celtas, mayas, pueblos africanos y muchas otras culturas lejanas en el tiempo. "));
        aniadirEntrada(new Lista_entrada("3", R.drawable.magia_verde, "MAGIA VERDE", "Magia de la naturaleza", "La magia verde es una parte de la tradición que sobrevivió durante los siglos y se deriva de las religiones prehistóricas. Probablemente sea una de las primeras formas de magia, ya que en la antigüedad el hombre, quien vivía en estrecho contacto con la naturaleza, veía en ella una especie de protección, así como los medios por los cuales podía sobrevivir."));
        aniadirEntrada(new Lista_entrada("4", R.drawable.magia_gris, "MAGIA GRIS", "Magia neutra", "La magia gris es un tipo neutral entre negra y blanca. Esto significa que no siempre se practica por razones beneficiosas, pero al mismo tiempo tiende a no dañar a los demás."));
        aniadirEntrada(new Lista_entrada("5", R.drawable.magia_azul, "MAGIA AZUL", "Magia del agua", "Esta es una práctica mágica que se relaciona con el elemento agua. En sus diferentes ritos, la magia azul utiliza las energías de los ríos. Es muy particular y, a menudo, se emplea en combinación con otras prácticas."));
        aniadirEntrada(new Lista_entrada("6", R.drawable.magia_rosa, "MAGIA ROSA", "Magia del amor", "La magia rosa es una evolución de la roja. Es más suave, ya que siempre se usa de manera positiva. Sus aplicaciones principales buscan consolidar una pareja, entre otros fines."));
        aniadirEntrada(new Lista_entrada("7", R.drawable.ilusionismo, "ILUSIONISMO", "Magia falsa", "El ilusionismo, vulgarmente denominado magia, es un arte escénico, subjetivo, narrativo y espectáculo de habilidad e ingenio, que consiste en producir artificialmente efectos en apariencia maravillosos e inexplicables mientras se desconoce la causa que los produce."));

    }

}
