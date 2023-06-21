import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        Stack<Character> st = new Stack<Character>();
        
        for(int i=0; i<words.length; i++) {
            
            // 중복된 단어가 나오는지 확인
            if(i==0)  map.put(words[i], true);
            else{ 
                Boolean flag = map.get(words[i]) == null ? false : map.get(words[i]);
                map.put(words[i], true);
              //  System.out.println(flag);
                if(flag){ // 기존에 나온 단어임
                    answer = returnOrder(n, i);
                    break;    
                }
            }
            
            // 앞의 단어랑 이어지지 않는 지 확인 
            char first = words[i].charAt(0);
            char end = words[i].charAt(words[i].length() - 1);
            
            if(!st.empty()) {
                if(st.peek() == first) {
                    st.pop();
                    st.push(words[i].charAt(words[i].length() - 1));
                } else {
                    answer = returnOrder(n, i);
                    break;
                }
            } else{
                st.push(words[i].charAt(words[i].length() - 1));
            }

        }
        
        return answer;
    }
    
    public int[] returnOrder(int n, int nth){
        nth++;
        int[] answer = null;
        int mok = nth / n;
        int nam = nth % n;
        if(nam==0){ // 나누어 떨어질 때
            answer = new int[]{n, mok};
        } else {
            answer = new int[]{nam, mok+1};
        }

        return answer;
    }
}