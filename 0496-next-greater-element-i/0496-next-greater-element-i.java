class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextEle = new int[10001];
        int n = nums2.length;
        Stack<Integer> stk = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && stk.peek()<=nums2[i]){
                stk.pop();
            }
            nextEle[nums2[i]] = stk.isEmpty()?-1:stk.peek();
            stk.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res[i] = nextEle[nums1[i]];
        }
        return res;
    }
}