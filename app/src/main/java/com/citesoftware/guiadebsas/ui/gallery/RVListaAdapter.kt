package com.citesoftware.guiadebsas.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.citesoftware.guiadebsas.R

class RVListaAdapter(private var TitulosLoc: Array<String>, private var TipoLoc: Array<String>, private var DireccionLoc: Array<String>, private var ImgLoc: Array<Int>): RecyclerView.Adapter<RVListaAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var itemImage: ImageView = itemView.findViewById(R.id.imgItem)

        var titulo: TextView = itemView.findViewById(R.id.tvTitulo)

        var tipo: TextView = itemView.findViewById(R.id.tvTipo)

        var direccion: TextView = itemView.findViewById(R.id.tvDireccion)

//        init {
//
//        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.titulo.text = TitulosLoc[position]
        holder.tipo.text = TipoLoc[position]
        holder.direccion.text = DireccionLoc[position]
        holder.itemImage.setImageResource(ImgLoc[position])

    }

    override fun getItemCount(): Int = TitulosLoc.size
}