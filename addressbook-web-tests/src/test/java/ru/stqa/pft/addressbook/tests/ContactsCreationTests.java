package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactsCreationTests extends TestBase {

  @Test
  public void testContactsCreation() {
    app.goTo().contactsPage();
    Contacts before = app.contacts().all();
    ContactsData contact = new ContactsData().withFirstname("test2");
    app.contacts().create(contact);
    Contacts after = app.contacts().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}