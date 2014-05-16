package algorithm.basic;

import java.util.LinkedList;

class Hashtable {
	private final int tableSize = 20;
	private int numElements;
	private Object[] table;

	public Hashtable() {
		this.table = new Object[this.tableSize];
		this.numElements = 0;
	}

	public Hashtable(Object initialKey, Object initialData) {
		this();
		this.add(initialKey, initialData);
	}

	public Hashtable(Object[] initialKeys, Object[] initialData) {
		this();

		/* Don't do stuff with differently sized input arrays */
		if (initialKeys.length != initialData.length) {
			System.err.println("ERROR: The size of the keys and data arrays are different");
		}

		this.add(initialKeys, initialData);
	}

	/**
	 * Add an item to the hash table
	 * 
	 * @param data
	 *            The data to store
	 */
	public void add(Object key, Object data) {
		if (data == null || key == null) {
			System.err.println("ERROR: Either the key or the data are null");
			return;
		}

		/* Don't add duplicate keys */
		if (this.contains(key)) {
			return;
		}

		/* Find out where in our array should the item go */
		int position = this.hash(key);

		/* If nothing exists in the position, create a new linked list there */
		if (this.table[position] == null) {
			this.table[position] = new LinkedList<HashtableNode>();
		}

		/* Add to the linked list in the appropriate position */
		((LinkedList<HashtableNode>) this.table[position]).add(new HashtableNode(key, data));
		this.numElements++;
	}

	/**
	 * Add a an array of items to the hash table
	 * 
	 * @param inputData
	 *            The data to add
	 */
	public void add(Object[] keys, Object[] inputData) {
		for (int i = 0; i < inputData.length; i++) {
			this.add(keys[i], inputData[i]);
		}
	}

	/**
	 * Remove an item from the hashtable
	 * 
	 * @param key
	 *            The item to remove
	 */
	public void remove(Object key) {
		int hashVal = this.hash(key);

		if (this.table[hashVal] != null) {
			HashtableNode node = new HashtableNode();
			node.setKey(key);

			if (((LinkedList) this.table[hashVal]).indexOf(node) > -1) {
				((LinkedList) this.table[hashVal]).remove(node);
				this.numElements--;
			}
		}
	}

	/**
	 * Remove many items from the hashtable
	 * 
	 * @param inputData
	 *            The array of items to remove
	 */
	public void remove(Object[] keys) {
		for (int i = 0; i < keys.length; i++) {
			this.remove(keys[i]);
		}
	}

	/**
	 * Calculate the hash for an object being stored. Use the toString() method
	 * to get a string from the Object and then add the ASCII values of the
	 * string (unless it's a-f, in which case we'll use it as hex)
	 */
	private int hash(Object key) {

		/* Start with a base, just so that it's not 0 for empty strings */
		int result = 42;

		String inputString = key.toString().toLowerCase();

		char[] characters = inputString.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			char currentChar = characters[i];

			if (currentChar == 'a' || currentChar == 'b' || currentChar == 'c' || currentChar == 'e'
					|| currentChar == 'e' || currentChar == 'f') {
				result += Integer.parseInt("" + currentChar, 16);
			}

			int j = (int) currentChar;
			result += j;
		}

		return (result % this.tableSize);
	}

	/**
	 * Give a string representation of the hash table
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(System.getProperty("line.separator"));
		buffer.append("{");
		buffer.append(System.getProperty("line.separator"));

		for (int i = 0; i < this.table.length; i++) {
			if (this.table[i] != null) {
				buffer.append("\t" + (LinkedList) this.table[i]);
				buffer.append(System.getProperty("line.separator"));
			}
		}

		buffer.append("}");

		return buffer.toString();
	}

	public int getNumElements() {
		return this.numElements;
	}

	/**
	 * Check if the table contains a certain element or not
	 * 
	 * @param data
	 *            The data to search for
	 * @return Whether or not the element exists
	 */
	public boolean contains(Object key) {
		boolean result = false;
		int hash = this.hash(key);

		if (this.table[hash] != null) {
			HashtableNode node = new HashtableNode();
			node.setKey(key);
			if (((LinkedList) this.table[hash]).indexOf(node) > -1) {
				result = true;
			}
		}

		return result;
	}

	private class HashtableNode {
		private Object key;
		private Object data;

		public HashtableNode() {
			this.key = null;
			this.data = null;
		}

		public HashtableNode(Object inKey, Object inData) {
			this.key = inKey;
			this.data = inData;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public Object getKey() {
			return key;
		}

		public void setKey(Object key) {
			this.key = key;
		}

		/*
		 * Equality can be based on key alone because there can't be 2 nodes
		 * with the same key in the table
		 */
		public boolean equals(Object obj) {
			if (obj instanceof HashtableNode) {
				HashtableNode node = (HashtableNode) obj;
				return this.key.equals(node.getKey());
			} else {
				return false;
			}
		}

		public String toString() {
			return "Key: [" + this.key + "] data: [" + this.data + "]";
		}
	}
}