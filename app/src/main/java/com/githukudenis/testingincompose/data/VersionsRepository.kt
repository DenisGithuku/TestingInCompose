package com.githukudenis.testingincompose.data

import kotlinx.coroutines.flow.Flow

interface VersionsRepository {
    suspend fun getVersions(): Flow<List<AndroidVersionItem>>
}