class Solution {
    public boolean isAnagram(String s, String t) {
        List<String> sList = Arrays.asList(s.split(""));
        List<String> tList = Arrays.asList(t.split(""));
        
        sList.sort(null);
        tList.sort(null);

        return sList.equals(tList);
    }
}