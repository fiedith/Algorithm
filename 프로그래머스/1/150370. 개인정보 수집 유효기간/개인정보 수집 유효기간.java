import java.util.*;

class Solution {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        // init todayArr [yyyy | mm | dd]
        String[] splitted = today.split("\\.");
        int[] todayYMD = new int[splitted.length];
        for(int i = 0; i < splitted.length; i++){
            todayYMD[i] = Integer.parseInt(splitted[i]);
        }

        // init term map
        Map<String, Integer> termMap = new HashMap<>();
        for(String term : terms){
            String[] sp = term.split(" ");
            termMap.put(sp[0], Integer.parseInt(sp[1]));
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < privacies.length; i++){
            // split into [yyyy.mm.dd | term string]
            String[] privacy = privacies[i].split(" ");
            // get months to add
            int monthsToAdd = termMap.get(privacy[1]);

            // split yyyy.mm.dd into [yyyy | mm | dd] and turn into int arr
            String[] sp = privacy[0].split("\\.");
            int[] expYMD = new int[sp.length];
            for(int j = 0; j < sp.length; j++){
                expYMD[j] = Integer.parseInt(sp[j]);
            }

            // add months, reset year and month accordingly
            expYMD[1] += monthsToAdd;
            expYMD[0] += expYMD[1] / 12;
            // if month is multiplies of 12
            if(expYMD[1] % 12 == 0){
                expYMD[0]--;
                expYMD[1] = 12;
            } else{
                expYMD[1] = expYMD[1] % 12;
            }

            //  today yyyy > current yyyy -> must break
            if(todayYMD[0] > expYMD[0]){
                result.add(i + 1);
                continue;
            }

            // if current yyyy == today yyyy
            if(expYMD[0] == todayYMD[0]){
                if(todayYMD[1] > expYMD[1] || (expYMD[1] == todayYMD[1] &&  todayYMD[2] >= expYMD[2])){
                    result.add(i + 1);
                }
            }
        }


        int[] resultArr = new int[result.size()];
        for(int i = 0; i < resultArr.length; i++){
            resultArr[i] = result.get(i);
        }

        return resultArr;
    }
}