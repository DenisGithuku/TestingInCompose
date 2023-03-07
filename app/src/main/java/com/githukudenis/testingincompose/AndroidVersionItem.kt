package com.githukudenis.testingincompose

data class AndroidVersionItem(
    val id: Long = 0L,
    val title: String? = null,
    val description: String? = null
)

val androidVersions = listOf(
    AndroidVersionItem(
        id = 1,
        title = "Oreo",
        description = "Android 8"
    ),
    AndroidVersionItem(
        id = 2,
        title = "Pie",
        description = "Android 9"
    ),
    AndroidVersionItem(
        id = 3,
        title = "Android 13",
        description = "Tiramisu"
    ),
    AndroidVersionItem(
        id = 4,
        title = "Android 14",
        description = "Cupcake"
    ),
    AndroidVersionItem(
        id = 5,
        title = "Android 7",
        description = "Nougat"
    )
)