package com.githukudenis.testingincompose.di

import com.githukudenis.testingincompose.data.VersionsRepository
import com.githukudenis.testingincompose.data.VersionsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object VersionsModule {
    @Provides
    @Singleton
    fun provideVersionsRepo(): VersionsRepository {
        return VersionsRepositoryImpl()
    }
}