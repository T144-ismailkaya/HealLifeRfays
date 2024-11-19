package StepDefinitions;

import Pages.HealLife;
import Utilities.ConfigReader;
import Utilities.Driver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class HLStepDefinitions {

    HealLife healLife = new HealLife();
    Actions actions = new Actions(Driver.getDriver());

    @Given("Kullanıcı {string} sayfasına gider")
    public void kullanıcı_sayfasına_gider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }
    @Given("Kullanıcı Login butonuna basar")
    public void kullanıcı_login_butonuna_basar() {
        healLife.Login.click();
    }
    @Given("Kullanıcı Username textbox'a {string} girer")
    public void kullanıcı_username_textbox_a_girer(String email) {
        healLife.email.sendKeys(ConfigReader.getProperty(email));
    }
    @Given("Kullanıcı Password textbox'a {string} girer")
    public void kullanıcı_password_textbox_a_girer(String password) {
        healLife.password.sendKeys(ConfigReader.getProperty(password));
    }

    @Given("Kullanıcı Sign In butonuna basar")
    public void kullanıcı_sign_ın_butonuna_basar() {
        healLife.signInButton.click();
    }
    @Given("Kullanıcı giriş yapabildiğini test eder")
    public void kullanıcı_giriş_yapabildiğini_test_eder() {
        healLife.Dashboard.isDisplayed();
    }

    @Given("Kullanıcı browser kapatır")
    public void kullanıcı_browser_kapatır() {
        Driver.quitDriver();
    }

    @Given("Kullanıcı sayfanın footer bölümüne gider")
    public void kullanıcı_sayfanın_footer_bölümüne_gider() {
        actions.sendKeys(Keys.END).perform();
    }
    @Given("Kullanıcı Sosyal Medya liklerinin doğru sayfaya gittiğini doğrular")
    public void kullanıcı_sosyal_medya_liklerinin_doğru_sayfaya_gittiğini_doğrular() {
        String anasayfa = Driver.getDriver().getWindowHandle();

    // Beklenen URL'ler listesi
        List<String> expectedUrls = Arrays.asList(
                "https://www.facebook.com/login",
                "https://x.com/i/flow/login?input_flow_data=%7B%22requested_variant%22%3A%22eyJsYW5nIjoiZW4iLCJteCI6IjIifQ%3D%3D%22%7D",
                "https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fwww.youtube.com%2Fsignin%3Faction_handle_signin%3Dtrue%26app%3Ddesktop%26hl%3Dtr%26next%3Dhttps%253A%252F%252Fwww.youtube.com%252Faccount%26feature%3Dredirect_login&hl=tr&ifkv=AcMMx-elW2j437xmZCltDElTAZWslyOfDLbx67WxdWRWs4Hjzeu3d0ZJTAQTmo8tCHQvQfXoFWhczw&passive=true&service=youtube&uilel=3&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S1127305400%3A1731853487837892&ddm=1",
                "https://workspaceupdates.googleblog.com/2023/04/new-community-features-for-google-chat-and-an-update-currents%20.html",
                "https://www.linkedin.com/uas/login?_l=en",
                "https://www.instagram.com/accounts/login/",
                "https://in.pinterest.com/login/"
        );

    // Tıklanacak sosyal medya linkleri
        for (int i = 0; i < healLife.socialMediaLinks.size(); i++) {
            healLife.socialMediaLinks.get(i).click();

            // Tüm açık sekmeleri al
            Set<String> windowHandles = Driver.getDriver().getWindowHandles();

            // Yeni sekmeyi bul ve geçiş yap
            for (String handle : windowHandles) {
                if (!handle.equals(anasayfa)) {
                    Driver.getDriver().switchTo().window(handle);
                    break;
                }
            }

            // Yeni sekmenin URL'sini al
            String currentUrl = Driver.getDriver().getCurrentUrl();

            // Beklenen URL ile doğrula
            if (expectedUrls.contains(currentUrl)) {
                System.out.println("Doğru URL'ye yönlendirildi");
            } else {
                System.out.println("Hatalı URL'ye yönlendirildi: " + currentUrl);
            }

            // Yeni sekmeyi kapat ve anasayfaya geri dön
            Driver.getDriver().close();
            Driver.getDriver().switchTo().window(anasayfa);
        }

    }

}