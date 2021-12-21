package projectOne;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\eclipse ide\\chrome_driver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/practice.php ");
		exerciseOne(driver);
		exerciseTwo(driver);
		exerciseThree(driver);
		exerciseFour(driver);
		exerciseFourPointOne(driver);
		exerciseFourPointTwo(driver);
		exerciseFive(driver);
		exerciseSix(driver);
		exerciseSeven(driver);
		exerciseEight(driver);
		exerciseNine(driver);

	}
	public static void exerciseOne(WebDriver driver){
			driver.findElement(By.xpath("//input[@value='radio1']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@value='radio1']")).isSelected());
		driver.findElement(By.xpath("//input[@value='radio2']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@value='radio2']")).isSelected());
		driver.findElement(By.xpath("//input[@value='radio3']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@value='radio3']")).isSelected());
	}
	public static void exerciseTwo(WebDriver driver) throws InterruptedException{
		driver.findElement(By.id("autocomplete")).sendKeys("United States");
		Thread.sleep(2000);
		 List<WebElement> eles = driver.findElements(By.xpath("//ul/li[@class='ui-menu-item']"));
		for( WebElement ele: eles){
			if(ele.getText().equalsIgnoreCase("United States Minor Outlying Islands")){
				ele.click();
				break;
			}
		}
		if(driver.findElement(By.id("autocomplete")).getAttribute("value").equalsIgnoreCase("United States Minor Outlying Islands")){
			System.out.println("correct value selected");
		}
	}
	public static void exerciseThree(WebDriver driver){
		WebElement dp = driver.findElement(By.id("dropdown-class-example"));
		Select drop = new Select(dp);
		drop.selectByIndex(1);
		String op1 = drop.getFirstSelectedOption().getText();
		if(op1.equals("Option1")){
			System.out.println("Option1 is selected");
		}
			drop.selectByIndex(2);
		String op2 = drop.getFirstSelectedOption().getText();
		if(op2.equals("Option2")){
			System.out.println("Option2 is selected");
		}
			drop.selectByIndex(3);
		String op3 = drop.getFirstSelectedOption().getText();
		if(op3.equals("Option3")){
			System.out.println("Option3 is selected");
		}
	}
	public static void exerciseFour(WebDriver driver){
		    	   	driver.findElement(By.name("checkBoxOption1")).click();
	   	boolean checked = driver.findElement(By.name("checkBoxOption1")).isSelected();
	   	if(checked==true){
	   		System.out.println("checkbox 1 is checked");
	   	}
	   	driver.findElement(By.name("checkBoxOption1")).click();
	   	boolean verify = driver.findElement(By.name("checkBoxOption1")).isSelected();
	   if(verify==false){
	   	System.out.println("checkbox 1 is unchecked");
	   }
	   driver.findElement(By.name("checkBoxOption2")).click();
	   boolean checked1 = driver.findElement(By.name("checkBoxOption2")).isSelected();
	   if(checked1==true){
	   	System.out.println("checkbox 2 is checked");
	   }
	   driver.findElement(By.name("checkBoxOption2")).click();
	   boolean verify1 = driver.findElement(By.name("checkBoxOption2")).isSelected();
	   if(verify1==false){
	   System.out.println("checkbox 2 is unchecked");
	   }

	   driver.findElement(By.name("checkBoxOption3")).click();
	   boolean checked2 = driver.findElement(By.name("checkBoxOption3")).isSelected();
	   if(checked2==true){
	   	System.out.println("checkbox 3 is checked");
	   }
	   driver.findElement(By.name("checkBoxOption3")).click();
	   boolean verify2 = driver.findElement(By.name("checkBoxOption3")).isSelected();
	   if(verify2==false){
	   System.out.println("checkbox 3 is unchecked");
	   }
	   
	}
	
	public static void exerciseFourPointOne(WebDriver driver){
		  		List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		    for(int i=0;i<boxes.size();i++){
		    	boxes.get(i).click();
		    }
		    for(int i=0;i<boxes.size();i++){
		    boolean as = boxes.get(i).isSelected();
		    	if(as==true){
		    		System.out.println("checkbox "+(i+1)+" is selected");
		    	}
		    }
		    for(int i=0;i<boxes.size();i++){
		    	boxes.get(i).click();}
	}
	public static void exerciseFourPointTwo(WebDriver driver){
List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
    for(int i=0;i<boxes.size();i++){
    	boxes.get(i).click();
    }
    for(int i=0;i<boxes.size();i++){
    boolean as = boxes.get(i).isSelected();
    	if(as==true){
    		System.out.println("checkbox "+(i+1)+" is checked");
    	}
    	
    }
    for(int i=0;i<boxes.size();i++){
    	boxes.get(i).click();
    }
    for(int i=0;i<boxes.size();i++){
    boolean as = boxes.get(i).isSelected();
    	if(as==false){
    		System.out.println("checkbox "+(i+1)+" is unchecked");
    	}
    }
		
	}
	
	public static void exerciseFive(WebDriver driver){
		driver.findElement(By.id("openwindow")).click();
	    Set<String> windows = driver.getWindowHandles();
	  Iterator<String> it = windows.iterator();
	  String pId = it.next();
	 String cId = it.next();
	driver.switchTo().window(cId);
	if(driver.getTitle().equalsIgnoreCase("QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy")){
		System.out.println("New page opened");
	}
		driver.close();
		driver.switchTo().window(pId);
		if(driver.getTitle().equalsIgnoreCase("Practice Page")){
			System.out.println("back to original page");
		}
	}


	public static void exerciseSix(WebDriver driver){

		 driver.findElement(By.id("opentab")).click();
		 Set<String> windows = driver.getWindowHandles();
		 Iterator<String> it = windows.iterator();
		 String pId = it.next();
		String cId = it.next();
		driver.switchTo().window(cId);
		if(driver.getTitle().equalsIgnoreCase("Rahul Shetty Academy")){
			System.out.println("new page opened");
			driver.close();
			}
		driver.switchTo().window(pId);
		if(driver.getTitle().equalsIgnoreCase("Practice Page")){
			System.out.println("back to original page");
		}
	}


	public static void exerciseSeven(WebDriver driver){
		 driver.findElement(By.id("name")).sendKeys("Mady");
		    driver.findElement(By.id("alertbtn")).click();
		  System.out.println(driver.switchTo().alert().getText());
		  driver.switchTo().alert().accept();
	}


	public static void exerciseEight(WebDriver driver){
	JavascriptExecutor je = (JavascriptExecutor) driver;
	je.executeScript("window.scroll(0,600)");
	WebElement table = driver.findElement(By.id("product"));
	List<WebElement> fr = table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th"));
	System.out.println(fr.get(0).getText());
	System.out.println(fr.get(1).getText());
	System.out.println(fr.get(2).getText());
	List<WebElement> sr = table.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td"));
	System.out.println(sr.get(0).getText());
	System.out.println(sr.get(1).getText());
	System.out.println(sr.get(2).getText());
	List<WebElement> tr = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
	System.out.println(tr.get(0).getText());
	System.out.println(tr.get(1).getText());
	System.out.println(tr.get(2).getText());
	List<WebElement> four = table.findElements(By.tagName("tr")).get(3).findElements(By.tagName("td"));
	System.out.println(four.get(0).getText());
	System.out.println(four.get(1).getText());
	System.out.println(four.get(2).getText());
	List<WebElement> fir = table.findElements(By.tagName("tr")).get(4).findElements(By.tagName("td"));
	System.out.println(fir.get(0).getText());
	System.out.println(fir.get(1).getText());
	System.out.println(fir.get(2).getText());
	List<WebElement> sir = table.findElements(By.tagName("tr")).get(5).findElements(By.tagName("td"));
	System.out.println(sir.get(0).getText());
	System.out.println(sir.get(1).getText());
	System.out.println(sir.get(2).getText());
	List<WebElement> ser = table.findElements(By.tagName("tr")).get(6).findElements(By.tagName("td"));
	System.out.println(ser.get(0).getText());
	System.out.println(ser.get(1).getText());
	System.out.println(ser.get(2).getText());
	List<WebElement> eir = table.findElements(By.tagName("tr")).get(9).findElements(By.tagName("td"));
	System.out.println(eir.get(0).getText());
	System.out.println(eir.get(1).getText());
	System.out.println(eir.get(2).getText());
	List<WebElement> nir = table.findElements(By.tagName("tr")).get(10).findElements(By.tagName("td"));
	System.out.println(nir.get(0).getText());
	System.out.println(nir.get(1).getText());
	System.out.println(nir.get(2).getText());
	}

	public static void exerciseNine(WebDriver driver){
	 JavascriptExecutor je = (JavascriptExecutor)driver;
	   je.executeScript("window.scroll(0,1200)");
	   WebElement mh = driver.findElement(By.id("mousehover"));
	Actions act = new Actions(driver);
	act.moveToElement(mh).build().perform();
	WebElement top = driver.findElement(By.xpath("//a[@href='#top']"));
	act.moveToElement(top).click().build().perform();

	}

}
