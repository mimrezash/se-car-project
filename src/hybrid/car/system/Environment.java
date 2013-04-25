package hybrid.car.system;
import hybrid.car.data.MapDataReader;

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
	
	public Map getMyMap()
	{
		return map;
	}

}