// define o pacote para essa classe
package com.example.taskapi.model;

// importa a classe LocalDate do pacote java.time
import java.time.LocalDate;

// define a classe Task
public class Task {
    // declara variaveis privadas
    private long id;              // indentificador único da tarefa
    private String title;         // título da tarefa
    private String description;   // descrição da tarefa
    private LocalDate dueDate;    // data de vencimento da tarefa

    // construtor padrão de Task
    public Task() {
    }

    // construtor parametrizado para a classe Task
    public Task(long id, String title, String description, LocalDate dueDate){
        // inicializa as variaveis de instância  com os valores fornecidos
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    // getters e seters para as variáveis de instância
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

}
