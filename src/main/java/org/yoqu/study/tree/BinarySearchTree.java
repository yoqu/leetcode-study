package org.yoqu.study.tree;

/**
 * @author: yoqu
 * @date: 2018/10/24
 * @email: yoqulin@qq.com
 **/
public class BinarySearchTree {

    public static void main(String[] args) {
        Tree tree = TreeBuilder.init()
                .append(20, "atom")
                .append(18, "bbs")
                .append(50, "aq")
                .append(30, "wwq")
                .append(28, "qoa")
                .build();
        System.out.println("------------------tree start-----------------------------\n\n\n");
        System.out.print(tree.toString());
        System.out.println("\n\n\n------------------tree end-----------------------------");
    }
}

class Tree {

    private Node root;

    public Node findFinalNode(long key) {
        return findFinalNode(root, key);
    }

    private Node findFinalNode(Node node, long key) {
        if (node != null) {
            if (node.getKey() == key) {
                return node;
            } else if (node.getKey() > key) {
                return findFinalNode(node.getLeftNode(), key);
            } else {
                return findFinalNode(node.getRightNode(), key);
            }
        }
        return null;
    }

    public void add(long key, Object value) {
        if (root == null) {
            root = new Node(value, key, 1);
        } else {
            add(root, key, value, 2);
        }
    }

    private void add(Node node, long key, Object value, long level) {
        if (node.getKey() > key) {
            if (node.getLeftNode() == null) {
                node.setLeftNode(new Node(value, key, level));
            } else {
                add(node.getLeftNode(), key, value, level + 1);
            }
        } else if (node.getKey() < key) {
            if (node.getRightNode() == null) {
                node.setRightNode(new Node(value, key, level));
            } else {
                add(node.getRightNode(), key, value, level + 1);
            }
        } else {
            throw new RuntimeException("duplicate key");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        string(sb, root, true);
        return sb.toString();
    }

    public void string(StringBuilder sb, Node node, boolean isRight) {
        if (node == null) {
            return;
        }
        if (node.getLeftNode() != null) {
            Node leftNode = node.getLeftNode();
            while (leftNode != null) {
                sb.append("*");
                leftNode = leftNode.getLeftNode();
            }
        }
        sb.append(node.getKey());
        if (node.getRightNode() != null) {
            Node leftNode = node.getLeftNode();
            while (leftNode != null) {
                sb.append("*");
                leftNode = leftNode.getLeftNode();
            }
            Node rightNode = node.getRightNode();
            while (rightNode != null) {
                sb.append("*");
                rightNode = rightNode.getRightNode();
            }
        }
        if (isRight) {
            sb.append("\n");
        }
        string(sb, node.getLeftNode(), false);
        string(sb, node.getRightNode(), true);
    }
}

class TreeBuilder {

    private Tree tree = new Tree();

    public static TreeBuilder init() {
        return new TreeBuilder();
    }

    public TreeBuilder append(long key, String value) {
        tree.add(key, value);
        return this;
    }

    public Tree build() {
        return tree;
    }

}

class Node {

    public Node(long key) {
        this.key = key;
    }

    public Node() {
    }

    public Node(Object value, long key) {
        this.value = value;
        this.key = key;
    }

    public Node(Object value, long key, long level) {
        this.value = value;
        this.key = key;
        this.level = level;
    }

    public Node(Node leftNode, Node rightNode, long value) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.value = value;
    }

    private Node leftNode;

    private Node rightNode;

    private Object value;

    private long key;

    private long level;

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public void add(long key, Object data) {
        if (key > this.key) {
            setRightNode(new Node(data, key));
        } else if (key < this.key) {
            setLeftNode(new Node(data, key));
        } else {
            throw new RuntimeException("duplicate key");
        }
    }

}

