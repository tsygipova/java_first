package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;
import java.util.Set;

public class ContactsCreationTests extends TestBase {

  @Test
  public void testContactsCreation() {
    app.goTo().contactsPage();
    Set<ContactsData> before = app.contacts().all();
    ContactsData contact = new ContactsData().withFirstname("test2");
    app.contacts().create(contact);
    Set<ContactsData> after = app.contacts().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}