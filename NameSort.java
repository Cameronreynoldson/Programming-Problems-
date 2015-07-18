import java.util.*; 

public class NameSort {   

  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    String[] s = new String[num];
    for(int i = 0; i < num; ++i)
    {
      s[i] = scanner.next();
    }

    System.out.println(Arrays.toString(answer(s)));

  }
    public static String[] answer(String[] names) { 
        Arrays.sort(names,new Comparator<String>(){
           public int compare(String name1, String name2)
           {
              int valueName1 = getValue(name1); 
              int valueName2 = getValue(name2); 
              
              if(valueName1 != valueName2)
              {
                  return Integer.compare(valueName2,valueName1);
              }
              else
              {
                  return name2.compareTo(name1);
              }
           }
        });
        
        return names; 
    } 
    
    private static int getValue(String name)
    {
        int value = 0; 
        for(int i = 0; i < name.length(); ++i)
        {
            value += ((int)name.charAt(i))-96; 
        }
        return value; 
    }
}
