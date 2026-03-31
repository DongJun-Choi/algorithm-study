import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node> {
        int x, y, num;
        Node left, right;
        
        Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
        
        @Override
        public int compareTo(Node o) {
            if(this.y == o.y) return this.x - o.x;
            return o.y - this.y;
        }
    }
    
    List<Integer> preorderList = new ArrayList<>();
    List<Integer> postorderList = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {        
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];
        
        for(int i=0; i<n; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1);
        }
        
        Arrays.sort(nodes);
        
        Node root = nodes[0];
        
        for(int i=1; i<n; i++) {
            insert(root, nodes[i]);
        }
        
        preorder(root);
        postorder(root);
        
        int[][] answer = new int[2][n];
        for(int i=0; i<n; i++) {
            answer[0][i] = preorderList.get(i);
            answer[1][i] = postorderList.get(i);
        }
        
        return answer;
    }
    
    private void insert(Node root, Node child) {
        Node cur = root;
        
        while (true) {
            if (child.x < cur.x) {
                if (cur.left == null) {
                    cur.left = child;
                    return;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = child;
                    return;
                }
                cur = cur.right;
            }
        }
    }
    
    private void preorder(Node node) {
        if (node == null) return;
        
        preorderList.add(node.num);
        preorder(node.left);
        preorder(node.right);
    }

    private void postorder(Node node) {
        if (node == null) return;
        
        postorder(node.left);
        postorder(node.right);
        postorderList.add(node.num);
    }
}