package co.aurasphere.jandex.dto;


public class DetectLanguageResponse extends BaseYandexResponse {

	private static final long serialVersionUID = 1L;
	
	private String lang;

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
	
}
