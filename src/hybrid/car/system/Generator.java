package hybrid.car.system;




public class Generator extends CarComponents {

	private String myName;
	private int myId;
	private int generatedPower;
	
	public Generator(){
		this.myName = "Generator";
		this.myId = -1;
		this.generatedPower = 0;
	}

	public String getName(){
		return myName;
	}

	public int getUniqueId(){
		return myId;
	}
	
	public int addGeneratedPower(Battery bat)
	{
		bat.addPower(1);
		return generatedPower;
	}

}