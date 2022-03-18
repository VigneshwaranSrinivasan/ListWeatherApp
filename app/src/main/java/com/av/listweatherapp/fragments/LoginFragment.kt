package com.av.listweatherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.av.listweatherapp.R
import com.av.listweatherapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        binding.btnSignin.setOnClickListener{
            val username = binding.edittextUsername.text.toString()
            val password = binding.edittextPassword.text.toString()
            if(username == "testapp@gmail.com" && password == "Test@123456"){
                findNavController().navigate(R.id.action_loginFragment_to_listFragment)
                Toast.makeText(requireContext(), "Login Success!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), "Login Failed!", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

}