package AmazonPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazon {
	
	public static String URL = "https://amazon.in";
	public static String Search = "Wrist Watches";
	public static WebDriver driver;
	public static String browser = "Chrome";
	
	public static void main(String[] args) {

		if (browser.equals("Chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(options);
			
		}

		else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("MicrosoftEdge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.get(URL);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys(Search);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement button = driver.findElement(By.id("nav-search-submit-button"));
		button.click();
		new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement brand = driver.findElement(By.xpath("//*[@id=\"p_89/Titan\"]/span/a/span"));
		brand.click();
		new WebDriverWait(driver, Duration.ofSeconds(10));
		
		Actions actions = new Actions(driver);    // PERFORMING ACTIONS TO SCROLL UP AND DOWN IN  A WEB PAGE //
		actions.scrollByAmount(0, 1500).perform();
		
		WebElement display = driver.findElement(By.xpath("//*[@id=\"p_n_feature_seven_browse-bin/1480900031\"]/span/a/span"));
		display.click();
		new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement BrandMaterial = driver.findElement(By.xpath("//*[@id=\"p_n_material_browse/1480907031\"]/span/a/span"));
		BrandMaterial.click();
		new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions actions1 = new Actions(driver);
		actions1.scrollByAmount(0,0).perform();
		
		 // WAITING FOR THE VISIBILITY OF THE ELEMENT TO PERFORM ACTION //
		WebElement discount =  wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"filters\"]/ul[4]")));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"filters\"]/ul[4]/span[2]")))).click();
		discount.isDisplayed();
		discount.isEnabled();
		discount.isSelected();
		System.out.println(discount.isDisplayed());
		System.out.println(discount.isEnabled());
		System.out.println(discount.isSelected());
		
		Actions actions2 = new Actions(driver);
		actions2.scrollByAmount(0, 0).perform();
		
		WebElement product = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[6]/div/div/div/div/div[2]/div[1]/h2/a"));
		product.getText();
		System.out.println(product.getText());
	}
}
