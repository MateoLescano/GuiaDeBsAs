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
        lista.add(DataModel("La Mezzetta", "Resto", "Av. 123", R.drawable.ic_launcher_foreground, "En nuestra humilde opinion esta es la mejor pizzería de la ciudad de Buenos Aires"))
        lista.add(DataModel("Mi casa", "Sitio Historico", "asd", R.drawable.ic_launcher_foreground, "QSY aca vivi yo"))
        lista.add(DataModel("Abcd", "Algo", "fiumba", R.drawable.ic_launcher_foreground, "ASDASDADS"))
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