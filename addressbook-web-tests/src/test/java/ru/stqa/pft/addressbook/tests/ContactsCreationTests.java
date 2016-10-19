package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.Comparator;
import java.util.List;

public class ContactsCreationTests extends TestBase {


  @Test
  public void testContactsCreation() {
    app.goTo().contactsPage();
    List<ContactsData> before = app.contacts().list();
    ContactsData contact = new ContactsData().withFirstname("test2");
    app.contacts().create(contact);
    List<ContactsData> after = app.contacts().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactsData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}