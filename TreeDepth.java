import java.util.*; 


public class TreeDepth
{

	public void depthNodes(Node node, ArrayList<ArrayList<Node>> list, int depth)
	{
		if(node.children.size() == 0)
		{
			return;
		}
		else
		{
			list.get(depth).add(node);
			for(int i = 0; i < node.children.size(); ++i)
			{
				depthNodes(node.children.get(i),list,depth+1);
			}
		}
	}

}
