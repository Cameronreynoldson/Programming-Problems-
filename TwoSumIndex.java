public class TwoSumIndex {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; ++i)
        {
            int num = target-nums[i];
            map.put(num,i);
        }
        int[] solution = new int[2];
        for(int i = 0; i < nums.length; ++i)
        {
            int val = nums[i];
            if(map.containsKey(val) && i != map.get(val))
            {
                solution[0] = Math.min(i,map.get(val))+1;
                solution[1] = Math.max(i,map.get(val))+1;
                return solution;
            }
        }
        return solution; 
    }
}
