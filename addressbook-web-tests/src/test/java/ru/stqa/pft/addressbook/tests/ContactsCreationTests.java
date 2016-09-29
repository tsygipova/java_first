package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

public class ContactsCreationTests extends TestBase {


  @Test
  public void testContactsCreation() {
    app.getContactsHelper().initContactCreation();
    app.getContactsHelper().submitContactCreation();
    app.returnToContactsPage();
  }

}
