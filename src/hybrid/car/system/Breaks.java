package hybrid.car.system;




/**
 * The Class Breaks.
 */
public class Breaks extends CarComponents {

	/** The my name. */
	private String myName;
	
	/** The my id. */
	private int myId;
	
	/**
	 * Instantiates a new breaks.
	 */
	public Breaks(){
		this.myName = "Breaks";
		this.myId = 3;
	}
	
	/**
	 * Do break.
	 *
	 * @param sensor the sensor
	 * @param nextSpeed the next speed
	 * @throws InterruptedException the interrupted exception
	 */
	public void doBreak(SpeedSensors sensor, int nextSpeed) throws InterruptedException{
		
		while(sensor.getSpeed() > nextSpeed)
		{
			if(sensor.getSpeed() - nextSpeed > 10){
				sensor.setSpeed( (sensor.getSpeed() - 10) );
				Thread.sleep(500);
			}
			else
			{
				sensor.setSpeed(nextSpeed);
				Thread.sleep(100);
			}
			
		}
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

}