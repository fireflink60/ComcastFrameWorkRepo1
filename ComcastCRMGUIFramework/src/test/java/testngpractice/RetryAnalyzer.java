package testngpractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzer {
	
	    @Test(retryAnalyzer =com.comcast.crm.listenerutility.ListImpClass.class)
	    public void createInnvoicetest() {
	    	Assert.fail();
	    	
	    	
	    }

}
