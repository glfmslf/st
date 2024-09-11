package com.yy.st.leetcode;

 public class DFSLEETCODE {

     String res = "~";
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        dfs(root, stringBuilder);
        return res;
    }

    public void dfs(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            return;
        }
        stringBuilder.append((char) ('a' + root.val));
        if (root.left == null && root.right == null) {
            // 叶子节点
            stringBuilder.reverse();
            String temp = stringBuilder.toString();
            if (temp.compareTo(res) < 0) {
                res = temp;
            }
            stringBuilder.reverse();
        }
        dfs(root.left, stringBuilder);
        dfs(root.right, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }

 static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}