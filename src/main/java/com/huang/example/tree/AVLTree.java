package com.huang.example.tree;

/**
 * @Author：CreateSequence
 * @Date：2020-07-23 19:01
 * @Description：平衡二叉树
 * 由于是在二叉排序树的基础上改进，这里直接继承了二叉排序树类
 */
public class AVLTree extends BinarySortTree{

    public AVLTree(BinarySortTreeNode root) {
        super(root);
    }


    /**
     * 重写二叉排序树的节点添加方法，当添加完节点后左子树与右子树高度差大于1时，让树进行左旋转，若情况相反则进行右旋转
     * @param node
     */
    @Override
    public void add(BinarySortTreeNode node) {
        super.add(node);
        //添加完节点后，判断左右树高度差是否大于1
        int disparity = getRightHeight(root) - getLeftHeight(root);
        if (disparity > 1) {
            System.out.println("高度差:" + disparity + ",左旋转！");
            //左子树与右子树高度差大于1就左旋
            leftRotate();
        }else if (- disparity > 1){
            System.out.println("高度差:" + disparity + ",右旋转！");
            //右子树与左子树高度差小于1就左旋
            rightRotate();
        }
    }

    /**
     * 排序树左旋转
     */
    private void leftRotate() {
        // 1.创建新节点，与根节点值相同
        BinarySortTreeNode node = new BinarySortTreeNode(root.val);
        //2.让新节点左子节点指向根节点左子节点
        node.left = root.left;
        //3.让新节点的右子节点指向根节点的右子节点的左子节点
        node.right = root.right.left;
        //4.让根节点的值变为其右子节点的值
        root.val = root.right.val;
        //5.把根节点的右子节点指向其右子节点的右子节点
        root.right = root.right.right;
        //6.让根节点的左子节点指向新节点
        root.left = node;
    }

    /**
     * 排序树右旋转
     */
    private void rightRotate() {
        // 1.创建新节点，与根节点值相同
        BinarySortTreeNode node = new BinarySortTreeNode(root.val);
        //2.让新节点右子节点指向根节点右子节点
        node.right = root.right;
        //3.让新节点的左子节点指向根节点的左子节点的右子节点
        node.left = root.left.right;
        //4.让根节点的值变为其左子节点的值
        root.val = root.left.val;
        //5.把根节点的左子节点指向其左子节点的左子节点
        root.left = root.left.left;
        //6.让根节点的右子节点指向新节点
        root.right = node;
    }

    /**
     * 获取当前节点的右子树高度
     * @param node
     * @return
     */
    public int getRightHeight(BinarySortTreeNode node) {
        if (node.right == null) {
            return 0;
        }
        return getHeight(node.right);
    }

    /**
     * 获取当前节点的左子树高度
     * @param node
     * @return
     */
    public int getLeftHeight(BinarySortTreeNode node){
        if (node.left == null) {
            return 0;
        }
        return getHeight(node.left);
    }

    /**
     * 获取以当前节点为根节点的树高度
     * @param node
     * @return
     */
    public int getHeight(BinarySortTreeNode node) {
        //判断当前节点的左/右节点是否为空，是返回0，否则遍历返回当前节点的左右树最高值
        return Math.max(node.left == null ? 0 : getHeight(node.left), node.right == null ? 0 : getHeight(node.right)) + 1;
    }

}
