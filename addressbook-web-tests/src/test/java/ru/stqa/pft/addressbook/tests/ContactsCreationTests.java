package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.HashSet;
import java.util.List;

public class ContactsCreationTests extends TestBase {


  @Test
  public void testContactsCreation() {
    List<ContactsData> before = app.getContactsHelper().getContactsList();
    ContactsData contact = new ContactsData("test1", null, null, null, null, null, null, null, null);
    app.getContactsHelper().createContact(contact);
    List<ContactsData> after = app.getContactsHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    int max = 0;
    for (ContactsData c : after) {
      if (c.getId() > max){
        max = c.getId();
      }
    }
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


  }

}