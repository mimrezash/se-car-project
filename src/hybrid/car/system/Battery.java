package hybrid.car.system;



public class Battery extends CarComponents {

	private String myName;
	private int myId;
	private int remainingPower;
	
	public Battery(){
		this.myName = "Battery";
		this.myId = -1;
		remainingPower = 100;
	}
	
	public void addPower(int power){
		this.remainingPower += power;
	}

	public String getName(){
		return myName;
	}

	public int getPowerLeft(){
		return remainingPower;
	}

	public int getUniqueId(){
		return myId;
	}

}