package com.example.pokedex.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokedex.R
import kotlinx.android.synthetic.main.fragment_details_view_pager.view.*

class DetailsViewPagerFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_details_view_pager, container, false)

        val fragmentList = arrayListOf(
                InfoScreen(),
                GalleryScreen(),
                AttacksScreen()
        )

        // TODO: Error after flipping phone
        val adapter = DetailsViewPagerAdapter(
                fragmentList,
                requireActivity().supportFragmentManager,
                lifecycle
        )

        view.detailsViewPager.adapter = adapter


        return view
    }

}