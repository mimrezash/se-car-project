package hybrid.car.system;
import hybrid.car.data.MapDataReader;
import hybrid.car.data.RoadData;


public class Map {
	
	MapDataReader myReader;

	public Map(MapDataReader reader){
		this.myReader = reader;
	}
	
	
	public RoadData getRoadInfo(int index)
	{
		return myReader.getRoads().get(index);
	}
	public int getRoadTotalDistance()
	{
		int totaldistance = 0 ;
		for (int i=0 ; i < myReader.getRoads().size(); i++)
		{
			totaldistance = totaldistance + myReader.getRoads().get(i).getDistance();
		}
		return totaldistance;
	}
   public int get_number_of_roads ()
   {
	   return myReader.getRoads().size();
   }
   
}