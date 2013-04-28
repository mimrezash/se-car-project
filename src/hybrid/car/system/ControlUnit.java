package hybrid.car.system;

public class ControlUnit {
	
	    private Car car;
	    private double avgMPG ;
	    private int counter;
	    
	    
	    public ControlUnit()
	    {
	    	car = new Car();
	    	counter = 0;
	    	avgMPG = 0.0;
	    }
	    
	    public double convertLtoMPG( double fuel )
	    {
	    	double coeff = car.getspeed()*1000/3600;
            double l100k = fuel / coeff * 100 ;
            double mpg = 235 / l100k ;
            return mpg;
	    }
	    
	    public void startDriving(Environment env)
	    {
	                avgMPG = 0;   
	                car.setspeed(45) ;
	                car.setweight(1670);
	                car.setS(0.4) ;
	                car.setR(5.8);
	                car.setCdA(0.584);
	                car.setacceleration(0.0);
	                double fuel=0 ;
	              
			while (car.currentMileage.getcurrentMileage() <  env.getMyMap().getRoadTotalDistance()  ) {
				counter++;
				// add a mile to the odometer
				car.currentMileage.incrementcurrentMileage();
				
	                        for (int i=0 ; i < env.getMyMap().get_number_of_roads() ; i++)
	                        {
	                            double cum_distance = 0;
	                            for (int j=0 ; j <=i ; j++)
	                            {
	                            	cum_distance = cum_distance + env.getMyMap().getRoadInfo(j).getDistance();
	                            }
	                            
	                        	if (car.currentMileage.getcurrentMileage() < cum_distance )
	                            {
	                              
	                             fuel = car.calc_feul(env.getMyMap().getRoadInfo(i).getRoadSlope());
	                             break;
	                              
	                            }
	                        	
	                        }
	                       
	                        avgMPG = (avgMPG + convertLtoMPG(fuel));
	                       
	                        System.out.println((int)avgMPG / counter);
	                        
				if( car.currentMileage.getcurrentMileage() % (int)(avgMPG /counter) == 0 )
					car.amountOfFuel.decrementFuelTank();
				if (car.EngineMode == "Spelit-Power")
				{
					car.bat.deccrementpower(1);
				}
				if (car.EngineMode == "Electric-Only")
				{
					car.bat.deccrementpower(3);
				}
					System.out.printf("Amount Of Fuel = %s\tCurrent Mileage = %s\n",
							car.amountOfFuel.getAmountOfFuel(), car.currentMileage.getcurrentMileage());
				if (car.bat.charging)
				{
				System.out.println("Battery in Charging");
				  car.gen.addGeneratedPower(car.bat);
				}
				System.out.println (car.EngineMode);
				


			}
	    }
	    public static void main(String[] args)
	    {
	    	ControlUnit test = new ControlUnit();
	    	Environment xy = new Environment("textfile");
	    	test.startDriving(xy);
	    }
	
}
