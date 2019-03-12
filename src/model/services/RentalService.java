package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	private Double pricePerHour;
	private Double pricePerDay;
	private TaxService taxService;
	
	public RentalService(){
		
	}
	
	
	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService ) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}


	public Double getPricePerHour() {
		return pricePerHour;
	}


	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}


	public Double getPricePerDay() {
		return pricePerDay;
	}


	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public void processInvoice(CarRental carRental) {
		long numberOfMiliseconds = carRental.getFinish().getTime() - carRental.getStart().getTime();
		Double numberOfHoursFraction = numberOfMiliseconds/(1000.0*60*60);
		int numberOfHours = (int) Math.ceil(numberOfHoursFraction);
		Double numberOfDaysFraction = numberOfMiliseconds/(1000.0*60*60*24);
		int numberOfDays = (int) Math.ceil(numberOfDaysFraction);
		
		Double basicPayment = (numberOfHours <= 12)? pricePerHour * numberOfHours
				: pricePerDay * numberOfDays;
		Double tax = taxService.tax(basicPayment);
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
}
