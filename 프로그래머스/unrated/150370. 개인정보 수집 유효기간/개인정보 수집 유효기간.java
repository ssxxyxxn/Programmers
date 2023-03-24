import java.util.*;
import java.text.SimpleDateFormat;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
        /*
        today        : 오늘 날짜 String
        terms        : 약관의 유효기간 배열
        privacies    : 수집된 개인정보의 정보를 담은 1차원 문자열 배열 
        answer       : 파기해야 할 개인정보의 번호 오름차순 정수 배열
        
        term_map    : 약관종류, 개월수 정리
        map         : privacies의 이전날짜, 개월수 정리
        idx_map     : privacies의 이전날짜, 번호 정리
        dateList    : 이후날짜만 정리
        */
        Map<String, Integer> term_map = new HashMap<>();        
        Map<String, Integer> map = new HashMap<>();      
        Map<String, Integer> idx_map = new HashMap<>();     
        List<Integer> dateList = new ArrayList<>();
        
        // 오늘 날짜 string -> date 변환
        int today_year = Integer.parseInt(today.split("\\.")[0]);
        int today_month = Integer.parseInt(today.split("\\.")[1]);
        int today_day = Integer.parseInt(today.split("\\.")[2]);
        
        // ** 오늘 날짜 일수로 변경
        int today_days = today_year*12*28 + today_month*28 + today_day;
        
        // terms 순회하며 약관종류, 개월수 term_map에 넣기
        for(String t : terms){
            String term = t.split(" ")[0];
            int month = Integer.valueOf(t.split(" ")[1]);
            term_map.put(term, month);
        }
   
        // privacies 순회하며 이전날짜, 약관을 map에 넣기
        for(int i=0; i<privacies.length; i++){
            String before_date = privacies[i].split(" ")[0]; // 이전날짜
            String term = privacies[i].split(" ")[1]; // 약관            
            map.put(before_date, term_map.get(term));
        }
        
        for(int i=0;  i<privacies.length; i++){
            String p = privacies[i];
            String before_date = p.split(" ")[0]; // 이전날짜
            int year = Integer.parseInt(before_date.split("\\.")[0]);
            int month = Integer.parseInt(before_date.split("\\.")[1]);
            int day = Integer.parseInt(before_date.split("\\.")[2]);
          //  int add_month = map.get(before_date); // 더해야 하는 개월            
            int add_month = term_map.get(p.split(" ")[1]);
            
            //** 이전날짜 일수 + 개월수 - 1
            int after_days = year*12*28 + (month+add_month)*28 + day - 1;
                 
            //** 이후날짜 일수 < 현재날짜 일수
            if(after_days < today_days) {
                // 인덱스 리스트에 넣기
                dateList.add(i+1); 
            }        
        }
        answer = dateList.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}