package bloomberg;

import java.util.Iterator;

public class BackToOriginal {
	 enum Steps {
	        UP, DOWN, LEFT, RIGHT
	    }
	    public boolean backToOriginal(final Iterable<Steps> steps) { 
	        int x = 0, y=0;
	        //Stack<Steps> stackOfSteps = new Stack<Steps>();
	        Iterator<Steps> itr = steps.iterator();
	        while(itr.hasNext()){
	            Object obj = (Steps)itr.next(); 
	            if(obj == "UP"){y++;}
	            if(obj =="DOWN"){y--;}
	            if(obj == "LEFT"){x--;}
	            if(obj == "RIGHT"){x++;}
	        } 
	        if(x == 0 && y == 0){
	            return true;
	        }
	        return false;
	    }
}
