package org.yoqu.study.linked;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
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

        System.out.println(new BinaryTree().levelOrder(buildTreeNode()));
    }

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
