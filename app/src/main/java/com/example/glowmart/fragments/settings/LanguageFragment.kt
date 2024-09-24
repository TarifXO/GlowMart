package com.example.glowmart.fragments.settings

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.glowmart.R
import com.example.glowmart.databinding.FragmentLanguageBinding
import com.example.glowmart.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class LanguageFragment : Fragment(R.layout.fragment_language) {

    private lateinit var binding: FragmentLanguageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLanguageBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvEnglish = binding.tvEnglish
        val tvArabic = binding.tvArabic

        tvEnglish.setOnClickListener {
            setLocale(requireContext(), "en")
        }

        tvArabic.setOnClickListener {
            setLocale(requireContext(), "ar")
        }

    }

    private fun setLocale(context: Context, languageCode : String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)

        // Save the selected language in SharedPreferences
        val sharedPreferences = context.getSharedPreferences("Settings", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("My_Lang", languageCode)
        editor.apply()

        // Restart the activity to apply the new language
        activity?.recreate()
    }

}