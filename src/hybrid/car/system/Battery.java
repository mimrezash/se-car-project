package hybrid.car.system;



/**
 * The Class Battery.
 */
public class Battery extends CarComponents {

	/** The my name. */
	private String myName;
	
	/** The my id. */
	private int myId;
	
	/** The remaining power. */
	private int remainingPower;
	
	/** The charging. */
	public boolean charging ;
	
	/**
	 * Instantiates a new battery.
	 */
	public Battery(){
		this.myName = "Battery";
		this.myId = -1;
		remainingPower = 500;
		charging = false;
	}
	
	/**
	 * Adds the power.
	 *
	 * @param power the power
	 */
	public void addPower(int power){
		this.remainingPower += power;
	}

	/* (non-Javadoc)
	 * @see hybrid.car.system.CarComponents#getName()
	 */
	public String getName(){
		return myName;
	}

	/**
	 * Gets the power left.
	 *
	 * @return the power left
	 */
	public int getPowerLeft(){
		return remainingPower;
	}

	/* (non-Javadoc)
	 * @see hybrid.car.system.CarComponents#getUniqueId()
	 */
	public int getUniqueId(){
		return myId;
	}
	
	/**
	 * Deccrementpower.
	 *
	 * @param x the x
	 */
	public void deccrementpower(int x)
	{
		this.remainingPower = this.remainingPower - x;
	}

}