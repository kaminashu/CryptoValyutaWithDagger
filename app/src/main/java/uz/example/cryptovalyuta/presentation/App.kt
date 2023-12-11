package uz.example.cryptovalyuta.presentation

import android.app.Application
import com.mocklets.pluto.Pluto
import uz.example.cryptovalyuta.di.DaggerAndroidComponent

class App :Application(){
    override fun onCreate() {
        Pluto.initialize(this)
        super.onCreate()
    }
    val component by lazy {
DaggerAndroidComponent.factory().create(this)
    }
}