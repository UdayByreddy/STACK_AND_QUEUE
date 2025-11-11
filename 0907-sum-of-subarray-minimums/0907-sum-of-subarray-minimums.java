class Solution {
    public int[] NSE(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && arr[stk.peek()]>= arr[i]){
                stk.pop();
            }
            ans[i] = stk.isEmpty()?n:stk.peek();
            stk.push(i);
        }
        return ans;
    }
    public int[] PSEE(int[] arr){
         Stack<Integer> stk = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
             while(!stk.isEmpty() && arr[stk.peek()]> arr[i]){
                stk.pop();
            }
            ans[i] = stk.isEmpty()?-1:stk.peek();
            stk.push(i);
        }
        return ans;
    }
    public int sumSubarrayMins(int[] arr) {
        int[] arr1 = NSE(arr);
        int[] arr2 = PSEE(arr);
        long sum=0;
        int mod = (int) (1e9+7);
        for(int i=0;i<arr.length;i++){
            int left = i-arr2[i];
            int right = arr1[i]-i;
            long freq = (left* right)%mod;
            long val = (arr[i]*freq)%mod;
            sum = (sum+val)%mod;

        }
        return (int)sum;
         
    }
}