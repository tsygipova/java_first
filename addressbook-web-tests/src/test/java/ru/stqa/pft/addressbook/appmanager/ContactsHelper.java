package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactsData;

/**
 * Created by Дарья on 03-Sep-16.
 */
public class ContactsHelper extends BaseHelper {

  public ContactsHelper(WebDriver wd) {
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

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void initContactDeletion() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));

  }

  public void submitContactDeletion() {
    wd.switchTo().alert().accept();

  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
      click(By.name("update"));
    }

  }


