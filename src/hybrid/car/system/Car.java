
package hybrid.car.system;



// TODO: Auto-generated Javadoc
/**
 * The Class Car.
 */
public class Car {
	
	/** The speed. */
	private double speed;
	
	/** The Cd a. */
	private double CdA;
	
	/** The s. */
	private double S;
	
	/** The r. */
	private double r;
	
	/** The power. */
	private double power;
	
	/** The acceleration. */
	private double acceleration;
	
	/** The fuel consumption. */
	private double fuelConsumption ; 
	
	/** The weight. */
	private double weight ;
	
	/** The amount of fuel. */
	FuelGauge amountOfFuel ;
	
	/** The current mileage. */
	Odometer currentMileage;
	
	/** The control. */
	MotorsController control ; 
	
	/** The bat. */
	Battery bat;
	
	/** The gen. */
	Generator gen;
	
	/** The elec. */
	ElectricMotor elec ;
	
	/** The compnents. */
	private CarComponents [] compnents;
	
	/** The m_ environment. */
	public Environment m_Environment;
	
	/** The Engine mode. */
	public String EngineMode ; 
	
	/**
	 * Instantiates a new car.
	 *
	 * @param fuel the fuel
	 */
	public Car(int fuel){
		
	amountOfFuel = new FuelGauge(fuel);
	currentMileage = new Odometer(0);
	bat = new Battery();
	gen = new Generator();
	control = new MotorsController();
	elec = new ElectricMotor();
	//	Battery bat = new B
	
	}

	/**
	 * Drive.
	 *
	 * @param env the env
	 */
	private void drive(Environment env){

	}
	
	/**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	public double getspeed ()
	{
		return this.speed;
	}
	
	/**
	 * Sets the speed.
	 *
	 * @param x the new speed
	 */
	public void setspeed (double x)
	{
		this.speed = x;
	}
	
	/**
	 * Gets the cd a.
	 *
	 * @return the cd a
	 */
	public double getCdA ()
	{
		return this.CdA;
	}
	
	/**
	 * Sets the cd a.
	 *
	 * @param x the new cd a
	 */
	public void setCdA (double x)
	{
		this.CdA = x;
	}
	
	/**
	 * Gets the s.
	 *
	 * @return the s
	 */
	public double getS()
	{
		return this.S;
	}
	
	/**
	 * Sets the s.
	 *
	 * @param x the new s
	 */
	public void setS (double x)
	{
		this.S = x;
	}
	
	/**
	 * Gets the r.
	 *
	 * @return the r
	 */
	public double getR()
	{
		return this.r;
	}
	
	/**
	 * Sets the r.
	 *
	 * @param x the new r
	 */
	public void setR (double x)
	{
		this.r = x;
	}
	
	/**
	 * Gets the acceleration.
	 *
	 * @return the acceleration
	 */
	public double getacceleration()
	{
		return this.acceleration;
	}
	
	/**
	 * Sets the acceleration.
	 *
	 * @param x the new acceleration
	 */
	public void setacceleration (double x)
	{
		this.acceleration = x;
	}
	
	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public double getweight()
	{
		return this.weight;
	}
	
	/**
	 * Sets the weight.
	 *
	 * @param x the new weight
	 */
	public void setweight (double x)
	{
		this.weight = x;
	}
	
	/**
	 * Calc_feul.
	 *
	 * @param slope the slope
	 * @return the double
	 */
	public double calc_feul(int slope)
	{
		elec.ElecmotroCheck(bat);
		return this.control.cal_feul_second(this ,slope);
	}
	

	
	
}