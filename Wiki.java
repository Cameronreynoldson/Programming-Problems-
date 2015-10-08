import java.util.*; 

public class Wiki
{
	public int clicks(Page source, Page destination)
	{
		Queue<Page> q = new LinkedList<Page>();

		q.add(source);

		int clicks = 0;

		while(!q.isEmpty()) //breadth first search
		{
			int size = q.size(); //get the number of nodes in the previous level

			for(int i = 0; i < size; ++i) //get all nodes for next level
			{
				Page current = q.poll();

				if(current == destination) //if we've reached the destination
				{
					return counter; 
				}

				ArrayList<Page> pages = current.getPages(); 

				for(int j = 0; j < pages.size(); ++j)
				{
					q.add(pages.get(j)); //add nodes from next level
				}
			}

			clicks++; //increment edge count
		}

		return -1; 
	}
}
