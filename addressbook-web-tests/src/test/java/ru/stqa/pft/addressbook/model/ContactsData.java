package ru.stqa.pft.addressbook.model;

public class ContactsData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String address;
  private String mobilephone;
  private String email1;

  public int getId() {
    return id;
  }

  public ContactsData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactsData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactsData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactsData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactsData withMobilephone(String mobilephone) {
    this.mobilephone = mobilephone;
    return this;
  }

  public ContactsData withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getMobilephone() {
    return mobilephone;
  }

  public String getEmail1() {
    return email1;
  }

  @Override
  public String toString() {
    return "ContactsData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", address='" + address + '\'' +
            ", mobilephone='" + mobilephone + '\'' +
            ", email1='" + email1 + '\'' +
            '}';
  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactsData that = (ContactsData) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }
}
