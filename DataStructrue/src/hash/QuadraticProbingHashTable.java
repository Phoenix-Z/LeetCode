package hash;

public class QuadraticProbingHashTable <AnyType> {

	private static class HashEntry<AnyType> {
		public AnyType element;    // the element
		public boolean isActive;   // false if marked deleted
		
		public HashEntry(AnyType e) {
			this(e, true);
		}

		public HashEntry(AnyType e, boolean i) {
			element = e;
			isActive = i;
		}
	} 
	
	private static final int DEFAULT_TABLE_SIZE = 11;
	
	private HashEntry<AnyType>[] array;  // The array of elements
	private int currentSize;             // The number of occupied cells
	
	public QuadraticProbingHashTable() {
		this(DEFAULT_TABLE_SIZE);
	}

	public QuadraticProbingHashTable(int size) {
		allocateArray(size);
		makeEmpty();
	}
	
	public void makeEmpty() {
		currentSize = 0;
		for(int i = 0; i < array.length; i++)
			array[i] = null;
	}
	
	/**
	 * Find an item in the hash table.
	 * @param x the item to search for.
	 * @return the matching item.
	 */
	public boolean contains(AnyType x) {
		int currentPos = findPos(x);
		return isActive(currentPos);
	}
	
	public void insert(AnyType x) {
		// Insert x as active
		int currentPos = findPos(x);
		if(isActive(currentPos))
			return;
		
		array[currentPos] = new HashEntry<AnyType>(x);
		
		if(++currentSize > array.length / 2)
			rehash();
	}
	
	public void remove(AnyType x) {
		int currentPos = findPos(x);
		if(isActive(currentPos))
			array[currentPos].isActive = false;
	}
	
	@SuppressWarnings("unchecked")
	public void allocateArray(int arraySize) {
		array = new HashEntry[nextPrime(arraySize)];
	}
	
	/**
	 * Return true if currentPos exists and is active.
	 * @param currentPos the result of a call to findPos.
	 * @return true if currentPos is active.
	 */
	public boolean isActive(int currentPos) {
		return array[currentPos] != null && array[currentPos].isActive;
	}
	
	/**
	 * Method that performs quadratic probing resolution.
	 * @param x the item to search for.
	 * @return the position where the search terminates.
	 */
	private int findPos(AnyType x) {
		int offset = 1;
		int currentsPos = myhash(x);
		
		while(array[currentsPos] != null && 
				!array[currentsPos].element.equals(x)) {
			currentsPos += offset; // Compute ith probe
			offset += 2;
			if(currentsPos >= array.length)
				currentsPos -= array.length;
		}
		
		return currentsPos;
	}
	
	private void rehash() {
		HashEntry<AnyType>[] oldArray = array;
		
		// Create a new double-sized, empty table
		allocateArray(nextPrime(2 * oldArray.length));
		currentSize = 0;
		
		// Copy table over
		for(int i = 0; i < oldArray.length; i++) {
			if(oldArray[i] != null && oldArray[i].isActive)
				insert(oldArray[i].element);
		}
	}
	
	private static int nextPrime(int n) {
		int prime = n + 1;
		while(!isPrime(prime)) {
			prime++;
		}
		return prime;
	}
	
	private static boolean isPrime(int n) {
		for(int i = 2; i < Math.sqrt(n); i++) {
			if(n % i == 0)
				return false;
		}
		return true;
	}

	private int myhash(AnyType x) {
		int hashVal = x.hashCode();
		
		hashVal %= array.length;
		if(hashVal < 0)
			hashVal += array.length;
		return hashVal;
	}
}
