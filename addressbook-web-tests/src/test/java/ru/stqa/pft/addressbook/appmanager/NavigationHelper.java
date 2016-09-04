package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Дарья on 03-Sep-16.
 */
public class NavigationHelper extends BaseHelper {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click (By.linkText("groups"));
  }

    public void gotoContactsPage() {
      click (By.linkText("contacts"));
    }

  }

