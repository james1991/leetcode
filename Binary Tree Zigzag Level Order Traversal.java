/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        dfs(root, 0, res);
        for(int i = 0; i < res.size(); i++){
            if(i % 2 != 0)
                Collections.reverse(res.get(i));
        }
        return res;
    }

    public void dfs(TreeNode root, int depth, ArrayList<ArrayList<Integer>> res) {
        if (root == null)
            return;
        ArrayList<Integer> list = null;
        if (depth < res.size()) {
            list = res.get(depth);
        } else {
            list = new ArrayList<Integer>();
            res.add(list);
        }
        list.add(root.val);
        dfs(root.left, depth + 1, res);
        dfs(root.right, depth + 1, res);
    }
}

public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null)
            queue.add(root);
        int nodesLeft = 0;
        ArrayList<Integer> row = null;
        boolean reverse = true;
        while (!queue.isEmpty()) {
            if (nodesLeft == 0) {
                nodesLeft = queue.size();
                row = new ArrayList<Integer>();
                result.add(row);
                reverse = !reverse;
            }
            TreeNode node = null;
            if (!reverse)
                node = queue.pollFirst();
            else
                node = queue.pollLast();
            nodesLeft--;
            row.add(node.val);
            if (!reverse) {
                if (node.left != null)
                    queue.addLast(node.left);
                if (node.right != null)
                    queue.addLast(node.right);
            } else {
                if (node.right != null)
                    queue.addFirst(node.right);
                if (node.left != null)
                    queue.addFirst(node.left);
            }
        }
        return result;
    }
}