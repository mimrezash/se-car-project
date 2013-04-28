package hybrid.car.system;



/**
 * @version 1.0
 * @created 08-Apr-2013 6:11:36 PM
 */
public class ElectricMotor extends Motor {

	private String myName;
	private int myId;
	private boolean inUse;
	private int nOfUsage;
	
	public ElectricMotor(){
		this.myName = "Electric Motor";
		this.myId = 2;
		this.inUse = false;
		nOfUsage = 0;
	}

	public String getName(){
		return this.myName;
	}

	public int getUniqueId(){
		return this.myId;
	}
    public void ElecmotroCheck(Car car )
	   {
		   if (car.bat.getPowerLeft()  < 5)
		   {
			   car.bat.charging = true;
			 
		   }
		   if (car.bat.getPowerLeft() == 40)
		   {
			   car.bat.charging = false;
		   }
	   }
    
	public void currentlyInUse()
	{
		this.inUse = true;
		nOfUsage++;
	}
	
	public void currentlyNotInUse()
	{
		this.inUse = false;
	}
	
	public boolean isItinUse()
	{
		return this.inUse;
	}
	
	public int getNofUsage()
	{
		return nOfUsage;
	}

}