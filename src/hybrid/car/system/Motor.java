package hybrid.car.system;




// TODO: Auto-generated Javadoc
/**
 * The Class Motor.
 */
public abstract class Motor extends CarComponents {

	/**
	 * Instantiates a new motor.
	 */
	public Motor(){

	}

	/* (non-Javadoc)
	 * @see hybrid.car.system.CarComponents#getName()
	 */
	public abstract String getName();

	/* (non-Javadoc)
	 * @see hybrid.car.system.CarComponents#getUniqueId()
	 */
	public abstract int getUniqueId();

}