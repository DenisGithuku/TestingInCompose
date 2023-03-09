package com.githukudenis.testingincompose.views.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.githukudenis.testingincompose.data.VersionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val versionRepo: VersionsRepository
) : ViewModel() {

    private val _state = mutableStateOf(HomeUiState())
    val state: State<HomeUiState> get() = _state

    init {
        getVersions()
    }

    private fun getVersions() {
        viewModelScope.launch {
                _state.value.copy(
                    isLoading = true
                )
                versionRepo.getVersions()
                    .collect {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            versions = it
                        )
                    }
            Log.d("versions", _state.value.versions.toString())

        }
    }
}