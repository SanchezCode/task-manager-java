package com.taskmanager.models;
import java.util.Date;

public class Task {
	private String title;
	private String description;
	private Date dueDate; //Fecha de vencimiento
	private boolean isCompleted;
	private int priority;
	private Date createdAt;
	private Date completedAt;
	
	public Task(String title, String description, Date dueDate, int priority) {
		this.title = title;
		this.setDescription(description);
		this.setDueDate(dueDate);
		this.isCompleted = false;
		this.setPriority(priority);
		this.createdAt = new Date(); //creado en la fecha actual
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
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public boolean getIsCompleted() {
		return isCompleted;
	}
	public void completeTask() {
		this.isCompleted = true;
		this.setCompletedAt(new Date()); //de modo que se completo en la fecha actual
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Date getCompletedAt() {
		return completedAt;
	}
	public void setCompletedAt(Date completedAt) {
		this.completedAt = completedAt;
	}
	
    @Override
    public String toString() {
        return "[title=" + title + 
        		", \ndescription=" + description + 
        		", \ndueDate=" + dueDate + 
        		", \nisCompleted=" + isCompleted + 
        		", \npriority=" + priority + 
        		", \ncreatedAt=" + createdAt + 
        		", \ncompletedAt=" + completedAt + "]";
    }

}
