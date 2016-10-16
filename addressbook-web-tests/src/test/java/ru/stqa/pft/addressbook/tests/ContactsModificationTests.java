package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

/**
 * Created by Дарья on 04-Sep-16.
 */
public class ContactsModificationTests extends TestBase {

  @Test
  public void testContactsModification(){
    int before = app.getContactsHelper().getContactCount();
    if (! app.getContactsHelper().isThereAContact()) {
      app.getContactsHelper().createContact(new ContactsData("test1", null, null, null, null, null, null, null, null));
    }
    app.getContactsHelper().initContactModification();
    app.getContactsHelper().fillContactForm(new ContactsData("test1", "test2", "test3", "test4", "test5", "098765", "46576576767", "mail1@mail.com", null));
    app.getContactsHelper().submitContactModification();
    app.getContactsHelper().returnToHomePage();
    int after = app.getContactsHelper().getContactCount();
    Assert.assertEquals(after, before);

  }

}
