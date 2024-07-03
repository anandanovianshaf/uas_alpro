package nandcars;

public class Rental {
    private Car car;
    private Customer customer;
    private int days;

    public Rental(Car car, Customer customer, int days) {
        if (car == null) {
            throw new IllegalArgumentException("Car cannot be null.");
        }
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        if (days <= 0) {
            throw new IllegalArgumentException("Days must be greater than zero.");
        }

        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }
}
