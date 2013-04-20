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
	
	
	/**
	 * Instantiates a new map data reader.
	 *
	 * @param filename the filename
	 */
	public MapDataReader(String filename)
	{
		reader = new MyFileReader(filename);
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
			if(parts.length == 5)
			{
				//Integer.parseInt
				int x1 = Integer.parseInt(parts[0]);
				int y1 = Integer.parseInt(parts[1]);
				int x2 = Integer.parseInt(parts[2]);
				int y2 = Integer.parseInt(parts[3]);
				int limit = Integer.parseInt(parts[4]);
				int curve = Integer.parseInt(parts[5]);
				startPoint.add(new Point(x1, y1));
				endPoint.add(new Point(x2, y2));
				speedLimit.add(limit);
				curves.add(curve);
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
	 * @param index the street number
	 * @return an end point
	 */
	public Point getEndPoint(int index)
	{
		return endPoint.get(index);
	}
	
	/**
	 * Gets a speed limit.
	 *
	 * @param index the street number
	 * @return the speed limit
	 */
	public int getSpeedLimit(int index)
	{
		return speedLimit.get(index);
	}
	
	
	/**
	 * Gets a Road's Curve.
	 *
	 * @param index the street number
	 * @return the Road's Curve
	 */
	public int getRoadCurve(int index)
	{
		return curves.get(index);
	}
	

}
