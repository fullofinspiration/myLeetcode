package com.fullofinspiration.github.leetcode;

/**
 * board[][]: 数据, word:要搜索的单词
 * //对于3行5列，这里遍历1，2，3
 * for(int i: board.size()) {
 *     //对于3行5列，这里遍历1，2，3，4，5
 *     for(int j: board[0].size) {
 *         //遍历到单词第几个元素
 *         int position = 0；
 *         if(!word.getCharacterAt(position).equals( board[i][j])) {
 *             continue;
 *         }
 *        List<Node> all = new ArrayList<>();
 *        Node node = new Node(i,j,board[i,j], 0, 0);
 *        all.add(node);
 *        if (getValidString(all)) {
 *            return true;
 *        }
 *     }
 * }
 * return false;
 *
 * private boolean getValidString(List<Node> all) {
 *     Node curNode = all.get(all.size()-1);
 *     for(int position=curNode.position;position < word.length;word++) {
 *        Node nextNode =  getNextNode(node.row, node.col,node.value node.status,node.position);
 *        if (nextNode == null) {
 *            break;
 *        }
 *        all.add(nextNode);
 *        curNode = nextNode;
*      }
 *     if (curNode.position = ${maxLength}) {
 *         return true;
 *     }
 *     list.remove(list.size() -1);
 *    return getValidString(list.get(list.size-1))
 * }
 *
 * //此处写成递归方法这样代码更简洁些
 * private Node getNextNode(int row, int col, char value, int status, int position) {
 *    if (status == 0) {
 *        if (isValid(row-1, col, status+1)) {
 *            return new Node(row-1, col,value, status +1, position);
 *        }
 *        return  getNextNode(row, col, status+1);
 *    }
 *    if (status == 1) {
 *        if (isValid(row, col+1, status)) {
 *            return new Node(row, col+1, value, status+1, position);
 *        }
 *        return getNextNode(row, col, status+1);
 *    }
 *    if (status == 2) {
 *        if (isValid(row+1, col, status))  {
 *            return new Node(row+1, col,value, status+1, position);
 *        }
 *        return getNextNode(row, col, status+1);
 *    }
 *    return null;
 * }
 *
 * boolean isValid(int row, int col, int status,char value) {
 *      if (row = 0 || row >= maxLength) {
 *         return false;
 *      }
 *      if (col = 0 || col >= maxHeight) {
 *           return false;
 *      }
 *      if (status == 3) {
 *           return false;
 *      }
 *      if (!board[row, col].equals(value))
 *      return false;
 * }
 * private static class Node {
 *     private int row;
 *     private int col;
 *     //按照左，下，右来遍历(分别为0，1，2，3),0表示都没有遍历，1表示左节点已遍历完，1表示
 *    private  char value;
 *     private int status;
 *     //在数组中位置
 *     private int position;
 * }
 */
public class _0079_WordSearch {

}
