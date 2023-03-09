package com.githukudenis.testingincompose.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class VersionsRepositoryImpl: VersionsRepository {
    override suspend fun getVersions(): Flow<List<AndroidVersionItem>> = flow {
            val versions = listOf(
                AndroidVersionItem(
                    id = 1,
                    title = "Oreo",
                    description = "Android 10"
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
                    description = "Upside down cake"
                ),
                AndroidVersionItem(
                    id = 5,
                    title = "Android 7",
                    description = "Nougat"
                ),
                AndroidVersionItem(
                    id = 6,
                    title = "Android 10",
                    description = "Q"
                ),
                AndroidVersionItem(
                    id = 7,
                    title = "Android 11",
                    description = "R"
                ),
                AndroidVersionItem(
                    id = 8,
                    title = "Android 12",
                    description = "S"
                )
            )
            emit(versions)
        }.flowOn(Dispatchers.IO)
    }