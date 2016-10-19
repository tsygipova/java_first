package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by Дарья on 03-Sep-16.
 */
public class ApplicationManager {
   WebDriver wd;

  private SessionHelper sessionHelper;
  private ContactsHelper contactsHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }


  public void init() {
    if(browser.equals(BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if(browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if(browser.equals(BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    }
    //wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    contactsHelper = new ContactsHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }


  public void stop() {
    wd.quit();
  }

  public void returnToContactsPage() {
    wd.findElement(By.linkText("home page")).click();
  }

  public GroupHelper group() {
    return groupHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public ContactsHelper contacts() {
    return contactsHelper;
  }
}
