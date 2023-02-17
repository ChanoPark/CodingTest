import java.util.LinkedList;
import java.util.Queue;

public class Prob7_7 {
    public static class Node {
        private int data;
        private Node lt;
        private Node rt;

        public Node(int data) {
            this.data = data;
            this.lt = null;
            this.rt = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLt() {
            return lt;
        }

        public void setLt(Node lt) {
            this.lt = lt;
        }

        public Node getRt() {
            return rt;
        }

        public void setRt(Node rt) {
            this.rt = rt;
        }
    }

    public static void main(String[] args) throws Exception {
        Node root = new Node(1);
        root.setLt(new Node(2));
        root.setRt(new Node(3));
        root.getLt().setLt(new Node(4));
        root.getLt().setRt(new Node(5));
        root.getRt().setLt(new Node(6));
        root.getRt().setRt(new Node(7));
        bfs(root);
    }

    public static void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            System.out.print(level+": ");
            for (int i = 0; i<size ; i++) {
                Node node = queue.poll();
                System.out.print(node.getData() + " ");
                if (node.getLt() != null) queue.offer(node.getLt());
                if (node.getRt() != null) queue.offer(node.getRt());
            }

            level++;
            System.out.println();
        }
    }
}
