package model.entities;

public class Invoice {

	private Double basicPayment;
	private Double tax;
	
	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
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
	
	public Double totalPayment() {
		return basicPayment + tax;
	}
	
	@Override
	public String toString() {
		return "INVOICE: \n"
				+ String.format("Basic payment: %.2f%n", basicPayment)
				+ String.format("Tax: %.2f%n", tax)
				+ String.format("Total payment: %.2f%n", totalPayment());
	}
}
