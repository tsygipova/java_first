package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;
import java.util.List;

public class ContactsCreationTests extends TestBase {


  @Test
  public void testContactsCreation() {
    List<ContactsData> before = app.getContactsHelper().getContactsList();
    app.getContactsHelper().createContact(new ContactsData("test1", null, null, null, null, null, null, null, null));
    List<ContactsData> after = app.getContactsHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size() + 1);

  }

}