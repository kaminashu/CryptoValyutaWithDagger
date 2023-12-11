package uz.example.cryptovalyuta.di

import android.view.View
import androidx.lifecycle.ViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.example.cryptovalyuta.presentation.vm.CoinViewModel

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelMapKey(CoinViewModel::class)
    fun bindsCoinViewModel(impl:CoinViewModel):ViewModel

}