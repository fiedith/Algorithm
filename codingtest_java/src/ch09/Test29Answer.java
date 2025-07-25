package ch09;

import java.util.*;

class Test29Answer {

    private static class Node{
        int num, x, y;      // 노드번호, x좌표, y좌표
        Node left, right;

        public Node(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    private static Node makeTree(int[][] nodeinfo){
        // nodes 배열 초기화
        Node[] nodes = new Node[nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++){
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        // 배열 정렬하기 (y값이 제일 큼 = root, 동일한 y값 = 동등 레벨, 같은 레벨에서 x값 작은게 먼저)
        Arrays.sort(nodes, (o1, o2) -> {
            if(o1.y == o2.y){
                return o1.x - o2.x;
            } else{
                return o2.y - o1.y;
            }
        });

        Node root = nodes[0];

        // 트리 구성 시작
        for(int i = 1; i < nodes.length; i++){
            Node parent = root;
            while(true){
                // 현재 고른 노드가 부모 노드의 좌측인 경우
                if(nodes[i].x < parent.x){
                    // 그리고 부모 노드의 좌측이 비어있는 경우 설정 후 탈출
                    if(parent.left == null){
                        parent.left = nodes[i];
                        break;
                    } else{     // 부모 좌측이 이미 존재하는 경우 그 노드를 부모로 재설정 후 repeat while
                        parent = parent.left;
                    }
                    // 현재 고른 노드가 부모 노드의 우측인 경우 -> 좌측 설정과 동일 로직
                } else{
                    if(parent.right == null){
                        parent.right = nodes[i];
                        break;
                    } else{
                        parent = parent.right;
                    }
                }
            }
        }

        // 그리고 루트 노드를 반환함
        return nodes[0];
    }

    // preorder -> 방 왼 오
    private static void preOrder(Node curr, List<Integer> answer){
        // 탈출조건 먼저
        if(curr == null){
            return;
        }
        answer.add(curr.num);
        preOrder(curr.left, answer);
        preOrder(curr.right, answer);
    }

    // postorder -> 왼 오 방
    private static void postOrder(Node curr, List<Integer> answer){
        // 탈출조건 먼저
        if(curr == null){
            return;
        }
        postOrder(curr.left, answer);
        postOrder(curr.right, answer);
        answer.add(curr.num);
    }

    public static int[][] solution(int[][] nodeinfo){
        List<Integer> pre = new ArrayList<>(nodeinfo.length);
        List<Integer> post = new ArrayList<>(nodeinfo.length);
        int[][] answer = new int[2][nodeinfo.length];

        Node root = makeTree(nodeinfo);
        preOrder(root, pre);
        postOrder(root, post);

        answer[0] = pre.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        answer[1] = post.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }

    public static void main(String[] args) {
        int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2},
                {2, 2}};

        int[][] result = solution(nodeinfo);
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }

    }

}