import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        // 문자열 배열로 바꿈
        String[] arr = s.split("");
        
        // 문자열을 arrayList로 변환
        Stack<String> stack = new Stack<String>();
        
        // stack 에 넣으면서 같은지 확인하기
        for(int i = 0; i < s.length(); i++)
        {
            String sa = arr[i];
            if(stack.empty()){
                stack.push(sa);
                continue;
            }
            String pick = stack.peek();
            
            if(pick.equals(sa)) {// 최근값과 같으면 pop
                stack.pop();
            } else { // 다르면 push
                stack.push(sa);
            }  
            
        }
        
        if(stack.empty()) answer = 1;
        else answer = 0;
        return answer;
    }
}