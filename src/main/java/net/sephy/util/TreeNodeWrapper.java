package net.sephy.util;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 树结构节点包装类
 * @author Sephy
 * @since: 2015-07-14
 */
public class TreeNodeWrapper<T extends TreeNode> {

    private T node;

    private Collection<TreeNodeWrapper<T>> subNodes;

    public T getNode() {
        return node;
    }

    public void setNode(T node) {
        this.node = node;
    }

    public Collection<TreeNodeWrapper<T>> getSubNodes() {
        return subNodes;
    }

    public void setSubNodes(Collection<TreeNodeWrapper<T>> subNodes) {
        this.subNodes = subNodes;
    }

    /**
     * 是否含有子节点
     * @return
     */
    public boolean getHasSubNodes() {
        return !CollectionUtils.isEmpty(subNodes);
    }

    /**
     * 添加子节点, 非线程安全
     * @param subNode
     */
    public void addSubNode(TreeNodeWrapper<T> subNode) {
        if (subNodes == null) {
            subNodes = new ArrayList<TreeNodeWrapper<T>>();
        }
        subNodes.add(subNode);
    }
}
