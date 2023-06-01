package test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.TechfiosTestPage;
import util.BrowserFactory;

public class TechfiosTest{
    
	WebDriver  driver;
	TechfiosTestPage techfiostestpage;
	
	@Before
	public void init() {
		driver = BrowserFactory.initDriver();
		techfiostestpage = PageFactory.initElements(driver, TechfiosTestPage.class);
	}
	
	//Test 1: Validate when the toggle all check box is CHECKED, all check boxes for list items are also CHECKED ON.
	@Test 
	public void validatingTaggleAllBox() {
		  
	      techfiostestpage.clickOnTaggleAllBox();
	      techfiostestpage.clickonRemoveButton();
	      techfiostestpage.addItemToTheListBox("Test1");
	      techfiostestpage.clickOnAddButton();
	      techfiostestpage.addItemToTheListBox("Test2");
	      techfiostestpage.clickOnAddButton();
	      techfiostestpage.addItemToTheListBox("Test3");
	      techfiostestpage.clickOnAddButton();
	      techfiostestpage.clickOnTaggleAllBox();
	      techfiostestpage.validatingAllCheckBoxCheckedOnOrNot();    
	}
	
	
	//Test 2: Validate that a single list item could be removed using the remove button when a single checkbox is selected.
	@Test
	public void validatingRemovingSingleItemFromTheList() throws InterruptedException {
		  
		  techfiostestpage.addItemToTheListBox("Test4");
	      techfiostestpage.clickOnAddButton();
	      techfiostestpage.checkingOnOneItemInList();
	      techfiostestpage.clickonRemoveButton();
	      Thread.sleep(2000);
	      techfiostestpage.validatingOneCheckBoxItemRemovedOrNot();
	}
	
	//Test 3: Validate that all list item could be removed using the remove button and 
	// when "Toggle All" functionality is on.

	@Test 
	public void validatingAllListItemsRemovedWithTaggleAllBoxOn() {
		  
		  techfiostestpage.clickOnTaggleAllBox();
		  techfiostestpage.clickonRemoveButton();
		  techfiostestpage.addItemToTheListBox("Test1");
	      techfiostestpage.clickOnAddButton();
	      techfiostestpage.addItemToTheListBox("Test2");
	      techfiostestpage.clickOnAddButton();
	      techfiostestpage.addItemToTheListBox("Test3");
	      techfiostestpage.clickOnAddButton();
	      techfiostestpage.clickOnTaggleAllBox();
	      techfiostestpage.clickonRemoveButton();
	      techfiostestpage.validatingToggleAllSelectedItemsRemovedOrNot();   
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
}
 