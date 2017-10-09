import java.util.Set;
import java.util.TreeSet;

public class Node implements Comparable<Node>{

	public String name;
	public Set<Node> connectedNodes = new TreeSet<Node>();
	
	public Node(String name)
	{
		this.name = name;
	}
	
	public void connect(Node newNode)
	{
		//connects this Node to the other
		connectedNodes.add(newNode);
	}
	
	@Override
	public int compareTo(Node other)
	{
		return this.name .compareTo(other.name) ;
	}
	
	
}
