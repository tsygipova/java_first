package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

/**
 * Created by Дарья on 03-Sep-16.
 */
public class ContactsDeletionTests extends TestBase {

  @Test
  public void testContactsDeletion() {
    int before = app.getContactsHelper().getContactCount();
    if (! app.getContactsHelper().isThereAContact()) {
      app.getContactsHelper().createContact(new ContactsData("test1", null, null, null, null, null, null, null, null));

    }
    app.getContactsHelper().selectContact(before - 1);
    app.getContactsHelper().initContactDeletion();
    app.getContactsHelper().submitContactDeletion();
    app.getContactsHelper().returnToHomePage();
    int after = app.getContactsHelper().getContactCount();
    Assert.assertEquals(after, before - 1);


  }
}