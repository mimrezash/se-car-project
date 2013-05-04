package hybrid.car.system;



/**
 * The Class GasolineMotor.
 */
public class GasolineMotor  extends Motor {
	
	/** The my name. */
	private String myName;
	
	/** The my id. */
	private int myId;
	
	/** The in use. */
	private boolean inUse;
	
	/** The not in use. */
	private int notInUse;
	
	/**
	 * Instantiates a new gasoline motor.
	 */
	public GasolineMotor (){
		this.myName = "Gasoline Motor";
		this.myId = 1;
		this.inUse = false;
		notInUse = 0;
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
	 * Currently in use.
	 */
	public void currentlyInUse()
	{
		this.inUse = true;
	}
	
	/**
	 * Currently not in use.
	 */
	public void currentlyNotInUse()
	{
		this.inUse = false;
		notInUse++;
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
		return notInUse;
	}

}