public class Prob7_9 {
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

        public boolean isLeaf() {
            if (this.rt == null && this.lt == null) return false;
            else return true;
        }
    }

    public static void main(String[] args) throws Exception {
        Node root = new Node(1);
        root.setLt(new Node(2));
        root.setRt(new Node(3));
        root.getLt().setLt(new Node(4));
        root.getLt().setRt(new Node(5));
        root.getRt().setLt(new Node(6));
        root.getRt().getLt().setRt(new Node(7));

        System.out.println(dfs(root, 0));

    }

    public static int dfs(Node node, int level) {
        if (node != null && node.isLeaf()) {
            return Math.min(dfs(node.getLt(), level + 1), dfs(node.getRt(), level + 1));
        } else return level;
    }
}
