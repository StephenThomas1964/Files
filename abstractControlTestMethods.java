package simpleWebsite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.*;


import org.openqa.selenium.By;


public abstract class abstractControlTestMethods {

	//Fields
	
	//private WebDriver driver = null;
	//private String input = null;
	//public String returned_selection = null;
	//public WebElement web_element;
	public String inputString, returnedString, returnedString2;
	
	       
    //Links lines and headers	
		
	
	public void clicker(WebElement buttonElement) {
		buttonElement.click();
	}
	
	

	public String textValue(WebElement textOnLine) {
		return textOnLine.getText();
		
	}
	
	
	
	
	//the two following methods interact with the dropdown implementation
	
	public void  selectDropdown(String x, WebElement y) {
		Select my_select = new Select(y);
		my_select.selectByVisibleText(x);
		
	}
	
	public String chosen(WebElement element) {
		Select my_select = new Select(element);
		WebElement temp = (my_select.getAllSelectedOptions()).get(0);
		returnedString = temp.getText();
    	return returnedString;
			
		
	}
	
	public String bakColour(WebElement inputString) {
		
		returnedString2 = inputString.getCssValue("background-color");
		String hexValue = Color.fromString(returnedString2).asHex();
		return hexValue;
		//(see https://stackoverflow.com/questions/23220575/how-to-get-element-color-with-selenium)
		
	}
	
	//The table should always have the following format: 
		//<table>
			//<tr>
				//<th>heading1</th>
				//<th>heading2</th>
				//<th>heading3</th>
			//</tr>
			//<tr>
				//<td>value1</td>
				//<td>value2</td>
				//<td>value3</td>
			//</tr>
		//</table>
	
	//...but can have any number of rows and columns
	
	//Pass the table element to this method. Pick out the th (tag for the headings) row. By obtaining size of the list of headings .... return how many headings 
	
	public int tableHeadingSize (WebElement tableElement1){
		List<WebElement> row = tableElement1.findElements(By.cssSelector("tr"));
		List<WebElement> headings = row.get(0).findElements(By.cssSelector("th"));
		int numberOfHeadings = headings.size();
		return numberOfHeadings;		
	};
	
	//Pass the table element to this method. Pass in also Cell position (column number and row number). Return cell content

	
	public String tableData (int columnNumber, int rowNumber, WebElement tableElement2){
		List<WebElement> row = tableElement2.findElements(By.cssSelector("tr"));
		List<WebElement> unique = row.get(rowNumber).findElements(By.cssSelector("td"));
		String valueToReturn = unique.get(columnNumber).getText();
		return valueToReturn;		
	};
	
	//...Later on ... might need to convert the string to an int (but this can be done in calling test) 
	
	//Pass the table element to this method. Pick out one of the the rows (row 0). identify row by using tr. Find out number of columns it has   ....
	
	public int tableColumnNumber (WebElement tableElement3){
		List<WebElement> rowCount = tableElement3.findElements(By.cssSelector("tr"));
		List<WebElement> columnCount = rowCount.get(0).findElements(By.cssSelector("td")); //only need to count one row
		int columnsToReturn = columnCount.size();
		return columnsToReturn;
				
	};
	
	//tested? 
	
	//Pass the table element to this method. Pick out all the tr's (the rows). Count these up and return the number of rows ....
	
	public int tableRowNumber (WebElement tableElement4){
		List<WebElement> rowCount = tableElement4.findElements(By.cssSelector("tr"));
		int RowToReturn = rowCount.size();
		return RowToReturn;
	}
	
	//Pass the table element to this method. Pick out the th (tag for the headings) row. Using the columnNumber2 parameter select and return a specific one of these  ....
	
	public String tableHeadingvalue (int columnNumber2, WebElement tableElement5) {
		List<WebElement> columnHeaders = tableElement5.findElements(By.cssSelector("tr"));
		List<WebElement> headLiners = columnHeaders.get(0).findElements(By.cssSelector("th"));
		String headerToReturn = headLiners.get(columnNumber2).getText();
		return headerToReturn;
				
		
	}

	public void bakColour2() {
		// TODO Auto-generated method stub
		
	};
}
	