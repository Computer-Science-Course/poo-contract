package model.services;

public class PaypalService implements OnlinePaymentService{

	private static final Double MONTHLY_SIMPLE_INTEREST = 0.01;
	private static final Double PAYMENT_FEE = 0.02;
	
	@Override
	public Double paymentFee(Double amount) {
		return amount * PAYMENT_FEE;
	}

	@Override
	public Double interest(Double amount, Integer month) {
		return amount * (MONTHLY_SIMPLE_INTEREST * month);
	}

}
