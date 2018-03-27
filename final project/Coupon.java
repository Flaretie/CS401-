package Common;
import java.util.Comparator;

public class Coupon implements Comparable<Coupon> {
	
	//Attributes of Coupon
	public String providerName;
	public String productName;
	public int price;
	public int discountRate;
	public int expPeriod;
	public String status;
	public float finalPrice;
	
	public Coupon() {}
	
	public Coupon(String productName, String providerName, int price, int discountRate, int expPeriod, String status) {
		this.providerName = providerName;
		this.discountRate = discountRate;
		this.expPeriod = expPeriod;
		this.price = price;
		this.status = status;
		this.productName = productName;
		finalPrice = (discountRate*price) / 100;
	} //constructor 
	

	  public int compareTo (Coupon otherCoupon)
	  {
	    
	    if (productName.compareTo (otherCoupon.productName) < 0)
	      return -1;
	    if (productName.compareTo (otherCoupon.productName) > 0)
	      return 1;
	    else
	    return 0;
	  } // method compareTo
	  
	  public boolean equals (Coupon otherCoupon) {
		  if (productName.equals(otherCoupon.productName))
			  return true;
		  else
			  return false;
	  }
	  
	    public static Comparator<Coupon> productNameComparator = new Comparator<Coupon>() {

	    	public int compare(Coupon s1, Coupon s2) {
	    	   String productName1 = s1.productName.toUpperCase();
	    	   String productName2 = s2.productName.toUpperCase();

	    	   //ascending order
	    	   return productName1.compareTo(productName2);

	    	   //descending order
	    	   //return StudentName2.compareTo(StudentName1);
	        }
	    };
	    
	    public static Comparator<Coupon> providerNameComparator = new Comparator<Coupon>() {

	    	public int compare(Coupon s1, Coupon s2) {
	    	   String providerName1 = s1.providerName.toUpperCase();
	    	   String providerName2 = s2.providerName.toUpperCase();

	    	   //ascending order
	    	   return providerName1.compareTo(providerName2);

	        }
	    };
	    
	    public static Comparator<Coupon> statusComparator = new Comparator<Coupon>() {

	    	public int compare(Coupon s1, Coupon s2) {
	    	   String status1 = s1.status.toUpperCase();
	    	   String status2 = s2.status.toUpperCase();

	    	   //ascending order
	    	   return status1.compareTo(status2);

	        }
	    };
	    
	    public static Comparator<Coupon> priceComparator = new Comparator<Coupon>() {

	    	public int compare(Coupon s1, Coupon s2) {
	    		if (s1.price > s2.price)
	    			return 1;
	    		if (s1.price < s2.price)
	    			return -1;			
	    		else 
	    			return 0;

	        }
	    };
	    

	    
	    public static Comparator<Coupon> discountrateComparator = new Comparator<Coupon>() {

	    	public int compare(Coupon s1, Coupon s2) {
	    		if (s1.discountRate > s2.discountRate)
	    			return 1;
	    		if (s1.discountRate < s2.discountRate)
	    			return -1;			
	    		else 
	    			return 0;

	        }
	    };
	    
	    public static Comparator<Coupon> expPeriodComparator = new Comparator<Coupon>() {

	    	public int compare(Coupon s1, Coupon s2) {
	    		if (s1.expPeriod > s2.expPeriod)
	    			return 1;
	    		if (s1.expPeriod < s2.expPeriod)
	    			return -1;			
	    		else 
	    			return 0;

	        }
	    };
	    
	    public static Comparator<Coupon> finalPriceComparator = new Comparator<Coupon>() {

	    	public int compare(Coupon s1, Coupon s2) {
	    		if (s1.finalPrice > s2.finalPrice)
	    			return 1;
	    		if (s1.finalPrice < s2.finalPrice)
	    			return -1;			
	    		else 
	    			return 0;

	        }
	    };
	  
	  
	  
	  
	 
	  
	  
		public String  toString() {
	          
			return "[" + "<Name of product>: "+ productName  + ", " +
				    "<Name of provider>: "+ providerName  + ", " +
				    "<Price of product>: "+ price + ", " +
				    "<Discount rate of the coupon>: "+ discountRate + "%" + ", " +
				    "<Expiration Period>: "+ expPeriod + ", " +
				    "<status of a coupon>: "+ status + "," +
				    "<Final Price>: " + finalPrice + "]\n ";
		}
	
	    

	    /*
		public String  printbyProductName() {
			return "[" + "Name of product: "+ productName  + ", " +
				    "Name of provider: "+ providerName  + ", " +
				    "Price of product: "+ price + ", " +
				    "Discount rate of the coupon: "+ discountRate + "%" + ", " +
				    "Expiration Period: "+ expPeriod + ", " +
				    "status of a coupon: "+ status + "," +
				    "Final Price: " + finalPrice + "]\n ";
		}
		
		public String  printbyPrice() {
			return "[" + "Price of product: "+ price  + ", " +
				    "Name of product: "+ providerName  + ", " +
				    "Name of provider: "+ productName + ", " +
				    "Discount rate of the coupon: "+ discountRate + "%" + ", " +
				    "Expiration Period: "+ expPeriod + ", " +
				    "status of a coupon: "+ status + "," +
				    "Final Price: " + finalPrice + "]\n ";
		}
		
		
		
		

		
		public static String  printbyDis = new String {
			return "[" + "Discount rate of the coupon: "+ discountRate + "%"  + ", " +
				    "Name of product: "+ providerName  + ", " +
				    "Price of product: "+ price + ", " +
				    "Name of provider: "+ productName + ", " +
				    "Expiration Period: "+ expPeriod + ", " +
				    "status of a coupon: "+ status + "," +
				    "Final Price: " + finalPrice + "]\n ";
		};
		
		public String  printbyExp() {
			return "[" + "Expiration Period: "+ expPeriod   + ", " +
				    "Name of product: "+ providerName  + ", " +
				    "Price of product: "+ price + ", " +
				    "Discount rate of the coupon: "+ discountRate + "%" + ", " +
				    "Expiration Period: "+ expPeriod + ", " +
				    "Name of provider: "+ productName + "," +
				    "Final Price: " + finalPrice + "]\n ";
		}
		
		public String  printbysta() {
			return "[" + "status of a coupon: "+ status  + ", " +
				    "Name of product: "+ providerName  + ", " +
				    "Price of product: "+ price + ", " +
				    "Discount rate of the coupon: "+ discountRate + "%" + ", " +
				    "Expiration Period: "+ expPeriod + ", " +
				    "Name of provider: "+ productName + "," +
				    "Final Price: " + finalPrice + "]\n ";
		}
		
		public  String  printbyfp() {
			return "[" + "<Final Price>: " + finalPrice  + ", " +
				    "<Name of product>: "+ providerName  + ", " +
				    "<Price of product>: "+ price + ", " +
				    "<Discount rate of the coupon>: "+ discountRate + "%" + ", " +
				    "<Expiration Period>: "+ expPeriod + ", " +
				    "<status of a coupon>: "+ status + "," +
				    "<Name of provider>: "+ productName + "]\n ";
		}
		*/
		
		
		
		
		
		
}
