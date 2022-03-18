package com.av.listweatherapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.av.listweatherapp.R
import com.av.listweatherapp.databinding.ListItemBinding

class ListFragment : Fragment() {

    private lateinit var binding: ListItemBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val view = inflater.inflate(R.layout.fragment_list, container, false)
        binding = ListItemBinding.inflate(inflater,container,false)

        //navigating from list screen to weather screen
        binding.root.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_weatherFragment)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_data -> {
                this.requireView().findNavController()
                    .navigate(R.id.action_listFragment_to_addFragment)
                true
            }
            else -> NavigationUI.onNavDestinationSelected(item,
                requireView().findNavController()) ||super.onOptionsItemSelected(item)
        }
    }
}