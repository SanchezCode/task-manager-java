package com.taskmanager;

import java.util.Date;

import com.taskmanager.models.Task;

public class Main {

	public static void main(String[] args) {
		Task task1 = new Task("Hacer ejercicio", "Tengo que ir al gym si quiero estar en forma", new Date(), 1);
		System.out.print(task1.toString());	
		task1.completeTask();
		System.out.println("Tarea completada!");
		System.out.print(task1.toString());	
	}

}
