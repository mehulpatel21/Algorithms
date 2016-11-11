package wordLadder;

import java.util.List;

public class Ladder {
	private List<String> path;
	private int length;
	private String lastWord;
	
	public Ladder(List<String> path){
		this.path = path;
	}
	
	public Ladder(List<String> path, int length, String lastWord){
		this.path = path;
		this.length = length;
		this.lastWord = lastWord;
	}

	public List<String> getPath() {
		return path;
	}

	public void setPath(List<String> path) {
		this.path = path;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getLastWord() {
		return lastWord;
	}

	public void setLastWord(String lastWord) {
		this.lastWord = lastWord;
	}
	
	

}
