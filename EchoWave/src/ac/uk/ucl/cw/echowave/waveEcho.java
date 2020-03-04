package ac.uk.ucl.cw.echowave;

import java.util.Scanner;

public class waveEcho {

	public static void main(String[] args) {
	int index;
	System.out.println("please input 1,2 or 3 to select a graph execute echo algorithm");
	Scanner input = new Scanner(System.in);
	index = input.nextInt();
	CreateGraph cg = new CreateGraph();
	Graph gp = cg.createGraph(index);  
	

    Execution exeIn = new Execution(gp);
    exeIn.exe();
	}
}
