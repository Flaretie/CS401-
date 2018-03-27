package Common;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class User {
	Functions<Coupon> user = new Functions<Coupon>();
	
	public static void main(String[] arg) throws Exception
	{
		
		new User().runStep2();
		
	}
	
	
	public void runStep1() throws Exception 
	{
		System.out.println(" <<Inventory Initialization>>  Data is imported from 'src/Common/Constructor.txt\n"
				+ "  1. With dafault capacity = 30\n"
				+ "  2. Defind your capacity\n"
				+ "Enter>");
		BufferedReader bdConsole = new BufferedReader(new InputStreamReader(System.in));

		String temp_bd = bdConsole.readLine();
		Integer real_bd = Integer.valueOf(temp_bd);

		switch(real_bd) 
		{
			case 1: 
				user.ULconstructor();
				break;
			case 2: 
				user.ULconstructor_manual_capacity();
				break;
			default:
				System.out.println("WRONG CASE NUMBER!\n  Back to the previous menu\n.");
				runStep1();
		}
	}
	
	
	public void runStep2() throws Exception
	{
		runStep1();
		System.out.println(" <<Main Menu>>\n"
				+ "  1. Purchase Coupon\n"
				+ "  2. Search Coupon\n"
				+ "  3. List Inventory(whith ascending)\n"
				+ "  4. Delete Coupon\n"
				+ "  5. Total Final Price calculator\n"
				+ "  6. High discount rate Coupon Search\n"
				+ "Enter>");
		
		BufferedReader swConsole = new BufferedReader(new InputStreamReader(System.in));
		String temp_switch = swConsole.readLine();
		Integer real_switch = Integer.valueOf(temp_switch);	


		switch(real_switch) 
		{
			case 1: 
				System.out.println(" <<Purchase Coupon>>\n"
						+ "  1. Add coupons from file(Data is imported from 'src/Common/PurchaseCouponTestFile.txt')\n"
						+ "  2. Manually add your coupons\n"
						+ "Enter>");
				BufferedReader pcConsole = new BufferedReader(new InputStreamReader(System.in));
				String pcTemp = pcConsole.readLine();
				Integer pcReal = Integer.valueOf(pcTemp);
					switch(pcReal) 
					{
						case 1: 
							user.purchaseCoupon_Auto();
							break;
						case 2: 
							user.purchase_manual();
							break;
						default:
							System.out.println("Wrong case number! back to the <<Main Menu>>\n.");
							runStep2();
					}//case 1 end
					runStep3();
			case 2:
				user.searchCoupon();
				runStep3();
				break;
			case 3:
				System.out.println("Select your feature to sort\n"
						+ "  1. Provider Name\n"
						+ "  2. Product Name\n"
						+ "  3. Price\n"
						+ "  4. Discount rate\n"
						+ "  5. Experation Period\n"
						+ "  6. Status\n"
						+ "  7. Final Price\n"
						+ "Enter>");
				BufferedReader lsConsole = new BufferedReader(new InputStreamReader(System.in));
				String lsTemp = lsConsole.readLine();
				Integer lsReal = Integer.valueOf(lsTemp);
					switch(lsReal) 
					{
						case 1: 
							user.SL_providerName();
							break;
						case 2: 
							user.SL_productName();
							break;
						case 3: 
							user.SL_price();
							break;
						case 4: 
							user.SL_discountRate();
							break;
						case 5: 
							user.SL_expPeriod();
							break;
						case 6: 
							user.SL_status();
							break;
						case 7: 
							user.SL_finalPrice();
							break;
						default:
							System.out.println("Wrong case number! back to the <<Main Menu>>\n.");
							runStep2();
					}//case 3 end
					runStep3();
			case 4:
				user.deleteCoupon();
				runStep3();
				break;
			case 5:
				user.Customer();
				runStep3();
				break;
			case 6:
				user.findNicecoupon();
				runStep3();
				break;
			default:
				System.out.println("Wrong case number! back to the <<>Main Menu>\n.");
				runStep2();

		}
	}
	
	public void runStep3() throws Exception 
	{
		System.out.println(" <<Main Menu>>\n"
				+ "  1. Purchase Coupon\n"
				+ "  2. Search Coupon\n"
				+ "  3. List Inventory(whith ascending)\n"
				+ "  4. Delete Coupon\n"
				+ "  5. Total Final Price calculator\n"
				+ "  6. High discount rate Coupon Search\n"
				+ "Enter>");
		
		BufferedReader swConsole = new BufferedReader(new InputStreamReader(System.in));
		String temp_switch = swConsole.readLine();
		Integer real_switch = Integer.valueOf(temp_switch);	


		switch(real_switch) 
		{
			case 1: 
				System.out.println(" <<Purchase Coupon>>\n"
						+ "  1. Add coupons from file\n"
						+ "  2. Manually add your coupons\n"
						+ "Enter>");
				BufferedReader pcConsole = new BufferedReader(new InputStreamReader(System.in));
				String pcTemp = pcConsole.readLine();
				Integer pcReal = Integer.valueOf(pcTemp);
					switch(pcReal) 
					{
						case 1: 
							user.purchaseCoupon_Auto();
							break;
						case 2: 
							user.purchase_manual();
							break;
						default:
							System.out.println("Wrong case number! back to the <<>Main Menu>\n.");
							runStep2();
					}//case 1 end
					runStep3();
			case 2:
				user.searchCoupon();
				runStep3();
				break;
			case 3:
				System.out.println("Select your feature to sort\n"
						+ "  1. Provider Name\n"
						+ "  2. Product Name\n"
						+ "  3. Price\n"
						+ "  4. Discount rate\n"
						+ "  5. Experation Period\n"
						+ "  6. Status\n"
						+ "  7. Final Price\n"
						+ "Enter>");
				BufferedReader lsConsole = new BufferedReader(new InputStreamReader(System.in));
				String lsTemp = lsConsole.readLine();
				Integer lsReal = Integer.valueOf(lsTemp);
					switch(lsReal) 
					{
						case 1: 
							user.SL_providerName();
							break;
						case 2: 
							user.SL_productName();
							break;
						case 3: 
							user.SL_price();
							break;
						case 4: 
							user.SL_discountRate();
							break;
						case 5: 
							user.SL_expPeriod();
							break;
						case 6: 
							user.SL_status();
							break;
						case 7: 
							user.SL_finalPrice();
							break;
						default:
							System.out.println("Wrong case number! back to the <<Main Menu>>\n.");
							runStep2();
					}//case 3 end
					runStep3();
			case 4:
				user.deleteCoupon();
				runStep3();
				break;
			case 5:
				user.Customer();
				runStep3();
				break;
			case 6:
				user.findNicecoupon();
				runStep3();
				break;
			default:
				System.out.println("Wrong case number! back to the <<Main Menu>>\n.");
				runStep2();
		}
	}
}
