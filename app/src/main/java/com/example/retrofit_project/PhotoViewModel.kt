package com.example.retrofit_project

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_project.api.Photo
import com.example.retrofit_project.repository.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModel() {

    private val _photoState = mutableStateOf(PhotoState())
    val photoState: State<PhotoState> = _photoState

    init {
        getRandomDog()
    }

    fun getRandomDog() {
        viewModelScope.launch {
            try {
                _photoState.value = photoState.value.copy(isLoading = true)
                _photoState.value = photoState.value.copy(
                    photo = photoRepository.getPhoto(),
                    isLoading = false
                )

            }
            catch (e : Exception) {
                Log.e("pvm", "getRandomDog() =", e)
                _photoState.value = photoState.value.copy(isLoading = false)
            }
        }
    }

    data class PhotoState(
        val photo: Photo? = null,
        val isLoading: Boolean = false
    )
}