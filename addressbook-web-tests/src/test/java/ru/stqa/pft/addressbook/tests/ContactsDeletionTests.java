package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Дарья on 03-Sep-16.
 */
public class ContactsDeletionTests extends TestBase {

  @Test
  public void testContactsDeletion() {
    app.getContactsHelper().selectContact();
    app.getContactsHelper().initContactDeletion();
    app.getContactsHelper().submitContactDeletion();
  }
}