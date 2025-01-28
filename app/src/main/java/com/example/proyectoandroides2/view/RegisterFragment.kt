package com.example.proyectoandroides2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.proyectoandroides2.R
import com.example.proyectoandroides2.databinding.FragmentSecondBinding
import com.example.proyectoandroides2.utils.FragmentCommunicator
import com.example.proyectoandroides2.viewModel.SignUpViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RegisterFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var communicator: FragmentCommunicator
    private val viewModel by viewModels<SignUpViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        communicator = requireActivity() as FragmentCommunicator
        //setupObservers()
        //setupView()
        binding.signUpButton.setOnClickListener {
            viewModel.createUser(binding.emailTextInput.editText?.text.toString(),
                binding.passwordTextInput.editText?.text.toString())
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        return binding.root

    }

    /*
    private fun setupObservers() {
        viewModel.userInfo.observe(viewLifecycleOwner) { userInfo ->
            //updateUI(userInfo)
        }
        viewModel.loaderState.observe(viewLifecycleOwner) { showLoader ->
            communicator.manageLoader(showLoader)
        }
    }*/

    /*
    private fun setupView() {
        viewModel.fetchUserInfo(editTextEmail.getText)
    }*/

    /* COMO EJECUTAR UNA RUTA DEL NAVGRAPH
    private fun updateUI(userInfo: UserData) {
        findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
    }
     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}