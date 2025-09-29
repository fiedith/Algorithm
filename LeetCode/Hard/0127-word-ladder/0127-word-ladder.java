class Solution {
    private class Node{
        String word;
        int depth;

        public Node(String word, int depth){
            this.word = word;
            this.depth = depth;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // quick return for case: endWord not existing in wordList
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return 0;
        }

        Map<String, List<String>> genericStringMap = new HashMap<>();
        for(String s : wordList){
            for(int i = 0; i < s.length(); i++){
                // e.g. hot = "*ot", "h*t", "ho*"
                String genericString = s.substring(0, i) + "*" + s.substring(i + 1, s.length());
                List<String> list = genericStringMap.getOrDefault(genericString, new ArrayList<>());
                list.add(s);
                genericStringMap.put(genericString, list);
            }
        }

        Deque<Node> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        q.addLast(new Node(beginWord, 1));  // starts at depth 1
        while(!q.isEmpty()){
            Node now = q.pollFirst();
            if(now.word.equals(endWord)){
                return now.depth;
            }

            if(visited.contains(now.word)){
                continue;
            }

            visited.add(now.word);
            for(int i = 0; i < now.word.length(); i++){
                String genericString = now.word.substring(0, i) + "*" + now.word.substring(i + 1, now.word.length());
                if(genericStringMap.containsKey(genericString)){
                    for(String s : genericStringMap.get(genericString)){
                        q.addLast(new Node(s, now.depth + 1));
                    }
                }
            }
        }

        // if not returned above
        return 0;
    }
}