import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static class Node {
        char c;
        Node prev, next;

        public Node(char c, Node prev, Node next) {
            this.c = c;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        Node head = new Node(' ', null, null);
        Node tail = new Node(' ', null, null);
        Node cur = new Node(input.charAt(input.length() - 1), head, tail);
        head.next = cur;
        tail.prev = cur;

        for (int i = input.length() - 2; i >= 0; i--) {
            Node newNode = new Node(input.charAt(i), cur.prev, cur);
            cur.prev.next = newNode;
            cur.prev = newNode;
            cur = cur.prev;
        }

        int M = Integer.parseInt(br.readLine());

        cur = tail;
        for (int i = 0; i < M; i++) {
            String order = br.readLine();

            if (order.charAt(0) == 'L') {
                if (cur.prev == head) continue;
                cur = cur.prev;
                continue;
            }
            if (order.charAt(0) == 'D') {
                if (cur == tail) continue;
                cur = cur.next;
                continue;
            }
            if (order.charAt(0) == 'B') {
                if (cur.prev == head) continue;
                Node deleteNode = cur.prev;
                cur.prev = deleteNode.prev;
                deleteNode.prev.next = cur;
                continue;
            }
            if (order.charAt(0) == 'P') {
                Node newNode = new Node(order.charAt(2), cur.prev, cur);
                cur.prev.next = newNode;
                cur.prev = newNode;
            }
        }

        cur = head.next;
        while (cur != tail) {
            sb.append(cur.c);
            cur = cur.next;
        }
        System.out.println(sb);
    }
}