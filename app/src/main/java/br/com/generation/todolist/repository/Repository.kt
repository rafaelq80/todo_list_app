package br.com.generation.todolist.repository

import br.com.generation.todolist.api.RetrofitInstance
import br.com.generation.todolist.model.Categoria
import br.com.generation.todolist.model.Tarefa
import retrofit2.Response

class Repository {

    suspend fun listCategoria(): Response<List<Categoria>> {
        return RetrofitInstance.api.listCategoria()
    }

    suspend fun addTarefa(tarefa: Tarefa): Response<Tarefa>{
        return RetrofitInstance.api.addTarefa(tarefa)
    }

    suspend fun listTarefas(): Response<List<Tarefa>> {
        return RetrofitInstance.api.listTarefas()
    }

    suspend fun updateTarefa(tarefa: Tarefa): Response<Tarefa>{
        return RetrofitInstance.api.updateTarefa(tarefa)
    }

    suspend fun deleteTarefa(id: Long): Response<Tarefa> {
        return RetrofitInstance.api.deleteTarefa(id)
    }
}