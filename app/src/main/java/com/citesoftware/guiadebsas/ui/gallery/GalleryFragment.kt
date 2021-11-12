package com.citesoftware.guiadebsas.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.citesoftware.guiadebsas.R
import com.citesoftware.guiadebsas.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel
    private var _binding: FragmentGalleryBinding? = null


    var lista: MutableList<DataModel> = ArrayList()


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    fun cargarLista(){
        lista.add(DataModel("Espacio de Memoria y Derechos Humanos Ex-ESMA", "Sitio histórico", "Av. del Libertador 8151", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("La Mezzetta", "Restauante", "Av. Álvarez Thomas 1321", R.drawable.ic_launcher_foreground, "En nuestra humilde opinion esta es la mejor pizzería de la ciudad de Buenos Aires. Su fuerte es la fugazzetta. Considerar que cada porción es abundante, asi que una o dos son suficientes para la mayoría de las personas. Como dato de color, cabe destacar que esta era la pizzería favorita de Gustavo Cerati"))
        lista.add(DataModel("Plaza de Mayo", "Sitio histórico", "Entre Rivadavia y Hipólito Yrigoyen", R.drawable.ic_launcher_foreground, "La Plaza de Mayo es el sitio fundacional de la ciudad trás la únion de dos plazas frente al fuerte Buenos Aires en 1884. Esta plaza a presenciado todos los eventos significantes de la historía Argentina, y ha sido hogar de incontables manifestaciones, entre las que se destacan las caminatas de las Abuelas de Plaza de Mayo alrededor de la piramide central."))
        lista.add(DataModel("Casa Rosada", "Sitio histórico", "Balcarce 50", R.drawable.ic_launcher_foreground, "Esta es la sede del poder ejecutivo nacional, es decir donde trabaja el presidente de la Nación. Además alberga el museo de la casa de gobierno."))
        lista.add(DataModel("El Cabildo", "Museo", "Bolívar 65", R.drawable.ic_launcher_foreground, "El Cabildo fue fundado en 1580 y desde la revolución de Mayo de 1810 funcionó como Junta de Gobierno. Ha funcionado como biblioteca pública, cárcel y desde 1939 como Museo Histórico Nacional del Cabildo y de la Revolución de Mayo."))
        lista.add(DataModel("Palacio Barolo", "Sitio arquitectónico", "Av. de Mayo 1370", R.drawable.ic_launcher_foreground, "Este edificio de oficinas diseñado por Mario Palanti fue inaugurado en 1923 y hasta 1930 fue el más alto de América del Sur. En su estructura pueden verse muchas referencias y analogías a la Divina Comedia de Dante Alighieri."))
        lista.add(DataModel("Museo Evita", "Museo", "Lafinur 2988", R.drawable.ic_launcher_foreground, "Originalmente adquirido por la Fundación de Ayuda Social Eva Perón para funcionar como hogar de tránsito para mujeres del interior del país con problemas de salud, trabajo, documentación o vivienda al llegar a Buenos Aires, es hoy un museo que repasa la historía de Evita, sus logros y su relación con la moda. Cuenta con una colección de vestidos originales en exhibición."))
        lista.add(DataModel("Cromañon", "Sitio histórico", "Mitre 3070", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Mercado de San Telmo", "Mercado/Restaurante", "", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Canto al Trabajo", "Monumento", "Av. Paseo Colón 800", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Facultad de Ingeniería", "Universidad/Sitio arquitectónico", "Av. Paseo Colón 850", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Casa Mínima", "Sitio arquitectónico", "San Lorenzo 380", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Biblioteca Nacional Mariano Moreno", "Sitio cultural", "Agüero 2502", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Museo Nacional de Bellas Artes", "Museo", "Av. del Libertador 1473", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Centro Cultural Recoleta", "Sitio cultural", "Junín 1930", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Facultad de derecho", "Universidad/Sitio arquitectónico", "Av. Figueroa Alcorta 2263", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Monumento a los Caídos en Malvinas", "Monumento", "Av. del Libertador 50", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Estación Retiro", "Sitio arquitectónico", "Av. Ramos Mejía 1430", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Plaza Arenales", "Parque", "Mercedes 4058", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Palacio Ceci", "Sitio arquitectónico", "Av. Lincoln 4305", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Palacio de los Bichos", "Sitio arquitectónico", "Campana 3220", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("La casa de 'Esperando La Carroza'", "Sitio histórico", "Echenagucía 1232", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("La Manzana de las Luces", "Sitio histórico", "Perú 294", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Centro Cultural Kirchner", "Sitio cultural", "Sarmiento 151", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Estadio Monumental", "Estadio", "Av. Figueroa Alcorta 7597", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Café Tortoni", "Restauante", "Av. de Mayo 825", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Obelisco", "Monumento", "Av. 9 de Julio", R.drawable.ic_launcher_foreground, ""))
//        lista.add(DataModel("", "", "", R.drawable.ic_launcher_foreground, ""))
//        lista.add(DataModel("", "", "", R.drawable.ic_launcher_foreground, ""))
//        lista.add(DataModel("", "", "", R.drawable.ic_launcher_foreground, ""))
//        lista.add(DataModel("", "", "", R.drawable.ic_launcher_foreground, ""))
//        lista.add(DataModel("", "", "", R.drawable.ic_launcher_foreground, ""))
//        lista.add(DataModel("", "", "", R.drawable.ic_launcher_foreground, ""))
//        lista.add(DataModel("", "", "", R.drawable.ic_launcher_foreground, ""))
//        lista.add(DataModel("", "", "", R.drawable.ic_launcher_foreground, ""))
//        lista.add(DataModel("", "", "", R.drawable.ic_launcher_foreground, ""))
//        lista.add(DataModel("", "", "", R.drawable.ic_launcher_foreground, ""))
//        lista.add(DataModel("", "", "", R.drawable.ic_launcher_foreground, ""))
//        lista.add(DataModel("", "", "", R.drawable.ic_launcher_foreground, ""))
//        lista.add(DataModel("", "", "", R.drawable.ic_launcher_foreground, ""))
//        lista.add(DataModel("", "", "", R.drawable.ic_launcher_foreground, ""))
//        lista.add(DataModel("", "", "", R.drawable.ic_launcher_foreground, ""))
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textGallery
//        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        cargarLista()

        val adapter = RVListaAdapter(lista)
        val recyclerView: RecyclerView = root.findViewById(R.id.rvLista)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}