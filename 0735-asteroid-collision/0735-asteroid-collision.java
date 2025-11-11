class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for(int a: asteroids){
            if(a>0){
                stk.push(a);
            }
            else{
                while(!stk.isEmpty()&&stk.peek()>0&&stk.peek()<Math.abs(a)){
                    stk.pop();
                }
                if(stk.isEmpty()||stk.peek()<0){
                    stk.push(a);
                }
                else if(stk.peek()+a==0){
                    stk.pop();
                }
               
            }
        }
        int[] res = new int[stk.size()];
        int i = stk.size()-1;
        while(!stk.isEmpty()){
            res[i--] = stk.pop();
        }
        return res;
        
    }
}