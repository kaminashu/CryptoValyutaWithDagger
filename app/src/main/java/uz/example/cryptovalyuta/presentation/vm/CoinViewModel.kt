package uz.example.cryptovalyuta.presentation.vm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.example.cryptovalyuta.data.CoinInfoRepositoryImpl
import uz.example.cryptovalyuta.data.database.AppDatabase
import uz.example.cryptovalyuta.data.network.ApiClient
import uz.example.cryptovalyuta.data.network.ApiService
import uz.example.cryptovalyuta.data.model.CoinInfoDto
import uz.example.cryptovalyuta.data.model.CoinInfoJsonContainerDto
import uz.example.cryptovalyuta.domain.GetCoinInfoListUseCase
import uz.example.cryptovalyuta.domain.GetCoinInfoUseCase
import uz.example.cryptovalyuta.domain.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    private val loadDataUseCase: LoadDataUseCase,
) : ViewModel() {


    val coinInfoList = getCoinInfoListUseCase()
    fun getDetailInfo(fSmy: String) = getCoinInfoUseCase(fSmy)

    init {
        loadDataUseCase()
    }


}