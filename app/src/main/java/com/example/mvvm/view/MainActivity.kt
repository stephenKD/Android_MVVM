package com.example.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.eddy.tkr.model.market.TickersDto
import com.example.mvvm.R
import com.example.mvvm.dto.Resource
import com.example.mvvm.dto.Status
import com.example.mvvm.viewmodel.TickersViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val model: TickersViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            model.getTickers()
        }


        model.tickers.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    Toast.makeText(this@MainActivity, it.data?.result?.tickers.toString(), Toast.LENGTH_SHORT).show()
                }
                Status.ERROR -> {
                    Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })

    }
}
