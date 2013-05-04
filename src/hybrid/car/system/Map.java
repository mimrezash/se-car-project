package hybrid.car.system;
import hybrid.car.data.MapDataReader;
import hybrid.car.data.RoadData;


// TODO: Auto-generated Javadoc
/**
 * The Class Map.
 */
public class Map {
	
	/** The my reader. */
	MapDataReader myReader;

	/**
	 * Instantiates a new map.
	 *
	 * @param reader the reader
	 */
	public Map(MapDataReader reader){
		this.myReader = reader;
	}
	
	
	/**
	 * Gets the road info.
	 *
	 * @param index the index
	 * @return the road info
	 */
	public RoadData getRoadInfo(int index)
	{
		return myReader.getRoads().get(index);
	}
	
	/**
	 * Gets the road total distance.
	 *
	 * @return the road total distance
	 */
	public int getRoadTotalDistance()
	{
		int totaldistance = 0 ;
		for (int i=0 ; i < myReader.getRoads().size(); i++)
		{
			totaldistance = totaldistance + myReader.getRoads().get(i).getDistance();
		}
		return totaldistance;
	}
   
   /**
    * Gets the _number_of_roads.
    *
    * @return the _number_of_roads
    */
   public int get_number_of_roads ()
   {
	   return myReader.getRoads().size();
   }
   
}