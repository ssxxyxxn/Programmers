import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        /*
            map  : 알파벳=최소횟수
        */
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> terget_map = new HashMap<String, Integer>();
        int max = 100;
        
        // 알파벳=최소횟수 map에 저장
        for(String key : keymap) {
            String[] k = key.split("");
            
            for(int i=0; i<k.length; i++) {
                int idx = i+1;
                int min = map.get(k[i]) == null ? max : map.get(k[i]);
                if(idx < min) {
                    map.put(k[i], i+1);// i 가 기존에 저장되어있던 최소값보다 작으면 바꿔치기
                }
            }            
        }
        
        
        for(int j=0; j<targets.length; j++) {
            int sum = 0;
            int cnt = 0;
            System.out.println(targets[j]);
            System.out.println(targets[j]+" 시작 = "+cnt);
            String[] t = targets[j].split("");
            
            for(int i=0; i<targets[j].length(); i++){
                cnt = map.get(t[i]) == null ? -1 : map.get(t[i]);
                System.out.println(t[i]+" = "+cnt);
                 if(cnt == -1) {
                     sum = -1;
                    break;          // 그리고 for문 탈출
                } else {
                    sum+=cnt;
                }
                System.out.println(t[i]+" 까지 = "+sum);
            }
                System.out.println(targets[j]+" 최종 = "+sum);
            answer[j]=sum;  // 알파벳이 없으면 answer에 -1 넣어줌
            
            
            
            
        }
        
        
        
        System.out.println(map);
                          
        
        return answer;
    }
}