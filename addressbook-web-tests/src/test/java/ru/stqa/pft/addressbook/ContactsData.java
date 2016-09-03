package ru.stqa.pft.addressbook;

public class ContactsData {
  private final String firstname;
  private final String lastname;
  private final String nickname;
  private final String company;
  private final String address;
  private final String homephome;
  private final String mobilephone;
  private final String email1;

  public ContactsData(String firstname, String lastname, String nickname, String company, String address, String homephome, String mobilephone, String email1) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.homephome = homephome;
    this.mobilephone = mobilephone;
    this.email1 = email1;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomephome() {
    return homephome;
  }

  public String getMobilephone() {
    return mobilephone;
  }

  public String getEmail1() {
    return email1;
  }
}
