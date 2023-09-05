package com.example.starshipsacapp.ui.planet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starshipsacapp.databinding.FragmentPlanetBinding
import com.example.starshipsacapp.ui.planet.rvPlanet.PlanetAdapter

class PlanetFragment : Fragment() {

    private var _binding: FragmentPlanetBinding? = null
    private val binding get() = _binding!!
    private lateinit var rvPlanet: RecyclerView
    private lateinit var planetAdapter: PlanetAdapter
    private lateinit var planetViewModel : PlanetViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        planetViewModel =
            ViewModelProvider(this).get(PlanetViewModel::class.java)

        _binding = FragmentPlanetBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initComponents()
        initUI()
        initListeners()

        return root
    }

    private fun initComponents(){
        rvPlanet = binding.rvPlanets
    }

    private fun initUI(){
        planetAdapter = PlanetAdapter()
        rvPlanet.setHasFixedSize(true)
        rvPlanet.layoutManager = LinearLayoutManager(binding.root.context)
        rvPlanet.adapter = planetAdapter
        planetViewModel.getAllPlanets()
    }

    private fun initListeners(){
        planetViewModel.isLoading.observe(viewLifecycleOwner){
            binding.progressBar.isVisible = it
        }
        planetViewModel.planets.observe(viewLifecycleOwner){
            planetAdapter.setPlanetsList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}