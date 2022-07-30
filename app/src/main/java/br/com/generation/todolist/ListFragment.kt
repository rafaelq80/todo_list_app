package br.com.generation.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.generation.todolist.adapter.TarefaAdapter
import br.com.generation.todolist.adapter.TaskItemClickListener
import br.com.generation.todolist.databinding.FragmentListBinding
import br.com.generation.todolist.model.Tarefa


class ListFragment : Fragment(), TaskItemClickListener {

    private lateinit var binding: FragmentListBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        mainViewModel.listTarefas()

        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        //Configuração do RecyclerView
        val adapter = TarefaAdapter(this, mainViewModel, requireContext())
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.setHasFixedSize(true)

        binding.floatingActionButton.setOnClickListener {
            mainViewModel.tarefaSelecionada = null
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        mainViewModel.myTarefaResponse.observe(viewLifecycleOwner) {
                response -> if (response != null){
                    adapter.setList(response.body() !!)
                }
        }

        return binding.root
    }

    override fun onTaskClickListener(tarefa: Tarefa) {
        mainViewModel.tarefaSelecionada = tarefa
        findNavController().navigate(R.id.action_listFragment_to_formFragment)
    }

}