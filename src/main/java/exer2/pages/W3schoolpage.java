package exer2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;

public class W3schoolpage {
    WebDriver driver;
    public W3schoolpage(WebDriver driver){
        this.driver=driver;
    }


    public boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) throws Exception {
        try {
            boolean isValidIndex = isValidIndex(searchColumn,returnColumnText);
       }catch (IndexOutOfBoundsException ex){
            throw new IndexOutOfBoundsException() ;
       }
        String actualText = getTableCellText(table,searchColumn,searchText,returnColumnText);
        if(actualText.equals(expectedText)){
            return true;
        }else{
            System.out.println("actual text is "+actualText+" but the expected is "+expectedText);
        }
        return false;
    }
    public String getTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText) {
        String retVal = null;
        try {
            retVal = getTableCellTextByXpath(table, searchColumn, searchText, returnColumnText);
        } catch (Exception e) {
            System.out.println("Element "+searchText+" not Found!");
        }
        return retVal;
    }
    public String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText) throws Exception {
        int i=1;
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//td["+searchColumn+"]"));
        for (WebElement element : rows) {
            i++;
            if (element.getText().equalsIgnoreCase(searchText)){
                break;
            }
        }
        List<WebElement> col = driver.findElements(By.xpath("//table[@id='customers']//tr["+i+"]/*["+returnColumnText+"]"));
        String retVal = col.get(0).getText();
        return retVal;
    }

    private boolean isValidIndex(int searchColumn, int returnColumnText) {
        int columnCount = driver.findElements(By.xpath("//table[@id='customers']//th")).size();
            if((searchColumn<1 || searchColumn>columnCount) && (searchColumn<1 || searchColumn>returnColumnText)){
                throw new IndexOutOfBoundsException();
            }
            return true;
    }
}
