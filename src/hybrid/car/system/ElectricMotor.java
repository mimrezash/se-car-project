package hybrid.car.system;



// TODO: Auto-generated Javadoc
/**
 * The Class ElectricMotor.
 */
public class ElectricMotor extends Motor {

	/** The my name. */
	private String myName;
	
	/** The my id. */
	private int myId;
	
	/** The in use. */
	private boolean inUse;
	
	/** The n of usage. */
	private int nOfUsage;
	
	/**
	 * Instantiates a new electric motor.
	 */
	public ElectricMotor(){
		this.myName = "Electric Motor";
		this.myId = 2;
		this.inUse = false;
		nOfUsage = 0;
	}

	/* (non-Javadoc)
	 * @see hybrid.car.system.Motor#getName()
	 */
	public String getName(){
		return this.myName;
	}

	/* (non-Javadoc)
	 * @see hybrid.car.system.Motor#getUniqueId()
	 */
	public int getUniqueId(){
		return this.myId;
	}
    
    /**
     * Elecmotro check.
     *
     * @param bat the bat
     */
    public void ElecmotroCheck(Battery bat )
	   {
		   if (bat.getPowerLeft()  < 5)
		   {
			   bat.charging = true;
			 
		   }
		   if (bat.getPowerLeft() == 40)
		   {
			   bat.charging = false;
		   }
	   }
    
	/**
	 * Currently in use.
	 */
	public void currentlyInUse()
	{
		this.inUse = true;
		nOfUsage++;
	}
	
	/**
	 * Currently not in use.
	 */
	public void currentlyNotInUse()
	{
		this.inUse = false;
	}
	
	/**
	 * Checks if is itin use.
	 *
	 * @return true, if is itin use
	 */
	public boolean isItinUse()
	{
		return this.inUse;
	}
	
	/**
	 * Gets the nof usage.
	 *
	 * @return the nof usage
	 */
	public int getNofUsage()
	{
		return nOfUsage;
	}

}