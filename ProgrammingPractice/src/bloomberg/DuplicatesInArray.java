package bloomberg;

import java.util.HashSet;
import java.util.Set;

public class DuplicatesInArray {
	public boolean containsDupes(int[] nums) {
        Set<Integer> setOfInteger = new HashSet<Integer>();
        for(int i=0; i< nums.length; i++){
            if(setOfInteger.contains(nums[i])){
                return true;
            } else {
                setOfInteger.add(nums[i]);
            }
        }
        return false;
    }
	
	public boolean containsDupesNearby(int[] nums, int k) {
        
        Set<Integer> setOfInteger = new HashSet<Integer>();
        for(int i=0; i< nums.length; i++){
            if(setOfInteger.contains(nums[i])){
                return true;
            }
            setOfInteger.add(nums[i]);
            if(i >=k){
                setOfInteger.remove(nums[i-k]);
            }
        }
        return false;
    }
}
