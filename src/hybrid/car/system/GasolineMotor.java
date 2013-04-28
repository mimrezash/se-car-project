package hybrid.car.system;


public class GasolineMotor  extends Motor {
	
	private String myName;
	private int myId;
	private boolean inUse;
	private int notInUse;
	
	public GasolineMotor (){
		this.myName = "Gasoline Motor";
		this.myId = 1;
		this.inUse = false;
		notInUse = 0;
	}

	public String getName(){
		return this.myName;
	}

	public int getUniqueId(){
		return this.myId;
	}

	public void currentlyInUse()
	{
		this.inUse = true;
	}
	
	public void currentlyNotInUse()
	{
		this.inUse = false;
		notInUse++;
	}
	
	public boolean isItinUse()
	{
		return this.inUse;
	}
	
	public int getNofUsage()
	{
		return notInUse;
	}

}