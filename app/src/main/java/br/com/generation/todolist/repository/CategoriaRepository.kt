package br.com.generation.todolist.repository

import br.com.generation.todolist.api.RetrofitInstance
import br.com.generation.todolist.model.Categoria
import retrofit2.Response

class CategoriaRepository {

    suspend fun listCategoria(): Response<List<Categoria>> {
        return RetrofitInstance.api.listCategoria()
    }

}