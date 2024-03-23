package mini_project;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MiniProject {


	public static void main(String[] args) throws InterruptedException {
		//We handled multiple browsers using switch case
		Scanner sc = new Scanner(System.in);
		WebDriver driver= null;
		boolean bool=true;
		do{
			System.out.println("Select the browser you want to use:-");
			System.out.println("1) Google Chrome");
			System.out.println("2) Edge");
			System.out.println("Enter the browser you want to use: ");
			int browser= sc.nextInt();
			switch(browser) {
				case 1:{
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					bool=false;
					break;
				}
				case 2:{
					WebDriverManager.edgedriver().setup();
					driver=new EdgeDriver();
					bool=false;
					break;
				}
				default:{
					System.out.println("Enter a valid Web Browser......");
				}
			}
		}while(bool);
		//We are entering into the website which we are going to automate
		driver.get("http://demo.automationtesting.in/Alerts.html");
		//We used implicit wait to wait for a certain measure of time before throwing an exception
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//We are hovering the mouse over the "SwitchTo" menu in this step and click on Alerts option
		Actions a=new Actions(driver);
		WebElement e1=driver.findElement(By.xpath("//li[4]/a[@href='SwitchTo.html']"));
		a.moveToElement(e1).perform();
		//Then we click on "Alerts with OK" option
		driver.findElement(By.xpath("//a[@href=\"#OKTab\"]")).click();
		//Then we click on "click the button to display an alert box:"
		driver.findElement(By.xpath("//button[@class=\"btn btn-danger\"]")).click();
		//We checked whether alert pop-up appears or not by printing the text on the alert box
		String s1=driver.switchTo().alert().getText();
		System.out.println(s1);
		//Then we clicked on okay by using .accept
		driver.switchTo().alert().accept();
		//Then we clicked on the link "Alert with OK & Cancel"
		driver.findElement(By.xpath("//a[@href=\"#CancelTab\"]")).click();
		//Then we Click on the link "click the button to display a confirm box"
		driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
		//We checked whether alert pop-up appears or not by using getText
		String s2=driver.switchTo().alert().getText();
		System.out.println(s2);
		//Then we clicked on cancel by using dismiss
		driver.switchTo().alert().dismiss();
		//The respective message is displayed here
		String s3=driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(s3);
		//We click on "Alert with Text-box" here
		driver.findElement(By.xpath("//a[@href=\"#Textbox\"]")).click();
		//Then we clicked on "click the button to demonstrate the prompt box"
		driver.findElement(By.xpath("//button[@onclick=\"promptbox()\"]")).click();
		//Here we have checked whether prompt box pop-up appeared or not by getting the text of the prompt box.
		String s4=driver.switchTo().alert().getText();
		System.out.println(s4);
		//Then we entered the name here and clicked on ok
		driver.switchTo().alert().sendKeys("Shamik Roy");
		driver.switchTo().alert().accept();
		//Then we checked if the message Hello <my name>(Shamik Roy) How are you today” is displayed by printing it
		String s5=driver.findElement(By.xpath("//p[@id=\"demo1\"]")).getText();
		System.out.println(s5);
		//Then we closed the browser
		sc.close();
		driver.quit();
	}
}
