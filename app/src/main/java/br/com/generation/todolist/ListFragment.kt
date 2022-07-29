package br.com.generation.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.generation.todolist.adapter.TarefaAdapter
import br.com.generation.todolist.databinding.FragmentListBinding
import br.com.generation.todolist.model.Tarefa


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        //Configuração do RecyclerView
        val tarefaAdapter = TarefaAdapter()
        binding.recyclerTarefa.adapter = tarefaAdapter
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.setHasFixedSize(true)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        val listTarefa = listOf(
            Tarefa(
                1,
                "Tarefa 01",
                "Descrição da Tarefa 01",
                "Responsável 01",
                "2002-07-28",
                false,
                "diária"
            ),
            Tarefa(
                2,
                "Tarefa 02",
                "Descrição da Tarefa 02",
                "Responsável 02",
                "2002-07-29",
                true,
                "semanal"
            ) ,
            Tarefa(
            3,
            "Tarefa 03",
            "Descrição da Tarefa 03",
            "Responsável 03",
            "2002-07-30",
            false,
            "mensal"
            )
        )

        tarefaAdapter.setList(listTarefa)

        return binding.root
    }

}