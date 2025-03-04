package com.taskmanager.services;
import com.taskmanager.models.Task;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class TaskManager {
	private List<Task> tasks;
	
	public TaskManager() {
		this.tasks = new ArrayList<>();
	}
	
	public void addTask(String title, String description, Date dueDate, int priority) {
		Task newTask = new Task(title, description, dueDate, priority);
		tasks.add(newTask);
	}
	
	public void listTasks() {
		if(tasks.isEmpty()) {
			System.out.println("La lista esta vacia.");
		} else {
			for(Task task: tasks) {
				System.out.println(task);
			}
		}
	}
	
	public void deleteTask(String title) {
		Task taskToRemove = null;
		
		for(Task task: tasks) {
			if(task.getTitle().equals(title)) {
				taskToRemove = task; break;
			}
		}
		if(taskToRemove != null) {
			tasks.remove(taskToRemove);
			System.out.println("La tarea: " + taskToRemove.getTitle() + " se ha borrado.");
		} else {
			System.out.println("La tarea no se encontro.");
		}
		
	}
	
	public void completeTask(String title) {
		for(Task task: tasks) {
			if(task.getTitle().equals(title)) {
				task.completeTask();
				System.out.println("Tarea: " + task.getTitle() + "completada!");
			} else {
				System.out.println("La tarea no se encontro.");
			}
		}
	}
	
	public Task getTaskByName(String title) {
		for(Task task: tasks) {
			if(task.getTitle().equals(title)) {
				return task;
			}
		}
		System.out.println("No se ha encontrado la tarea.");
		return null;
	}
}
