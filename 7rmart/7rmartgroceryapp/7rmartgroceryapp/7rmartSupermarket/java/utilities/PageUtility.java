package utilities;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public String selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}
	public String selectDropdownWithIndex(WebElement element, String value,int index)
	{
		Select object = new Select(element);
		object.selectByIndex(index);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
		
	}
	public String selectDropdownWithVisibleText(WebElement element, String value)
	{
		Select object = new Select(element);
		object.selectByVisibleText(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
		
	}
	
	public void javascriptclick(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	public void javascriptScrolldown(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)","");
		}
	public void javascriptScrollup(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,-350)","");
	}
	public void javascriptScrolltoleftside(WebElement button,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(500,0)","");
	}
	public void javascriptScrolltorightside(WebElement button,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)","");
	}
	public void actionclick(WebDriver driver,WebElement element )
	{
		Actions action=new Actions(driver);
		
		action.moveToElement(element).click().perform();
	}
	public void actionrightclick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		
		action.contextClick(element).perform();
	}
	public void actiondoubleclick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		
		action.doubleClick(element).perform();
	}
	public void dragAndDrop(WebDriver driver,WebElement element,WebElement element1)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(element, element1).perform();
	}
	public String generateCurrentDateAndTime() {
    	Date date = new Date(0);
    	SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
    	return formatter.format(date);
	}
	public void alert(WebDriver driver)
	{
	driver.switchTo().alert().accept();
	}
}













































































































































































