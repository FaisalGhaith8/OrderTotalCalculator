package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.*
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val main: Spinner = findViewById(R.id.main)
        val side: Spinner = findViewById(R.id.side)
        val drink: Spinner = findViewById(R.id.drink)
        val findtotal: Button = findViewById(R.id.findtotal)
        val total: TextView = findViewById(R.id.total)

        var main_options = arrayOf("Burger ($5)", "Pizza ($8)", "Shawerma ($3)")
        var side_options = arrayOf("None","Fries ($1.5)", "Mozzarella Sticks ($2)")
        var drink_options = arrayOf("None","Soft Drink ($0.5)", "Juice($0.75)", "Water ($0.25)")

        var main_prices = arrayOf(5, 8, 3)
        var side_prices = arrayOf(0F,1.5F, 2F)
        var drink_prices = arrayOf(0F,0.5F, 0.75F, 0.25F)

        main.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, main_options)
        side.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, side_options)
        drink.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, drink_options)

        var selected_main_index: Int = 0
        main.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selected_main_index = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        var selected_side_index: Int = 0
        side.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selected_side_index = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        var selected_drink_index: Int = 0
        drink.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selected_drink_index = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        findtotal.setOnClickListener { view ->
            total.text = "Your total is: $" + (main_prices[selected_main_index] + side_prices[selected_side_index] + drink_prices[selected_drink_index]).toString()
        }


    }
}

