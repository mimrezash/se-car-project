package hybrid.car.system;

public class FuelGauge {
	 private int amountOfFuel;
		
		public FuelGauge(int gallons){
			amountOfFuel = gallons;
		}
		public int getAmountOfFuel(){
			return amountOfFuel;
		}
		public void incrementFuelTank(){
			if (amountOfFuel < 15 )
				amountOfFuel++;
		}
		public void decrementFuelTank(){
			if (amountOfFuel > 0 )
				amountOfFuel--;
		}
}
