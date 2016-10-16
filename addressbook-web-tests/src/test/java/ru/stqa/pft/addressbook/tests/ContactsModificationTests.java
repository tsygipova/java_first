package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.List;

/**
 * Created by Дарья on 04-Sep-16.
 */
public class ContactsModificationTests extends TestBase {

  @Test
  public void testContactsModification(){
    if (! app.getContactsHelper().isThereAContact()) {
      app.getContactsHelper().createContact(new ContactsData("test1", null, null, null, null, null, null, null, null));
    }
    List<ContactsData> before = app.getContactsHelper().getContactsList();
    app.getContactsHelper().selectContact(before.size() - 1);
    app.getContactsHelper().initContactModification();
    app.getContactsHelper().fillContactForm(new ContactsData("test1", "test2", "test3", "test4", "test5", "098765", "46576576767", "mail1@mail.com", null));
    app.getContactsHelper().submitContactModification();
    app.getContactsHelper().returnToHomePage();
    List<ContactsData> after = app.getContactsHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size());

  }

}
