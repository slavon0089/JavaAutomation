package Steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import java.util.List;

public class AssertStep extends AbstractStep {
    public MainPage mainPage;

    public AssertStep(WebDriver driver) {
        super(driver);
    }

    @Step(" Assert Browser title Home Page")
    public void assertBrowserTitle(String title) {
        //2. Assert Browser title "Home Page"
        softAssert.assertEquals(webDriver.getTitle(), title);
    }

    @Step("I assert Username is loggined")
    public void assertUserIsLogged(String userFullName) {
        mainPage = new MainPage(webDriver);
        softAssert.assertEquals(mainPage.userLogged(), userFullName);
    }

    @Step(" I assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assert4HeadersItems(List<String> LIST_ITEMS_HEADER) {
        for (int i = 0; i < LIST_ITEMS_HEADER.size(); i++) {
            softAssert.assertEquals(mainPage.menuList().get(i).getText(), LIST_ITEMS_HEADER.get(i));
            softAssert.assertTrue(mainPage.menuList().get(i).isDisplayed());
        }
    }

    @Step("I assert that there are 4 images on the Index Page and they are displayed")
    public void assert4ImagesOnIndexPageDisplayed(int countOfImagesOnMainPage) {
        softAssert.assertEquals(mainPage.listOfImages.size(), countOfImagesOnMainPage);
        for (int i = 0; i < countOfImagesOnMainPage; i++) {
            softAssert.assertTrue(mainPage.listOfImages.get(i).isDisplayed());
        }
    }

    @Step("I assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void assertProperTextUnder4Images(List<String> textUnderImages) {
        for (int i = 0; i < mainPage.listOfTextUnderImages.size() - 1; i++) {
            softAssert.assertEquals(mainPage.listOfTextUnderImages.get(i).getText(), textUnderImages.get(i));
        }
    }

    @Step("I assert that there is the iframe with “Frame Button” exist")
    public void assertIframeButtonExist() {
        softAssert.assertTrue(mainPage.frame.isDisplayed());
    }

    @Step("I check that there is “Frame Button” in the iframe")
    public void assertFrameButtonIsDisplayed() {
        softAssert.assertTrue(mainPage.frameButton.isDisplayed());
    }

    @Step("I assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void assert5itemsInLeftSectionIsDisplayed(List<String> leftMenuItems) {
        for (int i = 0; i < mainPage.leftMenu.size() - 1; i++) {
            softAssert.assertEquals(mainPage.leftMenu.get(i).getText(), leftMenuItems.get(i));
        }
    }
}
