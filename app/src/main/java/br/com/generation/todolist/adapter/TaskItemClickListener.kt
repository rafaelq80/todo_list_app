package br.com.generation.todolist.adapter

import br.com.generation.todolist.model.Tarefa

interface TaskItemClickListener {

    fun onTaskClickListener(tarefa: Tarefa)

}