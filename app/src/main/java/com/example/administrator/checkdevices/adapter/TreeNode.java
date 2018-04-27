package com.example.administrator.checkdevices.adapter;

import android.support.annotation.NonNull;

import com.example.administrator.checkdevices.interfaces.LayoutItemType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by tlh on 2016/10/1 :)
 */

public class TreeNode<T extends LayoutItemType> implements Cloneable,Serializable,Comparable<TreeNode> {
    private T content;
    private TreeNode parent;
    private List<TreeNode> childList;
    private boolean isExpand;
    //the tree high
    private int height = UNDEFINE;

    private static final int UNDEFINE = -1;

    public TreeNode(@NonNull T content) {
        this.content = content;
    }

    public int getHeight() {
        if (isRoot())
            height = 0;
        else if (height == UNDEFINE)
            height = parent.getHeight() + 1;
        return height;
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return childList == null || childList.isEmpty();
    }

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public List<TreeNode> getChildList() {
        return childList;
    }

    public void setChildList(List<TreeNode> childList) {
        this.childList = childList;
    }

    public TreeNode addChild(TreeNode node) {
        if (childList == null)
            childList = new ArrayList<>();
        childList.add(node);
        node.parent = this;
        return this;
    }
    public TreeNode removeChild(TreeNode node) {
        if(childList.contains(node)){
            childList.remove(node);
        }
       /* if (childList == null)
            childList = new ArrayList<>();
        childList.add(node);*/
        node.parent = this;
        return this;
    }
    public boolean toggle() {
        isExpand = !isExpand;
        return isExpand;
    }

    public void collapse() {
        if (!isExpand)
            isExpand = false;
    }

    public void expand() {
        if (isExpand)
            isExpand = true;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "content=" + this.content +
                ", parent=" + (parent == null ? "null" : parent.getContent().toString()) +
                ", childList=" + (childList == null ? "null" : childList.toString()) +
                ", isExpand=" + isExpand +
                '}';
    }

    @Override
    protected TreeNode<T> clone() throws CloneNotSupportedException {
        TreeNode<T> clone = new TreeNode<>(this.content);
        clone.isExpand = this.isExpand;
        return clone;
    }

    @Override
    public int compareTo(@NonNull TreeNode o) {
        Object treeNode=(Object) this.getContent();
        /*if(treeNode instanceof tb_cdinfo){
            tb_cdinfo cdinfo=(tb_cdinfo)o.getContent();
            int i= Integer.parseInt(cdinfo.getCdnum())- Integer.parseInt(((tb_cdinfo) treeNode).getCdnum());
            return i;
        }else if(treeNode instanceof tb_zjq){
            tb_zjq zjq=(tb_zjq)o.getContent();
            int i=zjq.getTxadd()-((tb_zjq) treeNode).getTxadd();
            return i;
        }*/
        return 0;
    }
}
