package hybrid.car.system;



/**
 * @version 1.0
 * @created 08-Apr-2013 6:11:37 PM
 */
public class MotorsController {

	public MotorsController(){
		

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
   public double cal_feul_second (Car car , int slope)
   {
	 
	   ElecmotroCheck(car) ;
	   double fa = car.getweight() * car.getacceleration();
       double fd = car.getCdA() * 0.174 * car.getspeed() * car.getspeed() /2 ; 
       double cr = 0.0006 + 0.00000023* car.getspeed() * car.getspeed() ;
       double fr = car.getweight()*cr*Math.cos(Math.toRadians(slope));
       double fg = car.getweight()*Math.sin(Math.toRadians(slope));
       double power = (fa+fd+fr+fg)*car.getspeed();
       double part1 =0.0;
       if ( fa+fd+fr+fg < 0)
       {
          part1 = 0;
       }
       else
       {
          part1 = 1 /(0.4*36000);
       }
      
       
       return 0.5+part1*((power_split (car , power)/0.8)+10);
       
   }
   public double power_split( Car car , double power)
   {
	  
	   if (power >= 15000)
	   {
		   car.EngineMode = "Feul-Only";
		   return power;
		   
	   }
	   else if (power > 10000 && power < 15000)
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
	   else if (power > 0 && power < 10000)
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
	

}