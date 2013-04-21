package hybrid.car.system;



/**
 * @author Anonymouse
 * @version 1.0
 * @created 08-Apr-2013 6:11:36 PM
 */
public class Car {

	private CarComponents [] compnents;
	public Environment m_Environment;

	public Car(){
		compnents = new CarComponents[6];
		compnents[0] = new HybridEngine();
		compnents[1] = new SpeedSensors();
		compnents[2] = new Breaks();
		compnents[3] = new Battery();
		compnents[4] = new Generator();
		compnents[5] = new FuelTank();		
	}

	/**
	 * 
	 * @param env
	 */
	private void drive(Environment env){

	}
}