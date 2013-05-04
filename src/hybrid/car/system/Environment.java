package hybrid.car.system;
import hybrid.car.data.MapDataReader;

// TODO: Auto-generated Javadoc
/**
 * The Class Environment.
 */
public class Environment {

	/** The map. */
	private Map map;

	/**
	 * Instantiates a new environment.
	 *
	 * @param mapFileName the map file name
	 */
	public Environment(String mapFileName){
		this.map = new Map(new MapDataReader(mapFileName));
	}
	
	/**
	 * Gets the my map.
	 *
	 * @return the my map
	 */
	public Map getMyMap()
	{
		return map;
	}

}