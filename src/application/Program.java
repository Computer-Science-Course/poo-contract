package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;
public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter contract data");
		System.out.print("Account number: ");
		Integer contract_number = scanner.nextInt();
		scanner = new Scanner(System.in);
		
		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate contract_date = LocalDate.parse(scanner.nextLine(), formatter);

		System.out.print("Contract value: ");
		Double contract_value = scanner.nextDouble();
		
		Contract contract = new Contract(contract_number, contract_date, contract_value);
		
		System.out.print("Number of installment: ");
		Integer number_of_installments = scanner.nextInt();
		
		ContractService paypal = new ContractService(new PaypalService());
		
		paypal.processContract(contract, number_of_installments);
		
		System.out.println("Installments");
		for(Installment installment: contract.getInstallments()) {
			System.out.printf("%s - %.2f\n", installment.getDueDate().format(formatter), installment.getAmount());
		}
	}

}
