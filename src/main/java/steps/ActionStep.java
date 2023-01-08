package steps;

import io.qameta.allure.Step;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.DifferentElementsPage;
import pages.MainPage;
import pages.ServiceMenu;
import pages.UserTablePage;


public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver) throws IOException {
        super(driver);
    }

    @Step(" I Open test site by URL")
    public void openWebSite(String website) {
        webDriver.get(website);
    }

    @Step("I perform login")
    public void performLogin(String user, String password) {
        mainPage = new MainPage(webDriver);
        mainPage.login(user, password);
    }

    @Step("I Switch to the iframe")
    public void switchToIframe(String frame) {
        webDriver.switchTo().frame(frame);
    }

    @Step("Switch to original window back")
    public void switchToParentWindow() {
        webDriver.switchTo().parentFrame();
    }

    @Step("I open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        mainPage.headerMenu()
                .clickServiceMenu()
                .clickDifferentElements();
        difElPage = new DifferentElementsPage(webDriver);
    }

    @Step("Select checkbox")
    public void selectCheckbox(WebElement element) {
        element.click();
    }

    @Step("Select radiobutton")
    public void selectRadioButton(WebElement element) {
        element.click();
    }

    @Step("select dropdown")
    public void selectDropDownColor(WebElement element) {
        element.click();
    }

    public void clickServiceMenu() {
        mainPage.headerMenu()
                .clickServiceMenu();
    }

    public void clickMenuItem(String item) {
        By serviceMenuItemPath = new By.ByXPath("//a[contains(text(),'" + item + "')]");
        WebElement serviceMenuItem = webDriver.findElement(serviceMenuItemPath);
        serviceMenuItem.click();
    }

    @Step("I open user table from service menu")
    public void openUserTablePage() {
        serviceMenu = new ServiceMenu(webDriver);
        serviceMenu.clickUserTable();
        difElPage = new DifferentElementsPage(webDriver);
    }

    public void selectOneVipCheckbox(String checkBoxValue) {
        if (checkBoxValue.toLowerCase().contains("sergey ivan")) {
            userTablePage = new UserTablePage(webDriver);
            userTablePage.clickVipCheckBox("ivan");
        }
    }
}
