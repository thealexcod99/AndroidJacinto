package com.example.proyectomaterial10;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.AnimeViewHolder> {
    private List<Encapsulador> items;

    public static class AnimeViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView titulo;
        public TextView texto;

        public AnimeViewHolder(View vista) {
            super(vista);
            imagen = (ImageView) vista.findViewById(R.id.imagen);
            titulo = (TextView) vista.findViewById(R.id.titulo);
            texto = (TextView) vista.findViewById(R.id.texto);
        }
    }


    public Adaptador(List<Encapsulador> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public AnimeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.carta, viewGroup, false);
        return new AnimeViewHolder(v);
    }


    @Override
    public void onBindViewHolder(AnimeViewHolder viewHolder, final int i) {

        viewHolder.imagen.setImageResource(items.get(i).getIdImagen());
        viewHolder.titulo.setText(items.get(i).getTextoTitulo());
        viewHolder.texto.setText(String.valueOf(items.get(i).getTextoContenido()));
    }
}