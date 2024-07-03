package nandcars;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        Car car1 = new Car("C001", "Nissan", "GTR R35", 120000);
        Car car2 = new Car("C002", "Nissan", "Skyline R34", 118950);
        Car car3 = new Car("C003", "Nissan", "Acura NSX", 117650);
        Car car4 = new Car("C004", "Nissan", "Fairlady Z", 100000);
        Car car5 = new Car("C005", "Toyota", "Supra MK4", 115000);
        Car car6 = new Car("C006", "Honda", "Civic Turbo", 60000);
        Car car7 = new Car("C007", "Honda", "Civic Type R", 80000);
        Car car8 = new Car("C008", "Mazda",  "RX-7", 50000);
        Car car9 = new Car("C009", "Mazda", "RX-8", 45500);
        Car car10 = new Car("C010", "Lancer", "Evo 8", 77800);
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
        rentalSystem.addCar(car4);
        rentalSystem.addCar(car5);
        rentalSystem.addCar(car6);
        rentalSystem.addCar(car7);
        rentalSystem.addCar(car8);
        rentalSystem.addCar(car9);
        rentalSystem.addCar(car10);

        rentalSystem.menu();
    }
}