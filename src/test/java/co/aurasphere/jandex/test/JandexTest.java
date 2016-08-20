/**
* MIT License
* 
* Copyright (c) 2016 Donato Rimenti
* 
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
* 
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
*/
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
	private static final String API_KEY = "YOUR API KEY GOES HERE";

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
