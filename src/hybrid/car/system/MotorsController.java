package hybrid.car.system;



// TODO: Auto-generated Javadoc
/**
 * The Class MotorsController.
 */
public class MotorsController extends CarComponents {

	/**
	 * Instantiates a new motors controller.
	 */
	public MotorsController(){
		

	}
 
   /**
    * Cal_feul_second.
    *
    * @param car the car
    * @param slope the slope
    * @return the double
    */
   public double cal_feul_second (Car car , int slope)
   {
	 
	   double fa = car.getweight() * car.getacceleration();
       double drag_force = car.getCdA() * 0.174 * car.getspeed() * car.getspeed() /2 ; 
       double rolling_resistance = 0.0006 + 0.00000023* car.getspeed() * car.getspeed() ;
       double rolling_resistance_force = car.getweight()*rolling_resistance*Math.cos(Math.toRadians(slope));
       double gravity_force = car.getweight()*Math.sin(Math.toRadians(slope));
       double power = (fa+drag_force+rolling_resistance_force+gravity_force)*car.getspeed();
       double part1 =0.0;
       if ( fa+drag_force+rolling_resistance_force+gravity_force < 0)
       {
          part1 = 0;
       }
       
       else
       {
          part1 = 1 /(0.4*36000);
       }
      
       
       return 0.5+part1*((power_split (car , power)/0.8)+10);
       
   }
   
   /**
    * Power_split.
    *
    * @param car the car
    * @param power the power
    * @return the double
    */
   public double power_split( Car car , double power)
   {
	  
	   if (power >= 30000)
	   {
		   car.EngineMode = "Feul-Only";
		   return power;
		   
	   }
	   else if (power > 15000 && power < 30000)
	   {
		   if (car.bat.getPowerLeft() > 0)
		   {
			   if (!car.bat.charging)
			   {
			   car.EngineMode = "Spelit-Power" ; 
			   return power - 0.5*power; 
			   }
			   
		   }
		   else
		   {
			   car.EngineMode = "Feul-Only ";
			   return power;
		   }
	   }
	   else if (power > 0 && power < 15000)
	   {
		   if (car.bat.getPowerLeft() > 0)
		   {
			   if (!car.bat.charging)
			   car.EngineMode = "Electric-Only" ;
			   return power - 0.9*power;
		   }
		   else
		   {
			   car.EngineMode = "Feul-Only";
			   return power;
		   }
	   }
	  	 car.EngineMode = "Feul-Only";
		 return power;  
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