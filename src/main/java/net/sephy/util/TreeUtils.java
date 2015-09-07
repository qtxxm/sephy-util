package net.sephy.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 树结构工具类
 * @author Sephy
 * @since: 2015-07-15
 */
public abstract class TreeUtils {

	/**
	 * 将集合封装成树结构
	 * @param treeNodes 节点集合
	 * @param deep 深度, 从 1 开始
	 * @param <K>
	 * @param <T>
	 * @return
	 */
	public static <K, T extends TreeNode> Collection<TreeNodeWrapper<T>> constructTree(
			Collection<? extends TreeNode<K>> treeNodes, int deep) {

		if (deep < 1) {
			return Collections.emptyList();
		}

		Map<Integer, Map<K, TreeNodeWrapper<T>>> map = new HashMap<Integer, Map<K, TreeNodeWrapper<T>>>(); // 用来存放树每层的节点

		for (int lv = 1; lv <= deep; lv++) {

			int upLv = lv - 1; // 上一级层级

			Map<K, TreeNodeWrapper<T>> levelMap = new LinkedHashMap<K, TreeNodeWrapper<T>>(); // 初始化
			map.put(lv, levelMap);

			for (TreeNode<K> treeNode : treeNodes) {
				if (treeNode.getNodeLevel() == lv) { // 节点层级=当前层级
					TreeNodeWrapper treeNodeWrapper = new TreeNodeWrapper();
					treeNodeWrapper.setNode(treeNode);
					levelMap.put(treeNode.getKey(), treeNodeWrapper);

					// 关联上级层级
					K parentKey = treeNode.getParentKey();
					if (upLv > 0 && parentKey != null) {
						Map<K, TreeNodeWrapper<T>> upLevelMap = map.get(upLv); // 上级层级
						TreeNodeWrapper parentWrapper = upLevelMap.get(parentKey);
						if (parentWrapper != null) {
							parentWrapper.addSubNode(treeNodeWrapper);
						}
					}
				}
			}
		}

		return map.get(1).values();
	}
}
