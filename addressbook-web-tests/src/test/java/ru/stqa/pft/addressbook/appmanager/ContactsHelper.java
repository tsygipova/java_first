package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactsData;

/**
 * Created by Дарья on 03-Sep-16.
 */
public class ContactsHelper extends BaseHelper {

  public ContactsHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToContactsPage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactsData contactsData) {
    type(By.name("firstname"), contactsData.getFirstname());
    type(By.name("lastname"), contactsData.getLastname());
    type(By.name("nickname"), contactsData.getNickname());
    type(By.name("company"), contactsData.getCompany());
    type(By.name("address"), contactsData.getAddress());
    type(By.name("home"), contactsData.getHomephone());
    type(By.name("mobile"), contactsData.getMobilephone());
    type(By.name("email"), contactsData.getEmail1());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }
}