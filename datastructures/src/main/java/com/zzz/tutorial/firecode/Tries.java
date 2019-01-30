package com.zzz.tutorial.firecode;

import java.time.Instant;
import java.time.temporal.TemporalField;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class Tries {
    private class TrieNode {
        Character c;
        Boolean isLeaf = false;
        HashMap<Character, TrieNode> children = new HashMap<>();

        public TrieNode() {
        }

        public TrieNode(Character c) {
            this.c = c;
        }
    }

    class Trie {
        private TrieNode root;

        // Implement these methods :
        public Trie() {
            root = new TrieNode();
        }

        public void insertWord(String word) {
            if (word == null || word.trim().length() == 0) return;
            TrieNode temp = this.root;
            for (int i = 0; i < word.length(); i++) {
                temp = performOnChar(word.charAt(i), temp);
            }
            // Since temp is pointing to the last character, mark it as leaf
            // indicating the word here is complete
            temp.isLeaf = true;
        }

        private TrieNode performOnChar(Character ch, TrieNode temp) {
            // Check if the character exists, if so return the reference to that node
            return temp.children.getOrDefault(ch, temp.children.put(ch, new TrieNode(ch)));
        }

        public Boolean searchWord(String word) {
            if (word == null || word.trim().length() == 0) return false;
            long starttime = System.nanoTime();
            TrieNode node = search(word);
            System.out.println(System.nanoTime() - starttime);
            return node == null ? false : node.isLeaf;
        }

        private TrieNode search(String word) {
            TrieNode temp = this.root;
            for (int i = 0; i < word.length(); i++) {
                temp = temp.children.get(word.charAt(i));
                if (temp == null) break;
            }
            return temp;
        }

        public Boolean searchPrefix(String word) {
            if (word == null || word.trim().length() == 0) return false;
            return search(word) != null;
        }
    }

    public static void main(String[] args) {
        Tries tries = new Tries();
        Trie trie = tries.new Trie();
        trie.insertWord("FIRES");
        System.out.println(trie.searchWord("FIRE"));
        System.out.println(trie.searchPrefix("FIRE"));
    }
}
