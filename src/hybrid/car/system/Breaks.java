package hybrid.car.system;



public class Breaks extends CarComponents {

	private String myName;
	private int myId;
	
	public Breaks(){
		this.myName = "Breaks";
		this.myId = -1;
	}
	
	public int doBreak(SpeedSensors sensor, int nextSpeed) throws InterruptedException{
		
		while(sensor.getSpeed() > nextSpeed)
		{
			if(sensor.getSpeed() - nextSpeed > 10){
				sensor.setSpeed( (sensor.getSpeed() - 10) );
				Thread.sleep(500);
			}
			else
			{
				sensor.setSpeed(nextSpeed);
				Thread.sleep(100);
			}
			
		}
		
		return 0;
	}

	public String getName(){
		return myName;
	}

	public int getUniqueId(){
		return myId;
	}

}