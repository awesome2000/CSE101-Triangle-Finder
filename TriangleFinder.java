import java.util.ArrayList;
import java.util.Random;

public class TriangleFinder {

	public static void main(String[] args) {
		
		int numNodes = Integer.parseInt(args[0]);
		
		// We will hard-code the adj. matrix
		// This matrix is:
		// 0,1,1
		// 1,0,0
		// 1,1,0
		
		// In this implementation, nodes cannot be connected to themselves
		
		//start initialization:
		ArrayList<Node> myGraph = new ArrayList<Node>();
		int matrixSize = (numNodes);
		
		boolean[][] myAdjMatrix = new boolean[matrixSize][matrixSize];
		//Let's populate matrix:
		for (int j=0; j!= myAdjMatrix.length; j++)
		{
			for (int i=0; i!= myAdjMatrix[j].length; i++)
			{
				if (i<j) {continue;} //do not care about lower-half of matrix
				if (i==j) {continue;} //do not link Node to itself
				Random rand = new Random();
				boolean b = rand.nextBoolean();
				myAdjMatrix[j][i] = b;
				myAdjMatrix[i][j] = b;
			}
		}
		
		for (int i=0; i!=matrixSize; i++)
		{
			myGraph.add(new Node(Integer.toString(i)));
		}
		for (int j=0; j!= myAdjMatrix.length; j++)
		{
			for (int i=0; i!= myAdjMatrix[j].length; i++)
			{
				if (i<j) {continue;} //do not care about lower-half of matrix
				if (i==j) {continue;} //do not link Node to itself
				if (myAdjMatrix[j][i] == true) 
				{
					//System.out.println("CONNECTING:" + nodes[i] + " and " + nodes[j]);
					myGraph.get(i).connect(myGraph.get(j));
					myGraph.get(j).connect(myGraph.get(i));
				}
			}
		}
		
		//Graph should be built by now
		//printGraph(myGraph);
		
		//Let's start Triangle Algorithm
		boolean foundTri = false;
		for (Node myNode1 : myGraph)
		{
			for (Node myNode2 : myNode1.connectedNodes)
			{
				for (Node myNode3 : myNode2.connectedNodes)
				{
					for (Node myNode4 : myNode3.connectedNodes)
					{
						if (myNode4.compareTo(myNode1) == 0)
						{
							//If nodes are equal, we have a triangle!
							System.out.println("FOUND TRIANGLE:");
							System.out.println(myNode1.name + 
									" - " + myNode2.name + " - " + myNode3.name);
							foundTri = true;
							return;
						}
					}
				}
			}
		}
		
		if (foundTri == false) {System.out.println("FALSE!");}
		
	}
	
	public static void printGraph(ArrayList<Node> myGraph)
	{
		//prints out each node and its connections
		for (Node n : myGraph)
		{
			System.out.println(n.name + " is connected to:");
			for (Node nConnected : n.connectedNodes)
			{
				System.out.println("\t" + nConnected.name);
			}
		}
	}

}


