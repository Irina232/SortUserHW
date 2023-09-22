package sorting;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@ExtendWith(TestListener.class)
public class StartTesting {
    private static final String URL = "http://77.50.236.203:4881/#/read/users";
    private static final int ID_COL = 0;
    private static final int AGE_COL = 3;
    private static final int TIMEOUT = 15;

    protected static WebDriver driver;
    private UsersPage usersPage;

    @BeforeEach
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
        usersPage = new UsersPage(driver);
    }

    @AfterEach
    public void theEnd() {
        //driver.quit(); // Закомментировать, чтобы сделался скриншот
    }

    @Test
    @Owner("Irina 1")
    @Description("The sorting of the ID column is being tested")
    public void sortIDCol() {
        List<Integer> manualSortList = usersPage.testTable(ID_COL);
        Collections.sort(manualSortList);

        usersPage.btnIDClick();
        List<Integer> webSortDirectList = usersPage.testTable(ID_COL);

        Assertions.assertTrue(manualSortList.equals(webSortDirectList),"Direct sorting ID col failed");

        Collections.reverse(manualSortList);

        usersPage.btnIDClick();
        List<Integer> webSortReverseList = usersPage.testTable(ID_COL);

        Assertions.assertTrue(manualSortList.equals(webSortReverseList),"Reverse sorting ID col failed");
    }

    @Test
    @Owner("Irina 2")
    @Description("The sorting of the Age column is being tested")
    public void sortAgeCol() {
        List<Integer> manualSortList = usersPage.testTable(AGE_COL);
        Collections.sort(manualSortList);

        usersPage.btnAgeClick();
        List<Integer> webSortDirectList = usersPage.testTable(AGE_COL);

        Assertions.assertTrue(manualSortList.equals(webSortDirectList),"Direct sorting Age col failed");

        Collections.reverse(manualSortList);

        usersPage.btnAgeClick();
        List<Integer> webSortReverseList = usersPage.testTable(AGE_COL);

        Assertions.assertTrue(manualSortList.equals(webSortReverseList),"Reverse sorting Age col failed");
    }

}
