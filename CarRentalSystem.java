package nandcars;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days) {
        if (car.isAvailable()) {
            car.rent();
            rentals.add(new Rental(car, customer, days));
        } else{
            System.out.println("This beautiful car unfortunately is not available for rent :(");
        }
    }

    public void returnCar(Car car) {
        car.returnCar();
        Rental rentalToRemove = null;
        for (Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
        } else {
            System.out.println("Looks like the car is not rented.");
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("===== JDM Lovers Rentals =====");
                System.out.println("1. Rent a Car");
                System.out.println("2. Return a Car");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (choice == 1) {
                    System.out.println("\n== Rent your dream JDM Car ==\n");
                    System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();

                    System.out.println("\nAvailable JDM Cars:");
                    for (Car car : cars) {
                        if (car.isAvailable()) {
                            System.out.println(car.getCarId() + " - " + car.getBrand() + " " + car.getModel() + " | JPY " + car.getPrice());
                        }
                    }

                    System.out.print("\nEnter the car ID you want to rent: ");
                    String carId = scanner.nextLine();

                    System.out.print("Enter the number of days for rental: ");
                    int rentalDays = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
                    addCustomer(newCustomer);

                    Car selectedCar = null;
                    for (Car car : cars) {
                        if (car.getCarId().equals(carId) && car.isAvailable()) {
                            selectedCar = car;
                            break;
                        }
                    }

                    if (selectedCar != null) {
                        int totalPrice = selectedCar.calculatePrice(rentalDays);
                        System.out.println("\n== Rental Information ==\n");
                        System.out.println("Customer ID: " + newCustomer.getCustomerId());
                        System.out.println("Customer Name: " + newCustomer.getName());
                        System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
                        System.out.println("Rental Days: " + rentalDays);
                        System.out.printf("Total Price : JPY " + totalPrice);

                        System.out.print("\nConfirm this rental? (Y/N): ");
                        String confirm = scanner.nextLine();

                        if (confirm.equalsIgnoreCase("Y")) {
                            rentCar(selectedCar, newCustomer, rentalDays);
                            System.out.println("\nWonderful, have a good day with that beast :D\n");
                        } else if (confirm.equalsIgnoreCase("N")) {
                            System.out.println("\nNo problem, come back any time!\n");
                        } else {
                            System.out.println("\nPlease enter a correct validation!\n");
                        }
                    } else {
                        System.out.println("\nInvalid car & data selection or the car is not available for rent.\n");
                    }
                } else if (choice == 2) {
                    System.out.println("\n== Return a Car ==\n");
                    System.out.print("Enter the car ID you want to return: ");
                    String carId = scanner.nextLine();

                    Car carToReturn = null;
                    for (Car car : cars) {
                        if (car.getCarId().equals(carId) && !car.isAvailable()) {
                            carToReturn = car;
                            break;
                        }
                    }

                    if (carToReturn != null) {
                        Customer customer = null;
                        for (Rental rental : rentals) {
                            if (rental.getCar() == carToReturn) {
                                customer = rental.getCustomer();
                                break;
                            }
                        }
                        if (customer != null) {
                            returnCar(carToReturn);
                            System.out.println("Thank you. The beast ' "+ carToReturn.getBrand() + " " + carToReturn.getModel() + " ' has been returned successfully by " + customer.getName());
                        } 
                    } else {
                        System.out.println("\nInvalid car ID or car is not rented.\n");
                    }
                } else if (choice == 3) {
                    break;
                } else {
                    System.out.println("\nInvalid choice. Please enter a valid option :)\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a number.\n");
                scanner.nextLine(); // Clear invalid input
            } catch (NoSuchElementException e) {
                System.out.println("\nInput operation was interrupted.\n");
                scanner.nextLine(); // Clear invalid input
            } catch (IllegalStateException e) {
                System.out.println("\nScanner is closed.\n");
                break;
            } catch (Exception e) {
                System.out.println("\nAn unexpected error occurred: " + e.getMessage() + "\n");

            }
        }

        System.out.println("\nThank you for using the JDM Lovers Rentals!");
        scanner.close();
    }
}
