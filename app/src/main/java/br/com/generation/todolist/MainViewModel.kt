package br.com.generation.todolist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.generation.todolist.model.Categoria
import br.com.generation.todolist.repository.CategoriaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val categoriaRepository: CategoriaRepository
): ViewModel(){

    private var _myCategoriaResponse =
        MutableLiveData<Response<List<Categoria>>>()

    val dataSelecionada = MutableLiveData<LocalDate>()

   val myCategoriaResponse: LiveData<Response<List<Categoria>>> =
        _myCategoriaResponse

    init {
        dataSelecionada.value = LocalDate.now()
        listCategoria()
    }

    private fun listCategoria(){
        viewModelScope.launch{
            try {
                val response = categoriaRepository.listCategoria()
                _myCategoriaResponse.value = response
            }catch (e: Exception){
                Log.d("Error", e.message.toString())
            }
        }
    }

}