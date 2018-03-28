package mailru.autotests.model.data;

public class RegPasswordData {
  private final String password;
  private final String passwordretry;


  public RegPasswordData (String password, String passwordretry){
    this.password = password;
    this.passwordretry = passwordretry;
  }

  public String getPassword() {
    return password;
  }

  public String getPasswordretry() {
    return passwordretry;
  }
}
