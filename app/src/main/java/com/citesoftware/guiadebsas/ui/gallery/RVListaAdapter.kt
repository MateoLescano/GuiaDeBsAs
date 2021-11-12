package com.citesoftware.guiadebsas.ui.gallery

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.citesoftware.guiadebsas.R

class RVListaAdapter(val locaciones: List<DataModel>): RecyclerView.Adapter<RVListaAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var itemImage: ImageView = itemView.findViewById(R.id.imgItem)

        var titulo: TextView = itemView.findViewById(R.id.tvTitulo)

        var tipo: TextView = itemView.findViewById(R.id.tvTipo)

        var direccion: TextView = itemView.findViewById(R.id.tvDireccion)

        var descripcion: TextView = itemView.findViewById(R.id.tvDescripcion)

//        init {
//
//        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val data = locaciones[position]


        holder.titulo.text = data.titulo
        holder.tipo.text = data.tipo
        holder.direccion.text = data.direccionLoc
        holder.itemImage.setImageResource(data.imgLoc)
        holder.descripcion.text = data.descripcion

//        when (TipoLoc[position]){
//            "Trimarchi" -> holder.itemView.setBackgroundColor(0xFF3F51B5.toInt())
//        }

    }

    override fun getItemCount(): Int = locaciones.size
}