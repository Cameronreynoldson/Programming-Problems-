import java.util.*; 
public class MinWindow {   

	public static void main(String[] args)
	{
		String doc = "a b c d a"; 
		String[] terms = {"a","c","d"}; 
		System.out.println(answer(doc,terms));
	}

    public static String answer(String document, String[] searchTerms) { 
        //binary search the window size 
        int lowerBound = 0; 
        int upperBound = countWords(document); 
        int mid = 0; 
        StringBuilder correctWindow = new StringBuilder();
        StringBuilder testWindow = new StringBuilder();
        while(lowerBound <= upperBound)
        {
            mid = lowerBound + (upperBound-lowerBound)/2; 
            testWindow =  getWindow(mid,document,searchTerms); 
            if(testWindow.length() > 0)
            {
                correctWindow = testWindow;
                upperBound = mid-1; 
            }
            else
            {
                lowerBound = mid+1; 
            }
        }
        
        return correctWindow.toString();
    } 
    
    private static StringBuilder getWindow(int mid, String document, String[] words)
    {
        Deque<String> dq = new LinkedList<String>();
        Scanner scanner = new Scanner(document);
        int numberOfKeyWordsIncluded = 0; 
        HashMap<String,Integer> map = getMap(words); 
        while(scanner.hasNext())
        {
            String nextWord = scanner.next(); 
            if(dq.size() >= mid)
            {
                String first = dq.removeFirst(); 
                if(map.containsKey(first))
                {   
                    int count = map.get(first); 
                    map.put(first,count-1);
                    if(map.get(first) == 0)
                    {
                        numberOfKeyWordsIncluded--; 
                    }
                }
            }
            dq.addLast(nextWord);
            if(map.containsKey(nextWord))
            {
                int count = map.get(nextWord);
                map.put(nextWord,count+1); 
                if(count == 0) numberOfKeyWordsIncluded++; 
            }

            if(numberOfKeyWordsIncluded == words.length)
            {
            	StringBuilder sb = new StringBuilder();
            	int size = dq.size();
            	for(int i = 0; i < size-1; ++i)
            	{
                	sb.append(dq.removeFirst()+" ");
            	}
            	sb.append(dq.removeFirst());
           		 return sb; 
            }
        }
        
            return new StringBuilder();
    }
    
    //map each word to its respective index in the searchTerms array
    private static HashMap<String,Integer> getMap(String[] words)
    {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i = 0; i < words.length; ++i)
        {
            map.put(words[i],0);
        }
        return map; 
    }
    
    //count number of words in the document for initial upper bound
    private static int countWords(String document)
    {
        int words = 0; 
        Scanner scanner = new Scanner(document);
        while(scanner.hasNext())
        {
            scanner.next(); 
            words++; 
        }
        return words; 
    }
}
