package co.aurasphere.jandex.dto;

import java.util.HashMap;

public class SupportedLanguageResponse extends BaseYandexResponse{

	private static final long serialVersionUID = 1L;

	private HashMap<String, String> langs;
	
	private String[] dirs;

	public String[] getDirs() {
		return dirs;
	}

	public void setDirs(String[] dirs) {
		this.dirs = dirs;
	}

	public HashMap<String, String> getLangs() {
		return langs;
	}

	public void setLangs(HashMap<String, String> langs) {
		this.langs = langs;
	}
}
