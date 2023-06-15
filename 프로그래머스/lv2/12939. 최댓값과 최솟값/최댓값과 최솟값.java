import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        // 숫자 다 담음
        String[] num_arr = s.split(" ");
        
        // 최솟값, 최댓값 첫번째 숫자로 담음
        int min = Integer.parseInt(num_arr[0]);
        int max = Integer.parseInt(num_arr[0]);
        
        // 순회하면서 최솟값, 최댓값 새로 담음        
        for(String num_str : num_arr){
            int i = Integer.parseInt(num_str);
            if(min > i) min = i;
            if(max < i) max = i;
        }
        answer=Integer.toString(min)+" "+Integer.toString(max);
        
        return answer;
    }
}