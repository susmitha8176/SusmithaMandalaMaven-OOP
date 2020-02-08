package newYearGift;

public class Gulab extends Sweets implements NewYearGift {

	 int sweetWeight;
	 int sweetPrice;
	//constructor
	public Gulab(int sweetWeight, int sweetPrice) {
		super(sweetWeight, sweetPrice);
		
	}
	public int getSweetWeight() {
		return sweetWeight;
	}
	public void setSweetWeight(int sweetWeight) {
		this.sweetWeight = sweetWeight;
	}
	public int getSweetPrice() {
		return sweetPrice;
	}
	public void setSweetPrice(int sweetPrice) {
		this.sweetPrice = sweetPrice;
	}
	
	

	

	
}
