package hybrid.car.data;

import java.awt.Point;


/**
 * The Class RoadData.
 */
public class RoadData {
	
	/** The distance. */
	private int distance;
	
	/** The start. */
	private Point start;
	
	/** The end. */
	private Point end;
	
	/** The speed limit. */
	private int speedLimit;
	
	/** The slope. */
	private int slope;
	
	
	/**
	 * Instantiates a new road data.
	 *
	 * @param start the start point
	 * @param end the end point
	 * @param limit the speed limit
	 * @param slope the slope of road
	 */
	public RoadData(Point start, Point end, int limit, int slope)
	{
		this.start = start;
		this.end = end;
		this.speedLimit = limit;
		this.slope = slope;
		calculateDistance();
	}
	
	/**
	 * Gets the start point.
	 *
	 * @return the start point
	 */
	public Point getStartPoint()
	{
		return start;
	}
	
	/**
	 * Gets the end point.
	 *
	 * @return the end point
	 */
	public Point getEndPoint()
	{
		return end;
	}
	
	/**
	 * Gets the speed limit.
	 *
	 * @return the speed limit
	 */
	public int getSpeedLimit()
	{
		return speedLimit;
	}
	
	/**
	 * Gets the road slope.
	 *
	 * @return the road slope
	 */
	public int getRoadSlope()
	{
		return slope;
	}

	/**
	 * Gets the distance.
	 *
	 * @return the distance
	 */
	public int getDistance()
	{
		return distance;
	}
	
	/**
	 * Calculate distance.
	 */
	private void calculateDistance()
	{
		this.distance = (int) Math.sqrt(Math.pow((end.x - start.x), 2) + Math.pow((end.y - start.y), 2)); 
	}
}
