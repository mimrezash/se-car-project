package hybrid.car.system;





/**
 * The Class HybridEngine.
 */
public class HybridEngine extends CarComponents {

	/** The m_ motor. */
	public Motor m_Motor;

	/**
	 * Instantiates a new hybrid engine.
	 */
	public HybridEngine(){

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}

	/* (non-Javadoc)
	 * @see hybrid.car.system.CarComponents#getName()
	 */
	public String getName(){
		return "";
	}

	/* (non-Javadoc)
	 * @see hybrid.car.system.CarComponents#getUniqueId()
	 */
	public int getUniqueId(){
		return 0;
	}

}