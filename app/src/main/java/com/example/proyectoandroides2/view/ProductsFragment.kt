package com.example.proyectoandroides2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectoandroides2.databinding.ShopFragmentBinding
import com.example.proyectoandroides2.model.ShopItem
import com.example.proyectoandroides2.utils.FragmentCommunicator
import com.example.proyectoandroides2.view.adapters.ProductAdapter
import com.example.proyectoandroides2.viewModel.ShopViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ProductsFragment : Fragment() {

    private var _binding: ShopFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<ShopViewModel>()
    private lateinit var communicator: FragmentCommunicator
    private lateinit var productAdapter: ProductAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = ShopFragmentBinding.inflate(inflater, container, false)
        communicator = requireActivity() as FragmentCommunicator
        setupView()
        setupObservers()
        viewModel.fetchShopData()
        return binding.root

    }

    private fun setupView() {
        productAdapter = ProductAdapter(
            mutableListOf()
        )
        binding.forecastRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = productAdapter
        }
    }

    private fun setupObservers() {
        viewModel.shopInfo.observe(viewLifecycleOwner) { shop ->
            updateUI(shop)
        }
        viewModel.loaderState.observe(viewLifecycleOwner) { showLoader ->
            communicator.manageLoader(showLoader)
        }
    }

    private fun updateUI(shop: List<ShopItem>) {
        productAdapter.shop.addAll(shop)
        productAdapter.notifyDataSetChanged()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}