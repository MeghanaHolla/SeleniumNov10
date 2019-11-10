package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import utils.GenericMethods;

public class Application {

	@Test
	public void verifyInvalidLogin() throws IOException {
		String[][] data = GenericMethods.getData("D:\\SelOct13\\TestData2.xlsx", "Sheet1");
		for(int i = 1;i<data.length;i++) {
			//Making changes to the code after R1.1
			switch(data[i][3]) {
			case "openBrowser":
				Methods.openBrowser();
				break;
			case "maxBrowser":
				Methods.maximizeBrowserWindow();
				break;
			case "impWait":
				Methods.implicitWait();
				break;
			case "navigateToApp":
				Methods.navigateToAUT(data[i][6]);
				break;
			case "enterUserID":
				Methods.enterUserID(data[i][4],data[i][5], data[i][6]);
				break;
			case "enterPassword":
				Methods.enterPassword(data[i][4],data[i][5], data[i][6]);
				break;
			case "clickLogin":
				Methods.clickLoginButton(data[i][4],data[i][5]);
				break;
			case "verifyErrMsg":
				String actualMsg = Methods.verifyErrorMessage(data[i][5]);
				String expectedMsg = data[i][6];
				Assert.assertEquals(expectedMsg, actualMsg);
				break;
			case "closeBrowser":
				Methods.closeBrowser();
				break;
			}
		}
	}
}
