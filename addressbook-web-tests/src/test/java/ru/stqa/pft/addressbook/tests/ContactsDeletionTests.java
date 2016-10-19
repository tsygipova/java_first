package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

import java.util.List;

/**
 * Created by Дарья on 03-Sep-16.
 */
public class ContactsDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactsPage();
    if (app.contacts().list().size() == 0) {
      app.contacts().create(new ContactsData().withFirstname("test1"));
    }
  }

  @Test
  public void testContactsDeletion() {
    List<ContactsData> before = app.contacts().list();
    int index = before.size() - 1;
    app.contacts().delete(index);
    List<ContactsData> after = app.contacts().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
    }
}