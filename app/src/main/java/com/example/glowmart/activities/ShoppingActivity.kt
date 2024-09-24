package com.example.glowmart.activities

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.glowmart.R
import com.example.glowmart.databinding.ActivityShoppingBinding
import com.example.glowmart.utils.Resource
import com.example.glowmart.utils.loadLocale
import com.example.glowmart.viewmodels.CartViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.Locale

@AndroidEntryPoint
class ShoppingActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityShoppingBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<CartViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLocale(this)
        setContentView(binding.root)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.shoppingHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)

        lifecycleScope.launch {
            viewModel.cartProducts.collectLatest { resource ->
                when (resource) {
                    is Resource.Success -> {
                        val count = resource.data?.size ?: 0
                        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
                        bottomNavigation.getOrCreateBadge(R.id.cartFragment).apply {
                            number = count
                            backgroundColor = resources.getColor(R.color.g_blue, theme)
                        }
                    }
                    else -> Unit
                }
            }
        }

    }


}