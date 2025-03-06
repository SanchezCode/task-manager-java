package com.taskmanager.services;
import com.taskmanager.models.Task;
import com.taskmanager.utils.InputUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class TaskManager {
	private List<Task> tasks;
	InputUtils input = new InputUtils();
	Scanner scanner = new Scanner(System.in);
	public TaskManager() {
		this.tasks = new ArrayList<>();
	}
	public Task createTask() {
		String title = input.promptForInput("Titulo: "); 	
    	String description = input.promptForInput("Descripcion: ");
    	Date dueDate = null;
    	while(dueDate == null) {
	    	String dueDateString = input.promptForInput("Fecha de vencimiento (formato yyyy-mm-dd): ");
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	
	    	try { //Manage Date...
	    		sdf.setLenient(false); //This disable format flexibility like 2000-02-31
	    		dueDate = sdf.parse(dueDateString);
	    		
	    	} catch (ParseException e) {
	    		System.out.println("Error al parsear fecha.");
	    	}
    	}
    	System.out.println("Prioridad (1 - Alta, 2 - Media, 3 - Baja): ");
    	int priority = scanner.nextInt();
    	while(priority < 1 || priority > 3) {
    		System.out.println("Ha ingresado un numero fuera del rango.");
    		System.out.println("Prioridad (1 - Alta, 2 - Media, 3 - Baja): ");
        	priority = scanner.nextInt();
    	}
    
    	Task task = new Task(title, description, dueDate, priority);
    	return task;
	}
	public void addTask() {
//		Task newTask = new Task(title, description, dueDate, priority);
//		tasks.add(newTask);
		Task task = createTask();
    	tasks.add(task);
    	System.out.println("Tarea creada.");
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
			int index = tasks.indexOf(taskToUpdate);
			//Update task
			Task updatedTask = createTask();
			tasks.set(index, updatedTask); 			
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
