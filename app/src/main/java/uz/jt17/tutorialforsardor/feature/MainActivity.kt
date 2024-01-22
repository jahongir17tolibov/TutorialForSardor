package uz.jt17.tutorialforsardor.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.jt17.tutorialforsardor.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<MainViewModel>()
    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycler()

        viewModel.getData.onEach { data ->
            myAdapter.setList = data

            if (data.isEmpty()) binding.apply {
                myRecycler.isVisible = false
                isEmptyTextView.isVisible = true
            }
            else binding.apply {
                myRecycler.isVisible = true
                isEmptyTextView.isVisible = false
            }
        }.launchIn(lifecycleScope)  

        binding.floatingButton.setOnClickListener {
            viewModel.insertData(getCurrentDateMillis())
        }

        myAdapter.setOnItemClickListener { id ->
            viewModel.deleteItem(id)
        }

        binding.floatingButton.setOnLongClickListener {
            viewModel.clearAllData()
            true
        }

    }

    private fun setupRecycler() {
        binding.myRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myAdapter
        }
    }

    private fun getCurrentDateMillis(): String {
        val currentDate = Date().time
        val dateFormat = SimpleDateFormat("dd-MMM, HH:mm:ss", Locale.getDefault())

        return dateFormat.format(currentDate)
    }

}