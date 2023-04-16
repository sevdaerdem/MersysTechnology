package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class _01_DataTables {
    DialogContent dc=new DialogContent();
    LeftNav ln=new LeftNav();

    @Given("Navigate to Campus")
    public void navigateToCampus() {
        //System.out.println("merhaba 1");
        GWD.getDriver().get("https://test.mersys.io/");
    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        // System.out.println("merhaba 2");

//        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOf(dc.username));
//        dc.username.sendKeys("turkeyts");
//        dc.password.sendKeys("TechnoStudy123!");
//        dc.loginButton.click();

        dc.sendKeysFunction(dc.username, "turkeyts");
        dc.sendKeysFunction(dc.password,"TechnoStudy123");
        dc.clickFunction(dc.loginButton);
    }
    @Then("User should login succesfully")
    public void userShouldLoginSuccesfully() {
        dc.verifyContainsTextFunction(dc.txtTechnoStudy,"Techno Study");
    }
    @And("Navigate to country page")
    public void navigateToCountryPage() {
        ln.clickFunction(ln.setup);
        ln.clickFunction(ln.parameters);
        ln.clickFunction(ln.countries);
    }

    @When("create a country")
    public void createACountry() {
        String ulkeAdi= RandomStringUtils.randomAlphanumeric(8); // 8 harf
        String ulkeKodu= RandomStringUtils.randomNumeric(4); // 4 rakam

        dc.clickFunction(dc.addButton);
        dc.sendKeysFunction(dc.nameInput, ulkeAdi);
        dc.sendKeysFunction(dc.codeInput, ulkeKodu);
        dc.clickFunction(dc.saveButton); // TODO
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.verifyContainsTextFunction(dc.successMessage,"success");
    }

    @When("create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String name, String kod) {
        dc.clickFunction(dc.addButton);
        dc.sendKeysFunction(dc.nameInput, name);
        dc.sendKeysFunction(dc.codeInput, kod);
        dc.clickFunction(dc.saveButton);
    }
    @And("Navigate to CitizenShip page")
    public void navigateToCitizenShipPage() {
        ln.clickFunction(ln.setup);
        ln.clickFunction(ln.parameters);
        ln.clickFunction(ln.citizenShip);
    }

    @When("User a CitizenShip name as {string} short name as {string}")
    public void userACitizenShipNameAsShortNameAs(String name, String shortName) {
        dc.clickFunction(dc.addButton);
        dc.sendKeysFunction(dc.nameInput,name);
        dc.sendKeysFunction(dc.shortName,shortName);
        dc.clickFunction(dc.saveButton);
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.verifyContainsTextFunction(dc.alreadyExist,"already");
    }

    @When("User delete the {string}")
    public void userDeleteThe(String searchText) {
        dc.deleteItem(searchText);
    }
    @And("Click on the element in LeftNav")
    public void clickOnTheElementInLeftNav(DataTable items) {
        List<String> strButtons=items.asList(String.class);

        for (String strButton: strButtons) {
            WebElement element=ln.getWebElement(strButton); // webelemnti bul
            ln.clickFunction(element); // webelemente tıklat
        }
    }

    @And("Click on the element in Dialog")
    public void clickOnTheElementInDialog(DataTable dt) {
        List<String> strButtons=dt.asList(String.class);

        for (String strButton: strButtons) {
            WebElement element=dc.getWebElement(strButton); // webelemnti bul
            dc.clickFunction(element); // webelemente tıklat
        }
    }


    @And("User sending the keys in Dialog Content")
    public void userSendingTheKeysInDialogContent(DataTable dt) {
        List< List<String> > items= dt.asLists(String.class);

        for (int i = 0; i < items.size(); i++) {
            WebElement element= dc.getWebElement(items.get(i).get(0));
            dc.sendKeysFunction(element, items.get(i).get(1));
        }
    }


    @And("User delete item from Dialog Content")
    public void userDeleteItemFromDialogContent(DataTable dt) {
        List<String> strButtons=dt.asList(String.class);

        for (String strDeleteText: strButtons) {
            dc.deleteItem(strDeleteText);
        }
    }
    @When("User Create citizenship with ApacehPOI")
    public void userCreateCitizenshipWithApacehPOI() {
        ArrayList<ArrayList<String>> tablo =
                ExcelUtility.getData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx", "testCitizen", 2);

        for (ArrayList<String> satir : tablo) {
            dc.clickFunction(dc.addButton);
            dc.sendKeysFunction(dc.nameInput, satir.get(0));
            dc.sendKeysFunction(dc.shortName, satir.get(1));
            dc.clickFunction(dc.saveButton);
            dc.verifyContainsTextFunction(dc.successMessage, "success");
        }
    }

    @Then("User Delete citizenship with ApacehPOI")
    public void userDeleteCitizenshipWithApacehPOI() {
        ArrayList<ArrayList<String>> tablo =
                ExcelUtility.getData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx", "testCitizen", 1);

        for (ArrayList<String> satir : tablo) {
            dc.deleteItem(satir.get(0));
            dc.verifyContainsTextFunction(dc.successMessage, "success");
        }
    }

    @When("Add Subject Categories, Edit Subject Categories")
    public void addSubjectCategoriesEditSubjectCategories() {
    }

    @Then("Delete Subject Categories for setting different education")
    public void deleteSubjectCategoriesForSettingDifferentEducation() {
    }

    @When("Edit Subject Categories and Delete Subject Categories for setting different education details for schools.")
    public void editSubjectCategoriesAndDeleteSubjectCategoriesForSettingDifferentEducationDetailsForSchools() {
    }

    @Then("Subject Categories tab should be under Education > Setup tab")
    public void subjectCategoriesTabShouldBeUnderEducationSetupTab() {
    }

    @And("we should have search function for this page.")
    public void weShouldHaveSearchFunctionForThisPage() {
    }

    @Then("option to  activate and deactivite Subject Categories")
    public void optionToActivateAndDeactiviteSubjectCategories() {
    }
}
