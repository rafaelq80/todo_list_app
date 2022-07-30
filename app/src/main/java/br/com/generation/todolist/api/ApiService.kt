package br.com.generation.todolist.api

import br.com.generation.todolist.model.Categoria
import br.com.generation.todolist.model.Tarefa
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("categorias")
    suspend fun listCategoria(): Response<List<Categoria>>

    @POST("tarefas")
    suspend fun addTarefa(
        @Body tarefa: Tarefa
    ): Response<Tarefa>

    @GET("tarefas")
    suspend fun listTarefas(): Response<List<Tarefa>>

    @PUT("tarefas")
    suspend fun updateTarefa(
        @Body tarefa: Tarefa
    ): Response<Tarefa>

    @DELETE("tarefas/{id}")
    suspend fun deleteTarefa(
        @Path("id") valor: Long
    ): Response<Tarefa>

}