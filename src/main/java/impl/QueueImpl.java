package impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import skeleton.Person;
import skeleton.Queue;

public class QueueImpl extends Queue {

	public int size = 0;

	public QueueImpl() {
		super();
	}

	@Override
	public void add(Person p) {
		Node newNode = new Node(p);
		if (first == null) {
			first = newNode;
		} else {
			last.next = newNode;
		}
		last = newNode;
		size++;
	}

	@Override
	public Person retrieve() throws NoSuchElementException {
		if (first == null) {
			throw new NoSuchElementException("queue is empty");
		}

		Node resultNode = first;
		first = resultNode.next;
		size--;
		return resultNode.person;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		/*
		 * Comment from the Java implementation of clear() from the LinkedList
		 * 
		 * Clearing all of the links between nodes is "unnecessary", but: - helps a
		 * generational GC if the discarded nodes inhabit more than one generation - is
		 * sure to free memory even if there is a reachable Iterator
		 */
		Node queueFront = first;
		first = null;
		Node nextInLine = null;
		while (queueFront != null) {
			nextInLine = queueFront.next;
			queueFront.next = null;
			queueFront = nextInLine;
			size--;
		}
		last = null;
	}

	/**
	 * Iterator mostly used for printing in this exercise.
	 * 
	 * @return new Person iterator.
	 */
	public Iterator<Person> iterator() {
		return new Iterator<Person>() {

			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public Person next() {
				return null;
			}

		};
	}

	// This method is already implemented.
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Iterator<Person> it = iterator();

		while (it.hasNext()) {
			sb.append(it.next());
			sb.append(" -> ");
		}
		return sb.length() > 3 ? sb.substring(0, sb.length() - 3) : "empty list";
	}

}
