import java.util.*; 


public class AlphabetCreation {   


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int words = scanner.nextInt();
        String[] w = new String[words];
        for(int i = 0; i < words; ++i)
        {
            w[i] = scanner.next();
        }

        System.out.println(answer(w));
    }


    public static String answer(String[] words) { 
        Map<Integer,HashSet<Integer>> graph = new HashMap<Integer,HashSet<Integer>>();
        HashSet<Integer> lettersWithPreReq = new HashSet<Integer>();
        HashSet<Integer> uniqueLetters = new HashSet<Integer>();
        int[] degrees = new int[26];
        for(int i = 0; i < words.length; ++i)
        {
            for(int j = 0; j < words[i].length(); ++j)
            {
                uniqueLetters.add((int)words[i].charAt(j));
            }
        }
        for(int i = 0; i < words.length-1; ++i)
        {
            String word1 = words[i]; 
            String word2 = words[i+1];
            int minLength = Math.min(word1.length(),word2.length()); 
            for(int j = 0; j < minLength; ++j)
            {
                if(word1.charAt(j) != word2.charAt(j))
                {
                    //difference in characters, add dependency to graph
                    if(!graph.containsKey((int)word1.charAt(j)))
                    {
                        graph.put((int)word1.charAt(j),new HashSet<Integer>()); 
                    }
                    if(!graph.get((int)word1.charAt(j)).contains((int)word2.charAt(j)))
                    {
                         graph.get((int)word1.charAt(j)).add((int)word2.charAt(j));  
                         //store letters that have a letter that comes before it
                         lettersWithPreReq.add((int)word2.charAt(j)); 
                         degrees[word2.charAt(j)-97]++; 
                    }
                    break; 
                }
            }
        }
            
            //find the letters that don't have letters that come before them
            ArrayList<Integer> noPreReq = new ArrayList<Integer>();
            for(Integer letter: uniqueLetters)
            {
                if(!lettersWithPreReq.contains(letter))
                {
                    noPreReq.add(letter);
                }
            }
            
            ArrayList<Integer> sortedAlphabet = topologicalSort(graph,noPreReq,degrees,uniqueLetters);
            StringBuilder alphabet = new StringBuilder();
            for(int i = 0; i < sortedAlphabet.size(); ++i)
            {
                char append = (char)(int)sortedAlphabet.get(i);
                alphabet.append(append); 
            }
            return alphabet.toString();
    } 
    
    private static ArrayList<Integer> topologicalSort(Map<Integer,HashSet<Integer>> graph, ArrayList<Integer> noPreReq, int[] degrees, HashSet<Integer> uniqueLetters)
    {
        //perform topological sort
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        while(noPreReq.size() > 0)
        {
            int current = noPreReq.remove(noPreReq.size()-1); 
            list.add(current);
            if(graph.get(current) != null && graph.get(current).size() > 0)
            {
                for(Integer i: graph.get(current))
                {
                    degrees[i-97]--; 
                    if(degrees[i-97] == 0)
                    {
                        noPreReq.add(i); 
                    }
                }
            }
        }

        return list; 
    }
