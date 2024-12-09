package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.forms.PracticeFormPage;
import com.demoqa.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticeFormTest extends TestBase {

    @BeforeMethod

    public void precondition() {

        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm().hideIframes();

    }

    @Test(dataProviderClass= DataProviders.class,dataProvider="addNewStudentWithCsv")
    public void createStudentAccount(String name, String lastName, String email, String phone) {
        new PracticeFormPage(driver)
                .enterPersonalData(name, lastName, email, phone)
                .selectGender("Male")
                .enterDate("02 Feb 1990")
                .addSubjects(new String[]{"Math", "Chemistry"})
                .selectHobby(new String[]{"Sports", "Reading"})
                .uploadFile("C:/QA/The_Internet/Снимок экрана 2024-10-31 151113.png")
                .inputState("NCR")
                .inputCity("Delhi")
                .submit()
                .verifySuccessRegistration("");
    }

    @Test
    public void createStudentAccountWithSelectDate() {
        new PracticeFormPage(driver)
                .enterPersonalData("Ronny","Wide","wide@gm.com","1234398890")
                .selectGender("Male")
                .selectDate("August","1985","16")
                .addSubjects(new String[]{"Math","Chemistry"})
                .selectHobby(new String[]{"Sports","Reading"})
                .uploadFile("C:/QA/The_Internet/Снимок экрана 2024-10-31 151113.png")
                .inputState("NCR")
                .inputCity("Delhi")
                .submit()
                .verifySuccessRegistration("Thanks for submitting the form");
    }

}
