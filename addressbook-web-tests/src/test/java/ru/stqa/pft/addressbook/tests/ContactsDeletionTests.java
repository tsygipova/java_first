package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
    Contacts before = app.contacts().all();
    ContactsData deletedContact = before.iterator().next();
    app.contacts().delete(deletedContact);
    Contacts after = app.contacts().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedContact)));
    }
}