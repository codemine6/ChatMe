package com.kuswand.chatme.di

import com.kuswand.chatme.domain.repository.AuthRepository
import com.kuswand.chatme.domain.use_case.AuthUseCases
import com.kuswand.chatme.domain.use_case.auth.SignInWithEmail
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideAuthUseCases(repository: AuthRepository) = AuthUseCases(
        signInWithEmail = SignInWithEmail(repository)
    )
}