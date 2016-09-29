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
    app.getContactsHelper().submitContactModification();
    app.returnToContactsPage();
  }

}
