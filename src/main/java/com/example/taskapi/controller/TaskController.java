//  define o pacote para esta classe
package com.example.taskapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// importa  as classes Task e TaskRepository
import com.example.taskapi.model.Task;
import com.example.taskapi.repository.TaskRepository;
// marca esta classe como um contraldor spring
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepository repository;

    // construtor que injeta uma instância da TaskRepository
    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    // método para obter todoas as tarefas
    @GetMapping
    @CrossOrigin(origins = "https://front-full-stack-chi.vercel.app/")
    public List<Task> getAllList() {
        return repository.findAll();
    }

    // método para obter uma tarefa com base em seu ID
    @GetMapping("/{id}")
    @CrossOrigin(origins = "https://front-full-stack-chi.vercel.app/")
    public Task getTask(@PathVariable long id) {
        return repository.findById(id);
    }

    // método para criar uma nova tarefa a partir dos dados no corpo da solicitação
    @PostMapping
    @CrossOrigin(origins = "https://front-full-stack-chi.vercel.app/")
    public Task createTask(@RequestBody Task task) {
        return repository.save(task);
    }

    // método para atualizar uma tarefa com base em seu ID
    @PutMapping("/{id}")
    @CrossOrigin(origins = "https://front-full-stack-chi.vercel.app/")
    public Task updateTask(@PathVariable long id, @RequestBody Task updateTask) {
        updateTask.setId(id); // gaernte que o ID do caminho seja usado
        return repository.save(updateTask);
    }

    // método para excluir uma tarefa com base em seu ID
    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "https://front-full-stack-chi.vercel.app/")
    public void deleteTask(@PathVariable long id) {
        repository.delete(id);
    }
}