package com.huang.example.tree;

/**
 * @Author：黄成兴
 * @Date：2020-07-11 17:44
 * @Description：二叉树
 */
public class BinaryTree {

    private BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        if (root == null) {
            throw new RuntimeException("根节点不允许为空！");
        }
        this.root = root;
    }

    public void preOrder(){
        preOrder(root);
    }
    /**
     * 前序遍历
     */
    public void preOrder(BinaryTreeNode node){
        //打印节点
        System.out.println(node);
        //向左子树前序遍历
        if (node.getLeft() != null) {
            preOrder(node.getLeft());
        }
        //向右子树前序遍历
        if (node.getRight() != null) {
            preOrder(node.getRight());
        }
    }

    public void inOrder(){
        inOrder(root);
    }
    /**
     * 中序遍历
     */
    public void inOrder(BinaryTreeNode node){
        //向左子树中序遍历
        if (node.getLeft() != null) {
            inOrder(node.getLeft());
        }
        //打印节点
        System.out.println(node);
        //向右子树中序遍历
        if (node.getRight() != null) {
            inOrder(node.getRight());
        }
    }

    public void postOrder(){
        postOrder(root);
    }
    /**
     * 后序遍历
     */
    public void postOrder(BinaryTreeNode node){
        //向左子树中序遍历
        if (node.getLeft() != null) {
            postOrder(node.getLeft());
        }
        //向右子树中序遍历
        if (node.getRight() != null) {
            postOrder(node.getRight());
        }
        //打印节点
        System.out.println(node);
    }

    public BinaryTreeNode preSearch(int num){
        return preSearch(num, root);
    }

    /**
     * 前序查找
     * @param num
     * @param node
     * @return
     */
    public BinaryTreeNode preSearch(int num,BinaryTreeNode node){
        BinaryTreeNode result = null;

        //判断当前节点是否为查找节点
        if (node.getNodeNum() == num) {
            result = node;
        }
        //判断左节点是否为空，不为空就前序查找节点
        if (node.getLeft() != null) {
            result = preSearch(num, node.getLeft());
        }
        //如果左树找到就返回
        if (result != null){
            return result;
        }
        //否则就判断并递归前序查找右树
        if (node.getRight() != null) {
            result = preSearch(num, node.getRight());
        }
        return result;
    }

    public BinaryTreeNode inSearch(int num){
        return inSearch(num, root);
    }

    /**
     * 中序查找
     * @param num
     * @param node
     * @return
     */
    public BinaryTreeNode inSearch(int num,BinaryTreeNode node){
        BinaryTreeNode result = null;

        //判断左节点是否为空，不为空就中序查找节点
        if (node.getLeft() != null) {
            result = inSearch(num, node.getLeft());
        }
        //如果左树找到就返回
        if (result != null){
            return result;
        }
        //如果左树未找到就判断当前节点是不是
        if (node.getNodeNum() == num) {
            result = node;
        }
        //否则就判断并递归前序查找右树
        if (node.getRight() != null) {
            result = inSearch(num, node.getRight());
        }
        return result;
    }

    public BinaryTreeNode postSearch(int num){
        return postSearch(num, root);
    }

    /**
     * 后序查找
     * @param num
     * @param node
     * @return
     */
    public BinaryTreeNode postSearch(int num,BinaryTreeNode node){
        BinaryTreeNode result = null;

        //判断左节点是否为空，不为空就后序查找节点
        if (node.getLeft() != null) {
            result = postSearch(num, node.getLeft());
        }
        //如果左树找到就返回
        if (result != null){
            return result;
        }

        //否则就判断并递归后序查找右树
        if (node.getRight() != null) {
            result = postSearch(num, node.getRight());
        }
        //判断右树是否找到
        if (result != null){
            return result;
        }

        //如果右树仍未找到就判断当前节点是不是
        if (node.getNodeNum() == num) {
            result = node;
        }
        return result;
    }
}
