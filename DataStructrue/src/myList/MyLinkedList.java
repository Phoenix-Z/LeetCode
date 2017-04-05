package myList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<AnyType> implements Iterable<AnyType>{

	private static class Node<AnyType> {
		public AnyType data;
		public Node<AnyType> prev;
		public Node<AnyType> next;
		
		public Node(AnyType data, Node<AnyType> prev, Node<AnyType> next) {
			super();
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
	}
	
	private int theSize;
	// modCount 代表自从构造依赖对链表所做改变的次数
	private int modCount = 0;
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;
	
	public MyLinkedList() {
		clear();
	}
	
	/**
	 * Change the size of this collection to zero.
	 */
	private void clear() {
		beginMarker = new Node<AnyType>(null, null, null);
		endMarker = new Node<AnyType>(null, beginMarker, null);
		beginMarker.next = endMarker;
		
		theSize = 0;
		modCount++;
	}

	public int size() {
		return theSize;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean add(AnyType x) {
		add(size(), x);
		return true;
	}
	
	public void add(int idx, AnyType x) {
		addBefore(getNode(idx), x);
	}

	/**
	 * Adds an item to this collection, at specified position p.
	 * Items at or after that position are slid one position higher.
	 * @param p Node to add before.
	 * @param x any object.
	 */
	private void addBefore(Node<AnyType> p, AnyType x) {
		Node<AnyType> newNode = new Node<AnyType>(x, p.prev, p);
		newNode.prev.next = newNode;
		p.prev = newNode;
		theSize++;
		modCount++;
	}

	/**
	 * Gets the Node at position idx, which must range from 0 to size().
	 * @param idx index of node being obtained.
	 * @return internal node corresponding to idx.
	 * @throws IndexOutOfBoundsException if idx is not between 0 and size().
	 */
	private Node<AnyType> getNode(int idx) {
		Node<AnyType> p;
		
		if(idx < 0 || idx >= size())
			throw new IndexOutOfBoundsException();
		
		if(idx < size() / 2) {
			p = beginMarker.next;
			for(int i = 0; i < idx; i++) {
				p = p.next;
			}
		} else {
			p = endMarker;
			for(int i = size(); i > idx; i--) {
				p = p.prev;
			}
		}
 		return p;
	}

	public AnyType get(int idx) {
		return getNode(idx).data;
	}
	
	public AnyType set(int idx, AnyType newVal) {
		Node<AnyType> p = getNode(idx);
		AnyType oldVal = p.data;
		p.data = newVal;
		return oldVal;
	}
	
	public AnyType remove(int idx) {
		return remove(getNode(idx));
	}
	
	/**
	 * Removes the object contained in Node p.
	 * @param p the Node contained the object.
	 * @return the items was removed from the collection.
	 */
	public AnyType remove(Node<AnyType> p) {
		p.next.prev = p.prev;
		p.prev.next = p.next;
		theSize--;
		modCount++;
		
		return p.data;
	}
	
	@Override
	public Iterator<AnyType> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<AnyType> {

		private Node<AnyType> current = beginMarker.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;
		
		@Override
		public boolean hasNext() {
			return current != endMarker;
		}

		@Override
		public AnyType next() {
			if(modCount != expectedModCount)
				throw new ConcurrentModificationException();
			if(!hasNext())
				throw new NoSuchElementException();
			
			AnyType nextItem = current.data;
			current = current.next;
			okToRemove = true;
			return nextItem;
		}
		
		@Override
		public void remove() {
			if(modCount != expectedModCount)
				throw new ConcurrentModificationException();
			if(!okToRemove)
				throw new IllegalStateException();
			
			MyLinkedList.this.remove(current.prev);
			okToRemove = false;
			expectedModCount++;
		}
		
	}
	
}
