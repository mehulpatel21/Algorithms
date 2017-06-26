package interview_questions;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToEatBreakfast {
	public static void main(String[] args){
	}
	
	private static boolean isValidMenuForTheDay(ArrayList<MenuEnum> bfMenu, int day, MenuEnum todayMenu) {
		int prevDay=day-1;
		int prev2Day=day-2;
		if(prevDay > -1 && bfMenu.get(prevDay)==MenuEnum.Pizza && todayMenu==MenuEnum.Pizza){
			return false;
		}
		if(prev2Day > -1 && bfMenu.get(prev2Day)==MenuEnum.Burger && todayMenu==MenuEnum.Burger){
			return false;
		}
		return true;
	}
	
	public static void getPermutationsBreakfastMenuForDays(int startDay,int noOfDays,ArrayList<MenuEnum> list){
		if(list.size()==4){
			System.out.println("Final List: "+list);
		}
		if(startDay < 4 && noOfDays > -1){
			for(MenuEnum menu:MenuEnum.values()){
				if(isValidMenuForTheDay(list,startDay,menu)){
					list.add(menu);
					getPermutationsBreakfastMenuForDays(startDay+1,noOfDays-1,list);
					list.remove(startDay);
				}
			}
			
		}
	}
	
	public enum MenuEnum {
		BreadAndButter,Pizza,Burger
	}
}