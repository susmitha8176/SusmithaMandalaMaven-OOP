package newYearGift;

import java.util.*;

public class Gift {
	static Scanner sc = new Scanner(System.in);
	static ArrayList <Chocolates> ch = new ArrayList <Chocolates>();
	static ArrayList <Chocolates> candies = new ArrayList <Chocolates>();
	static ArrayList <Sweets> s = new ArrayList <Sweets>();
	static HashMap<String,Integer> nameWeight = new HashMap<String,Integer>(); 
	static HashMap<String,Integer> namePrice = new HashMap<String,Integer>();
	
	public static void main(String[] args) {
		userChocolates();
		userSweets();
		System.out.println("Total weight of the gift"+TotalWeight());
		System.out.println("select a way to sort 1.By Price 2.By weight");
		int sortType = sc.nextInt();
		if(sortType == 1){
			Comparator<Chocolates> cmpPrice = new Comparator<Chocolates>() {
				public int compare(Chocolates c1, Chocolates c2) {
					return ((Integer)c1.getChocoPrice()).compareTo(c2.getChocoPrice());
				}
			};
			Collections.sort(ch,cmpPrice);
			System.out.println("the sorted result : ");
			for(Chocolates choco:ch){
				System.out.println(choco.getChocoPrice());
			}
		}
		if(sortType == 2){
			Comparator<Chocolates> cmpWeight = new Comparator<Chocolates>() {
				public int compare(Chocolates c1, Chocolates c2) {
					return ((Integer)c1.getChocoWeight()).compareTo(c2.getChocoWeight());
				}
			};
			Collections.sort(ch,cmpWeight);
			System.out.println("the sorted result : ");
			for(Chocolates choco:ch){
				System.out.println(choco.getChocoWeight());
			}
			range(sortType);
		
		}
		
		
	}

	private static void range(int sortType) {
		int low,high;
		if(sortType == 1){
			System.out.println("enter low limit");
			low = sc.nextInt();
			System.out.println("enter high limit");
			high = sc.nextInt();
			Set<Map.Entry<String, Integer>> cset = namePrice.entrySet();
			Iterator<Map.Entry<String,Integer>> cIterator = cset.iterator();
			while(cIterator.hasNext()){
				Map.Entry cElement = (Map.Entry)cIterator.next();
				int presentPrice = (Integer) cElement.getValue();
				if(presentPrice >= low && presentPrice <= high){
					System.out.println(cElement.getKey());
				}
			}
		}
		if(sortType == 2){
			System.out.println("enter low limit");
			low = sc.nextInt();
			System.out.println("enter high limit");
			high = sc.nextInt();
			Set<Map.Entry<String, Integer>> cset = nameWeight.entrySet();
			Iterator<Map.Entry<String,Integer>> cIterator = cset.iterator();
			while(cIterator.hasNext()){
				Map.Entry cElement = (Map.Entry)cIterator.next();
				int presentPrice = (Integer) cElement.getValue();
				if(presentPrice >= low && presentPrice <= high){
					System.out.println(cElement.getKey());
				}
			}
		}
	}

	public static void userSweets() {
		System.out.println("enter no.of sweets");
		int numSweet = sc.nextInt();
		for(int i = 0; i < numSweet;i++){
			System.out.println("Select sweet type : 1.gulab 2.cova");
			int sweetType = sc.nextInt();
			if(sweetType == 1){
			System.out.println("Enter weight of gulab");
			int sweetWeight = sc.nextInt();
			System.out.println("Enter price of gulab");
			int sweetPrice = sc.nextInt();
			Sweets sweet = new Sweets(sweetWeight,sweetPrice);
			s.add(sweet);
		}
			if(sweetType == 2){
					System.out.println("Enter weight of gulab");
					int sweetWeight = sc.nextInt();
					System.out.println("Enter price of gulab");
					int sweetPrice = sc.nextInt();
					Sweets sweet = new Sweets(sweetWeight,sweetPrice);
					s.add(sweet);
				}
			else{
				System.out.println("please select correct option");
			}
			}
		}
		
	public static int TotalWeight(){
		int totalWeight = 0;
		for(Chocolates choco:ch){
			totalWeight += choco.getChocoWeight();
		}
		for(Sweets sweets:s){
			//System.out.println(sweets.getSweetWeight());
			totalWeight += sweets.getSweetWeight();
			}
		return totalWeight;
		
	}

	public static void userChocolates() {
		System.out.println("enter no.of chocolates");
		int numChoco = sc.nextInt();
		int chocoWeight = 0,chocoPrice = 0 ;
		for(int i = 0; i < numChoco;i++){
			System.out.println("Select choco type : 1.candy 2.whiteChocolate");
			int chocoType = sc.nextInt();
			if(chocoType == 2){
			System.out.println("Enter weight of Chocolate");
			chocoWeight = sc.nextInt();
			System.out.println("Enter price of Chocolate");
			 chocoPrice = sc.nextInt();
			}
			if(chocoType == 1){
				System.out.println("Enter weight of Candy");
				 chocoWeight = sc.nextInt();
				System.out.println("Enter price of Candy");
				 chocoPrice = sc.nextInt();
			}
			else{
				System.out.println("please select correct option");
			}
			if(chocoType == 1){
				System.out.println("Enter the name of the candy");
				String cName = sc.next();
				if(nameWeight.containsKey(cName)){
					nameWeight.put(cName, (int)nameWeight.get(cName) + chocoWeight);
				}
				else{
					nameWeight.put(cName, chocoWeight);
				}
					if(namePrice.containsKey(cName)){
						nameWeight.put(cName, (int)namePrice.get(cName) + chocoPrice);
					}
					else{
						namePrice.put(cName, chocoPrice);
					}
			}
			Chocolates choco = new Chocolates(chocoWeight,chocoPrice);
			ch.add(choco);
			if(chocoType == 1){
				candies.add(choco);
			}
		}
		
	}
	
}
