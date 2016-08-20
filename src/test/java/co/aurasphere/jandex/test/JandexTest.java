package co.aurasphere.jandex.test;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import co.aurasphere.jandex.Jandex;
import co.aurasphere.jandex.dto.DetectLanguageResponse;
import co.aurasphere.jandex.dto.SupportedLanguageResponse;
import co.aurasphere.jandex.dto.TranslateTextResponse;

public class JandexTest {

	private Jandex client;

	/**
	 * If you need an API key, you can get it <a
	 * href=https://tech.yandex.com/keys/get/?service=trnsl>here</a>.
	 */
	private static final String API_KEY = "trnsl.1.1.20160818T212242Z.ac542a8d13d69886.d854498fa0e07b92c95bc1cfc113f4a85f8fa1e1";
			//"YOUR API KEY GOES HERE";

	@Before
	public void setup() {
		client = new Jandex(API_KEY, true);
	}

	@Test
	public void detectLanguageTest() {
		String textToDetect = "This is an English text. The response should be 'en'. Feel free to change this text to try out for yourself.";
		DetectLanguageResponse response = client.detectLanguage(textToDetect);
		System.out.println("Detected language: " + response.getLang());
	}

	@Test
	public void supportedLanguageTest() {
		SupportedLanguageResponse response = client.supportedLanguages();
		HashMap<String, String> langs = response.getLangs();
		System.out.println("Available languages:");
		for (String s : langs.keySet()) {
			System.out.println(s + " : " + langs.get(s));
		}
	}

	@Test
	public void translationTest() {
		String textToTranslate = "This text is in English. We will try to translate it into italian.";
		String targetLanguage = "it";

		TranslateTextResponse response = client.translateText(textToTranslate,
				targetLanguage);

		String[] translatedText = response.getText();

		System.out.println("Translated text:");
		for (String t : translatedText) {
			System.out.println(t);
		}
	}
}