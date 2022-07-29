package br.com.generation.todolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.generation.todolist.R
import br.com.generation.todolist.model.Tarefa

class TarefaAdapter : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>(){

    private var listTarefas = emptyList<Tarefa>()

    class TarefaViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val textNome = view.findViewById<TextView>(R.id.textNome)
        val textDescricao = view.findViewById<TextView>(R.id.textDescricao)
        val textResponsavel = view.findViewById<TextView>(R.id.textResponsavel)
        val textData = view.findViewById<TextView>(R.id.textData)
        val switchAtivoCard = view.findViewById<TextView>(R.id.switchAtivo)
        val textCategoria = view.findViewById<TextView>(R.id.textCategoria)
        val buttonDeletar = view.findViewById<TextView>(R.id.buttonDeletar)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
         val layoutAdapter  = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent, false)

         return TarefaViewHolder(layoutAdapter)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = listTarefas[position]

        holder.textNome.text = tarefa.nome
        holder.textDescricao.text = tarefa.descricao
        holder.textResponsavel.text = tarefa.responsavel
        holder.textData.text = tarefa.data
        holder.switchAtivoCard.isPressed = tarefa.status
        holder.textCategoria.text = tarefa.categoria
    }

    override fun getItemCount(): Int {
        return listTarefas.size
    }

    fun setList(tarefas: List<Tarefa>){
        this.listTarefas = tarefas
        notifyDataSetChanged()
    }
}