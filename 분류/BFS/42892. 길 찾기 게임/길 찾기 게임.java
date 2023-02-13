import java.util.*;

class Solution {
    static class Node {

        private final int num;
        private final int x;
        private final int y;

        private Node leftChild;
        private Node rightChild;

        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.leftChild = this.rightChild = null;
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodeList = new ArrayList<>();

        // Node 초기화
        int i = 1;
        for (int[] node : nodeinfo)
            nodeList.add(new Node(i++, node[0], node[1]));

        // Tree 빌드
        nodeList.sort(comparator);
        for (i = 1; i < nodeList.size(); i++)
            addNode(nodeList.get(0), nodeList.get(i));

        // 전위, 후위 처리
        preOrder(nodeList.get(0));
        postOrder(nodeList.get(0));

        return new int[][]{pre.stream().mapToInt(Integer::intValue).toArray(), post.stream().mapToInt(Integer::intValue).toArray()};
    }

    void addNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.leftChild == null)
                parent.leftChild = child;
            else
                addNode(parent.leftChild, child);
        }
        else {
            if (parent.rightChild == null)
                parent.rightChild = child;
            else
                addNode(parent.rightChild, child);
        }
    }

    List<Integer> pre = new ArrayList<>();
    List<Integer> post = new ArrayList<>();

    void preOrder(Node n) {
        pre.add(n.num);
        if (n.leftChild != null) preOrder(n.leftChild);
        if (n.rightChild != null) preOrder(n.rightChild);
    }

    void postOrder(Node n) {
        if (n.leftChild != null) postOrder(n.leftChild);
        if (n.rightChild != null) postOrder(n.rightChild);
        post.add(n.num);
    }

    Comparator<Node> comparator = (o1, o2) -> {
        if (o1.y == o2.y)
            return o1.x - o2.x;
        return o2.y - o1.y;
    };
}