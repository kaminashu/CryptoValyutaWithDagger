package uz.example.cryptovalyuta.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelMapKey (val value :KClass<out ViewModel>)