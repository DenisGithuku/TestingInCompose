package com.githukudenis.testingincompose.views.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.githukudenis.testingincompose.data.AndroidVersionItem
import com.githukudenis.testingincompose.data.VersionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val versionsRepository: VersionsRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(AndroidVersionItem())
    val state: State<AndroidVersionItem> get() = _state

    init {
        val versionId: Long = checkNotNull(savedStateHandle["versionId"])
        getVersionDetails(versionId)
    }

    private fun getVersionDetails(versionId: Long) {
        viewModelScope.launch {
            versionsRepository.getVersions().collect {
                val item = it.find {
                    it.id == versionId
                }
                _state.value = _state.value.copy(
                    id = item?.id ?: return@collect,
                    title = item?.title,
                    description = item?.description
                )
            }
        }
    }
}