package com.example.starshipsacapp.ui.starship

import android.app.Dialog
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.starshipsacapp.R
import com.example.starshipsacapp.data.model.StarshipDataStoreModel
import com.example.starshipsacapp.databinding.FragmentStarshipDetailBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.CornerSize
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class StarshipDetailFragment : Fragment() {
    private lateinit var _binding: FragmentStarshipDetailBinding
    private val binding get() = _binding!!
    private var idStarship: String? = null
    private var urlStarship: String? = null
    private lateinit var fabUpdateStarship: FloatingActionButton
    private lateinit var starshipDetailViewModel: StarshipDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idStarship = it.getString(ID_BUNDLE)
            urlStarship = it.getString(URL_IMAGE_BUNDLE)
            Log.i("aris", idStarship.orEmpty())
            Log.i("aris", urlStarship.orEmpty())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStarshipDetailBinding.inflate(inflater, container, false)
        val root:View = binding.root

        starshipDetailViewModel =
            ViewModelProvider(this).get(StarshipDetailViewModel::class.java)

        initComponents()
        InitUI()
        initListeners()

        starshipDetailViewModel.getStarshipDetail(idStarship.orEmpty())
        Picasso.get().load(urlStarship).into(binding.ivStarship)

        starshipDetailViewModel.isLoading.observe(viewLifecycleOwner){
            binding.progressBar.isVisible = it
            if(it == false ){
                binding.clStarship.isVisible = true
                fabUpdateStarship.isVisible = true
            }
        }
        starshipDetailViewModel.starshipDetail.observe(viewLifecycleOwner){
            binding.tvStarshipName.text = it?.name.orEmpty()
            binding.tvModel.text = it?.model.orEmpty()
            binding.tvManufacturer.text = it?.manufacturer.orEmpty()
            binding.tvLength.text = it?.length.orEmpty()
            binding.tvCrew.text = it?.crew.orEmpty()
            binding.tvPassengers.text = it?.passengers.orEmpty()
            binding.tvMaxAtmospheringSpeed.text = it?.max_atmosphering_speed.orEmpty()
            binding.tvConsumables.text = it?.consumables.orEmpty()
            binding.tvRating.text = it?.hyperdrive_rating.orEmpty()
            binding.tvStarshipclass.text = it?.starship_class.orEmpty()
        }
        starshipDetailViewModel.starshipDataStore.observe(viewLifecycleOwner){
            binding.tvRetrieveName.text = it.name
            binding.tvRetrieveModel.text = it.model
        }

        return root
    }

    private fun initComponents(){
        fabUpdateStarship = binding.fabUpdateStarship
    }

    private fun InitUI(){
        roundCardViewEdges()
    }

    private fun initListeners(){
        fabUpdateStarship.setOnClickListener{ showDialog()}
        binding.btnRetrieveData.setOnClickListener { retrieveData() }
    }

    private fun retrieveData(){
        starshipDetailViewModel.retrieveData(binding.root.context)
    }

    private fun showDialog(){
        val dialog = Dialog(binding.root.context)
        dialog.setContentView(R.layout.dialog_starship)

        val btnUpdateStarship: Button =  dialog.findViewById(R.id.btnUpdate)
        val etStarshipName: EditText =  dialog.findViewById(R.id.etStarshipName)
        val etStarshipModel: EditText =  dialog.findViewById(R.id.etStarshipModel)

        etStarshipName.setText(binding.tvStarshipName.text)
        etStarshipModel.setText(binding.tvModel.text)

        btnUpdateStarship.setOnClickListener {
            val currentStarshipName = etStarshipName.text.toString()
            val currentStarshipModel = etStarshipModel.text.toString()
            if(currentStarshipName.isNotEmpty() && currentStarshipModel.isNotEmpty()){
                starshipDetailViewModel.saveData(
                    binding.root.context,
                    StarshipDataStoreModel(
                        id = idStarship.orEmpty(),
                        name = currentStarshipName,
                        model = currentStarshipModel
                    )
                )
                dialog.hide()
            }
        }
        dialog.show()
    }

    private fun roundCardViewEdges(){
        val leftShapePathModel = ShapeAppearanceModel().toBuilder()
        leftShapePathModel.setTopLeftCorner(
            CornerFamily.ROUNDED,
            CornerSize { return@CornerSize 100F })
        leftShapePathModel.setTopRightCorner(
            CornerFamily.ROUNDED,
            CornerSize { return@CornerSize 100F })
        val bg = MaterialShapeDrawable(leftShapePathModel.build())
        //Screen without applying color it shows black background
        bg.fillColor = ColorStateList.valueOf(
            binding.root.context.resources.getColor(R.color.starwar_colorprimary)
        )
        bg.elevation = 8F
        binding.cvStarship.background = bg
        binding.cvStarship.invalidate()
    }

    companion object {
        const val ID_BUNDLE = "id"
        const val URL_IMAGE_BUNDLE = "url"
        /*@JvmStatic
        fun newInstance(param1: String, param2: String) =
            StarshipDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }*/
    }
}