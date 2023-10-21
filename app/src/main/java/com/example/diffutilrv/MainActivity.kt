package com.example.diffutilrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diffutilrv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //why using lazy, because for creating an object that will be initialized at the first access to it
    //can use the lazy method

    private val sampleAdapter by lazy { SampleAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sampleAdapter.differ.submitList(loadData())

        binding.apply {
            rvMain.apply {
                layoutManager=LinearLayoutManager(this@MainActivity)
                adapter=sampleAdapter
            }
        }
    }

    fun loadData() : MutableList<SampleModel>{
        val nameList : MutableList<SampleModel> = mutableListOf()
        nameList.add(SampleModel(1, "Sample Name"))
        nameList.add(SampleModel(2, "Sample Two"))
        nameList.add(SampleModel(3, "Sample Three"))
        nameList.add(SampleModel(4, "Sample Four"))
        nameList.add(SampleModel(5, "Sample Five"))

        return nameList
    }
}