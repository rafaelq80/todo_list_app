package br.com.generation.todolist.api

import br.com.generation.todolist.model.Categoria
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("categorias")
    suspend fun listCategoria(): Response<List<Categoria>>

}