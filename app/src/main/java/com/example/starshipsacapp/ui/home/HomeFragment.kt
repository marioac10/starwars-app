package com.example.starshipsacapp.ui.home

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starshipsacapp.R
import com.example.starshipsacapp.databinding.FragmentHomeBinding
import com.example.starshipsacapp.ui.home.rvHome.Category
import com.example.starshipsacapp.ui.home.rvHome.CategoryAdapter
import com.example.starshipsacapp.ui.home.rvHome.CollectionAdapter
import com.example.starshipsacapp.ui.home.rvHome.ItemCollection
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {
    private val categories = listOf(
        Category.Starship,
        Category.Planet,
        Category.Specie
    )

    private val collections = mutableListOf(
        ItemCollection(name = "Death Star",Category.Starship),
        ItemCollection(name = "Tatooine",Category.Planet),
        ItemCollection(name = "Wookie",Category.Specie)
    )

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var rvCategory: RecyclerView
    private lateinit var categoriesAdapter: CategoryAdapter
    private lateinit var rvCollection: RecyclerView
    private  lateinit var itemsCollectionAdapter: CollectionAdapter
    private lateinit var fabAddCollection: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initComponents()
        initUI()
        initListeners()

        return root
    }

    private fun initComponents(){
        rvCategory = binding.rvCategories
        rvCollection = binding.rvCollections
        fabAddCollection = binding.fabAddCollection
    }

    private fun initUI(){
        categoriesAdapter = CategoryAdapter(categories) { updateCategories(it) }
        rvCategory.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        rvCategory.adapter = categoriesAdapter

        itemsCollectionAdapter = CollectionAdapter(collections) { position -> onItemSelected(position) }
        rvCollection.layoutManager = LinearLayoutManager(binding.root.context)
        rvCollection.adapter = itemsCollectionAdapter
    }

    private fun onItemSelected(position:Int){
        collections[position].isSelected = !collections[position].isSelected
        updateCollections()
    }

    private fun updateCategories(position: Int){
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateCollections()
    }

    private fun updateCollections(){
        val selectedCategories: List<Category> = categories.filter { it.isSelected }
        val newCollection = collections.filter { selectedCategories.contains(it.category) }
        itemsCollectionAdapter.itemsCollection = newCollection
        itemsCollectionAdapter.notifyDataSetChanged()
    }

    private fun initListeners(){
        fabAddCollection.setOnClickListener{ showDialog()}
    }

    private fun showDialog(){
        val dialog = Dialog(binding.root.context)
        dialog.setContentView(R.layout.dialog_collection)

        val btnAddTask: Button =  dialog.findViewById(R.id.btnAddCollection)
        val etCollection: EditText =  dialog.findViewById(R.id.etCollection)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = etCollection.text.toString()
            if(currentTask.isNotEmpty()){
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory:Category = when(selectedRadioButton.text){
                    getString(R.string.dialog_category_starships) -> Category.Starship
                    getString(R.string.dialog_category_planets) -> Category.Planet
                    else -> Category.Specie
                }

                collections.add(ItemCollection(etCollection.text.toString(), currentCategory))
                updateCollections()
                dialog.hide()
            }
        }

        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}