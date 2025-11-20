import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>();    // <genre, total plays>
        Map<String, Map<Integer, Integer>> songMap = new HashMap<>();   // <genre, Map<idx, plays>>
        
        for(int i = 0; i < genres.length; i++){
            // if current genre hasn't been introduced yet
            if(!songMap.containsKey(genres[i])){
                Map<Integer, Integer> map = new HashMap<>();    // <idx, plays>
                map.put(i, plays[i]);
                songMap.put(genres[i], map);
                genreMap.put(genres[i], plays[i]);  // add genre with total plays
            } else{
                Map<Integer, Integer> map = songMap.get(genres[i]);
                map.put(i, plays[i]);
                genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);    // accumulate
            }
        }
        
        List<String> genreKeys = new ArrayList<>(genreMap.keySet());
        // sort total plays per genre desc
        Collections.sort(genreKeys, (g1, g2) -> (genreMap.get(g2) - genreMap.get(g1)));
        
        List<Integer> result = new ArrayList<>();
        
        // pick each sorted genres in order
        for(String genre : genreKeys) {
            // get <idx, plays> from songMap
            Map<Integer, Integer> map = songMap.get(genre);
            List<Integer> idxs = new ArrayList<>(map.keySet());
            // sort all songs from current genre by plays desc
            Collections.sort(idxs, (s1, s2) -> (map.get(s2) - map.get(s1)));
        
            // add top played song first
            result.add(idxs.get(0));
            // if more songs size > 1, add the following song
            if(idxs.size() > 1){
                result.add(idxs.get(1));
            }
        }
        
        // return list as arr
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}