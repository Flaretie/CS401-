package Common;
import java.io.FileNotFoundException;
import java.io.IOException;


public interface FuncInterface<T> {
	
	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws Exception
	 */
	public void  ULconstructor() throws FileNotFoundException, Exception; 
	
	public void ULconstructor_manual_capacity() throws Exception;
	
	public void sortedMLconstructor();
	public void purchaseCoupon_Auto() throws FileNotFoundException;
	
	public void purchase_manual() throws Exception;
	
	public void searchCoupon() throws IOException;
	public void SL_providerName();
	public void SL_productName();
	
	public void SL_status();
	public void SL_finalPrice();
	
	public void SL_price();
	public void SL_discountRate();
	public void SL_expPeriod();
	public void Customer() throws IOException;
	public void findNicecoupon() throws IOException;
	
	public void deleteCoupon() throws IOException;
	
}
