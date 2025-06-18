package com.fullofinspiration.github.leetcode;


public class _0079_WordSearch {
    /**
     * 开始时间:20:46
     * 结束时间: 21:14
     * 耗时：28min
     */
    class Solution {
        char[][] board;
        String word;
        private boolean[][] visited;

        public boolean exist(char[][] board, String word) {
            this.board = board;
            this.word = word;
            visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    boolean ret = backtrace(0, i, j);
                    if (ret) {
                        return true;
                    }
                }
            }
            return false;
        }


        private boolean backtrace(int matchIdx, int i, int j) {
            if (matchIdx >= word.length()) {
                return false;
            }
            if (i < 0 || i >= board.length) {
                return false;
            }
            int colLen = board[0].length;
            if (j < 0 || j >= colLen) {
                return false;
            }
            if (visited[i][j]) {
                return false;
            }
            if (word.charAt(matchIdx) != board[i][j]) {
                return false;
            }
            if (matchIdx == word.length() - 1) {
                return true;
            }
            visited[i][j] = true;
            boolean ret1 = backtrace(matchIdx + 1, i - 1, j);
            boolean ret2 = backtrace(matchIdx + 1, i + 1, j);
            boolean ret3 = backtrace(matchIdx + 1, i, j - 1);
            boolean ret4 = backtrace(matchIdx + 1, i, j + 1);
            boolean ret = ret1 || ret2 || ret3 || ret4;
            if (ret) {
                return true;
            }
            visited[i][j] = false;
            return false;
        }

    }

    /**
     * board[][]: 数据, word:要搜索的单词
     * //对于3行5列，这里遍历1，2，3
     * for(int i: board.size()) {
     * //对于3行5列，这里遍历1，2，3，4，5
     * for(int j: board[0].size) {
     * //遍历到单词第几个元素
     * int position = 0；
     * if(!word.getCharacterAt(position).equals( board[i][j])) {
     * continue;
     * }
     * List<Node> all = new ArrayList<>();
     * Node node = new Node(i,j,board[i,j], 0, 0);
     * all.add(node);
     * if (getValidString(all)) {
     * return true;
     * }
     * }
     * }
     * return false;
     * <p>
     * private boolean getValidString(List<Node> all) {
     * Node curNode = all.get(all.size()-1);
     * for(int position=curNode.position;position < word.length;word++) {
     * Node nextNode =  getNextNode(node.row, node.col,node.value node.status,node.position);
     * if (nextNode == null) {
     * break;
     * }
     * all.add(nextNode);
     * curNode = nextNode;
     * }
     * if (curNode.position = ${maxLength}) {
     * return true;
     * }
     * list.remove(list.size() -1);
     * return getValidString(list.get(list.size-1))
     * }
     * <p>
     * //此处写成递归方法这样代码更简洁些
     * private Node getNextNode(int row, int col, char value, int status, int position) {
     * if (status == 0) {
     * if (isValid(row-1, col, status+1)) {
     * return new Node(row-1, col,value, status +1, position);
     * }
     * return  getNextNode(row, col, status+1);
     * }
     * if (status == 1) {
     * if (isValid(row, col+1, status)) {
     * return new Node(row, col+1, value, status+1, position);
     * }
     * return getNextNode(row, col, status+1);
     * }
     * if (status == 2) {
     * if (isValid(row+1, col, status))  {
     * return new Node(row+1, col,value, status+1, position);
     * }
     * return getNextNode(row, col, status+1);
     * }
     * return null;
     * }
     * <p>
     * boolean isValid(int row, int col, int status,char value) {
     * if (row = 0 || row >= maxLength) {
     * return false;
     * }
     * if (col = 0 || col >= maxHeight) {
     * return false;
     * }
     * if (status == 3) {
     * return false;
     * }
     * if (!board[row, col].equals(value))
     * return false;
     * }
     * private static class Node {
     * private int row;
     * private int col;
     * //按照左，下，右来遍历(分别为0，1，2，3),0表示都没有遍历，1表示左节点已遍历完，1表示
     * private  char value;
     * private int status;
     * //在数组中位置
     * private int position;
     * }
     */
    class Solution00 {
        public boolean exist(char[][] board, String word) {
            return false;
        }
    }
}
