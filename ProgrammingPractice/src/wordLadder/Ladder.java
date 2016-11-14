package wordLadder;

import java.util.List;

public class Ladder {
	private List<String> path;
	private String endWord;
	private int length;
	
	public Ladder(List<String> path){
		this.path = path;
	}
	public Ladder(List<String> path, int length, String endWord){
		this.path = path;
		this.length = length;
		this.endWord = endWord;
	}
	public List<String> getPath() {
		return path;
	}
	public void setPath(List<String> path) {
		this.path = path;
	}
	public String getEndWord() {
		return endWord;
	}
	public void setEndWord(String endWord) {
		this.endWord = endWord;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

}
