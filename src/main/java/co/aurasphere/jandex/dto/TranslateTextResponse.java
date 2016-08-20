package co.aurasphere.jandex.dto;

public class TranslateTextResponse extends DetectLanguageResponse{

	private static final long serialVersionUID = 1L;

	private String[] text;

	public String[] getText() {
		return text;
	}

	public void setText(String[] text) {
		this.text = text;
	}
	
}
