package service;

public class PayServicePaypal implements PayService {

	public double pay(double amount, int numberOfPays) {
		amount += amount * 0.01 * numberOfPays;
		return amount += amount * 0.02;
	}
}
