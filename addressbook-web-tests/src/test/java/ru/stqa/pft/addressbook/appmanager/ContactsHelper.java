package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsData;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    type(By.name("address"), contactsData.getAddress());
    type(By.name("mobile"), contactsData.getMobilephone());
    type(By.name("email"), contactsData.getEmail1());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void initContactDeletion() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void submitContactDeletion() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[9]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void create(ContactsData contact) {
    initContactCreation();
    fillContactForm(contact);
    submitContactCreation();
    returnToContactsPage();
  }

  public void modify(ContactsData contact) {
    selectContactById(contact.getId());
    initContactModification();
    fillContactForm(contact);
    submitContactModification();
    returnToHomePage();
  }

  public void delete(ContactsData contact) {
    selectContactById(contact.getId());
    initContactDeletion();
    submitContactDeletion();
    returnToHomePage();
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

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));

      String firstname = cells.get(2).getText();
      String lastname = cells.get(3).getText();
      String address = cells.get(4).getText();
      String mobilephone = cells.get(5).getText();
      String email1 = cells.get(6).getText();

      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactsData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return contacts;
  }
}