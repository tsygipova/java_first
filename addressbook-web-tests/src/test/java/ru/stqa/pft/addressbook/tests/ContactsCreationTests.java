package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

public class ContactsCreationTests extends TestBase {


  @Test
  public void testContactsCreation() {
    int before = app.getContactsHelper().getContactCount();
    app.getContactsHelper().createContact(new ContactsData("test1", null, null, null, null, null, null, null, null));
    int after = app.getContactsHelper().getContactCount();
    Assert.assertEquals(after, before + 1);

  }

}