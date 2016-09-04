package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;

/**
 * Created by Дарья on 04-Sep-16.
 */
public class ContactsModificationTests extends TestBase {

  @Test
  public void testContactsModification(){
    app.getContactsHelper().initContactModification();
    app.getContactsHelper().fillContactForm(new ContactsData("test1", "test2", "test3", "test4", "test5", "098765", "46576576767", "mail1@mail.com"));
    app.getContactsHelper().submitContactModification();
    app.returnToContactsPage();
  }

}
