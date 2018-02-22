package mailru.autotests.model;

public class MessageData {
	private final String addressee;
	private final String theme;
	private final String message;

	public MessageData(String addressee, String theme, String message){
		this.addressee = addressee;
		this.theme = theme;
		this.message = message;
	}

	public String getAddressee() {
		return addressee;
	}

	public String getTheme() {
		return theme;
	}

	public String getMessage() {
		return message;
	}
}
