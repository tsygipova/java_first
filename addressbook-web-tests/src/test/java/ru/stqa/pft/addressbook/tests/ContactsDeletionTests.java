package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.List;

/**
 * Created by Дарья on 03-Sep-16.
 */
public class ContactsDeletionTests extends TestBase {

  @Test
  public void testContactsDeletion() {
    if (! app.getContactsHelper().isThereAContact()) {
      app.getContactsHelper().createContact(new ContactsData("test1", null, null, null, null, null, null, null, null));
    }
    List<ContactsData> before = app.getContactsHelper().getContactsList();
    app.getContactsHelper().selectContact(before.size() - 1);
    app.getContactsHelper().initContactDeletion();
    app.getContactsHelper().submitContactDeletion();
    app.getContactsHelper().returnToHomePage();
    List<ContactsData> after = app.getContactsHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size() - 1);


  }
}