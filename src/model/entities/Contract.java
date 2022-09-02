package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	private Integer number;
	private LocalDate date;
	private Double totalValue;
	private List<Installment> installments = new ArrayList<>();
	
	public Contract(Integer number, LocalDate date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}
	private Integer getNumber() {
		return number;
	}
	private void setNumber(Integer number) {
		this.number = number;
	}
	public LocalDate getDate() {
		return date;
	}
	private void setDate(LocalDate date) {
		this.date = date;
	}
	public Double getTotalValue() {
		return totalValue;
	}
	private void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	public List<Installment> getInstallments() {
		return installments;
	}
	public void addInstallment(Installment installment) {
		this.installments.add(installment);
	}
	
	
}
