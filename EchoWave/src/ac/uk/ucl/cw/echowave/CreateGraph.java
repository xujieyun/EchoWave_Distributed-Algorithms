package ac.uk.ucl.cw.echowave;

public class CreateGraph {
	public Graph createGraph(int i) {
		switch(i) {
		//create graph1
		case(1): 
			Graph graph1 = new Graph(7);
		    int[] a1=new int[] {0,1,1,0,0,0,1};
		    int[] a2=new int[] {1,0,0,1,0,0,0};
		    int[] a3=new int[] {1,0,0,1,0,0,0};
		    int[] a4=new int[] {0,1,1,0,1,0,1};
		    int[] a5=new int[] {0,0,0,1,0,1,0};
		    int[] a6=new int[] {0,0,0,0,1,0,1};
		    int[] a7=new int[] {1,0,0,1,0,1,0};
		    
		    graph1.matrix[0] = a1;
		    graph1.matrix[1] = a2;
		    graph1.matrix[2] = a3;
		    graph1.matrix[3] = a4;
		    graph1.matrix[4] = a5;
		    graph1.matrix[5] = a6;
		    graph1.matrix[6] = a7;
		    
		    return graph1;
		//create graph2
		case(2):
			Graph graph2 = new Graph(13);
	        int[] b1=new int[] {0,  0,  1,  0,  0,  0,  1,  0,  0,  1,  0,  0,  0};
	        int[] b2=new int[] {0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	1,	0,	0};
	        int[] b3=new int[] {1,	0,	0,	1,	0,	0,	0,	0,	1,	0,	0,	0,	0};
	        int[] b4=new int[] {0,	0,	1,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0};
	        int[] b5=new int[] {0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1};
	        int[] b6=new int[] {0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	1,	0};
	        int[] b7=new int[] {1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	1,	0};
	        int[] b8=new int[] {0,	0,	0,	0,	0,	1,	0,	0,	1,	1,	0,	0,	1};
	        int[] b9=new int[] {0,	0,	1,	0,	0,	0,	0,	1,	0,	0,	0,	1,	0};
	        int[] b10=new int[] {1,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	1};
	        int[] b11=new int[] {0,	1,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0};
	        int[] b12=new int[] {0,	0,	0,	0,	0,	1,	1,	0,	1,	0,	0,	0,	0};
	        int[] b13=new int[] {0,	0,	0,	0,	1,	0,	0,	1,	0,	1,	0,	0,	0};
	        
	        graph2.matrix[0] = b1;
	        graph2.matrix[1] = b2;
	        graph2.matrix[2] = b3;
	        graph2.matrix[3] = b4;
	        graph2.matrix[4] = b5;
	        graph2.matrix[5] = b6;
	        graph2.matrix[6] = b7;
	        graph2.matrix[7] = b8;
	        graph2.matrix[8] = b9;
	        graph2.matrix[9] = b10;
	        graph2.matrix[10] = b11;
	        graph2.matrix[11] = b12;
	        graph2.matrix[12] = b13;
	        return graph2;
	    //create graph3
		case(3):
			Graph graph3 = new Graph(7);
            int[] c1=new int[] {0,1,0,0,0,0,1};
            int[] c2=new int[] {1,0,0,1,0,0,0};
            int[] c3=new int[] {0,0,0,1,0,1,0};
            int[] c4=new int[] {0,1,1,0,0,0,1};
            int[] c5=new int[] {0,0,0,0,0,1,0};
            int[] c6=new int[] {0,0,1,0,1,0,1};
            int[] c7=new int[] {1,0,0,1,0,1,0};
    
            graph3.matrix[0] = c1;
            graph3.matrix[1] = c2;
            graph3.matrix[2] = c3;
            graph3.matrix[3] = c4;
            graph3.matrix[4] = c5;
            graph3.matrix[5] = c6;
            graph3.matrix[6] = c7;
            
            return graph3;
		default:
			System.out.println("please input 1 or 2 or 3");
		    return null;
	  }
	}
}
