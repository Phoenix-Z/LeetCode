package hash;

import java.util.LinkedList;
import java.util.List;

public class SeperateChainingHashTable <AnyType> {

	private static final int DEFAULT_TABLE_SIZE = 101;
	
	private List<AnyType>[] theLists;
	private int currentSize;
	
	/**
	 * Construct the hash table
	 */
	public SeperateChainingHashTable() {
		this(DEFAULT_TABLE_SIZE);
	}

	/**
	 * Construct the hash table.
	 * @param size approximate table size.
	 */
	@SuppressWarnings("unchecked")
	public SeperateChainingHashTable(int size) {
		theLists = new LinkedList[nextPrime(size)];
		for(int i = 0; i < theLists.length; i++) {
			theLists[i] = new LinkedList<>();
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
		
		hashVal %= theLists.length;
		if(hashVal < 0)
			hashVal += theLists.length;
		return hashVal;
	}
	
	@SuppressWarnings("unchecked")
	private void rehash() {
		List<AnyType>[] oldLists = theLists;
		
		// Create new double-sized, empty table
		theLists = new List[nextPrime(2 * theLists.length)];
		for(int j = 0; j < theLists.length; j++) {
			theLists[j] = new LinkedList<>();
		}
		
		// Copy table over
		currentSize = 0;
		for(int i = 0; i < oldLists.length; i++) {
			for(AnyType item : oldLists[i]) {
				insert(item);
			}
		}
	}
	
	/**
	 * Insert into the hash table. If the item is already
	 * present, then do nothing.
	 * @param x the item to insert.
	 */
	public void insert(AnyType x) {
		List<AnyType> whichList = theLists[myhash(x)];
		if(!whichList.contains(x)) {
			whichList.add(x);
			
			if(++currentSize > theLists.length)
				rehash();
		}
	}
	
	/**
	 * Remove from the hash table.
	 * @param x the item to remove
	 */
	public void remove(AnyType x) {
		List<AnyType> whichList = theLists[myhash(x)];
		if(whichList.contains(x)) {
			whichList.remove(x);
			currentSize--;
		}
	}
	
	/**
	 * Find an item in the hash table.
	 * @param x the item to search for.
	 * @return true if x is found.
	 */
	public boolean contains(AnyType x) {
		List<AnyType> whichList = theLists[myhash(x)];
		return whichList.contains(x);
	}
	
	/**
	 * Make the hash table logically empty.
	 */
	public void makeEmpty() {
		for(int i = 0; i < theLists.length; i++) {
			theLists[i].clear();
		}
		currentSize = 0;
	}
}
