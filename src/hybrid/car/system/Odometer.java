package hybrid.car.system;

// TODO: Auto-generated Javadoc
/**
 * The Class Odometer.
 */
public class Odometer extends CarComponents {
	  
	/** The current mileage. */
	private int currentMileage;
	
	/** The my name. */
	private String myName;
	
	/** The my id. */
	private int myId;
		
		/**
		 * Instantiates a new odometer.
		 *
		 * @param gallons the gallons
		 */
		public Odometer(int gallons){
			this.myName = "Odometer";
			this.myId = 6;
			currentMileage = gallons;
		}
		
		/**
		 * Gets the current mileage.
		 *
		 * @return the current mileage
		 */
		public int getcurrentMileage(){
			return currentMileage;
		}
		
		/**
		 * Incrementcurrent mileage.
		 */
		public void incrementcurrentMileage(){
			    if (currentMileage < 999999 )  
	                        currentMileage++;  
	                if (currentMileage == 999999)
	                        currentMileage = 0;
		}
		
		/**
		 * Decrementcurrent mileage.
		 */
		public void decrementcurrentMileage(){
			if (currentMileage > 24 )
				currentMileage++;
		}
		
		/**
		 * Increment mileage.
		 */
		public void incrementMileage(){
			
		}
		
		/* (non-Javadoc)
		 * @see hybrid.car.system.CarComponents#getName()
		 */
		public String getName(){
			return myName;
		}

		/* (non-Javadoc)
		 * @see hybrid.car.system.CarComponents#getUniqueId()
		 */
		public int getUniqueId(){
			return myId;
		}
}
