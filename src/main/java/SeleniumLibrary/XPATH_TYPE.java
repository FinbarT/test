package SeleniumLibrary;

public enum XPATH_TYPE {

	IMAGE("image"),	
	BUTTON("button"),
	TEXT("text");
	
	private String mType;
	
	private XPATH_TYPE(String type) {
		this.mType = type;
	}
	
	public String getType() {
		return mType;
	}
}
