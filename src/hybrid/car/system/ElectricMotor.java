package hybrid.car.system;



/**
 * @version 1.0
 * @created 08-Apr-2013 6:11:36 PM
 */
public class ElectricMotor extends Motor {

	public ElectricMotor(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public String getName(){
		return "";
	}

	public int getUniqueId(){
		return 0;
	}
    public void ElecmotroCheck(Car car )
	   {
		   if (car.bat.getPowerLeft()  < 5)
		   {
			   car.bat.charging = true;
			 
		   }
		   if (car.bat.getPowerLeft() == 40)
		   {
			   car.bat.charging = false;
		   }
	   }

}