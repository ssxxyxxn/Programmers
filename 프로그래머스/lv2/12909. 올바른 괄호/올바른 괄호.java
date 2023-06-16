import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();
        char[] arr = s.toCharArray();

        for(int i = 0 ; i < s.length(); i++){
            if(st.isEmpty()){ // 맨 처음 입력 될 때 
                if(arr[i] == ')'){ // )이면 바로 false
                    return false;
                }
                st.push(arr[i]); // (이니까 추가하고 끝
                
                continue;
            }
            if(arr[i] == '('){
                st.push(arr[i]); 
            }
            else{ // arr[i] == ')'
                if(st.peek() == '(') st.pop();
                else return false;
            }
        }

        if(st.isEmpty()) answer = true;
        else answer = false;

        return answer;
    }
}