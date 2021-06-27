package com.fullofinspiration.github.leetcode;

/**
 * if (root == null)  {
 *     return true;
 * }
 * List<Node> all = new ArrayList<>();
 * all.add(root);
 * while(true) {
 *     int startIndex=0;
 *     int endIndex=all.size()-1;
 *     for(;startIndex <endIndex; startIndex++,eneIndex--){
 *         if ( (all[startIndex].left==null && all[endIndex].right!=null) ||
 *             (all[startIndex].left!=null && all[endIndex].right == null) ||
 *         all[startIndex].value != all[endIndex].value) {
 *             return false;
 *         }
 *     }
 *     intNextNotNullCount = 0;
 *     List<Node> nextNodes = new ArrayList();
 *     for(int i=0, i< all.size();i++) {
 *        if (all.get(i) == null) {
 *            nextNodes.add(null);
 *            nextNodes.add(null);
 *        } else {
 *           intNextNotNullCount++;
 *           Node curNode =  all.get(i);
 *           nextNodes.add(curNode.left);
 *           nextNodes.add(curNode.right);
 *        }
 *     }
 *     //说明下一层都没有值，表明是对称的
 *     if (intNextNotNullCount == 0) {
 *         return true;
 *     }
 *     all= nextNodes;
 * }
 */
public class _0101_SymmetricTree {

}
