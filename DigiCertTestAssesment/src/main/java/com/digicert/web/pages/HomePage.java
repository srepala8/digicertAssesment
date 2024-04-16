package com.digicert.web.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

	WebDriver driver;
	@FindBy(xpath = "//tbody")
	WebElement MoviesList;

	@FindBy(xpath = "/html/body/section/main/div[2]")
	WebElement PhantomMoviesList;

	@FindBy(xpath = "/html/body/section/main/div[2]/div[3]")
	WebElement SpiecesList;

	@FindBy(xpath = "//a[normalize-space()='The Empire Strikes Back']")
	WebElement TheEmpire;

	@FindBy(xpath = "//a[normalize-space()='The Phantom Menace']")
	WebElement ThePhantom;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getHomePageUrl() {
		try {
			return (driver.getCurrentUrl());

		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public void getTitlesofMovies() {
		ArrayList<String> obtainedList = new ArrayList<>();
		List<WebElement> elementList = driver.findElements(By.xpath("//tbody"));
		for (WebElement we : elementList) {
			obtainedList.add(we.getText());
		}
		ArrayList<String> sortedList = new ArrayList<>();
		for (String s : obtainedList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList);
		Assert.assertTrue(sortedList.equals(obtainedList));

	}

	public void clickonThePhantomMenaceLink() {
		ThePhantom.click();

	}

	public void wookieOnspeciesList() throws InterruptedException {

		List<WebElement> elementList = driver.findElements(By.xpath("/html/body/section/main/div[2]/div[3]"));
		Thread.sleep(3000);
		for (WebElement we : elementList) {
			if (we.getText().equals("Wookie")) {
				System.out.println("Wookie present on spicies list");
				break;
			}

		}

	}

	public void thePhantomList() throws InterruptedException {

		List<WebElement> List = driver.findElements(By.xpath("/html/body/section/main/div[2]"));
		Thread.sleep(3000);
		for (WebElement wl : List) {
			if ((wl.getText().contains("Planets")) || (wl.getText().contains("Camino"))) {
				System.out.println("Planets and Camino present on the list");
				break;
			} else {
				System.out.println("Planets and Camino not present on the list");
			}

		}

	}

	public void clickonTheEmpiresStrikesBackLink() {

		TheEmpire.click();
	}
}
