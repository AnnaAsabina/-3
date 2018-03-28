package mailru.autotests.model.data;

public class RegData {


  private final String firstname;
  private final String lastname;

  public RegData(String fistname, String lastname) {
    this.firstname = fistname;
    this.lastname = lastname;
  }


  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  }
