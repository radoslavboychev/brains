package vehicleTask;

public class Main {

	public static void main(String[] args) {

		Vehicle v1 = new Vehicle("BMW", "Coupe", 16, "G4YF4G", 240, 200);
		Vehicle v2 = new Vehicle("Tesla", "Coupe", 4, "QU33R", 260, 189);
		Vehicle v3 = new Vehicle("Volga", "Combi", 21, "WHATSUP", 100, 50);

		v1.printInfo();
		v1.calculatePrice(2001);

		v2.printInfo();
		v2.calculatePrice(2015);

		v3.printInfo();
		v3.calculatePrice(2010);

	}

}
