import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OturumAcmaLogin extends BaseDriver {
    @Test
    public void Test(){

        driver.get("https://www.akakce.com/");

        WebElement loginNavigator = driver.findElement(By.xpath("//a[text()='Giriş Yap']"));
        loginNavigator.click();
        MyFunc.Wait(1);

        WebElement eMailField = driver.findElement(By.xpath("//input[@id='life']"));
        eMailField.sendKeys("zaferCansiz1@gmail.com");
        MyFunc.Wait(1);

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='lifp']"));
        passwordField.sendKeys("StringSifre1");
        MyFunc.Wait(1);

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='lfb']"));
        loginButton.click();
        MyFunc.Wait(1);

        BekleVeKapat();


    }
    @Test
    public void TestNegative1(){
        driver.get("https://www.akakce.com/");

        WebElement loginNavigator = driver.findElement(By.xpath("//a[text()='Giriş Yap']"));
        loginNavigator.click();
        MyFunc.Wait(1);

        WebElement eMailField = driver.findElement(By.xpath("//input[@id='life']"));
        eMailField.sendKeys("zaferCansiz1@gmail.com");
        MyFunc.Wait(1);

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='lifp']"));
        passwordField.sendKeys("HataliSifre1");
        MyFunc.Wait(1);

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='lfb']"));
        loginButton.click();
        MyFunc.Wait(1);

        WebElement message = driver.findElement(By.xpath("//div[@class='alertX t2']"));

        Assert.assertTrue("Uyari mesaji gorulmedi",message.getText().contains("Şifre doğru değil."));

        BekleVeKapat();

    }

    @Test
    public void TestNegative2(){
        driver.get("https://www.akakce.com/");

        WebElement loginNavigator = driver.findElement(By.xpath("//a[text()='Giriş Yap']"));
        loginNavigator.click();
        MyFunc.Wait(1);

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='lfb']"));
        loginButton.click();
        MyFunc.Wait(1);

        WebElement message = driver.findElement(By.xpath("//div[@class='alertX t2']"));

        Assert.assertTrue("Uyari mesaji gorulmedi",message.getText().contains("Lütfen e-posta adresinizi yazın."));

        BekleVeKapat();

    }
}
