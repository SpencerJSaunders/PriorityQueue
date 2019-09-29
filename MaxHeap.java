import java.util.Arrays;

/*
 * @Spencer Saunders
 * 
 * 
 * Class that makes a MaxHeap ADT implementation
 */
public class MaxHeap<T> {

	//declare our variables, heapnode array, etc
	int heapSize = 0;
	int capacity = 0;
	int DEFAULT_CAPACITY = 50;
	HeapNode<T>[] heap;
	
	//constructor creates an empty HeapNode array, sets capacity
	public MaxHeap()
	{
		heap = new HeapNode[DEFAULT_CAPACITY];
		heapSize = 0;
		capacity = DEFAULT_CAPACITY;
	}
	
	//constructor populates a HeapNode array with objects and keys arrays.
	public MaxHeap(T objects[], int keys[])
	{
		heap = new HeapNode[DEFAULT_CAPACITY];
		heapSize = 0;
		capacity = DEFAULT_CAPACITY;
	
		//for loop will populate until we reach length of the keys array 
		for(int i = 0; i < keys.length; i++)
		{
			//use insert method to populate
			maxHeapInsert(objects[i], keys[i]);
		}
		
	}

	//returns maximum value in the heap
	
	public T heapMax()
	{
	  return heap[1].getObject();	
	}
	

	public T extractHeapMax()
	{
		//if heapsize is less than 1, there's nothing to extract 
		if(heapSize < 1)
		{
			System.out.println("Heap underflow");
			System.exit(-1);
		}
		//set a T value equal to max heap
		T maxNum = heap[1].getObject();
		
		heap[1] = heap[heapSize];
		//reduce size by 1 to shrink size of HeapNode array
		heapSize = heapSize - 1;
		
		//call maxheapify to ensure that the rearranged Max Heap is ordered properly
		maxHeapify(1);
		
		return maxNum;
		
	}
	
	  public void maxHeapInsert(T object, int key)
	  {
		//heapsize must be increased if equal to capacity because 
		if(heapSize == capacity)
		{
			expandCapacity();
		}
		HeapNode <T> newNode = new HeapNode<T>(object, -999999);
		heapSize = heapSize + 1;
		//put the node into the added index in the HeapNode array
		heap[heapSize] = newNode;
		//update the key value
		increaseHeapKey(heapSize, key);
	  }
	
	
	public void expandCapacity()
	{
		heap  = Arrays.copyOf(heap, capacity*2);
		capacity = capacity*2;
	}
	public void increaseHeapKey(int index, int key)
	{
	   //if the parameter key is less than the current indexed key value, then send a message	
	   if(key < heap[index].getKey())
	   {
		   System.out.println("New key is smaller than current key");
	   }
	   heap[index].setKey(key);
	   
	   //ensure that parent key is less than child key
	   while(index > 1 && heap[parent(index)].getKey() < heap[index].getKey())
	   {
		   moveUp(index);
		   index = parent(index);
	   }
	}
	
	public void maxHeapify(int index)
	{
		//declare the parent, left, right, and biggest indexes 
		int biggest = index;
		int left = left(index);
		int right = right(index);
		int parent = parent(index);
		
		
		//update biggest value to left or right if neccessary
		if(left <= heapSize && heap[index].getKey() < heap[left].getKey())
		{
			biggest = left;
		}
		if(right <= heapSize && heap[index].getKey() < heap[right].getKey())
		{
			biggest = right;
		}
		
		if(biggest != index)
		{
			//exchange values and recursively call MaxHeapify.
			exchange(index, biggest);
			maxHeapify(biggest);
		}
	}
	
	//call exchange method instead of coding an entirely new method
	public void moveUp(int index)
	{
		exchange(index, parent(index));
	}
	public int getHeapSize()
	{
		return heapSize;
	}
	public boolean isEmpty()
	{
	   return (heapSize == 0);
	}
	public void exchange(int first, int second)
	{
	 //make temp node with indexed values of objects and keys and exchange the first indexed
	 //...position with the second indexed position
	 HeapNode<T> temp = new HeapNode(heap[first].getObject(), heap[first].getKey());
	 heap[first] = heap[second];
	 
	 //set heap indexed position second equal to the temp node
	 heap[second] = temp;
		
	}
	public int left(int i)
	{
		return (2*i);
	}
	public int right(int i)
	{
		return (2*i+1);
	}
	public int parent(int i)
	{
		return (i/2);
	}
	public void setHeapSize(int heapSize)
	{
	   this.heapSize = heapSize;
	}
	public void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}
	
	
}
