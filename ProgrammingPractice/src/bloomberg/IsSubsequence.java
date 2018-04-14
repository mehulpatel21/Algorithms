package bloomberg;

public class IsSubsequence {

	public static void main(String[] args) {
		IsSubsequence obj = new IsSubsequence();
		System.out.println(obj.isSubsequence("abc", "aebhcj"));
	}

	public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }

}
