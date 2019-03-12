package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		System.out.println("Enter rental data");
		System.out.print("Car model: ");
		String model = sc.nextLine();
		System.out.print("Pick up (dd/MM/yyyy hh:mm): ");
		String start = sc.nextLine();
		System.out.print("Return (dd/MM/yyyy hh:mm): ");
		String finish = sc.nextLine();
		System.out.print("Enter price per hour: ");
		Double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		Double pricePerDay = sc.nextDouble();
		
		try {
			CarRental carRental = new CarRental(sdf.parse(start), sdf.parse(finish), new Vehicle(model));
			RentalService rentalService = new RentalService(pricePerHour
					, pricePerDay, new BrazilTaxService());
			
			rentalService.processInvoice(carRental);
			System.out.println("INVOICE: ");
			System.out.println(carRental.getInvoice().toString());
			
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			sc.close();
		}
		
		
	}

}
