
public class Car {
	private String carId;
	private String brand;
	private String Model;
	private double basePricePerDay;
	private boolean isAvailable;
	
	public Car(String carId, String brand, String model, double basePricePerDay) {
		super();
		this.carId = carId;
		this.brand = brand;
		Model = model;
		this.basePricePerDay = basePricePerDay;
		this.isAvailable = true;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public double getBasePricePerDay() {
		return basePricePerDay;
	}
	public void setBasePricePerDay(double basePricePerDay) {
		this.basePricePerDay = basePricePerDay;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public void rent()
	{
		isAvailable=false;
	}
	public void returnCar()
	{
		isAvailable=true;
	}
	public double Calculateprice(int rentalDays)
	{
		return basePricePerDay * rentalDays;
	}
	
}
