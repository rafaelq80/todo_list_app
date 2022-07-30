package br.com.generation.todolist.api

import br.com.generation.todolist.model.Categoria
import br.com.generation.todolist.model.Tarefa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("categorias")
    suspend fun listCategoria(): Response<List<Categoria>>

    @POST("tarefas")
    suspend fun addTarefa(
        @Body tarefa: Tarefa
    ): Response<Tarefa>

}