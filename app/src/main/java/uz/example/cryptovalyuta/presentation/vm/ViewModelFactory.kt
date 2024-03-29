package uz.example.cryptovalyuta.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.example.cryptovalyuta.di.ApplicationScope
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

@ApplicationScope
class ViewModelFactory @Inject constructor(
    private val viewModelProvider:@JvmSuppressWildcards Map<Class<out ViewModel>,Provider<ViewModel>>
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelProvider[modelClass]?.get() as T
    }
}