package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactsCreationTests extends TestBase {


  @Test
  public void testContactsCreation() {
    initContactCreation();
    fillContactForm(new ContactsData("test1", "test2", "test3", "test4", "test5", "098765", "46576576767", "mail1@mail.com"));
    submitContactCreation();
    returnToContactsPage();
  }

}
