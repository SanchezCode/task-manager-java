package com.taskmanager.utils;
import java.util.Scanner;

public class InputUtils {
	Scanner input = new Scanner(System.in);
	
	public String promptForInput(String message) {
	    System.out.println(message);
	    return input.nextLine();
	}
}

