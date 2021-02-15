package vehicleTask;

public class Vehicle {

	String brand;
	String type;
	int age;
	String licensePlate;
	int maxSpeed;
	int horsePower;

	Vehicle() {

	}

	Vehicle(String brand, String type, int age, String licensePlate, int maxSpeed, int horsePower) {

		this.brand = brand;
		this.type = type;
		this.age = age;
		this.licensePlate = licensePlate;
		this.maxSpeed = maxSpeed;
		this.horsePower = horsePower;
	}

	void calculatePrice(int year) {
		int price;
		price = (maxSpeed * horsePower) / (2017 - year);
		System.out.println("The price of this car is: " + price + " EUR.\n~~~");

	}

	void printInfo() {
		System.out.println("---Car Info---\nBrand: " + brand + "\nType: " + type + "\nAge" + age + "\nLicense Number: "
				+ licensePlate + "Max Speed: " + maxSpeed + "\nHorsepower: " + horsePower + "\n");
	}
	
}
