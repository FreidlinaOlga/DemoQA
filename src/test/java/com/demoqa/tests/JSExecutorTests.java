package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.TextBoxPage;
import org.checkerframework.dataflow.qual.TerminatesExecution;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutorTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
        new SidePanel(driver).selectTextBox().hideIframes();
    }

    @Test
    public void jsExecutorTest() {
        new TextBoxPage(driver).enterDataWithJS("Jane Doe", "JD@gmail.com")
                .clickOnSubmitWithJs()
                .refreshWithJS()
                .getInnerTextWithJS()
                .verifyUrlWithJS()
                .navigateToNewPageWithJS()
                .verifyTitleOfPageWithJS()
                .generateAlertWithJS();

    }


}