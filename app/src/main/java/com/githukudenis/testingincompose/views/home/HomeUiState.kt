package com.githukudenis.testingincompose.views.home

import com.githukudenis.testingincompose.data.AndroidVersionItem

data class HomeUiState(
    val isLoading: Boolean = false,
    val versions: List<AndroidVersionItem> = emptyList()
)