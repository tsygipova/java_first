package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

public class ContactsCreationTests extends TestBase {


  @Test
  public void testContactsCreation() {
    app.getContactsHelper().initContactCreation();
    app.getContactsHelper().fillContactForm(new ContactsData("test1", null, null, null, null, null, null, null, null), true);
    app.getContactsHelper().submitContactCreation();
    app.returnToContactsPage();
  }

}
