package com.taskmanager.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.taskmanager.services.TaskManager;

public class TaskMenu {
	TaskManager taskManager = new TaskManager();
	Scanner input = new Scanner(System.in);
	
	public void startMenu() {
		showMenu();
	}
	
	private void showMenu() {
		boolean exit = false;
		while(!exit) {
	        System.out.println("\n--- Menú ---");
	        System.out.println("1. Listar tareas");
	        System.out.println("2. Crear nueva tarea");
	        System.out.println("3. Eliminar tarea");
	        System.out.println("4. Completar tarea");
	        System.out.println("5. Actualizar tarea");
	        System.out.println("6. Salir");
	        System.out.print("Selecciona una opción: ");
	        try {
	        int option = input.nextInt();
	        input.nextLine();  // Limpiar el buffer
	        switch(option) {
		        case 1: 
		        	taskManager.listTasks();
		        	break;
		        case 2:
		        	String title = promptForInput("Titulo: "); 	
		        	String description = promptForInput("Descripcion: ");
		        	String dueDateString = promptForInput("Fecha de vencimiento (formato yyyy-mm-dd): ");
		        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		        	Date dueDate = null;
		        	
		        	try {
		        		dueDate = sdf.parse(dueDateString);
		        	} catch (ParseException e) {
		        		System.out.println("Ërror al parsear fecha.");
		        	}
		        	
		        	System.out.println("Prioridad (1 - Alta, 2 - Media, 3 - Baja): ");
		        	int priority = input.nextInt();
		        
		        	taskManager.addTask(title, description, dueDate, priority);
		        	System.out.println("Tarea creada.");
		        	break;
		        case 3:
		        	System.out.println("Ingresar nombre de la tarea: ");
		        	String removeTaskTitle = input.nextLine();
		        
		        	taskManager.deleteTask(removeTaskTitle);
		        	break;
		        case 4:
		        	System.out.println("Ingresar nombre de la tarea completada: ");
		        	String completedTaskTitle = input.nextLine();
		        	
		        	taskManager.completeTask(completedTaskTitle);
		        	break;
		        case 5:
		        	System.out.println("Ingresar titulo de la tarea a actualizar: ");
		        	String updateTaskTitle = input.nextLine();
		        	
		        	taskManager.updateTask(updateTaskTitle);
		        	break;
		        case 6:
		        	System.out.println("Saliendo...");
		        	exit = true; 
		        	return;
		        default:
		        	System.out.println("Opcion invalida.");
		        }
	        } catch(InputMismatchException e) {
	        	System.out.println("Entrada invalida.");
	        	input.nextLine();
	        }
		}
	}
	
	private String promptForInput(String message) {
	    System.out.println(message);
	    return input.nextLine();
	}

}
