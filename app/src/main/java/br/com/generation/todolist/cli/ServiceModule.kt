package br.com.generation.todolist.cli

import br.com.generation.todolist.repository.CategoriaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provideRepository(): CategoriaRepository {
        return CategoriaRepository()
    }

}