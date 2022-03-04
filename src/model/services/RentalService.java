package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	private Double pricePerHour;
	private Double pricePerDay;
	
	private BrazilTaxService taxService;

	public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		
		Double hours = (double)(t2 - t1) / 1000 / 60 / 60;
		Double basicPayment;
		
		if (hours <= 12) {
			basicPayment = Math.ceil(hours) * pricePerHour;
		}
		else {
			basicPayment = Math.ceil(hours/24) * pricePerDay;
		}
		
		carRental.setInvoice(new Invoice(basicPayment, taxService.tax(basicPayment)));
	}
}
