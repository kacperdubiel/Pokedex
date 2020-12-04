package com.example.pokedex.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokedex.R
import com.example.pokedex.pokemon.Pokemon
import kotlinx.android.synthetic.main.fragment_gallery_screen.view.*

class GalleryScreen(val pokemon: Pokemon) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_gallery_screen, container, false)

        var imgCounter = 1
        val imagesAmount = pokemon.images.size
        view.galleryPictureIV.setImageResource(pokemon.images[1])

        view.prevBTN.setOnClickListener {
            if (imgCounter == 1) {
                imgCounter = imagesAmount - 1
            } else {
                imgCounter -= 1
            }
            view.galleryPictureIV.setImageResource(pokemon.images[imgCounter])
        }

        view.nextBTN.setOnClickListener {
            if (imgCounter == imagesAmount - 1) {
                imgCounter = 1
            } else {
                imgCounter += 1
            }
            view.galleryPictureIV.setImageResource(pokemon.images[imgCounter])
        }

        return view
    }

}