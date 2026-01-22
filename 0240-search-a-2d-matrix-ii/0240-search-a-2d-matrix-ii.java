class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // for(int[] arr: matrix){
        //     if(target>=arr[0] && target<=arr[arr.length-1]){
        //         if(bin(arr,target)){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int row=0;
        int col = n-1;
        while(row<m && col>=0){
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]>target){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
         
    }
    // public boolean bin(int[] arr,int target){
    //     int low=0;
    //     int high = arr.length-1;
    //     while(low<=high){
    //         int mid = (low+high)/2;
    //         if(arr[mid]==target) return true;
    //         else if(arr[mid]>target) high=mid-1;
    //         else low=mid+1;
    //     }
    //     return false;
    // }
}