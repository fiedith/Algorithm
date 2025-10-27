import java.util.*;

class Solution {
    class Node{
        int idx;
        Node next, prev;
        
        public Node(int idx){
            this.idx = idx;
        }
    }
    
    public String solution(int n, int k, String[] cmd) {
        Node[] nodes = new Node[n];
        nodes[0] = new Node(0);
        for(int i = 1; i < n; i++){
            nodes[i] = new Node(i);
            nodes[i - 1].next = nodes[i];
            nodes[i].prev = nodes[i - 1];
        }
        
        Node pointer = nodes[k];    // current node
        Deque<Node> deleted = new ArrayDeque<>();   // stack
        
        for(String c : cmd){
            if(c.startsWith("C")){
                deleted.push(pointer);  // push deleted node to stack without any changes to the node itself
                if(pointer.prev != null){   // if previous node exists
                    pointer.prev.next = pointer.next;   // change previous node's next node
                }
                
                if(pointer.next != null){   // if next node exists
                    pointer.next.prev = pointer.prev;
                    pointer = pointer.next;     // set pointer to next node
                } else{
                    pointer = pointer.prev;     // else set pointer to previous node
                }
            } else if(c.startsWith("Z")){
                Node recovered = deleted.pop();
                if(recovered.prev != null){
                    recovered.prev.next = recovered;
                }
                
                if(recovered.next != null){
                    recovered.next.prev = recovered;
                }
            } else{
                String[] splitted = c.split(" ");
                String command = splitted[0];
                int count = Integer.parseInt(splitted[1]);
                if(command.equals("U")){
                    for(int i = 0; i < count; i++){
                        pointer = pointer.prev;
                    }
                } else{
                    for(int i = 0; i < count; i++){
                        pointer = pointer.next;
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append("O");
        }
        
        while(!deleted.isEmpty()){
            Node popped = deleted.pop();
            sb.setCharAt(popped.idx, 'X');
        }
        
        return sb.toString();
    }
}