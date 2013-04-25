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

}