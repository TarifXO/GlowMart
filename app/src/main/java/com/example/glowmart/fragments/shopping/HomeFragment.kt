package com.example.glowmart.fragments.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.glowmart.R
import com.example.glowmart.adapters.HomeViewPagerAdapter
import com.example.glowmart.databinding.FragmentHomeBinding
import com.example.glowmart.fragments.categories.AccessoryFragment
import com.example.glowmart.fragments.categories.ChairFragment
import com.example.glowmart.fragments.categories.CupboardFragment
import com.example.glowmart.fragments.categories.FurnitureFragmnet
import com.example.glowmart.fragments.categories.MainCategoryFragment
import com.example.glowmart.fragments.categories.TableFragment
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesFragments = arrayListOf(
            MainCategoryFragment(),
            ChairFragment(),
            CupboardFragment(),
            TableFragment(),
            AccessoryFragment(),
            FurnitureFragmnet()
        )

        val viewPagerAdapter = HomeViewPagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        binding.viewpagerHome.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewpagerHome) { tab, position ->
            when(position){
                0 -> tab.text = "Main"
                1 -> tab.text = "Chairs"
                2 -> tab.text = "Cupboards"
                3 -> tab.text = "Tables"
                4 -> tab.text = "Accessories"
                5 -> tab.text = "Furniture"
            }
        }.attach()
    }

}