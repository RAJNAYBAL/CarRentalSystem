
public class MainCar {

	public static void main(String[] args) {
		System.out.println("Welcome");
		CarRentalSystem rentalsys=new CarRentalSystem();
		Car c=new Car("C001","Marutii", "Van", 10);
		Car c1=new Car("C002","Bugati", "Bug65", 20);
		Car c2=new Car("C003","BMW", "BMW1232", 30);
		rentalsys.addCar(c);
		rentalsys.addCar(c1);
		rentalsys.addCar(c2);
		rentalsys.menu();

	}

}
