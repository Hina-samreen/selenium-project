package de.ecom.testfaelle;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import de.ecom.testbasis.TestBasis;

public class Tf02_KostenVergleichTest extends TestBasis {
	
	@Test
	public void kostenVergleichTest() {
		
		String MobileTitle;
		String MobileCostListPage="";
		String MobileCostDetailsPage;
		
		//click on mobile menu
		mainpage.mobileBtnClick();
	
		//in the list of all mobile read the cost of sony xperia mobile. Note this value
		String[] mobileTitles= mobilepage.getTitleOfMobileElements();
		String[] mobileCosts=mobilepage.getCostsOfMobiles();
		
		for(int i=0;i<mobileTitles.length;i++) {
				
			MobileTitle=mobileTitles[i];

				if(MobileTitle.equalsIgnoreCase("xperia"))
				{
					MobileCostListPage=mobileCosts[i];
					System.out.println("Mobile Cost in mobile page"+MobileCostListPage);
				}
			}
					

		
		//click on SonyXperia mobile to navigate to details page
		mobilepage.clickXperiaIcon();
		
		//read the SonyXperia mobile cost from detail page and note it
		MobileCostDetailsPage= mobileDetailsPage.getPriceXperia();
		
		System.out.println("Mobile Cost in detail page"+MobileCostDetailsPage);
		//compare values of mobileCost in List page and details page. Both should be same
		assertTrue(MobileCostDetailsPage.equalsIgnoreCase(MobileCostListPage), "The costs in detail and lists page are not equal");
				
		
		
	}

}
