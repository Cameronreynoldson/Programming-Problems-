import java.util.*; 
public class LongestUniqueSubstring {
    public int lengthOfLongestSubstring(String s) {
        int max = 0; 
        int[] charIndex = new int[256];
        for(int i = 0; i < 256; ++i) charIndex[i] = -1; 
        int start = 0; 
        int end = 0; 
        for(int i = 0; i < s.length(); ++i)
        {
            char c = s.charAt(i);
            if(charIndex[c] >= start)
            {
                max = Math.max(i-start,max);
                start = charIndex[c]+1; 
            }
            charIndex[c] = i; 
        }
        max = Math.max(s.length()-start,max);
        return max; 
    }
}
