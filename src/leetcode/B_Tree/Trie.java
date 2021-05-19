package leetcode.B_Tree;

public class Trie {

    class TrieNode {
        boolean end;
        TrieNode[] children = new TrieNode[26];
    }

    public Trie() {
        root = new TrieNode();
    }

    TrieNode root;


    //208. Implement Trie (Prefix Tree)

    public void insert(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.children[u] == null) p.children[u] = new TrieNode();
            p = p.children[u];
        }
        p.end = true;
    }

    public boolean search(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.children[u] == null) return false;
            p = p.children[u];
        }
        return p.end;
    }

    public boolean startsWith(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.children[u] == null) return false;
            p = p.children[u];
        }
        return true;
    }
}
