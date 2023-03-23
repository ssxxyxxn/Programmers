import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];             // 답안 제출용 배열
        Map<String, HashSet<String>> map = new HashMap<>(); // {신고당한 사람=[신고자들]}
        Map<String, Integer> idxMap = new HashMap<>();      // {신고당한 사람의 id_list 인덱스} : map엔 순서없이 들어가기 때문
    
        // id_list 순회하면서 map에 신고당한 사람 세팅
        // id_list 순회하면서 idxMap에 신고당한 사람 세팅
        for(int i=0; i<id_list.length; i++){
            String name = id_list[i];
            map.put(name, new HashSet<>());
            idxMap.put(name, i);               
        }
        
        for(String s : report){
            String[] str = s.split(" ");
            String from = str[0];
            String to = str[1];
            map.get(to).add(from); // map의 HashSet<String> 부분에 중복없이 추가할 수 있음
        }
        
        // id_list 순회하면서 map의 [신고자들] 꺼내온 후 
        // 그 안에서 또 순회하며 신고 횟수 k 이상일 때 신고자들 답안배열에 추가
        for(int i=0; i<id_list.length; i++){            
            HashSet<String> send = map.get(id_list[i]); // map의 HashSet을 꺼내오기

            if(send.size() >= k){
                for(String name : send){ // 신고자들 순회하면서  
                    answer[idxMap.get(name)]++;
                }
            }
        }
        
        return answer;
    }
}