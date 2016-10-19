package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Дарья on 04-Sep-16.
 */
public class ContactsModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactsPage();
    if (app.group().list().size() == 0) {
      app.contacts().create(new ContactsData("test1", null, null, null, null));
    }
  }

  @Test (enabled = true)
  public void testContactsModification(){
    List<ContactsData> before = app.contacts().list();
    int index = before.size() - 1;
    ContactsData contact = new ContactsData(before.get(index).getId(), "test1", "test2", "test3", "46576576767", "mail1@mail.com");
    app.contacts().modify(index, contact);
    List<ContactsData> after = app.contacts().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactsData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
