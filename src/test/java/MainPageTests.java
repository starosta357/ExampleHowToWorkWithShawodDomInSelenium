import org.testng.annotations.Test;
import page.MainPage;

public class MainPageTests extends BaseTest {

    @Test
    public void checkTitleOnTheMainPage(){
        new MainPage(driver)
                .openMainPage()
                .clickOnMenuBtn()
                .checkMenuItems();
    }
}
