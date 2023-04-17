package com.example.classhangman.email

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.classhangman.R
import com.example.classhangman.databinding.ActivityEmailBinding
import com.google.android.material.chip.Chip

class EmailActivity : AppCompatActivity() {

    lateinit var binding: ActivityEmailBinding

    val possibleEmails = listOf(
        "pau.garcia@enti.cat",
        "pau.garcia@gmail.com",
        "marta.garcia@gmail.cat",
        "jose@enti.cat",
        "montserrat@enti.cat"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.emailToSerachBar.setAdapter(
            ArrayAdapter(this, R.layout.item_search_view_email, possibleEmails)
        )

        binding.emailToSerachBar.setOnItemClickListener { parent, _, position, _ ->
            val email = parent.getItemAtPosition(position).toString()
            val chip = Chip(this)
            chip.text = email
            chip.setChipIconResource(R.drawable.ic_baseline_cancel_24)
            chip.setOnClickListener {
                binding.chipGroup.removeView(chip)
            }

            binding.chipGroup.addView(chip)
            binding.emailToSerachBar.setText("")
        }

    }
}