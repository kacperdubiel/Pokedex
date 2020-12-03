package com.example.pokedex.screens.list

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.pokemon.Pokemon
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment(), OnListItemClickListener {

    private lateinit var viewModel: ListViewModel
    private lateinit var listRVAdapter: ListRecyclerViewAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        setHasOptionsMenu(true)
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR

        Log.i("ListFragment", "Called ViewModelProvider.get!")
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        // Recyclerview with pokemons
        listRVAdapter = ListRecyclerViewAdapter(viewModel.currentPokemonList, this)
        view.pokemonListRV.adapter = listRVAdapter
        view.pokemonListRV.layoutManager = LinearLayoutManager(this.context)
        view.pokemonListRV.setHasFixedSize(true)

        // Removing item from recyclerview by swipe
        val itemTouchHelperCallback =
                object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT) {
                    override fun onMove(
                            recyclerView: RecyclerView,
                            viewHolder: RecyclerView.ViewHolder,
                            target: RecyclerView.ViewHolder
                    ): Boolean {
                        return false
                    }

                    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                        val position = viewHolder.adapterPosition
                        viewModel.removePokemonAt(position)

                        listRVAdapter.updateToNewData(viewModel.currentPokemonList)
                    }
                }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(view.pokemonListRV)

        // Filtering pokemons
        viewModel.menuFilter.observe(viewLifecycleOwner, {
            viewModel.filterCurrentPokemonList()
            listRVAdapter.updateToNewData(viewModel.currentPokemonList)
        })

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.category_menu, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.remove_filters -> {
                viewModel.removeFilters()
                activity?.invalidateOptionsMenu()
            }
        }

        if (item.isCheckable && (item.order >= 0 && item.order < viewModel.menuFilter.value?.size ?: -1)) {
            item.isChecked = !item.isChecked
            viewModel.toggleMenuItem(item.order)
            activity?.invalidateOptionsMenu()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.remove_filters).isVisible = viewModel.filtersOn()

        for (item in menu.findItem(R.id.categories).subMenu.children) {
            if (viewModel.checkIfFilterActive(item.order)) {
                item.isChecked = true
            }
        }

        super.onPrepareOptionsMenu(menu)
    }

    override fun onItemClick(item: Pokemon, position: Int) {
        findNavController().navigate(R.id.action_listFragment_to_detailsViewPagerFragment)
    }

    override fun onFavouriteClick(item: Pokemon, position: Int) {
        viewModel.toggleFavourite(position)
        listRVAdapter.notifyItemChanged(position)
        viewModel.filterCurrentPokemonList()
        listRVAdapter.updateToNewData(viewModel.currentPokemonList)
    }

}