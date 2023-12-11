package uz.example.cryptovalyuta.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import uz.example.cryptovalyuta.data.CoinInfoRepositoryImpl
import uz.example.cryptovalyuta.data.database.AppDatabase
import uz.example.cryptovalyuta.data.database.CoinPriceInfoDao
import uz.example.cryptovalyuta.domain.CoinRepository

@Module

interface DataModule {

    @Binds
    fun bindsCoinRepository(coinInfoRepositoryImpl: CoinInfoRepositoryImpl): CoinRepository

    companion object {
        @Provides
        fun providesCoinPriceInfoDao(context: Context): CoinPriceInfoDao {
            return AppDatabase.getInstens(context).coinPriceInfoDao()
        }
    }
}