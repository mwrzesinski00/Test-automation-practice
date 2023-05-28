
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UltimateQATest extends PageSetup {


    @Test
    public void testOne() {
        WebElement buttonUsingId = driver.findElementById("idExample");
        buttonUsingId.click();

        WebElement buttonSuccessText = driver.findElementByClassName("entry-title");
        assertEquals("Button success", buttonSuccessText.getText());
    }

    @Test
    public void testTwo() throws InterruptedException {
        WebElement nameTextField = driver.findElementByName("et_pb_contact_name_0");
        nameTextField.sendKeys("Tester");

        WebElement emailTextField = driver.findElementByName("et_pb_contact_email_0");
        emailTextField.sendKeys("random@tester.com");

        Thread.sleep(2000);

        WebElement emailMeButton = driver.findElementByName("et_builder_submit_button");
        emailMeButton.click();

        Thread.sleep(3000);

        WebElement thanksText  = driver.findElementByClassName("et-pb-contact-message");
        assertEquals("Thanks for contacting us", thanksText.getText());
    }

    @Test
    public void testThree() {
        WebElement blueField = driver.findElementByXPath("//*[contains(@class, 'et_pb_module et_pb_cta_0 et_pb_promo')]");
        assertEquals("rgba(46, 163, 242, 1)", blueField.getCssValue("background-color"));
    }

    @Test
    public void testFour() {
        WebElement bikeCheckbox = driver.findElementByXPath("//*[@type='checkbox' and @value='Bike']");
        bikeCheckbox.click();
        assertTrue(bikeCheckbox.isSelected());
    }

    @Test
    public void testFive() {

        List<String> listOfCars = new ArrayList<>();
        listOfCars.add("volvo");
        listOfCars.add("saab");
        listOfCars.add("opel");
        listOfCars.add("audi");

        for (String listOfCar : listOfCars) {
            WebElement dropdownOption = driver.findElementByXPath("//*[@value='" + listOfCar + "']");
            dropdownOption.click();
            assertTrue(dropdownOption.isSelected());
        }


    }

}
