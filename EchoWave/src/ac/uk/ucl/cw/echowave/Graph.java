package ac.uk.ucl.cw.echowave;

public class Graph {
	private int N;//amount of vertex
    Node [] vertex; //collections of vertex
    int[] vertexId; //collections of vertex id
	int [] [] matrix;// create a connect matrix which is a double dimensional array
	
	public Graph (int N){
		this.setN(N);
		matrix = new int [N][N];//initialize a matrix, length and width is N.
		vertex = new Node [N];//initialize the vertex
		vertexId = new int[N];
		for(int i=0;i<N;i++) {
			vertex[i] = new Node(i);
		}
		for(int m=0;m<N;m++) {
			vertexId[m] = m;
		}
		
	}
	public int[] getVertexId() {
		return vertexId;
	}
	public Node[] getVertex() {
		return vertex;
	}

	/**
	 * @return the matrix
	 */
	public int [] [] getMatrix() {
		return matrix;
	}

	/**
	 * @param matrix the matrix to set
	 */
	public void setMatrix(int [] [] matrix) {
		this.matrix = matrix;
	}

	/**
	 * @return the n
	 */
	public int getN() {
		return N;
	}

	/**
	 * @param n the n to set
	 */
	public void setN(int n) {
		N = n;
	}
	
	public String toString() {
		return "amount of node: " + N + "infomation of vertex: "+ vertex; 
	}
	
	public void printDetail() {
		System.out.println("amount of node: " + N );
		for(int i=0;i<N;i++) {
			System.out.println(vertex[i]+" ");
		}
		for(int m=0;m<N;m++) {
			System.out.println();
			for(int n=0;n<N;n++) {
				System.out.print(matrix[m][n]+" ");
			}
	    }
    }
	/**
	 * 
	 * @param i i is node id
	 * @return returns amount of node i's edge
	 */
	public int getEdgeAmount(int i) {
		int m;
		int amount=0;
		for(m=0;m<N;m++) {
			if(this.matrix[i][m]==1) {
				amount++;
			}
		}
		return amount;
	}
	/**
	 * 
	 * @param i is node id
	 * @return returns a collection of edge id
	 */
	public int[] getEdge(int i) {
		int m = this.getEdgeAmount(i);
		int[] edge =new int[m];
		int a=0;
		for(int n=0;n<N;n++) {
			if(this.matrix[i][n]==1) {
				edge[a]= n;
				a++;
			}
		}
		return edge;
	}
	/**
	 * a method to send token from i to his neighbor
	 * @param i i is node id
	 */
	public void sendtok(int i) {
		int[] arr=this.getEdge(i);
		for(int m=0;m<this.getEdgeAmount(i);m++) {
			if(arr[m] != vertex[i].getParentId()) {
			vertex[arr[m]].recAmount++;
			//100 is default parent id
			if(vertex[arr[m]].getParentId()==100) {
				vertex[arr[m]].setParent(vertex[i]);
			}
			if(vertex[arr[m]].act==false && vertex[arr[m]].recAmount == 1) {
				vertex[arr[m]].activate();
			}
			System.out.println("send tok success from node:"+i+" to node:"+vertex[arr[m]]);
		  }
		}
	}
	/**
	 * a method to return token from i to his parent
	 * @param i i is node id
	 */
	public void returntok(int i) {
		vertex[i].parent.recAmount++;
		vertex[i].sleep = true;
		System.out.println("Node"+i+" send tok return to his parent Node"+vertex[i].getParentId());
	}
	
	
}
