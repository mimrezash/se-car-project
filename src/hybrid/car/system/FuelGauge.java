package hybrid.car.system;

// TODO: Auto-generated Javadoc
/**
 * The Class FuelGauge.
 */
public class FuelGauge extends CarComponents {
	 
 	/** The amount of fuel. */
 	private int amountOfFuel;
		
		/**
		 * Instantiates a new fuel gauge.
		 *
		 * @param gallons the gallons
		 */
		public FuelGauge(int gallons){
			amountOfFuel = gallons;
		}
		
		/**
		 * Gets the amount of fuel.
		 *
		 * @return the amount of fuel
		 */
		public int getAmountOfFuel(){
			return amountOfFuel;
		}
		
		/**
		 * Increment fuel tank.
		 */
		public void incrementFuelTank(){
			if (amountOfFuel < 15 )
				amountOfFuel++;
		}
		
		/**
		 * Decrement fuel tank.
		 */
		public void decrementFuelTank(){
			if (amountOfFuel > 0 )
				amountOfFuel--;
		}
		/* (non-Javadoc)
		 * @see hybrid.car.system.CarComponents#getName()
		 */
		public String getName(){
			return "";
		}

		/* (non-Javadoc)
		 * @see hybrid.car.system.CarComponents#getUniqueId()
		 */
		public int getUniqueId(){
			return 0;
		}
}
