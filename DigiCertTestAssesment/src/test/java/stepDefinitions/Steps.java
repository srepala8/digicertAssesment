package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.digicert.web.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

	WebDriver driver;

	HomePage homepage;

	@Given("User Launch browser")
	public void user_launch_browser() {

		driver = new ChromeDriver();
		homepage = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Given("opens URL {string}")
	public void opens_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("User Navigates to SatrWars page")
	public void user_navigates_to_satr_wars_page() {
		System.out.println("User was on starwars home page");

	}

	@Then("User should be on the page with the currentUrl")
	public void user_should_be_on_the_page_with_the_current_url() {
		homepage = new HomePage(driver);
		String exp_url = homepage.getHomePageUrl();
		Assert.assertEquals(exp_url, "http://localhost:3000/");
	}

	@Then("User observes the list of Title of Movies")
	public void user_observes_the_list_of_title_of_movies() {
		System.out.println("User Saw list of movies on starwars home page");
	}

	@Then("User sort the movies by title")
	public void user_sort_the_movies_by_title() {
		homepage = new HomePage(driver);
		homepage.getTitlesofMovies();

	}

	@Then("User should see the last movie in the list is {string}")
	public void user_should_see_the_last_movie_in_the_list_is(String string) {
		
		System.out.println("User should see the last movie");
	}
	

	@When("User Click on the movie The Empire Strikes Back")
	public void user_click_on_the_movie_the_empire_strikes_back() {
		homepage = new HomePage(driver);
		homepage.clickonTheEmpiresStrikesBackLink();
	}

	@Then("User should find wookie on the species list")
	public void user_should_find_wookie_on_the_species_list() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.wookieOnspeciesList();
	}

@When("User Click on the movie The Phantom Menace")
public void user_click_on_the_movie_the_phantom_menace() {
	homepage = new HomePage(driver);
	homepage.clickonThePhantomMenaceLink();
}

@Then("User should not find Planets and Camino on that list")
public void user_should_not_find_planets_and_camino_on_that_list() throws InterruptedException {
	homepage = new HomePage(driver);
    homepage.thePhantomList();
}


	@Then("User Close the Browser")
	public void user_close_the_browser() {
	    driver.close();
	}
}
