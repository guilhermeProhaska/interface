package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer number;
	private Date date;
	private Double totalValue;
	
	private List<Installments> installment = new ArrayList<>();
	
	public Contract() {
	}

	public Contract(Integer number, Date date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	public List<Installments> getInstallment() {
		return installment;
	}
	
	public void addInstallments(Installments installments) {
		installment.add(installments);
	}
	
	public void removeInstallments(Installments installments) {
		installment.remove(installments);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Installments i : installment) {
			sb.append(sdf.format(i.getDueDate()) + " - ");
			sb.append(String.format("%.2f", i.getAmount()) + "\n");
		}
		return sb.toString();
		
	}
}
