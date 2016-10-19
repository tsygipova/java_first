package ru.stqa.pft.addressbook.model;

public class ContactsData {
  private int id;
  private final String firstname;
  private final String lastname;
  private final String nickname;
  private final String company;
  private final String address;
  private final String homephome;
  private final String mobilephone;
  private final String email1;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactsData that = (ContactsData) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  private final String group;

  public ContactsData(String firstname, String lastname, String nickname, String company, String address, String homephome, String mobilephone, String email1, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.homephome = homephome;
    this.mobilephone = mobilephone;
    this.email1 = email1;
    this.group = group;
  }

  public ContactsData(int id, String firstname, String lastname, String nickname, String company, String address, String homephome, String mobilephone, String email1, String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.homephome = homephome;
    this.mobilephone = mobilephone;
    this.email1 = email1;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getHomephone() {
    return homephome;
  }

  public String getMobilephone() {
    return mobilephone;
  }

  public String getEmail1() {
    return email1;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "ContactsData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", nickname='" + nickname + '\'' +
            ", company='" + company + '\'' +
            ", address='" + address + '\'' +
            ", homephome='" + homephome + '\'' +
            ", mobilephone='" + mobilephone + '\'' +
            ", email1='" + email1 + '\'' +
            ", group='" + group + '\'' +
            '}';
  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }


}
