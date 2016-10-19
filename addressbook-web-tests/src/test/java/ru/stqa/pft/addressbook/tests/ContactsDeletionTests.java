package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;
import java.util.Set;

/**
 * Created by Дарья on 03-Sep-16.
 */
public class ContactsDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactsPage();
    if (app.contacts().all().size() == 0) {
      app.contacts().create(new ContactsData().withFirstname("test1"));
    }
  }

  @Test
  public void testContactsDeletion() {
    Set<ContactsData> before = app.contacts().all();
    ContactsData deletedContact = before.iterator().next();
    app.contacts().delete(deletedContact);
    Set<ContactsData> after = app.contacts().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
    }
}