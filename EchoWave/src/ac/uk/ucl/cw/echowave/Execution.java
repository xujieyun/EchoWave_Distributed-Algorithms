package ac.uk.ucl.cw.echowave;

import java.util.ArrayList;
import java.util.Collections;  
import java.util.List;  

public class Execution {
	int Amountofiteration=0;
	int iterationCounter=0;
	public Graph ph;
	int MAX_NODE;
	int K=10;
	int amountAcp=0;
	public Execution(Graph ph) {
		this.ph = ph;
		this.MAX_NODE = ph.getN();
	}
	/**
	 * a main execution method
	 */
	public void exe() {
		int initiatorId;
		
		initiatorId=(int)(0+Math.random()*MAX_NODE);
		System.out.println("Node:"+initiatorId+" is the initiator");
		ph.vertex[initiatorId].activate();// change initiator act to true
		ph.sendtok(initiatorId);
		ph.vertex[initiatorId].act = false;// change initiator act to false
		for(int i=0;i<K;i++) {
			System.out.println("/////////////////////////////////////////////////");
			System.out.println("this is the "+(iterationCounter+1)+" times iteration");
			iteration(initiatorId);
			iterationCounter++;
			if(ph.vertex[initiatorId].recAmount == ph.getEdgeAmount(initiatorId)) {
				break;
			}
		}
		//If the initiator is undecided within KN iterations, increase K
		while(ph.vertex[initiatorId].recAmount != ph.getEdgeAmount(initiatorId)) {
			System.out.println("/////////////////////////////////////////////////");
			System.out.println("this is the "+(iterationCounter+1)+" times iteration");
			iteration(initiatorId);
			iterationCounter++;
			K++;
		}
		System.out.println("finish");
		System.out.println("Node :"+initiatorId+" will decide");
		for(int k=0;k<MAX_NODE;k++) {
			System.out.println(ph.vertex[k]);
		}
		System.out.println("ROOT node is the node which has parent 100");
		for(int i=0;i<MAX_NODE;i++) {
			amountAcp = amountAcp + ph.vertex[i].getRecAmount();
		}
		System.out.println("Amount of sendtok: "+amountAcp);
		System.out.println("K= "+K);
		System.out.println("Amount of iteration: " + Amountofiteration);
	}
	public void iteration(int initiatorId) {
		int R;//Choose R nodes randomly and allow only the chosen nodes to execute the protocol.
		R = (int)(0+Math.random()*MAX_NODE);
		
		System.out.println("In this turn "+R+" nodes will work :");
		
        int[] arr1= ph.getVertexId();
        int[] arr2= randomFunction(arr1,R);
        for(int x=0;x<R;x++) {
			System.out.print(arr2[x]+" ");
		}
        System.out.print("\n");
        for(int i=0;i<ph.getN();i++) {
        	for(int m=0;m<R;m++) {
        	if( ph.vertex[i].getId() == arr2[m] ) {
        		if(ph.vertex[i].act ) {
        			ph.sendtok(i);
        			ph.vertex[i].act = false;
        			Amountofiteration++;
        		}
        		else if(ph.vertex[i].sleep == false && ph.vertex[i].recAmount == ph.getEdgeAmount(i) && ph.vertex[i].id !=initiatorId) {
        			ph.returntok(i);
        			Amountofiteration++;
        		}
        		else {Amountofiteration++;}
        	}
        	}
        }
	}
	/**
	 * 
	 * @param arr original array
	 * @param R is How many element will be chose
	 * @return a new random array and have only R element
	 */
	public int[] randomFunction(int[] arr,int R) {
		int[]arr1=arr;
		List<Integer> list = new ArrayList<>();
		for(int i:arr1) {
			list.add(i);
		}
		Collections.shuffle(list);
		int[] arr2 = new int[list.size()];
		for(int m=0;m<list.size();m++) {
			arr2[m]=list.get(m);
		}
		int[] arr3 = new int[R];
		//only R element of array will be chose.
		for(int n=0;n<R;n++) {
			arr3[n]=arr2[n];
		}
		return arr3;
	}
	
}
