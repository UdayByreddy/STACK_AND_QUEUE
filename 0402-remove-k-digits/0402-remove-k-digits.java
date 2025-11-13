class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();
        for(char ch: num.toCharArray()){
            while(!stk.isEmpty() && k>0 && stk.peek()>ch){
                stk.pop();
                k--;
            }
            stk.push(ch);
        }
        while(k>0){
            stk.pop();
            k--;
        }
        if(stk.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        while(sb.length()>0 && sb.charAt(sb.length()-1)=='0'){
            sb.deleteCharAt(sb.length()-1);
        }
        sb.reverse();
        if(sb.length()==0) return "0";
        return sb.toString();

        
    }
}