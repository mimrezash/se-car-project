
package hybrid.car.system;



/**
 * @author Anonymouse
 * @version 1.0
 * @created 08-Apr-2013 6:11:36 PM
 */
public class Car {
	private double speed;
	private double CdA;
	private double S;
	private double r;
	private double power;
	private double acceleration;
	private double fuelConsumption ; 
	private double weight ;
	FuelGauge amountOfFuel ;
	Odometer currentMileage;
	MotorsController control ; 
	Battery bat;
	Generator gen;
	ElectricMotor elec ;
	private CarComponents [] compnents;
	public Environment m_Environment;
	public String EngineMode ; 
	
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
	 * 
	 * @param env
	 */
	private void drive(Environment env){

	}
	
	public double getspeed ()
	{
		return this.speed;
	}
	
	public void setspeed (double x)
	{
		this.speed = x;
	}
	
	public double getCdA ()
	{
		return this.CdA;
	}
	
	public void setCdA (double x)
	{
		this.CdA = x;
	}
	
	public double getS()
	{
		return this.S;
	}
	
	public void setS (double x)
	{
		this.S = x;
	}
	
	public double getR()
	{
		return this.r;
	}
	
	public void setR (double x)
	{
		this.r = x;
	}
	
	public double getacceleration()
	{
		return this.acceleration;
	}
	
	public void setacceleration (double x)
	{
		this.acceleration = x;
	}
	
	public double getweight()
	{
		return this.weight;
	}
	
	public void setweight (double x)
	{
		this.weight = x;
	}
	
	public double calc_feul(int slope)
	{
		elec.ElecmotroCheck(bat);
		return this.control.cal_feul_second(this ,slope);
	}
	

	
	
}