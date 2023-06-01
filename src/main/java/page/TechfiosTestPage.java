package page;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TechfiosTestPage {

	WebDriver driver;
	String beforeItemNum_CSS = "input[name='todo[";
	String afterItemNum_CSS = "]']";
	
	public TechfiosTestPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy (how=How.CSS,using="input[value='Remove']") WebElement REMOVE_ITEM_ELEMENT;
	@FindBy (how=How.CSS, using="input[name='allbox']") WebElement TOGGLE_ALL_BOX_ELEMENT;
	@FindBy (how=How.CSS, using="input[name='data']") WebElement ADD_ITEM_ELEMENT;
	@FindBy (how=How.CSS, using="input[value='Add']") WebElement ADD_BUTTON_ELEMENT;
	@FindBy (how=How.CSS, using="input[name='todo[0]']") WebElement ONE_CHECKBOX_ITEM_IN_LIST_SELECTED_ELEMENT;
	
	By onecheckbox = By.cssSelector("input[name='todo[3]']");
	
	public void clickonRemoveButton() {
		REMOVE_ITEM_ELEMENT.click();
	}

	public void addItemToTheListBox(String itemName) {
		ADD_ITEM_ELEMENT.sendKeys(itemName);
	}

	public void clickOnAddButton() {
		ADD_BUTTON_ELEMENT.click();
	}

	public void clickOnTaggleAllBox() {
		TOGGLE_ALL_BOX_ELEMENT.click();
	}

	public void validatingAllCheckBoxCheckedOnOrNot() {

		for (int i = 0; i < 3; i++) {
			Boolean itemCheckedOnStaus = driver.findElement(By.cssSelector(beforeItemNum_CSS + i + afterItemNum_CSS))
					.isSelected();
			// System.out.println("status of item checked on " + itemCheckedOn);

			if (itemCheckedOnStaus == true) {
				System.out.println("All items in checkBox are checked on");
			} else {
				System.out.println("All items in checkBox are not checked on");
			}
		}

	}

	public void checkingOnOneItemInList() {
		ONE_CHECKBOX_ITEM_IN_LIST_SELECTED_ELEMENT.click();
	}

	public boolean validatingOneCheckBoxItemRemovedOrNot() {

//		boolean itemRemovedStatus = ONE_CHECKBOX_ITEM_IN_LIST_SELECTED_ELEMENT.isSelected();
//		if (itemRemovedStatus != true) {
//			System.out.println(" One item is removed from the checkBox list");
//		} else {
//			System.out.println("One item is not removed from the checkBox list");
//		}
//	
		try {

			return ONE_CHECKBOX_ITEM_IN_LIST_SELECTED_ELEMENT.isSelected();

		} catch (NoSuchElementException e) {
			System.out.println("selected item is not present in the list, it removed successfully");
			return false;
		}
	}

	public void validatingToggleAllSelectedItemsRemovedOrNot() {

		try {
			for (int i = 0; i < 3; i++) {
				boolean itemsRemovedStatus = driver
						.findElement(By.cssSelector(beforeItemNum_CSS + i + afterItemNum_CSS)).isSelected();
				if (itemsRemovedStatus == true) {
					System.out.println("Toggle All selected items in list are not removed");
				} else {
					System.out.println("Toggle All selected items in list are not removed");
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("\"Toggle All & Remove\" items have been removed. Items do not exist");

		}

	}

}
