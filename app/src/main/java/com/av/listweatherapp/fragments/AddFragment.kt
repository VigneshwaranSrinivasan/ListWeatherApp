package com.av.listweatherapp.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.av.listweatherapp.viewmodel.DataViewModel
import com.av.listweatherapp.R
import com.av.listweatherapp.databinding.FragmentAddBinding
import com.av.listweatherapp.room.DetailsData


class AddFragment : Fragment() {
    private lateinit var dataDataViewModel : DataViewModel
    private lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(inflater,container,false)

        //app is crashing due to null in ViewModel class
        //dataDataViewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        binding.btnSave.setOnClickListener {
            insertDataIntoDataBase()
        }
        binding.btnCancel.setOnClickListener {
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
        return binding.root
    }



    private fun insertDataIntoDataBase() {
        val firstName = binding.edittextFirstname.text.toString()
        val lastName = binding.edittextLastname.text.toString()
        val emailAddress = binding.edittextEmail.text.toString()
        if(inputCheck(firstName,lastName,emailAddress)) {
            //create User Object
            val data = DetailsData("Asma", "Taskeen", "asma@gamil.com", 1)
            //add data in database
            //app is crashing due to null in ViewModel class
            /*dataDataViewModel.insertData(data)*/
            Toast.makeText(requireContext(), "successfully added", Toast.LENGTH_SHORT).show()
            //navigate bac to the home fragment
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstname :String,lastname:String,email:String): Boolean{
        return !(TextUtils.isEmpty(firstname)&& TextUtils.isEmpty(lastname)&&TextUtils.isEmpty(email))
    }





}