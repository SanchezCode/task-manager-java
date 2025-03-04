package com.taskmanager;

import java.util.Date;
import java.util.Scanner;

import com.taskmanager.models.Task;
import com.taskmanager.services.TaskManager;

public class Main {

	public static void main(String[] args) {
		TaskManager taskManager = new TaskManager();
		Scanner input = new Scanner(System.in);
		while(true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Listar tareas");
            System.out.println("2. Crear nueva tarea");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Completar tarea");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int option = input.nextInt();
            input.nextLine();  // Limpiar el buffer
            switch(option) {
            case 1: 
            	taskManager.listTasks();
            	break;
            case 2:
            	System.out.println("Titulo de la tarea: ");
            	String title = input.nextLine();
            	System.out.println("Descripcion: ");
            	String description = input.nextLine();
            	System.out.println("Fecha de vencimiento (formato yyyy-mm-dd): ");
            	String dueDateString = input.nextLine();
            	Date dueDate = new Date();
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
            	System.out.println("Saliendo...");
            	return;
            default:
            	System.out.println("Opcion invalida.");
            }
		}
	}

}
