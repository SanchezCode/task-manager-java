package com.taskmanager.services;
import com.taskmanager.models.Task;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



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
	
	private Task getTaskByName(String title) {
		for(Task task: tasks) {
			if(task.getTitle().equals(title)) {
				return task;
			}
		}
		System.out.println("No se ha encontrado la tarea.");
		return null;
	}
	
	public void deleteTask(String title) {
		Task taskToRemove = getTaskByName(title);
		if(taskToRemove != null) {
			tasks.remove(taskToRemove);
			System.out.println("La tarea: " + taskToRemove.getTitle() + " se ha borrado.");
		} else {
			System.out.println("La tarea no se encontro.");
		}
		
	}
	
	public void updateTask(String title) {
		Task taskToUpdate = getTaskByName(title);
		if(taskToUpdate != null) {
			Scanner input = new Scanner(System.in);
			int index = tasks.indexOf(taskToUpdate);
			
			System.out.println("Nuevo titulo: ");
			String newTitle = input.nextLine();
			
			System.out.println("Nueva descripcion: ");
			String newDescription = input.nextLine();
			
			System.out.println("Nueva fecha de vencimiento (formato yyyy-mm-dd): ");
			String newDueDateString = input.nextLine();
        	Date dueDate = new Date();
        	
			System.out.println("Nueva prioridad (1 - Alta, 2 - Media, 3 - Baja): ");
			int newPriority = input.nextInt();
			
			//Update task
			Task updatedTask = new Task(newTitle, newDescription, dueDate, newPriority);
			tasks.set(index, updatedTask); 
//			System.out.println(index);
			
		}
		
	}
	
	public void completeTask(String title) {
		Task taskToComplete = getTaskByName(title);
		if(taskToComplete != null) {
			taskToComplete.completeTask();
		} else {
			System.out.println("La tarea no se encontro.");
		}
	}
	
}
