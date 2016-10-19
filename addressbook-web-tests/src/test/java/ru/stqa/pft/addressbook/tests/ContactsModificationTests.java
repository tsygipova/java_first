package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Дарья on 04-Sep-16.
 */
public class ContactsModificationTests extends TestBase {

  @Test (enabled = true)
  public void testContactsModification(){
    if (! app.getContactsHelper().isThereAContact()) {
      app.getContactsHelper().createContact(new ContactsData("test1", null, null, null, null, null, null, null, null));
    }
    List<ContactsData> before = app.getContactsHelper().getContactsList();
    app.getContactsHelper().selectContact(before.size() - 1);
    app.getContactsHelper().initContactModification();
    ContactsData contact = new ContactsData(before.get(before.size() - 1).getId(), "test1", "test2", "test3", "test4", "test5", "098765", "46576576767", "mail1@mail.com", null);
    app.getContactsHelper().fillContactForm(contact);
    app.getContactsHelper().submitContactModification();
    app.getContactsHelper().returnToHomePage();
    List<ContactsData> after = app.getContactsHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactsData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }

}
