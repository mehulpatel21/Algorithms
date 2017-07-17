package tree;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	public static void main(String[] args){
		Trie trie = new Trie();
		trie.insert("Mehul");
		System.out.println(trie.search("Mehul"));
	}
	
	public class TrieNode{
		Map<Character, TrieNode> children;
		boolean endOfWord;
		
		public TrieNode(){
			children = new HashMap<>();
			endOfWord = false;
		}
	}
	public final TrieNode root;
	
	public Trie(){
		root = new TrieNode();
	}
	
	// Iterative implementation of Insert
	public void insert(String word){
		TrieNode current = root;
		for(int i=0; i<word.length(); i++){
			char ch=word.charAt(i);
			TrieNode node = current.children.get(ch);
			// if node doesn't exist in map then create one and put it into map
			if(node == null){
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}
	
	// Iterative implementation of Search
	public boolean search(String word){
		TrieNode current = root;
		for(int i=0; i<word.length(); i++){
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			// if node doesn't exist for given char then return false
			if(node == null){
				return false;
			}
			current = node;
		}
		return current.endOfWord;
	}
	
	// Delete entire word from trie
	public void delete(String word){
		delete(root, word, 0);
	}
	
	// Returns true if parent should delete mapping
	private boolean delete(TrieNode current, String word, int index){
		if(index == word.length()){
			if(!current.endOfWord){
				return false;
			}
			current.endOfWord = false;
			return current.children.size() == 0;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if(node == null){
			return false;
		}
		boolean shouldDeleteCurrentNode = delete(node, word, index+1);
		if(shouldDeleteCurrentNode){
			current.children.remove(ch);
			return current.children.size() == 0;
		}
		return false;
	}
}
