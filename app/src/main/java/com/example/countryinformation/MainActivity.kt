package com.example.countryinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.countryinformation.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val countreName = binding.countryNameEditText.text.toString()

            lifecycleScope.launch {
                try {


                val countries = restCountresAPI.getCountryByName(countreName)
                val country = countries[0]

                binding.countryNameTextView.text = country.name
                binding.capitalTextView.text = country.capital
                binding.populationTextView.text = formatNumber(country.population)
                binding.areaTextView.text = formatNumber(country.area)
                binding.languigesTextView.text = languagesToString(country.languages)

               loadImages(binding.imageView, country.flags.png)

                binding.statusLayout.visibility = View.INVISIBLE
                binding.resultLayout.visibility = View.VISIBLE
                } catch (e: Exception) {
                    binding.statusTextView.text = "Страна не найдена"
                    binding.statusImageView2.setImageResource(R.drawable.ic_baseline_error_24)
                    binding.statusLayout.visibility = View.VISIBLE
                    binding.resultLayout.visibility = View.INVISIBLE
                }



            }



        }
    }


}