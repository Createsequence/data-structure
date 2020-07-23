package com.huang.example.tree;

/**
 * @Author：CreateSequence
 * @Date：2020-07-20 12:18
 * @Description：二叉排序树
 */
public class BinarySortTree {

    BinarySortTreeNode root;

    public BinarySortTree(BinarySortTreeNode root) {
        if (root == null) {
            throw new RuntimeException("根节点不允许为空！");
        }
        this.root = root;
    }

    /**
     * 遍历树
     */
    private void show(BinarySortTreeNode node) {
        if (node.left != null) {
            show(node.left);
        }
        System.out.println(node.toString());
        if (node.right != null) {
            show(node.right);
        }
    }

    public void show() {
        show(root);
    }

    /**
     * 添加节点
     * @param parent 父节点
     * @param node 要添加的节点
     */
    private void add(BinarySortTreeNode parent,BinarySortTreeNode node){
        //判断子节点是否小于父节点
        if (parent.val > node.val) {
            //判断要添加的位置是否还有节点
            if (parent.left != null) {
                //有就继续遍历左树
                add(parent.left, node);
            }else {
                //否则直接添加
                parent.left = node;
            }
        }else {
            //如果子节点大于父节点
            if (parent.right != null) {
                add(parent.right, node);
            }else {
                parent.right = node;
            }
        }
    }

    public void add(BinarySortTreeNode node){
        add(root, node);
    }

    /**
     * 查找节点
     * @param node 当前节点
     * @param val 要查找的节点值
     * @return
     */
    private BinarySortTreeNode search(BinarySortTreeNode node, int val) {
        //判断当前节点是否为要找到的值
        if (node.val == val) {
            return node;
        } else if (node.val > val) {
            //如果当前节点大于查找值，就向左递归
            if (node.left == null) {
                return null;
            }
            return search(node.left, val);
        }else {
            //否则就向右递归
            if (node.right == null) {
                return null;
            }
            return search(node.right, val);
        }
    }

    public BinarySortTreeNode search(int val) {
        return search(root, val);
    }

    /**
     * 查找目标节点的父节点
     * @param node 当前节点
     * @param val 要查找的值
     * @return
     */
    private BinarySortTreeNode searchTargetParent(BinarySortTreeNode node, int val) {
        //判断当前节点的子节点是否为目标节点
        boolean isTargetParent = (node.left != null && node.left.val == val) || (node.right != null && node.right.val == val);
        if (isTargetParent) {
            return node;
        } else {
            //如果查找值小于当前节点，向左递归
            if (val < node.val && node.left != null) {
                return searchTargetParent(node.left, val);
            } else if (val >= node.val && node.right != null) {
                //如果查找值大于当前节点,向右递归
                return searchTargetParent(node.right, val);
            } else {
                //否则目标节点不存在
                return null;
            }
        }
    }

    public BinarySortTreeNode searchTargetParent(int val) {
        return searchTargetParent(root, val);
    }

    /**
     * 删除指定节点
     * @param val 要删除节点的值
     */
    public void deleteNode(int val) {
        //判断要删除的是否为根节点
        if (root.val == val && root.left == null && root.right == null) {
            throw new RuntimeException("树中只有根节点，无法删除!");
        }

        //查找目标节点
        BinarySortTreeNode target = search(val);
        if (target == null) {
            return;
        }
        //查找目标节点的父节点
        BinarySortTreeNode parent = searchTargetParent(val);

        //判断要删除的节点的子节点情况
        if (target.left == null && target.right == null) {
            //删除叶子节点
            deleteLeafNode(val, parent);
        } else if (target.left != null && target.right != null) {
            //删除有两颗子树的节点的节点
            deleteTwoBranchNode(target);
        }else {
            //删除只有一颗子树的节点
            deleteOneBranchNode(val, target, parent);
        }
    }

    /**
     * 删除有两颗子树的节点
     * @param target 目标节点
     * @return
     */
    public void deleteTwoBranchNode(BinarySortTreeNode target) {
        BinarySortTreeNode minNodeOfTargetRitht = target.right;
        //遍历找到目标节点右子树上的最小值
        //右子树上的最小值，也就是目标节点的右子节点的左树最大值
        while (minNodeOfTargetRitht.left != null) {
            minNodeOfTargetRitht = minNodeOfTargetRitht.left;
        }
        //删除最小值
        deleteNode(minNodeOfTargetRitht.val);
        //目标节点的值替换为该最小值
        target.val = minNodeOfTargetRitht.val;
    }

    /**
     * 删除只有一颗子树的节点
     * @param val 要删除的节点的值
     * @param target 要删除的节点
     * @param parent 要删除的节点的父节点
     */
    private void deleteOneBranchNode(int val, BinarySortTreeNode target, BinarySortTreeNode parent) {
        //判断要目标节点有左子树还是右子树
        if (target.left != null) {
            //判断是否为根节点
            if (parent == null) {
                //如果是根节点，就直接删除
                root = target.left;
            }else {
                //目标节点只有左子树
                if (parent.left.val == val) {
                    parent.left = target.left;
                }else {
                    parent.right = target.left;
                }
            }
        }else {
            if (parent == null) {
                root = target.right;
            }else {
                //目标节点只有右子树
                if (parent.left.val == val) {
                    parent.left = target.right;
                } else {
                    parent.right = target.right;
                }
            }
        }
    }

    /**
     * 删除叶子节点
     * @param val 要删除的节点的值
     * @param parent 要删除的节点的父节点
     */
    private void deleteLeafNode(int val, BinarySortTreeNode parent) {
        //判断目标节点是父节点左节点还是右节点
        if (parent.right != null && parent.right.val == val) {
            parent.right = null;
        }else {
            parent.left = null;
        }
    }
}
