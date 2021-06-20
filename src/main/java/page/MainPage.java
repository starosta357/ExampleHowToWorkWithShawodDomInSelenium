package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.improvement.FindInShadow;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class MainPage extends BasePage {

    private final static String MAIN_PAGE_URL = "https://books-pwakit.appspot.com";

    @FindInShadow(css = "book-app[apptitle='BOOKS'] >>> app-header > app-toolbar > button.menu-btn")
    private WebElement menuBtn;

    @FindInShadow(css = "book-app[apptitle='BOOKS'] >>> app-drawer[position='left'][opened] nav.drawer-list > a")
    private List<WebElement> menuItems;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage openMainPage() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    public MainPage clickOnMenuBtn() {
        menuBtn.click();
        return this;
    }

    public void checkMenuItems() {
        assertEquals(menuItems.size(), 3, "Number of menu items are incorrect");
        assertEquals(menuItems.get(0).getText(), "Home", "First item in the menu incorrect");
        assertEquals(menuItems.get(0).getAttribute("href"), BASE_URL + "/explore?q=", "First item href incorrect");
        assertEquals(menuItems.get(1).getText(), "Favorites", "Second item in the menu incorrect");
        assertEquals(menuItems.get(1).getAttribute("href"), BASE_URL + "/favorites", "Second item href incorrect");
        assertEquals(menuItems.get(2).getText(), "About", "Third item in the menu incorrect");
        assertEquals(menuItems.get(2).getAttribute("href"), BASE_URL + "/about", "Third item href incorrect");
    }

}
