package com.example.starshipsacapp.ui.starship

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starshipsacapp.R
import com.example.starshipsacapp.databinding.FragmentStarshipBinding
import com.example.starshipsacapp.ui.starship.StarshipDetailFragment.Companion.ID_BUNDLE
import com.example.starshipsacapp.ui.starship.StarshipDetailFragment.Companion.URL_IMAGE_BUNDLE
import com.example.starshipsacapp.ui.starship.rv_starship.StarshipAdapter

class StarshipFragment : Fragment() {
    private var _binding: FragmentStarshipBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: StarshipAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val starshipViewModel =
            ViewModelProvider(this).get(StarshipViewModel::class.java)

        _binding = FragmentStarshipBinding.inflate(inflater, container, false)
        val root: View = binding.root

        adapter = StarshipAdapter{id:String,url:String -> navigateToDetail(id,url)}
        binding.rvStarship.setHasFixedSize(true)
        binding.rvStarship.layoutManager = LinearLayoutManager(context)
        binding.rvStarship.adapter = adapter

        starshipViewModel.getAllStarshipsList()

        starshipViewModel.starshipList.observe(viewLifecycleOwner){
            adapter.setStarshipList(it)
        }
        starshipViewModel.isLoading.observe(viewLifecycleOwner){
            binding.progressBar.isVisible = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateToDetail(id:String, url:String){
        val bundle = bundleOf(
            ID_BUNDLE to id,
            URL_IMAGE_BUNDLE to url
        )
        findNavController().navigate(R.id.action_nav_starship_to_starshipDetailFragment2, bundle)
    }


}