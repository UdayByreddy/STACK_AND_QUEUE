class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] prefix = new int[n][m];
        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=(matrix[i][j]=='1'?1:0);
                if(matrix[i][j]=='0'){
                    sum=0;
                    prefix[i][j]=0;
                }
                else{
                    prefix[i][j]=sum;
                }
            }
        }
        int rect =0;
        for(int i=0;i<n;i++){
            int hisRec = getHisRec(prefix[i]);
            rect = Math.max(rect,hisRec);
        }
        return rect;
    }
    public int getHisRec(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int ans=0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() &&(arr[stk.peek()]>=arr[i])){
            int len = arr[stk.peek()];
            stk.pop();
            int width;
            if(stk.isEmpty()){
                width=i;
            }
            else{
                width = i-stk.peek()-1;
            }
            int area = len*width;
            ans = Math.max(ans,area);
            }
           
            stk.push(i);
        }
        while (!stk.isEmpty()) {
    int len = arr[stk.pop()];
    int width = stk.isEmpty() ? n : n - stk.peek() - 1;
    ans = Math.max(ans, len * width);
}
        return ans;
    }
}