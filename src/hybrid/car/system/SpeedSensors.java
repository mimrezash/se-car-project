package hybrid.car.system;



// TODO: Auto-generated Javadoc
/**
 * The Class SpeedSensors.
 */
public class SpeedSensors extends CarComponents {

	/** The speed. */
	private int speed;
	
	/** The my name. */
	private String myName;
	
	/** The my id. */
	private int myId;
	
	
	/**
	 * Instantiates a new speed sensors.
	 */
	public SpeedSensors(){
		this.myName = "SpeedSensor";
		this.myId = 4;
	}

	/* (non-Javadoc)
	 * @see hybrid.car.system.CarComponents#getName()
	 */
	public String getName(){
		return myName;
	}

	/* (non-Javadoc)
	 * @see hybrid.car.system.CarComponents#getUniqueId()
	 */
	public int getUniqueId(){
		return myId;
	}
	
	/**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	public int getSpeed()
	{
		return speed;
	}
	
	/**
	 * Sets the speed.
	 *
	 * @param nextspeed the new speed
	 */
	public void setSpeed(int nextspeed)
	{
		speed = nextspeed;
	}

}