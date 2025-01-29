package com.example.proyectoandroides2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.proyectoandroides2.R
import com.example.proyectoandroides2.databinding.LoginfragmentLayoutBinding
import com.example.proyectoandroides2.utils.FragmentCommunicator
import com.example.proyectoandroides2.viewModel.LoginViewModel

/**v
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    private var _binding: LoginfragmentLayoutBinding? = null
    private val binding get() = _binding!!
    private lateinit var communicator: FragmentCommunicator
    private val viewModel by viewModels<LoginViewModel>()

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = LoginfragmentLayoutBinding.inflate(inflater, container, false)
        communicator = requireActivity() as FragmentCommunicator
        binding.signInButton.setOnClickListener {
            //communicator.manageLoader(true)
            viewModel.loginUser(binding.emailLoginInput.editText?.text.toString(), binding.passwordLoginInput.editText?.text.toString())
        }
        binding.signUpTextView.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}