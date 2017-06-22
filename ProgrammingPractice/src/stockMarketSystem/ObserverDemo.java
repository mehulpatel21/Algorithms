package stockMarketSystem;

public class ObserverDemo {
	public static void main(String[] args) {
		StockUpdate su = new StockUpdate();
		MobileDisplay md = new MobileDisplay();
		
		su.registerObserver(md);
		
		su.setIbm(25);
		su.setMicrosoft(30);
		
		
		
	}
}
