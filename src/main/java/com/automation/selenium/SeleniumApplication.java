package com.automation.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.logging.Logger;

@SpringBootApplication
public class SeleniumApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeleniumApplication.class, args);

		Logger LOGGER = Logger.getLogger("SELENIUM-APP");
//		String chromeDriverPath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";

//		System.setProperty("webdriver.chrome.driver",chromeDriverPath);

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.setCapability("browserVersion", "123");
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-gpu");

		WebDriver driver = new ChromeDriver(options);


		LOGGER.info(" : : Driver Setup");

		driver.get("https://github.com");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        LOGGER.info(" : : Gone to github");

		driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div[2]/div/div/div/a")).click();

		LOGGER.info(" : : Gone to Sign-in");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		driver.findElement(By.xpath("//*[@id=\"login_field\"]")).sendKeys("your-github-mail-id");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("your-github-password");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		driver.findElement(By.xpath("//*[@id=\"login\"]/div[4]/form/div/input[13]")).click();


		LOGGER.info(" : : mail-password and entered");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		driver.findElement(By.xpath("/html/body/div[1]/div[6]/div/div/aside/div/div/loading-context/div/div[1]/div/div[1]/a/span/span[2]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		LOGGER.info(" : : gone to new repository");

		driver.findElement(By.xpath("//*[@id=\":r3:\"]")).sendKeys("My-test-repo1");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		LOGGER.info(" : : entered name for new repository");
		driver.findElement(By.xpath("/html/body/div[1]/div[6]/main/react-app/div/form/div[5]/button/span/span")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}


		LOGGER.info(" : : created new repository");


		driver.quit();

	}

}
