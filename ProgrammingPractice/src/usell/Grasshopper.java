package usell;

public class Grasshopper {
	/*
	 * Array of int to store leaves
	 * int variable to hold current position
	 */
    private int[] leaves;
    private int currentPosition;
    
    /**
     * Initialization of view field with n leaves and grasshopper on leaf 'position'.
     * 
     * @param n Number of leaves in row.
     * @param position
     */
    public Grasshopper(int n, int position) {
        leaves = new int[n];
        for(int i=0; i<n; i++){
            leaves[i] = 1;
        }
        currentPosition = position - 1;
    }

    /**
     * Grasshopper has eaten the current leaf and hopped left.
     */
    public void eatAndHopLeft() {
    	leaves[currentPosition] = 0;
    	int position = test(currentPosition, -1);
    	if (position != -1) {
    		leaves[currentPosition] = 0;
    		currentPosition = position;
    	}
    }

    /**
     * Grasshopper has eaten the current leaf and hopped right.
     */
    public void eatAndHopRight() {
    	leaves[currentPosition] = 0;
    	int position = test(currentPosition, 1);
    	if (position != -1) {
    		leaves[currentPosition] = 0;
    		currentPosition = position;
    	}
    }
    
    /**
     * Function to test in which direction grasshopper should go.
     * @param position currentPosition of grasshopper
     * @param direction 
     * @return
     */
    private int test(int position, int direction) {
    	/* Go left*/
    	if (direction == -1) {
    		position -= 2;
    		if (position < 0) return -1;
    		while (position >= 0 && leaves[position] == 0) {
				position--;
			}
			if (leaves[position] == 1) {
				return position;
			} else return -1;
    	} 
    	/* Go right*/
    	else if (direction == 1) {
    		position += 2;
    		if (position >= leaves.length) return -1;
    		while (position < leaves.length && leaves[position] == 0) {
				position++;
			}
			if (leaves[position] == 1) {
				return position;
			} else return -1;
    	} else return -1;
    }

    /**
     * Return the leaf number that grasshopper is feeding on right now.
     * 
     * @return Leaf number that grasshopper is feeding on right now.
     */
    public int whereAmI() {
    	return currentPosition + 1;    
    }

    public static void main(String[] args) {
        Grasshopper g = new Grasshopper(5, 2);
        System.out.println(g.whereAmI());

        g.eatAndHopRight();
        System.out.println(g.whereAmI());

        g.eatAndHopLeft();
        System.out.println(g.whereAmI());
    }
}