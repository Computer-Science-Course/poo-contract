package model.entities;

import java.time.LocalDate;

public class Installment {
	private LocalDate dueDate;
	private Double amount;
	
	public Installment(LocalDate dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	private void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public Double getAmount() {
		return amount;
	}
	private void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}
