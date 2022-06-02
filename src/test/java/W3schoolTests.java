import com.aventstack.extentreports.model.Report;
import exer2.pages.W3schoolpage;
import exer2.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class W3schoolTests extends TestBase {
    @FindBy(how = How.XPATH ,using = "//table[@id='customers']")
    WebElement table;
    @Parameters({"searchColumn","searchText","returnColumnText","expectedText"})
    @Test
    public void verifyValidData(int searchColumn,String searchText,int returnColumnText,String expectedText){
        W3schoolpage w3schoolPage = PageFactory.initElements(driver,W3schoolpage.class);
        boolean result = false;
        try {
            result = w3schoolPage.verifyTableCellText(table,searchColumn,searchText,returnColumnText,expectedText);
        } catch (Exception e) {
            System.out.println("index out of bound");
        }
        Assert.assertEquals(true,result);
    }

    @Parameters({"searchColumn","searchText","returnColumnText","expectedText"})
    @Test
    public void VerifyInvalidData(int searchColumn,String searchText,int returnColumnText,String expectedText){
        W3schoolpage w3schoolPage = PageFactory.initElements(driver,W3schoolpage.class);
        boolean result = false;
        try {
            result = w3schoolPage.verifyTableCellText(table,searchColumn,searchText,returnColumnText,expectedText);
        } catch (Exception e) {
            System.out.println("index out of bound");
        }
        Assert.assertEquals(false,result);
    }

    @Parameters({"searchColumn","searchText","returnColumnText","expectedText"})
    @Test
    public void indexOutOfBound(int searchColumn,String searchText,int returnColumnText,String expectedText){
        W3schoolpage w3schoolPage = PageFactory.initElements(driver,W3schoolpage.class);
        boolean result = false;
        try {
            result = w3schoolPage.verifyTableCellText(table,searchColumn,searchText,returnColumnText,expectedText);
        } catch (Exception e) {
            System.out.println("index out of bound");
        }
        Assert.assertEquals(false,result);
    }

}
