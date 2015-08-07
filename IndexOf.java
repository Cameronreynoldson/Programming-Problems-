public class IndexOf {
    public int strStr(String haystack, String needle) {
        int index = -1; 
        
        if(needle.length() == 0)
        {
            return 0;
        }
        else if(needle.length() > haystack.length())
        {
            return -1; 
        }
        
        //find the needle
        for(int i = 0; i < haystack.length(); ++i)
        {
            if(haystack.length()-i < needle.length())
            {
                return -1; 
            }
            
            if(haystack.charAt(i) == needle.charAt(0))
            {
                if(haystack.substring(i,i+needle.length()).equals(needle))
                {
                    return i;
                }
            }
        }
        
        return index; 
    }
}
