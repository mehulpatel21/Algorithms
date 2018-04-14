package bloomberg;

public class MaxProfit {
	public static void main(String[] args){
		int[] prices = new int[] {2,1,3,5,4,8,9};
		MaxProfit obj = new MaxProfit();
		System.out.println(obj.maxProfit(prices));
	}
	
	public int maxProfit(int[] prices){
		int maxPrice = 0;
		int minPrice = prices[0];
		
		if(prices.length == 0) return maxPrice;
		for(int i=1; i<prices.length; i++){
			if(prices[i] > minPrice){
				if(maxPrice < (prices[i] - minPrice)){
					maxPrice = prices[i] - minPrice;
				}
			} else {
				minPrice = prices[i];
			}
		}
		return maxPrice;
		
	}
}
