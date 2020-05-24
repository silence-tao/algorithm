package com.silentao.leetcode.string;

/**
 * @Description
 * 208. 实现 Trie (前缀树)
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/submissions/
 * @Author Silence
 * @Date 2020/5/24 20:23
 **/
public class ImplementTriePrefixTree {

    /**
     * Trie (发音为 "try") 或前缀树是一种树数据结构，用于检索字符串数据集中的键。这一高效的数据结构有多种应用：
     * 1. 自动补全
     * 2. 拼写检查
     * 3. IP 路由 (最长前缀匹配)
     * 4. T9 (九宫格) 打字预测
     * 5. 单词游戏
     *
     * Trie 树的结点结构，Trie 树是一个有根的树，其结点具有以下字段：
     * 最多 RR 个指向子结点的链接，其中每个链接对应字母表数据集中的一个字母。
     * 本文中假定 RR 为 26，小写拉丁字母的数量。
     * 布尔字段，以指定节点是对应键的结尾还是只是键前缀。
     */
    class Trie {

        Trie[] tries;
        boolean end;

        /** Initialize your data structure here. */
        public Trie() {
            tries = new Trie[26];
        }

        /** Inserts a word into the trie. */
        /**
         * 向 Trie 树中插入键
         * 我们通过搜索 Trie 树来插入一个键。我们从根开始搜索它对应于第一个键字符的链接。有两种情况：
         *
         * 链接存在。沿着链接移动到树的下一个子层。算法继续搜索下一个键字符。
         * 链接不存在。创建一个新的节点，并将它与父节点的链接相连，该链接与当前的键字符相匹配。
         * 重复以上步骤，直到到达键的最后一个字符，然后将当前节点标记为结束节点，算法完成。
         * @param word
         */
        public void insert(String word) {
            Trie t = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (t.tries[c - 'a'] == null) {
                    t.tries[c - 'a'] = new Trie();
                }

                t = t.tries[c - 'a'];
            }

            t.end = true;
        }

        /** Returns if the word is in the trie. */
        /**
         * 在 Trie 树中查找键
         * 每个键在 trie 中表示为从根到内部节点或叶的路径。我们用第一个键字符从根开始
         * 检查当前节点中与键字符对应的链接。有两种情况：
         *  存在链接。我们移动到该链接后面路径中的下一个节点，并继续搜索下一个键字符。
         *  不存在链接。若已无键字符，且当前结点标记为 isEnd，则返回 true。否则有两种可能，均返回 false :
         *      还有键字符剩余，但无法跟随 Trie 树的键路径，找不到键。
         *      没有键字符剩余，但当前结点没有标记为 isEnd。也就是说，待查找键只是Trie树中另一个键的前缀。
         * @param word
         * @return
         */
        public boolean search(String word) {
            Trie t = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if ((t = t.tries[c - 'a']) == null) {
                    return false;
                }
            }

            return t.end;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        /**
         * 该方法与在 Trie 树中搜索键时使用的方法非常相似。
         * 我们从根遍历 Trie 树，直到键前缀中没有字符，或者无法用当前的键字符继续 Trie 中的路径。
         * 与上面提到的“搜索键”算法唯一的区别是，到达键前缀的末尾时，总是返回 true。
         * 我们不需要考虑当前 Trie 节点是否用 “isend” 标记，因为我们搜索的是键的前缀，而不是整个键。
         * @param prefix
         * @return
         */
        public boolean startsWith(String prefix) {
            Trie t = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if ((t = t.tries[c - 'a']) == null) {
                    return false;
                }
            }

            return true;
        }
    }
}
