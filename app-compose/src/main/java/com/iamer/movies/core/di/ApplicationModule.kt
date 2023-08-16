package com.iamer.movies.core.di

import com.iamer.movies.features.movies.data.network.MoviesApi
import com.iamer.movies.features.movies.data.network.MoviesService
import com.iamer.movies.features.movies.data.repositories.MoviesRepositoryImpl
import com.iamer.movies.features.movies.domain.repositories.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideMoviesService(moviesService: MoviesService): MoviesApi = moviesService

    @Provides
    @Singleton
    fun provideMoviesRepository(moviesRepository: MoviesRepositoryImpl): MoviesRepository =
        moviesRepository


}