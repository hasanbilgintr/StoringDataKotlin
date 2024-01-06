package com.hasanbilgin.storingdatakotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hasanbilgin.storingdatakotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    var ageFromPreferences: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        //SharedPrefences Initialize
        sharedPreferences =
            this.getSharedPreferences("com.atilsamancioglu.storingdata", Context.MODE_PRIVATE)
        ageFromPreferences = sharedPreferences.getInt("age", -1)
        if (ageFromPreferences == -1) {
            binding.textView.text = "Your Age: "
        } else {
            binding.textView.text = "Your Age: $ageFromPreferences"

        }


    }

    fun saveButtonOnClick(view: View) {
        val myAge = binding.editTextTextPersonName.text.toString().toIntOrNull()
        if (myAge != null) {
            binding.textView.text = "Your Age: " + myAge
            sharedPreferences.edit().putInt("age", myAge).apply()
        }
    }

    fun delButtonOnClick(view: View) {
        ageFromPreferences = sharedPreferences.getInt("age", - 1)
        if (ageFromPreferences != -1) {
            sharedPreferences.edit().remove("age").apply()
            binding.textView.text = "Your Age: "
        }
    }

}

