package retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class Retry  implements IRetryAnalyzer {//methodne over ride cheum, implement interface
	private static final Logger LOG = LogManager.getLogger("Retry.class"); //oro attemptineum retry cheyan logger kodukum
	private static final int maxTry = 2;  //fail ayal extra 2 time run..maximum 3 time
	private int count = 0;//   counted attempts   tracked         
	public boolean retry(final ITestResult iTestResult) {  //test case result provided by itestresult-inteface
		if (!iTestResult.isSuccess()) {     //successsallenkil 
			if (this.count < maxTry) {       
				LOG.info("Retrying test " + iTestResult.getName() + " with status "
						+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");
				this.count++;
				return true; 
			}
		}
		return false;  	}

	public String getResultStatusName(final int status) {
		String resultName = null;
		if (status == 1) {
			resultName = "SUCCESS";
		}
		if (status == 2) {
			resultName = "FAILURE";
		}
		if (status == 3) {
			resultName = "SKIP";
		}
		return resultName;
	}

}
