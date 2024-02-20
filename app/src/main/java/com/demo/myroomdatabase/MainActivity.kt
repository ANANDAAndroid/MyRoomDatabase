package com.demo.myroomdatabase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.material.button.MaterialButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity(),GetDataFromSource {
    @Inject
    internal lateinit var appDataBase: AppDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel= ViewModelProvider(this)[ViewModel::class.java]

        findViewById<MaterialButton>(R.id.insert).setOnClickListener{
            val arrayList=ArrayList<User>()
            for (i in 0..5){
                arrayList.add(User(name = "ananda", os = "Android", amount = 100, language = "bengali"))
            }
            lifecycleScope.launch(Dispatchers.IO) {
                appDataBase.myDao().insertAll(arrayList)

            }
        }

        findViewById<MaterialButton>(R.id.insert2).setOnClickListener{
            lifecycleScope.launch(Dispatchers.IO) {
                val array= arrayOf(Student(name = "Ananda",rollNumber = 20),Student(name = "Ananda",rollNumber = null))
                appDataBase.myDao().insertAllStudent(array)
            }

        }

        findViewById<MaterialButton>(R.id.update).setOnClickListener{
            lifecycleScope.launch(Dispatchers.IO) {
                appDataBase.myDao().update("ananda")
            }

        }
        findViewById<MaterialButton>(R.id.delete).setOnClickListener{
            lifecycleScope.launch(Dispatchers.IO) {
                appDataBase.myDao().delete(User(id = 1, name = "ananda", os = "Android", amount = 100, language = "bengali"))
            }
        }
        findViewById<MaterialButton>(R.id.fetch).setOnClickListener{
                viewModel.getData()
        }

        viewModel.data.observe(this){
            when(it){
                is Status.Processing ->{
                    Toast.makeText(this, "Fetching", Toast.LENGTH_SHORT).show()
                }
                is Status.Success ->{

                    Thread.sleep(2000)
                    Toast.makeText(this, it.value.toString(), Toast.LENGTH_SHORT).show()
                }
                is Status.Failure ->{

                }
            }

        }



    }
}