import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = n;
        
        
        int n_one_cnt = Integer.bitCount(n);
        
       /*
        int n_one_cnt = 0;
        String n_bin = Integer.toBinaryString(n);
        for(int i=0; i<n_bin.length(); i++){
            if(n_bin.charAt(i)=='1') n_one_cnt++;
        }*/
        //System.out.println("n_bin= "+n_bin+" n_one_cnt= "+n_one_cnt);
        
        int answer_one_cnt = 0;
        while (true){
            answer++;
            answer_one_cnt = Integer.bitCount(answer);
            if(answer_one_cnt==n_one_cnt) return answer;
            /*
            answer_one_cnt = 0;
            String answer_bin = Integer.toBinaryString(answer);
            for(int i=0; i<answer_bin.length(); i++){
                if(answer_bin.charAt(i)=='1') answer_one_cnt++;
            }
            */
           // System.out.println("answer_bin= "+answer_bin+" answer_one_cnt= "+answer_one_cnt);
        } 
      
    }
    
     private static int findNextBiggerNumber(int count, int n) {
        while (true) {
            n++;
            int binaryCount = Integer.bitCount(n);

            if (binaryCount == count) {
                return n;
            }
        }
    }
}