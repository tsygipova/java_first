package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

/**
 * Created by Дарья on 03-Sep-16.
 */
public class ContactsDeletionTests extends TestBase {

  @Test
  public void testContactsDeletion() {
    if (! app.getContactsHelper().isThereAContact()) {
      app.getContactsHelper().createContact(new ContactsData("test1", null, null, null, null, null, null, null, null));

    }
    app.getContactsHelper().selectContact();
    app.getContactsHelper().initContactDeletion();
    app.getContactsHelper().submitContactDeletion();
    app.getContactsHelper().returnToHomePage();
  }
}