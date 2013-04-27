package hybrid.car.data;

import java.awt.Point;
import java.util.ArrayList;


/**
 * The Class MapDataReader.
 */
public class MapDataReader {
	
	/** The reader. */
	MyFileReader reader;
	
	/** The start points. */
	ArrayList<Point> startPoint;
	
	/** The end points. */
	ArrayList<Point> endPoint;
	
	/** The speed limits. */
	ArrayList<Integer> speedLimit;
	
	/** The Roads' Curve. */
	ArrayList<Integer> curves;
	
	/** The Roads' data. */
	ArrayList<RoadData> roads;
	
	
	/**
	 * Instantiates a new map data reader.
	 *
	 * @param filename the filename
	 */
	public MapDataReader(String filename)
	{
		reader = new MyFileReader(filename);
		startPoint = new ArrayList<Point>();
		endPoint = new ArrayList<Point>();
		speedLimit = new ArrayList<Integer>();
		curves = new ArrayList<Integer>();
		roads = new ArrayList<RoadData>();
		buildMap();
	}
	
	/**
	 * Builds the map.
	 */
	private void buildMap()
	{
		ArrayList<String> temp = reader.readFile();
		for(int i = 0; i < temp.size(); i++)
		{
			String line = temp.get(i);
			line = line.replace("(", "");
			line = line.replace(")", "");
			line = line.replace(" ", "");
			String[] parts = line.split(",");
			if(parts.length == 6)
			{
				//Integer.parseInt
				int x1 = Integer.parseInt(parts[0]);
				int y1 = Integer.parseInt(parts[1]);
				int x2 = Integer.parseInt(parts[2]);
				int y2 = Integer.parseInt(parts[3]);
				int limit = Integer.parseInt(parts[4]);
				int curve = Integer.parseInt(parts[5]);
				Point p = new Point(x1,y1);
				startPoint.add(p);
				p = new Point(x2,y2);
				endPoint.add(p);
				speedLimit.add(limit);
				curves.add(curve);
				roads.add(new RoadData(startPoint.get(i), endPoint.get(i), limit, curve));
			}
		}
		
	}
	
	/**
	 * Gets a start point.
	 *
	 * @param index the street number
	 * @return a start point
	 */
	public Point getStartPoint(int index)
	{
		return startPoint.get(index);
	}
	
	/**
	 * Gets an end point.
	 *
	 * @return an end point
	 */
	public ArrayList<Point> getEndPoints()
	{
		return endPoint;
	}
	
	/**
	 * Gets a speed limit.
	 *
	 * @return the speed limit
	 */
	public ArrayList<Integer> getSpeedLimit()
	{
		return speedLimit;
	}
	
	
	/**
	 * Gets a Road's Curve.
	 *
	 * @return the Road's Curve
	 */
	public ArrayList<Integer> getRoadCurve()
	{
		return curves;
	}
	
	
	/**
	 * Gets the combined roads' data.
	 *
	 * @return the roads
	 */
	public ArrayList<RoadData> getRoads()
	{
		return roads;
	}

}
