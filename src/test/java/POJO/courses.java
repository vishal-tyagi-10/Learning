package POJO;

import java.util.List;

public class courses {
	
	// In this json contain another json and that json contains array
	
	//private String webAutomation;
	//private String api;
	//private String mobile;
	//
	
	private List<webAutomation> webAutomation; // now it create object of child class webautomation by use of classname 
	private List<api> api;
	private List<mobile> mobile;
	
	
	public List<POJO.webAutomation> getWebAutomation() {// string is replace by pojop.webautomation because it take data from child class webautomation
		return webAutomation;
	}
	public void setWebAutomation(List<POJO.webAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<POJO.api> getApi() {
		return api;
	}
	public void setApi(List<POJO.api> api) {
		this.api = api;
	}
	public List<POJO.mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<POJO.mobile> mobile) {
		this.mobile = mobile;
	}


}
