package SeleniumLibrary;

/*
 * @author finbar timmins
 */
public class ElementSelector {

	private SELECTOR_TYPE m_SelectorType;
	private String m_Selector;
	private String m_Description;
	
	public ElementSelector(SELECTOR_TYPE a_SelectorType, String a_Selector, String a_Description) {
		this.m_SelectorType = a_SelectorType;
		this.m_Selector = a_Selector;
		this.m_Description = a_Description;
	}
	
	public ElementSelector(SELECTOR_TYPE a_SelectorType, String a_Selector) {
		this.m_SelectorType = a_SelectorType;
		this.m_Selector = a_Selector;
		this.m_Description = "Dynamically Generated From: " + a_Selector;
	}

	public SELECTOR_TYPE getSelectorType() {
		return this.m_SelectorType;
	}
	
	public String getSelector() {
		return this.m_Selector;
	}
	
	public String getDescription(){
		return this.m_Description;
	}
}
