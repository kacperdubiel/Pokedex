package com.example.pokedex.screens.details

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.pokedex.R
import com.example.pokedex.data.Data
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_details_view_pager.view.*

class DetailsViewPagerFragment : Fragment() {

    private val args: DetailsViewPagerFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_details_view_pager, container, false)
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val pokemon = Data.pokemons[args.pokemonId]
        val fragmentList = arrayListOf(
                InfoScreen(pokemon),
                GalleryScreen(pokemon),
                AttacksScreen(pokemon)
        )

        val adapter = DetailsViewPagerAdapter(
                fragmentList,
                requireActivity().supportFragmentManager,
                lifecycle
        )

        view.detailsViewPager.adapter = adapter


        val infoTabName = context?.getString(R.string.info_tab_name)
        val galleryTabName = context?.getString(R.string.gallery_tab_name)
        val attacksTabName = context?.getString(R.string.attacks_tab_name)

        val tabLayout = view.tab_layout
        val tabTitles = listOf(infoTabName, galleryTabName, attacksTabName)
        TabLayoutMediator(tabLayout, view.detailsViewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        return view
    }

}