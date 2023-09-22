package sorting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class UsersPage extends AbstractPage {
    public UsersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@aria-label='sort']/button[3]")
    private WebElement btnId;

    @FindBy(xpath = "//div[@aria-label='sort']/button[6]")
    private WebElement btnAge;

    @FindBy(xpath = "//table/tbody/tr")
    private List<WebElement> userRows;

    public void btnIDClick() {
        btnId.click();
    }

    public void btnAgeClick() {
        btnAge.click();
    }

    public List<Integer> testTable(int colIndex) {
        List<Integer> t = new ArrayList<>();
        for (WebElement row: userRows) {
            t.add(Integer.parseInt(row.findElements(By.tagName("td")).get(colIndex).getText()));
        }
        return  t;
    }

}
