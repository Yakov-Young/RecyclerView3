package com.example.recyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), CellClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rView)
        recyclerView.layoutManager = LinearLayoutManager(this) //Вид отображение списка верт/гор \ выбирает текущую компановку
        recyclerView.adapter = Adapter(this, list,this)
    }
    private val list = arrayListOf(ColorData(Color.RED, "Red"),
        ColorData(Color.GREEN, "Green"),
        ColorData(Color.BLUE, "Blue"),
        ColorData(Color.BLACK, "Black"),
        ColorData(Color.WHITE, "White"),
        ColorData(Color.DKGRAY, "DkGray"),
        ColorData(Color.MAGENTA, "Magenta"),
        ColorData(Color.YELLOW, "Yellow")
    )
    override fun onCellClickListener(data: ColorData) {
        Toast.makeText(this, "IT'S " + data.colorName, Toast.LENGTH_SHORT).show()
    }
}

class ColorData(
    val colorHex: Int,
    val colorName: String
)

interface CellClickListener {
    fun onCellClickListener(data: ColorData)
}