package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactsData;
import java.util.ArrayList;
import java.util.List;

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

//    if (creation) {
//      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactsData.getGroup());
//    } else {
//      Assert.assertFalse(isElementPresent(By.name("new_group")));
//    }
//  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();

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

  public void createContact(ContactsData contact) {
    initContactCreation();
    fillContactForm(contact);
    submitContactCreation();
    returnToContactsPage();

  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactsData> getContactsList() {
    List<ContactsData> contacts = new ArrayList<ContactsData>();
    List<WebElement> elements = wd.findElements(By.name("selected[]"));
    for (WebElement element : elements) {
      String name = element.getText();
      String id = element.findElement(By.tagName("input")).getAttribute("value");
      ContactsData contact = new ContactsData(id, name, null, null, null, null, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}