import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
	private List<Customer> custo;
	private List<Car> car;
	private List<DaysForRent> rent;
	

	public CarRentalSystem()
	{
		custo=new ArrayList<>();
		car=new ArrayList<>();
		rent=new ArrayList<>(); 
	}


	public void addCustomer(Customer cust)
	{
		custo.add(cust);
	}
	public void addCar(Car cr)
	{
		car.add(cr);
	}

	public void CarRent(Car car, Customer cust,int days)
	{
		if(car.isAvailable()) {
			car.rent();
		    rent.add(new DaysForRent(car, cust, days));
	}else {
		System.out.println("Car is Not Available for Rent");
	}
	}
	public void returnCar(Car car)
	{
		car.returnCar(); 
		DaysForRent rentalToRemove=null;
		for(DaysForRent rent1:rent) {
			if(rent1.getCar()==car)
			{
				rentalToRemove=rent1;
				break;
			}
			
		}
		if(rentalToRemove!=null)
		{
			rent.remove(rentalToRemove);
				System.out.println("Return Successfully.....Available Fpr Rent ");
				
		}
		else {
			System.out.println("Not Return....Not Available");
		}
	}
	
	public void menu()
	{
		Scanner sc =new Scanner(System.in);
		
		while(true)
		{
			System.out.println("===========Car Rental System=============");
			System.out.println("1 Rent A Car");
			System.out.println("2 Return A Car");
			System.out.println("3 Exist");
			System.out.println("Enter Your Choice");
			
			int choice=sc.nextInt();
			sc.nextLine();
			
			if(choice==1)
			{
				System.out.println("========Rent a Car============");
				System.out.println("Enter your Name");
				String custnm=sc.next();
				
				System.out.println("Now Available Cars");
				for(Car c:car)
				{
					System.out.println("\n"+c.getCarId()+"\n"+c.getBrand()+"\n"+c.getModel());
				}
			
			System.out.println("\n Enter CarId you want to rent");
			String carid=sc.next();
			
			System.out.println("Enter number of Days for Rental");
			int day=sc.nextInt();
			sc.nextLine();
			System.out.print("Cust");
			Customer newCustomer=new Customer((custo.size()+1), custnm);
			addCustomer(newCustomer);
			
			Car selectedcar=null;
			for(Car c:car)
			{
				if(c.getCarId().equals(carid)&&c.isAvailable())
				{
					selectedcar =c;
					break;
				}
				else
				{
					System.out.println("Not Available");
				}
			}
			if(selectedcar!=null)
				
			{
				double totalPrice=selectedcar.Calculateprice(day);
				System.out.println("============rental Information============");
				System.out.println("Customer Id : \t"+ newCustomer.getId());
				System.out.println("Customer Name :\t"+newCustomer.getNm());
				System.out.println("Car :\t"+selectedcar.getBrand()+" \t"+selectedcar.getModel());
				System.out.println("Rental Days :\t"+day);
				System.out.println("Total Price :\t"+totalPrice);
				System.out.println("Confirm Rental (Y/N)");
				String confirm=sc.nextLine();
				if(confirm.equalsIgnoreCase("Y"))
				{
					CarRent(selectedcar, newCustomer, day);
					System.out.println("Car REnted Successfully");
					
				}
				else {
					System.out.println("Cancel Rental");
				}
			}
			else
			{
				System.out.println("\n Invalid Selection or Car Rent Not Available");
			}
		}
			else if(choice==2)
			{
				System.out.println("Return Car");
				System.out.println("Enter Car Id You Want To Return");
				String  carId=sc.nextLine();
				
				Car carToReturn=null;
				for(Car c:car)
				{
					if(c.getCarId().equals(carId)&& !c.isAvailable())
					{
						carToReturn=c;
						break;
					}
				}
				if(carToReturn!=null)
				{
					Customer customer=null;
					for(DaysForRent rental:rent)
					{
						if(rental.getCar()==carToReturn)
						{
							customer=rental.getCustomer();
							break;
						}
					}
					if(customer!=null) {
						returnCar(carToReturn);
					System.out.println("Car Return By Successfully"+customer.getNm());
					
					}
					  else {
						System.out.println("Car was Not rented or rental information is missing");
					}
					
	
					
					
				
				}else {
					System.out.println("Invalid Car Id or Not Valid Option");
				}
			}
			else if(choice==3)
			{
				break;
			}else {
				System.out.println("Invaid Choice.Enter Correct Choice");
			}
		}
	}
}
