package net.sephy.util;

/**
 * @author Sephy
 * @since: 2015-07-15
 */
public interface TreeNode<T> {

    T getKey();

    T getParentKey();

    int getNodeLevel();
}
