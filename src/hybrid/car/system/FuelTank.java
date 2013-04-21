package hybrid.car.system;



public class FuelTank extends CarComponents {


	private String myName;
	private int myId;
	private int fuelRemaining;
	
	public FuelTank(){
		this.myName = "FuelTank";
		this.myId = -1;
		this.fuelRemaining = 100;
	}

	public int getFuelRate(){
		return 0;
	}

	public String getName(){
		return myName;
	}

	public int getUniqueId(){
		return myId;
	}
	
	public int getRemainingFuel()
	{
		return this.fuelRemaining;
	}

}