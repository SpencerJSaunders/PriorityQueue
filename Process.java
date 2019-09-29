/**
 * 
 * @author Spencer Saunders
 *
 *Process class which models a CPU process
 */
public class Process {
	
	
	//declare our variables
	private int priorityLevel;
	private int timeToFinish;
	private int timeNotProcessed;
	private int arrivalTime;
	private int maxPriorityLevel;
	
	Process(int arrivalTime, int priorityLevel, int timeToFinish, int maxPriorityLevel)
	{
		this.arrivalTime = arrivalTime;
		this.priorityLevel = priorityLevel;
		this.timeToFinish = timeToFinish;
		this.maxPriorityLevel = maxPriorityLevel;
	}
	
	public void reduceTimeRemaining()
	{
		timeNotProcessed = 0;
		timeToFinish--;
	}
	public void incrementTimeNotProcessed()
	{
		timeNotProcessed++;
	}
	/**
	 * 
	 * @return timeNotProcessed
	 */
	public int getTimeNotProcessed()
	{
		return timeNotProcessed;
	}
	/**
	 * 
	 * @return timeToFinish
	 */
	public int getTimeRemaining()
	{
		return timeToFinish;
	}
	
	/**
	 * 
	 * @return timeToFinish == 0
	 */
	public boolean done()
	{
		return (timeToFinish == 0);
	}
	/**
	 * 
	 * @return arrivalTime
	 */
	public int getArrivalTime()
	{
		return arrivalTime;
	}
	/**
	 * 
	 * @return priorityLevel
	 */
	public int getPriority()
	{
		return priorityLevel;
	}
	
	public void incrementPriority()
	{
		priorityLevel++;
	}
	public void resetTimeNotProcessed()
	{
		this.timeNotProcessed = 0;
	}
	private void setPriorityLevel(int priorityLevel)
	{
		this.priorityLevel = priorityLevel;
	}
	/**
	 * 
	 * @return timeToFinish
	 */
	public int getTimeToFinish()
	{
		return this.timeToFinish;
	}

	private void setTimeToFinish(int timeToFinish)
	{
		this.timeToFinish = timeToFinish;
	}
	private void setTimeNotProcessed(int time)
	{
		this.timeNotProcessed = timeNotProcessed;
	}
	private void setArrivalTime(int arrivalTime)
	{
		this.arrivalTime = arrivalTime;
	}
	/**
	 * 
	 * @return maxPriorityLevel
	 */
	public int getMaxPriorityLevel()
	{
	   return this.maxPriorityLevel;
	}
	public void setMaxPriorityLevel(int maxPriorityLevel)
	{
		this.maxPriorityLevel = maxPriorityLevel;
	}

}
