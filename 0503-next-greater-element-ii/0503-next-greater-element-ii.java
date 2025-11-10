class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            int currEle = i%n;
            while(!stk.isEmpty() && stk.peek()<=nums[currEle]){
                stk.pop();
            }
            if(i<n){
                if(stk.isEmpty()){
                    res[i]=-1;
                }
                else{
                    res[i]=stk.peek();
                }
            }
            stk.push(nums[currEle]);
        }
        return res;
    }
}