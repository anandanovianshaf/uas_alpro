package nandcars;

public class Car {
    private String carId;
    private String brand;
    private String model;
    private int basePricePerDay;
    private boolean isAvailable;

    public Car(String carId, String brand, String model, int basePricePerDay) {
        if (carId == null || carId.trim().isEmpty()) {
            throw new IllegalArgumentException("Car ID cannot be null or empty.");
        }
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or empty.");
        }
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty.");
        }
        if (basePricePerDay <= 0) {
            throw new IllegalArgumentException("Base price per day must be greater than zero.");
        }

        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }

    public String getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return basePricePerDay;
    }

    public int calculatePrice(int rentalDays) {
        if (rentalDays <= 0) {
            throw new IllegalArgumentException("Rental days must be greater than zero.");
        }
        return basePricePerDay * rentalDays;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {
        if (!isAvailable) {
            throw new IllegalStateException("Car is already rented.");
        }
        isAvailable = false;
    }

    public void returnCar() {
        if (isAvailable) {
            throw new IllegalStateException("Car is already available.");
        }
        isAvailable = true;
    }
}
