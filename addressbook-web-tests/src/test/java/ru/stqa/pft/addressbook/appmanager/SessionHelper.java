package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Дарья on 03-Sep-16.
 */
public class SessionHelper extends BaseHelper {

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {
    click (By.id("LoginForm"));
    type (By.name("user"), username);
    type (By.name("pass"), password);
    click (By.xpath("//form[@id='LoginForm']/input[3]"));
  }

}

