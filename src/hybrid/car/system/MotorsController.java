package hybrid.car.system;



/**
 * @version 1.0
 * @created 08-Apr-2013 6:11:37 PM
 */
public class MotorsController {

	public MotorsController(){
		

	}
   public double cal_feul_second (Car car , int slope)
   {
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
       //  System.out.println(part1);
       
       return 0.5+part1*((power/0.8)+10);
       
   }
	

}