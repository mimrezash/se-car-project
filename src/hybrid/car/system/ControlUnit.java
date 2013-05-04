package hybrid.car.system;

import javax.swing.JTextArea;

import hybrid.car.gui.MainFrame;

public class ControlUnit {

	    private Car hybridCar ;
	    private double avgMPG ;
	    private int counter ;
	    private JTextArea text;
	    public ControlUnit(double [] specs , JTextArea text ) {
	    	 this.text = text;
	    	 hybridCar = new Car((int) specs[1]);
	    	 //hybridCar.setspeed(45) ;
             hybridCar.setweight(specs[2]);
             hybridCar.setS(0.4) ;
             hybridCar.setR(5.8);
             hybridCar.setCdA(specs[0]);
             hybridCar.setacceleration(0.0);// TODO Auto-generated constructor stub
             counter = 0;
 	    	 avgMPG = 0.0;
		}
	   
	    
	    
	    private double convertLtoMPG( double fuel )
	    {
	    	double coeff = hybridCar.getspeed()*1000/3600;
            double l100k = fuel / coeff * 100 ;
            double mpg = 235 / l100k ;
            return mpg;
	    }
	    
	    public void startDriving(Environment env , int index)
	    {
	                avgMPG = 0;   
	               
	                double fuel=0 ;
	                hybridCar.setspeed(env.getMyMap().getRoadInfo(index).getSpeedLimit());
	                fuel = hybridCar.calc_feul(env.getMyMap().getRoadInfo(index).getRoadSlope());
	              // avgMPG = (avgMPG + convertLtoMPG(fuel));
                    
                //    System.out.println(convertLtoMPG(fuel));
                    
		
		if (hybridCar.EngineMode == "Spelit-Power")
		{
			hybridCar.bat.deccrementpower(1);
		}
		if (hybridCar.EngineMode == "Electric-Only")
		{
			hybridCar.bat.deccrementpower(3);
		}
		if (hybridCar.bat.charging)
		{
	//	System.out.println("Battery in Charging");
		  hybridCar.gen.addGeneratedPower(hybridCar.bat);
		}
		
		//System.out.println (hybridCar.EngineMode);
		text.setText(               "Fuel Consumption : "+ convertLtoMPG(fuel)+ " MPG"+"\n"+
		                            "Engine mode : "+hybridCar.EngineMode + "\n"+
		                            "Slope of the Road: " + env.getMyMap().getRoadInfo(index).getRoadSlope()+"\n"+
		                            "Maximum speed of the car: " + env.getMyMap().getRoadInfo(index).getSpeedLimit()+"\n"+
		                            "Total Distance : " + env.getMyMap().getRoadTotalDistance()+ "\n" +
		                            "Estimated Feul Used Gal :" + env.getMyMap().getRoadTotalDistance()/ convertLtoMPG(fuel) );
	               // System.out.println(index);
	              
		/*	while (hybridCar.currentMileage.getcurrentMileage() <  env.getMyMap().getRoadTotalDistance()  ) {
				counter++;
				// add a mile to the odometer
				hybridCar.currentMileage.incrementcurrentMileage();
				
	                        for (int i=0 ; i < env.getMyMap().get_number_of_roads() ; i++)
	                        {
	                            double cum_distance = 0;
	                            for (int j=0 ; j <=i ; j++)
	                            {
	                            	cum_distance = cum_distance + env.getMyMap().getRoadInfo(j).getDistance();
	                            }
	                            
	                        	if (hybridCar.currentMileage.getcurrentMileage() < cum_distance )
	                            {
	                              
	                             fuel = hybridCar.calc_feul(env.getMyMap().getRoadInfo(i).getRoadSlope());
	                             break;
	                              
	                            }
	                        	
	                        }
	                       
	                        avgMPG = (avgMPG + convertLtoMPG(fuel));
	                       
	                        System.out.println((int)avgMPG / counter);
	                        
				if( hybridCar.currentMileage.getcurrentMileage() % (int)(avgMPG /counter) == 0 )
					hybridCar.amountOfFuel.decrementFuelTank();
				if (hybridCar.EngineMode == "Spelit-Power")
				{
					hybridCar.bat.deccrementpower(1);
				}
				if (hybridCar.EngineMode == "Electric-Only")
				{
					hybridCar.bat.deccrementpower(3);
				}
					System.out.printf("Amount Of Fuel = %s\tCurrent Mileage = %s\n",
							hybridCar.amountOfFuel.getAmountOfFuel(), hybridCar.currentMileage.getcurrentMileage());
				if (hybridCar.bat.charging)
				{
				System.out.println("Battery in Charging");
				  hybridCar.gen.addGeneratedPower(hybridCar.bat);
				}
				System.out.println (hybridCar.EngineMode);
				


			}*/
	    }

}
