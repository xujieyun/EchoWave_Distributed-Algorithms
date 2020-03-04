package ac.uk.ucl.cw.echowave;


public class Node {
	int id;
	// node id
	Node parent;
	// node parent
	boolean act=false;
	// node can send token only when act is true
	boolean sleep=false;
	// node will be silent when sleep id true
	int recAmount = 0;
	final public static Node defualt = new Node(100);
	/**
	 * @return the id
	 */
	public Node (int i) {
		this.id = i;
		parent = defualt;
	}
	public int getRecAmount() {
		return recAmount;
	}
	
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the parent
	 */
	public Node getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public String toString() {
		return "id: "+id+" parentID: "+parent.getId();
	}
	
	public int getParentId() {
		return parent.id;
	}
	
	public void activate() {
		this.act = true;
	}
	
	public void toSleep() {
		this.sleep = true;
	}
}
