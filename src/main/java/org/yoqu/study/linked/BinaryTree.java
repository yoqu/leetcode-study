package org.yoqu.study.linked;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryTree {
    public static TreeNode buildTreeNode() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(9);
        TreeNode topRightNode = new TreeNode(20);
        topRightNode.left = new TreeNode(15);
        topRightNode.right = new TreeNode(7);
        node.right = topRightNode;
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = buildTreeNode();
//        System.out.println(new BinaryTree().levelOrder(buildTreeNode()));
        System.out.println("------递归前序遍历-----");
        Long now = System.currentTimeMillis();
        preOrderTreeNode(node);
        System.out.println("遍历时间:" + (System.currentTimeMillis() - now));
        System.out.println("------栈前序遍历-----");
        now = System.currentTimeMillis();
        preOrderTreeNodeByStack(node);
        System.out.println("遍历时间:" + (System.currentTimeMillis() - now));

//        System.out.println("------中序遍历-----");
//        inOrderTreeNode(node);
//        System.out.println("------后序遍历-----");
//        afterOrderTreeNode(node);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public static void inOrderTreeNode(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTreeNode(node.left);
        System.out.println(node.val);
        inOrderTreeNode(node.right);
    }

    /**
     * 后续遍历
     *
     * @param node
     */
    public static void afterOrderTreeNode(TreeNode node) {
        if (node == null) {
            return;
        }
        afterOrderTreeNode(node.left);
        afterOrderTreeNode(node.right);
        System.out.println(node.val);
    }

    /**
     * 递归前序遍历
     *
     * @param node
     */
    public static void preOrderTreeNode(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preOrderTreeNode(node.left);
        preOrderTreeNode(node.right);
    }

    /**
     * 使用栈前序遍历
     *
     * @param node
     */
    public static void preOrderTreeNodeByStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = node;
        while (root != null || !stack.empty()) {
            while (root != null) {
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    /**
     * 层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> nums = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    nums.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                size--;
            }
            res.add(nums);
        }
        return res;
    }
}
