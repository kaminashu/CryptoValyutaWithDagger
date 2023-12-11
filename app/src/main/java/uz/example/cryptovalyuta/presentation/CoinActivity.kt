package uz.example.cryptovalyuta.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import uz.example.cryptovalyuta.databinding.ActivityCoinBinding
import uz.example.cryptovalyuta.domain.CoinInfo
import uz.example.cryptovalyuta.presentation.vm.CoinViewModel
import uz.example.cryptovalyuta.presentation.vm.ViewModelFactory
import javax.inject.Inject

class CoinActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var coinViewModel: CoinViewModel
    private lateinit var adapter: CoinAdapter
    private lateinit var binding: ActivityCoinBinding
     val component by lazy {
        (application as App).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCoinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        component.inject(this)
        coinViewModel = ViewModelProvider(this, viewModelFactory)[CoinViewModel::class.java]
        adapter = CoinAdapter()

        adapter.onclick = object : CoinAdapter.OnClickItem {
            override fun onCoinClick(coinInfo: CoinInfo) {
                val newIntent = CoinActivityDetail.newIntent(this@CoinActivity, coinInfo.fromSymbol)
                startActivity(newIntent)
            }

        }
        coinViewModel.coinInfoList.observe(this) {
            adapter.submitList(it)
        }
        binding.rec.itemAnimator = null
        binding.rec.adapter = adapter

    }


}