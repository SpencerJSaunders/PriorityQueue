/**
 * 
 * @author Spencer Saunders
 *
 * @param <T>
 */


public class PQueue <T> {
	
	private MaxHeap<T> maxHeap;
	
	/*
	 * The constructor
	 */
	public PQueue()
	{
		maxHeap = new MaxHeap<T>();
	}
	
	/*
	 * populate the MaxHeap
	 */
	public PQueue(T[] objects, int[] keys)
	{
		maxHeap = new MaxHeap<T>(objects, keys);
	}
	
	/*
	 * @return max
	 */
	public T maximum()
	{
		T max = maxHeap.heapMax();
		return max;
	}
	
	/*
	 * @return max
	 */
	public T extractMax()
	{
		T max = maxHeap.heapMax();
		maxHeap.extractHeapMax();
		
		return max;
	}
	
	/*
	 * call increaseHeapKey from MaxHeap class
	 */
	public void increaseKey(int index, int newKey)
	{
		maxHeap.increaseHeapKey(index, newKey);
	}
	/*
	 * call maxHeapInsert from MaxHeap class
	 */
	public void insert(T object, int key)
	{
		maxHeap.maxHeapInsert(object, key);
	}
	/*
	 * call getHeapSize from MaxHeap class
	 */
	public boolean isEmpty()
	{
		return (maxHeap.getHeapSize() == 0);
	}
	/*
	 * return maxHeap.getHeapSize()
	 */
	public int size()
	{
		return maxHeap.getHeapSize();
	}
}
