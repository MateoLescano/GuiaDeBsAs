package com.citesoftware.guiadebsas.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
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

        //spinner

        val spinner: Spinner = binding.spinnerC
        val values: Array<String> = arrayOf("Restaurante", "Sitio historico")

        val adapterS = ArrayAdapter(requireContext(), R.layout.spinner_layout,values)
        adapterS.setDropDownViewResource(R.layout.spinner_dropdown)
        spinner.adapter = adapterS
//        spinner.onItemSelectedListener = this

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


    fun cargarLista(){
        lista.add(DataModel("Espacio de Memoria y Derechos Humanos Ex-ESMA", "Sitio hist??rico", "Av. del Libertador 8151", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("La Mezzetta", "Restauante", "Av. ??lvarez Thomas 1321", R.drawable.ic_launcher_foreground, "En nuestra humilde opinion esta es la mejor pizzer??a de la ciudad de Buenos Aires. Su fuerte es la fugazzetta. Considerar que cada porci??n es abundante, asi que una o dos son suficientes para la mayor??a de las personas. Como dato de color, cabe destacar que esta era la pizzer??a favorita de Gustavo Cerati"))
        lista.add(DataModel("Plaza de Mayo", "Sitio hist??rico", "Entre Rivadavia y Hip??lito Yrigoyen", R.drawable.ic_launcher_foreground, "La Plaza de Mayo es el sitio fundacional de la ciudad tr??s la ??nion de dos plazas frente al fuerte Buenos Aires en 1884. Esta plaza a presenciado todos los eventos significantes de la histor??a Argentina, y ha sido hogar de incontables manifestaciones, entre las que se destacan las caminatas de las Abuelas de Plaza de Mayo alrededor de la piramide central."))
        lista.add(DataModel("Casa Rosada", "Sitio hist??rico", "Balcarce 50", R.drawable.ic_launcher_foreground, "Esta es la sede del poder ejecutivo nacional, es decir donde trabaja el presidente de la Naci??n. Adem??s alberga el museo de la casa de gobierno."))
        lista.add(DataModel("El Cabildo", "Museo", "Bol??var 65", R.drawable.ic_launcher_foreground, "El Cabildo fue fundado en 1580 y desde la revoluci??n de Mayo de 1810 funcion?? como Junta de Gobierno. Ha funcionado como biblioteca p??blica, c??rcel y desde 1939 como Museo Hist??rico Nacional del Cabildo y de la Revoluci??n de Mayo."))
        lista.add(DataModel("Palacio Barolo", "Sitio arquitect??nico", "Av. de Mayo 1370", R.drawable.ic_launcher_foreground, "Este edificio de oficinas dise??ado por Mario Palanti fue inaugurado en 1923 y hasta 1930 fue el m??s alto de Am??rica del Sur. En su estructura pueden verse muchas referencias y analog??as a la Divina Comedia de Dante Alighieri."))
        lista.add(DataModel("Museo Evita", "Museo", "Lafinur 2988", R.drawable.ic_launcher_foreground, "Originalmente adquirido por la Fundaci??n de Ayuda Social Eva Per??n para funcionar como hogar de tr??nsito para mujeres del interior del pa??s con problemas de salud, trabajo, documentaci??n o vivienda al llegar a Buenos Aires, es hoy un museo que repasa la histor??a de Evita, sus logros y su relaci??n con la moda. Cuenta con una colecci??n de vestidos originales en exhibici??n."))
        lista.add(DataModel("Croma??on", "Sitio hist??rico", "Mitre 3070", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Mercado de San Telmo", "Mercado/Restaurante", "", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Canto al Trabajo", "Monumento", "Av. Paseo Col??n 800", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Facultad de Ingenier??a", "Universidad/Sitio arquitect??nico", "Av. Paseo Col??n 850", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Casa M??nima", "Sitio arquitect??nico", "San Lorenzo 380", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Biblioteca Nacional Mariano Moreno", "Sitio cultural", "Ag??ero 2502", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Museo Nacional de Bellas Artes", "Museo", "Av. del Libertador 1473", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Centro Cultural Recoleta", "Sitio cultural", "Jun??n 1930", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Facultad de derecho", "Universidad/Sitio arquitect??nico", "Av. Figueroa Alcorta 2263", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Monumento a los Ca??dos en Malvinas", "Monumento", "Av. del Libertador 50", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Estaci??n Retiro", "Sitio arquitect??nico", "Av. Ramos Mej??a 1430", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Plaza Arenales", "Parque", "Mercedes 4058", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Palacio Ceci", "Sitio arquitect??nico", "Av. Lincoln 4305", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Palacio de los Bichos", "Sitio arquitect??nico", "Campana 3220", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("La casa de 'Esperando La Carroza'", "Sitio hist??rico", "Echenaguc??a 1232", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("La Manzana de las Luces", "Sitio hist??rico", "Per?? 294", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Centro Cultural Kirchner", "Sitio cultural", "Sarmiento 151", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Estadio Monumental", "Estadio", "Av. Figueroa Alcorta 7597", R.drawable.ic_launcher_foreground, ""))
        lista.add(DataModel("Caf?? Tortoni", "Restauante", "Av. de Mayo 825", R.drawable.ic_launcher_foreground, ""))
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
}