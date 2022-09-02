package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, Integer months) {
		
		Double basic_quota = contract.getTotalValue() / months;
		
		for(Integer month = 1; month <= months; month++) {
			LocalDate date = contract.getDate().plusMonths(month);
			Double updated_quota = basic_quota + onlinePaymentService.interest(basic_quota, month);
			Double full_quota = updated_quota + onlinePaymentService.paymentFee(updated_quota);
			
			contract.addInstallment(new Installment(date, full_quota));
		}
	}
}
