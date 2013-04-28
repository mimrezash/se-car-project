package hybrid.car.gui;
import hybrid.car.system.ControlUnit;
import hybrid.car.system.Environment;



public class MainGUI {

	private ControlUnit control;
	private Environment env;

	public MainGUI(){
		env = new Environment("textfile");
		control = new ControlUnit();
	}
	
	public static void main(String [] arg)
	{
		
	}
}