package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

public class ContactsCreationTests extends TestBase {


  @Test
  public void testContactsCreation() {
    app.getContactsHelper().initContactCreation();
    app.getContactsHelper().fillContactForm(new ContactsData("test1", "test2", "test3", "test4", "test5", "098765", "46576576767", "mail1@mail.com"));
    app.getContactsHelper().submitContactCreation();
    app.returnToContactsPage();
  }

}
