package hybrid.car.system;



public class SpeedSensors extends CarComponents {

	private int speed;
	private String myName;
	private int myId;
	
	
	public SpeedSensors(){
		this.myName = "SpeedSensor";
		this.myId = -1;
	}

	public String getName(){
		return myName;
	}

	public int getUniqueId(){
		return myId;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setSpeed(int nextspeed)
	{
		speed = nextspeed;
	}

}