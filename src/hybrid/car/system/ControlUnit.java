package hybrid.car.system;

public class ControlUnit {
	    Car car = new Car();
	   
	    
	    public void startSimulation()
	    {
	        FuelGauge amountOfFuel = new FuelGauge(40);
			Odometer currentMileage = new Odometer(0);
	                Environment env = new Environment("textfile");
	             
	          car.setspeed(45) ;
	                car.setweight(1670);
	                car.setS(0.4) ;
	                car.setR(5.8);
	                car.setCdA(0.584);
	                car.setacceleration(0.0);
	                double fuel=0 ;
	              
			while (currentMileage.getcurrentMileage() <  env.getMyMap().getRoadTotalDistance()  ) {

				// add a mile to the odometer
				currentMileage.incrementcurrentMileage();
				System.out.println(env.getMyMap().getRoadInfo(0).getDistance());
	                        for (int i=0 ; i < env.getMyMap().get_number_of_roads() ; i++)
	                        {
	                            double cum_distance = 0;
	                            for (int j=0 ; j < i ; j++)
	                            {
	                            	cum_distance = cum_distance + env.getMyMap().getRoadInfo(j).getDistance();
	                            }
	                            
	                        	if (currentMileage.getcurrentMileage() < cum_distance )
	                            {
	                              
	                             
	                              double fa = car.getweight() * car.getacceleration();
	                              double fd = car.getCdA() * 0.174 * car.getspeed() * car.getspeed() /2 ; 
	                              double cr = 0.0006 + 0.00000023* car.getspeed() * car.getspeed() ;
	                              double fr = car.getweight()*cr*Math.cos(Math.toRadians(env.getMyMap().getRoadInfo(i).getRoadSlope()));
	                              double fg = car.getweight()*Math.sin(Math.toRadians(env.getMyMap().getRoadInfo(i).getRoadSlope()));
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
	                              fuel = 0.5+part1*((power/0.8)+10);
	                              
	                              break;
	                              
	                            }
	                        	
	                        }
	                        double coeff = car.getspeed()*1000/3600;
	                        double l100k = fuel / coeff * 100 ;
	                        
	                        
				if( currentMileage.getcurrentMileage() % 24 == 0 )
					amountOfFuel.decrementFuelTank();
				{
					System.out.printf("Amount Of Fuel = %s\tCurrent Mileage = %s\n",
							amountOfFuel.getAmountOfFuel(), currentMileage.getcurrentMileage());
				}


			}
	    }
	    public static void main(String[] args)
	    {
	    	ControlUnit test = new ControlUnit();
	    	test.startSimulation();
	    }
	
}
