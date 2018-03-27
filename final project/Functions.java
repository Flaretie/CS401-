package Common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Scanner;


public class Functions<E> implements FuncInterface<E>{
	
	public CS401ArrayImpl<Coupon> MasterList = new CS401ArrayImpl<Coupon>();
	public CS401ArrayImpl<Coupon> productNameML = new CS401ArrayImpl<Coupon>();
	public CS401ArrayImpl<Coupon> priceML = new CS401ArrayImpl<Coupon>();
	public CS401ArrayImpl<Coupon> discountML = new CS401ArrayImpl<Coupon>();
	public CS401ArrayImpl<Coupon> expML = new CS401ArrayImpl<Coupon>();
	public CS401ArrayImpl<Coupon> finalPML = new CS401ArrayImpl<Coupon>();
	public CS401ArrayImpl<Coupon> statusML = new CS401ArrayImpl<Coupon>();
	
	CS401BST<Coupon> sortedMasterList = new CS401BST<Coupon>();
	newArrayList<Coupon> sortedMLA = new newArrayList<Coupon>(Coupon.class);
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////MasterList Builder Methods////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/** <<Requirements>>
	 *		User’s initial input creates an UL.
	 *		When a user selects a menu, then construct a SL (Sorted List, depends on with a key field).
	 *		The UL also needs two different ways to create an array:
	 *			1. Default value of N (e.g. use N = 30)
	 *			2. User input array size
	 *
	 * 	<<Methods including>>
	 * ULconstructor(); 
	 * 		Initial MasterList by adding Coupon from Constructor.txt with default capacity(30)
	 * ULconstructor_manual_capacity();
	 * 		User can input the capacity and initial MasterList
	 * sortedMLconstructor ();
	 * 		Sort MasterList
	 *
	 */
	public void ULconstructor() throws Exception 
	{		
		Coupon UL_coupon;
		@SuppressWarnings("resource")
		Scanner scfile_ul = new Scanner(new File("src/Common/Constructor.txt"));
        
        while (scfile_ul.hasNextLine())
        {
            String line = scfile_ul.nextLine();
            // scan elements from emp.txt and split data base on ",".

            String[] parts = line.split(",");  
            Integer parts2 = Integer.valueOf(parts[2]);
            Integer parts3 = Integer.valueOf(parts[3]);
            Integer parts4 = Integer.valueOf(parts[4]);
            UL_coupon = new Coupon(parts[0], parts[1], parts2, parts3, parts4, parts[5]);
            MasterList.add(UL_coupon);
        }      
        
         System.out.println("<<Storage>>\n" + "  <<The number of coupon>> " + MasterList.size()+ "\n"+ " " + MasterList); 
          
          sortedMLconstructor ();
	}
	
	public void ULconstructor_manual_capacity() throws Exception 
	{	
		Coupon UL_coupon;
		@SuppressWarnings("resource")
		Scanner scfile_ul_manual = new Scanner(new File("src/Common/Constructor.txt"));
		System.out.println("Input the capacity you want:\n"
						+  "Enter>");
	    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String commandLine;
        commandLine = console.readLine();  

        Integer ManualCapacity = Integer.valueOf(commandLine);
        MasterList.newCap(ManualCapacity);
        while (scfile_ul_manual.hasNextLine())
        {
            String line = scfile_ul_manual.nextLine();
            // scan elements from emp.txt and split data base on ",".

            String[] parts = line.split(",");  
            Integer parts2 = Integer.valueOf(parts[2]);
            Integer parts3 = Integer.valueOf(parts[3]);
            Integer parts4 = Integer.valueOf(parts[4]);
            UL_coupon = new Coupon(parts[0], parts[1], parts2, parts3, parts4, parts[5]);
            MasterList.add(UL_coupon);
        }        
          System.out.println("<<Storage>>\n" + "  <<The number of coupon>> " + MasterList.size()+ "\n" 
          		+ " " + MasterList); 
          sortedMLconstructor ();
	}
		
	public void sortedMLconstructor () 
	{
		for (int SMLcount = 0; SMLcount < MasterList.size(); SMLcount++) 
		{
			sortedMLA.add(SMLcount, MasterList.get(SMLcount));
		} 
	}
	
	
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////Purchase Methods////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**  <<Requirements>>
	 * a. Coupon purchase (insert it into data collection) : either using data file and/or
	 *	  manual way (data file is provided by a user)
	 * b. Once importing data from a user provided file is completed, then a user
	 *	  continues to input more data manually
	 *
	 * 	<<Methods including>>
	 * purchaseCoupon_Auto(); 
	 * 		User can add coupon from existed file
	 * purchase_manual();
	 *		Add coupon into the master list by adding elements manually
	 */
		public void purchaseCoupon_Auto() throws FileNotFoundException
		{
			Coupon p_coupon = null;
			@SuppressWarnings("resource")
			Scanner scfile = new Scanner(new File("src/Common/PurchaseCouponTestFile.txt"));
	        
	        while (scfile.hasNextLine())
	        {      	
	            String line = scfile.nextLine();
	            String[] parts = line.split(",");                                            // scan elements from Constructor.txt and split data base on ",".  
	            Integer parts2 = Integer.valueOf(parts[2]);
	            Integer parts3 = Integer.valueOf(parts[3]);
	            Integer parts4 = Integer.valueOf(parts[4]);
	            p_coupon = new Coupon(parts[0], parts[1], parts2, parts3, parts4, parts[5]);
	            MasterList.add(p_coupon);
	        } //add elements to MasterList.   
	        
	            System.out.println("<<Storage>>: \n "+  "  <<The number of coupon>> " + MasterList.size()+ "\n"+ " " + MasterList);	
		}// method purchaseCoupon_Auto
		
		public void purchase_manual() throws Exception 
		{
			String commandLine;
			Coupon p_coupon_manual;
			
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Return to the previous menu with XXX\n" + "Print new list by entering 'print'");// Prompt and read what the user entered
		    	System.out.println();
		    System.out.print("Split attributes by entering ','" + "\n" +
		        		 		 "Continue inputting data by entering 'return" + "\n" +
		        		 		 "Input your data in the following order: product name, provider name, price, discount rate, expire period, coupon status." + "\n" + 
		        		 		 "Please input your data> ");
		    while (true) 
		    {
		    		commandLine = console.readLine();
		    		String src = commandLine;  

		        	if (commandLine.equals("XXX"))  
		        	{
		        		
		        		break; 
		        	}
		        	if (commandLine.equals("print"))  
		        	{
		        		System.out.println("<<Storage>>: \n " + "  <<The number of coupon>> " + MasterList.size()+ "\n" + " " + MasterList);
		        		break; 
		        	}
		         // keep looping when user entered a return
		        	if (commandLine.equals(""))
		        	{
		    	 		continue;    
		        } 
		        	else 
		        	{
		        		String[] parts = src.split(",");  
			        Integer parts2 = Integer.valueOf(parts[2]);
			        Integer parts3 = Integer.valueOf(parts[3]);
			        Integer parts4 = Integer.valueOf(parts[4]);
			        p_coupon_manual = new Coupon(parts[0], parts[1], parts2, parts3, parts4, parts[5]);
			        MasterList.add(p_coupon_manual);
			        System.out.println("Success!!\n ");
		        	}// Else, commandLine contains infix string; read parse and evaluate
		   }//while
		}//method purchase_manual
					
		/*
		 if (!commandLine.equals(MasterList.contains(p_coupon_manual))) {
	    	 System.out.println("This product is out of storage!");
	    	 continue;
	     }
	     */
			
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////Search Coupon Method/////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 *  <<Requirements>>
		 * a. If coupon is found, show coupon to a user
		 * b. Also provide count of search from the existing list
		 * c. When searching, use both BST algorithm and linear search algorithm.
		 * d. For example, if there are 10 products in the list and the search finds the coupon
		 *    in 4th comparison by BST and 8th iterations by linear search, then the count
		 *	  output: “Found in 4th by BST and 8th by Linear Search”
		 * e. If searching element is not found, then return “No Coupon is found – 5th by
		 *	  BST and 10th by Linear Search”
		 *
		 * 	<<Methods including>>
		 * searchCoupon_Auto(); 
		 * 		When user enter coupon, the method will search this item with both O(N) and O(logN) runtime complexity,
		 * 	and compare the number of steps used by each algorithm. 
		 */
			
		public void searchCoupon() throws IOException
		{
			CS401BST<Coupon> searchBST = new CS401BST<Coupon>();
			
			for(int count = 0; count < MasterList.size(); count++) 
			{
				searchBST.add(MasterList.get(count));	
			}
			
			String commandLine;
			Coupon p_coupon_manual;
		    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		    System.out.println("Return to the previous menu with XXX");
		         // Prompt and read what the user entered
		    	System.out.println();
		    		while (true) 
		    		{
		    			System.out.print("\nEnter> ");
		    			commandLine = console.readLine();
		    			String src = commandLine;  
		    			int i = 0;
		    			if (commandLine.equals("XXX"))  
		    			{				 
		    				break; 
		    			}
		         // keep looping when user entered a return
		    			if (commandLine.equals(""))
		    			{
		    				continue;    
		    			} 
		    			else 
		    			{
		    				String[] parts = src.split(",");  
		    				Integer parts2 = Integer.valueOf(parts[2]);
		    				Integer parts3 = Integer.valueOf(parts[3]);
		    				Integer parts4 = Integer.valueOf(parts[4]);
		    				p_coupon_manual = new Coupon(parts[0], parts[1], parts2, parts3, parts4, parts[5]);
		    					if (searchBST.contains(p_coupon_manual)) 
		    					{
		    						System.out.println("Coupon found!\n" + " This is your Coupon: " + searchBST.get(p_coupon_manual).toString());
		    						System.out.print("Found in "+ (searchBST.count(p_coupon_manual) + 1) + "th by BST and ");
		    							for (; i < MasterList.size(); i++) 
		    							{
		    								if(MasterList.get(i).equals(p_coupon_manual))  // compare product name by override equals method
		    								System.out.print((i+1) + "th by linear"); 
		    							}// for 
		    					}//if
		    					else
		    						System.out.println(" No coupon is found - " + (searchBST.height() + 1) + "th by BST and " +
			        												 (MasterList.size() + 1) + "th by linear");
		    			}// Else, commandLine contains infix string; read parse and evaluate
		    		}//while
			}//method purchase_manual
		
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////List Coupon Method///////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * Here we have 7 method, each of them can sorted master list by different features. 
		 */
		
		
		
		public void SL_providerName () 
		{
			Collections.sort(sortedMLA, Coupon.providerNameComparator);
	        System.out.println("<<Sorted MasterList by Provider Name>>\n" + "  " + sortedMLA);
		}
		
		public void SL_productName ()
		{
			Collections.sort(sortedMLA, Coupon.productNameComparator);
	        System.out.println("<<Sorted MasterList by Product Name>>\n" + "  " + sortedMLA);
		}
		
		public void SL_status () 
		{
			Collections.sort(sortedMLA, Coupon.statusComparator);
	        System.out.println("<<Sorted MasterList by Status>>\n" + "  " + sortedMLA);
		}
		
		public void SL_finalPrice () {
			
			Collections.sort(sortedMLA, Coupon.finalPriceComparator);
	        System.out.println("<<Sorted MasterList by Final Price>>\n" + "  " + sortedMLA);
		}
		
		public void SL_price () 
		{
			Collections.sort(sortedMLA, Coupon.priceComparator);
	        System.out.println("<<Sorted MasterList by Price(before discount)>>\n" + "  " + sortedMLA);
		}
		
		public void SL_discountRate () 
		{
			Collections.sort(sortedMLA, Coupon.discountrateComparator);
	        System.out.println("<<Sorted MasterList by Discount rate>>\n" + "  " + sortedMLA);
		}
		
		public void SL_expPeriod () 
		{
			Collections.sort(sortedMLA, Coupon.expPeriodComparator);
	        System.out.println("<<Sorted MasterList Expire Period>>\n" + "  " + sortedMLA);
		}
		
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////Delete Coupon Method/////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 *  <<Method>>
		 * deleteCoupon();
		 * 		This method is really similar with search method, but here i only use O(logN) algorithm for better runtime complexity.
		 *  After input coupon manually, this method would define whether its in inventory, if it's true, then delete this coupon and 
		 * 	update Master list. 
		 * @throws IOException
		 */
		public void deleteCoupon() throws IOException 
		{
			CS401BST<Coupon> deleteBST = new CS401BST<Coupon>();
			
				for(int count = 0; count < MasterList.size(); count++) 
				{
					deleteBST.add(MasterList.get(count));	
				}
				
			String commandLine;
			Coupon d_coupon;
		    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			
		    System.out.println("Return to the previous menu with XXX");
		         // Prompt and read what the user entered
		    	System.out.println();
		      
		      while (true)
		      {
		    	  		System.out.print("\nEnter> ");         
		    	  		commandLine = console.readLine();
		    	  		String src = commandLine;  
		    	  		int i = 0;
		    	  		if (commandLine.equals("XXX")) 
		    	  		{				 
		    	  			break; 
		    	  		}
		         // keep looping when user entered a return
		    	  		if (commandLine.equals(""))
		    	  		{
		    	  			continue;    
		    	  		} 
		    	  		else 
		    	  		{
		    	  			String[] parts = src.split(",");  
		    	  			Integer parts2 = Integer.valueOf(parts[2]);
		    	  			Integer parts3 = Integer.valueOf(parts[3]);
		    	  			Integer parts4 = Integer.valueOf(parts[4]);
		    	  			d_coupon = new Coupon(parts[0], parts[1], parts2, parts3, parts4, parts[5]);
			        if (deleteBST.contains(d_coupon)) 
			        {
			        		System.out.println("Coupon found!\n" + " This is your Coupon: " 
			        		  								  + deleteBST.get(d_coupon).toString());
			          
				        for (; i < MasterList.size(); i++)
				        {
				        		if(MasterList.get(i).equals(d_coupon))  // compare product name by override equals method
				        			MasterList.remove(i); 
				        }// for
				        System.out.println("<<Storage after deleting>>\n  " +  MasterList);
			        }//if
			        else
			        		System.out.println(" Coupon is not exist! ");
		    	  		}// Else, commandLine contains infix string; read parse and evaluate
		      }//while
			}//method purchase_manual
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////Customer Method//////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 *  <<Methods>>
		 * Customer();
		 * 		This method can calculate the total final price based on user input.
		 * @throws IOException
		 */
			
		public void Customer () throws IOException 
		{
			CS401BST<Coupon> customerBST = new CS401BST<Coupon>();
			
			for(int count = 0; count < MasterList.size(); count++) 
			{
				customerBST.add(MasterList.get(count));	
			}
			
		String commandLine;
		Coupon p_coupon_manual;
		float customerPrice = 0;
		
	    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
	    System.out.println("Return to the previous menu with XXX\n" + "Get total final price by entering 'Done'\n");
	         // Prompt and read what the user entered
	    	System.out.println();  
	      while (true)
	      {
	    	  		System.out.print("Enter> ");         
	    	  		commandLine = console.readLine();
	    	  		String src = commandLine;  
	    	  		if (commandLine.equals("XXX")) 
	    	  		{				
	    	  			break; 
	    	  		}
	    	  		if (commandLine.equals("Done")) 
	    	  		{				
	    	  			System.out.println("You should pay: " + customerPrice + "\n");
	    	  			break;
	    	  		}
	         // keep looping when user entered a return
	    	  		if (commandLine.equals(""))
	    	  		{
	    	  			continue;    
	    	  		} 
	    	  		else 
	    	  		{
	    	  			String[] parts = src.split(",");  
	    	  			Integer parts2 = Integer.valueOf(parts[2]);
	    	  			Integer parts3 = Integer.valueOf(parts[3]);
	    	  			Integer parts4 = Integer.valueOf(parts[4]);
	    	  			p_coupon_manual = new Coupon(parts[0], parts[1], parts2, parts3, parts4, parts[5]);
		        if (customerBST.contains(p_coupon_manual)) 
		        {
		        		System.out.println(" Coupon has been added for counting! ");
		          
		        		customerPrice += customerBST.get(p_coupon_manual).finalPrice;
		        }//if
		        else
		        		System.out.println(" Coupon is not exist! ");
	    	  		}// Else, commandLine contains infix string; read parse and evaluate
	      }//while
		}
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////Find nice coupon Method//////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		/**
		 * Define a discount rate by yourself. This method help you to find coupons which are >= than your threshold.
		 * @throws IOException
		 */
		public void findNicecoupon() throws IOException 
		{
			CS401ArrayImpl<Coupon> saleList = new CS401ArrayImpl<Coupon>();
			System.out.println(" Set the threshold for discount rate (% is not required): ");
			BufferedReader console_sale = new BufferedReader(new InputStreamReader(System.in));
			
			String temp_threshold = console_sale.readLine();
			Integer sale_threshold = Integer.valueOf(temp_threshold);		
			int sale_count = 0;
			
			
	        for (; sale_count < MasterList.size(); sale_count++)
	        {
	        		if((MasterList.get(sale_count).discountRate >= sale_threshold))  // compare product name by override equals method
	        			saleList.add(MasterList.get(sale_count)); 
	        }// for
	            
	        		if (!saleList.is_empty())
	        		{
	        			System.out.println(" <<Products on big sale>>\n " + saleList);
	        		}
	        		else
	        		{
	        			System.out.println(" Sale Threshold is too high!! Please reset");
	        			findNicecoupon();
	        		}        
		}

}
