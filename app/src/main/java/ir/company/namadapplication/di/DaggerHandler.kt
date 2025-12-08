package ir.company.namadapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaggerHandler {

    @Provides
    fun provideTest(): String {
        return "Hello"
    }

}