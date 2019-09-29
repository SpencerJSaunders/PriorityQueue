import java.util.Random;
/**
 * 
 * 
 * @author Spencer Saunders
 *
 */
public class ProcessGenerator {

	//define our variable
	double probability;
	Random random = new Random();
	Process p;
	
	//constructor sets the value of probability 
	public ProcessGenerator(double probability)
	{
		this.probability = probability;
	}
	
	public boolean query()
	{
		double randomValue = random.nextDouble();
		
		if(randomValue < probability)
		{
			return true;
		}
		return false;
	}
	
	public Process getNewProcess(int currentTime, int maximumProcessTime, int maximumPriorityLevel)
	{
		int timeToFinish = random.nextInt(maximumProcessTime);
		int priorityLevel = random.nextInt(maximumPriorityLevel);
		p = new Process(currentTime,priorityLevel,timeToFinish, maximumPriorityLevel);
		
		return p;
	}
	private void setProbability(double probability)
	{
		this.probability = probability;
	}
}
