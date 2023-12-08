// define pacote para essa classe
package com.example.taskapi.repository;

// importar as classes Task e Repository
import com.example.taskapi.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

// marcar esse repositorio como repositorio Spring
@Repository
public class TaskRepository {
    // declara uma lista de tarefas para armazenar as tarefas
    private final List<Task> tasks = new ArrayList<>();
    // declara um gerador de ID atômico para garantir IDs exclusivos
    private final AtomicLong idGenerator = new AtomicLong();
    
    // método para obter todas as tarefas
    public List<Task> findAll() {
        return tasks;
    }

    // método para encontrar uma tarefa por seu ID
    public Task findById(long id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // método para salvar uma tarefa
    public Task save(Task task) {
        if (task.getId() == 0) {
            // tarefa nova atribuir um ID único
            task.setId(idGenerator.incrementAndGet());
        } else {
            // tarefa existente, atualiza
            tasks.removeIf(t -> t.getId() == task.getId());
        }
        tasks.add(task);
        return task;
    }

    // método para execluir um tarefa por seu ID
    public void delete(long id) {
        tasks.removeIf(task -> task.getId() == id);
    }
}