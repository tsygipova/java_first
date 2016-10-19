package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;
import java.util.Set;

/**
 * Created by Дарья on 04-Sep-16.
 */
public class ContactsModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactsPage();
    if (app.contacts().all().size() == 0) {
      app.contacts().create(new ContactsData().withFirstname("test1"));
    }
  }

  @Test (enabled = true)
  public void testContactsModification(){
    Set<ContactsData> before = app.contacts().all();
    ContactsData modifiedContact = before.iterator().next();
    ContactsData contact = new ContactsData()
            .withId(modifiedContact.getId()).withFirstname("test1").withLastname("test2")
            .withAddress("test3").withMobilephone("46576576767").withEmail1("mail1@mail.com");
    app.contacts().modify(contact);
    Set<ContactsData> after = app.contacts().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}
