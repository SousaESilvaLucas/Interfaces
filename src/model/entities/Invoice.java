package model.entities;

public class Invoice {
	
	private Double basicPayment;
	private Double tax;
	private Double totalPayment;
	
	public Invoice() {
		
	}

	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
		this.totalPayment = tax + basicPayment;
	}

	public Double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getTotalPayment() {
		return totalPayment;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("BASIC PAYMENT: " + String.format("%.2f", basicPayment) + "\n");
		sb.append("TAX: " + String.format("%.2f", tax) + "\n");
		sb.append("TOTAL PAYMENT: " + String.format("%.2f", totalPayment));
		return sb.toString();
	}
}
