package service;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installments;

public class OnlineService {

	private Integer numberOfPays;
	
	private PayService payService;

	public OnlineService(Integer numberOfPays, PayService payService) {
		super();
		this.numberOfPays = numberOfPays;
		this.payService = payService;
	}
	
	public void processContract(Contract contract) {
		double totalValue = contract.getTotalValue();
		double basicPayment = totalValue / numberOfPays;
		Date dueDate = contract.getDate();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dueDate);
		double pay;
		
		for(int i = 1; i<= numberOfPays; i++) {
			pay = payService.pay(basicPayment, i);
			cal.add(Calendar.MONTH, 1);
			contract.addInstallments(new Installments(dueDate = cal.getTime(), pay));
		}
		
	}
}
