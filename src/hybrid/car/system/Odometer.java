package hybrid.car.system;

public class Odometer {
	  private int currentMileage;
		
		public Odometer(int gallons){
			currentMileage = gallons;
		}
		public int getcurrentMileage(){
			return currentMileage;
		}
		public void incrementcurrentMileage(){
			    if (currentMileage < 999999 )  
	                        currentMileage++;  
	                if (currentMileage == 999999)
	                        currentMileage = 0;
		}
		public void decrementcurrentMileage(){
			if (currentMileage > 24 )
				currentMileage++;
		}
		public void incrementMileage(){
			
		}
}
