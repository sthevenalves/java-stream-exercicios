package listaTarefas;

import java.util.ArrayList;
import java.util.List;

public class ToDo {
    private List<Task> taskList;

    //list precisa ser inicialzado
    public ToDo() {
        this.taskList = new ArrayList<>();
    }

    public void addTask(String name, String description) {
        taskList.add(new Task(name, description));
    }



    public void removeTask(String name) {
        List<Task> taskRemoved = new ArrayList<>();
        if (!(taskList.isEmpty())) {
            taskList.forEach((v) -> {
                if (v.getName().equalsIgnoreCase(name)) {
                    taskRemoved.add(v);
                }
            });
            taskList.removeAll(taskRemoved);
        } else {
            System.out.println("Lista Vazia");
        }
    }

    public int totalTask() {
        return taskList.size();
    }

    public void statusTask() {
        if (!taskList.isEmpty()) {
            taskList.forEach(v -> {
                System.out.println(v.getName() + ", " + v.getDescription());
            });
        }
    }

    public static void main(String[] args) {
        ToDo listTask = new ToDo();
        listTask.addTask("correr", "5km");
        listTask.addTask("estudar", "4h");
        listTask.addTask("cozinhar", "feijao");
        var numTask = listTask.totalTask();
        System.out.println("Total de tarefas: "+numTask);
        listTask.removeTask("cozinhar");
        listTask.statusTask();


    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
