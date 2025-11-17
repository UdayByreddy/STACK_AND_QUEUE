class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int max=0;
        int n = heights.length;
        for(int i=0;i<=n;i++){
            while(!stk.isEmpty() && ((i==n) || heights[stk.peek()]>=heights[i])){
                int height = heights[stk.peek()];
                stk.pop();
                int width;
                if(stk.isEmpty()){
                    width =i;
                }
                else{
                    width = i-stk.peek()-1;
                }
                max = Math.max(max,height*width);
            }
            stk.push(i);
        }
        return max;
    }
}