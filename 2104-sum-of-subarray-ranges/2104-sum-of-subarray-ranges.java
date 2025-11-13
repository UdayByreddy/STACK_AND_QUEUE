class Solution {
    public int[] NSE(int[] nums){
        Stack<Integer> stk = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && nums[stk.peek()]>=nums[i]){
                stk.pop();
            }
            ans[i] = stk.isEmpty()?n:stk.peek();
            stk.push(i);
        }
        return ans;
    }
    public int[] PSEE(int[] nums){
        Stack<Integer> stk = new Stack<>();
        int n= nums.length;
           int[] ans = new int[n];
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && nums[stk.peek()]>nums[i]){
                stk.pop();
            }
            ans[i] = stk.isEmpty()?-1:stk.peek();
            stk.push(i);
        }
        return ans;
    }
    public int[] NGE(int[] nums){
        Stack<Integer> stk = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && nums[stk.peek()]<=nums[i]){
                stk.pop();
            }
            ans[i] = stk.isEmpty()?n:stk.peek();
            stk.push(i);
        }
        return ans;
    }
    public int[] PGEE(int[] nums){
        Stack<Integer> stk = new Stack<>();
        int n= nums.length;
           int[] ans = new int[n];
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && nums[stk.peek()]<nums[i]){
                stk.pop();
            }
            ans[i] = stk.isEmpty()?-1:stk.peek();
            stk.push(i);
        }
        return ans;
    }

    public long subArrayMin(int[] PSEE,int[] NSE,int[] nums){
        long ans=0;
        for(int i=0;i<nums.length;i++){
            int left = i-PSEE[i];
            int right = NSE[i]-i;
            long val = left*right*1L;
            long freq = (val*nums[i]);
            ans +=freq;
        }
        return ans;
    }
    public long subArrayMax(int[] PGEE,int[] NGE,int[] nums){
        long ans=0;
        for(int i=0;i<nums.length;i++){
            int left = i-PGEE[i];
            int right = NGE[i]-i;
            long val = left*right*1L;
            long freq = (val*nums[i]);
            ans+=freq;
        }
        return ans;
    }
    public long subArrayRanges(int[] nums) {
        int[] PSEE = PSEE(nums);
        int[] NSE = NSE(nums);
        int[] PGEE = PGEE(nums);
        int[] NGE = NGE(nums);
        long subArrayMin = subArrayMin(PSEE,NSE,nums);
        long subArrayMax = subArrayMax(PGEE,NGE,nums);

        return subArrayMax - subArrayMin;
    }
}