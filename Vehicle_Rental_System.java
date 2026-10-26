import java.util.Scanner;

// Base class
class Vehicle {
    String vehicleNumber;
    double rentPerDay;

    public Vehicle(String vehicleNumber, double rentPerDay) {
        this.vehicleNumber = vehicleNumber;
        this.rentPerDay = rentPerDay;
    }

    public double calculateRent(int days) {
        return 0.0; // To be overridden by subclasses
    }
}

// Subclass for Car
class Car extends Vehicle {
    public Car(String vehicleNumber, double rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    @Override
    public double calculateRent(int days) {
        return rentPerDay * days;
    }
}

// Subclass for Bike
class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    @Override
    public double calculateRent(int days) {
        return rentPerDay * days * 0.90; // 10% discount
    }
}

// Subclass for Truck
class Truck extends Vehicle {
    public Truck(String vehicleNumber, double rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    @Override
    public double calculateRent(int days) {
        return rentPerDay * days * 1.20; // 20% additional charge
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            
            for (int i = 0; i < n; i++) {
                int vehicleType = scanner.nextInt();
                String vehicleNumber = scanner.next();
                double rentPerDay = scanner.nextDouble();
                int days = scanner.nextInt();
                
                Vehicle vehicle = null;
                
                // Instantiating based on type
                if (vehicleType == 1) {
                    vehicle = new Car(vehicleNumber, rentPerDay);
                } else if (vehicleType == 2) {
                    vehicle = new Bike(vehicleNumber, rentPerDay);
                } else if (vehicleType == 3) {
                    vehicle = new Truck(vehicleNumber, rentPerDay);
                }
                
                if (vehicle != null) {
                    // Calculating rent via runtime polymorphism
                    double totalRent = vehicle.calculateRent(days);
                    System.out.printf("%s %.2f\n", vehicle.vehicleNumber, totalRent);
                }
            }
        }
        scanner.close();
    }
}
