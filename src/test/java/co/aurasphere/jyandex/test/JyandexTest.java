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
package co.aurasphere.jyandex.test;

import java.util.HashMap;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.aurasphere.jyandex.Jyandex;
import co.aurasphere.jyandex.dto.DetectLanguageResponse;
import co.aurasphere.jyandex.dto.ResponseCode;
import co.aurasphere.jyandex.dto.SupportedLanguageResponse;
import co.aurasphere.jyandex.dto.TranslateTextResponse;

/**
 * Test for {@link Jyandex}.
 * 
 * @author Donato Rimenti
 */
public class JyandexTest {

	/**
	 * The client to test.
	 */
	private Jyandex client;

	/**
	 * If you need an API key, you can get it <a
	 * href=https://tech.yandex.com/keys/get/?service=trnsl>here</a>.
	 */
	private static final String API_KEY = "";

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		client = new Jyandex(API_KEY);
	}

	@Test
	public void detectLanguageTest() {
		String textToDetect = "This is an English text. The response should be 'en'. Feel free to change this text to try out for yourself.";
		DetectLanguageResponse response = client.detectLanguage(textToDetect);
		Assert.assertEquals(ResponseCode.OK, response.getCode());
		System.out.println("Detected language: " + response.getDetectedLanguage());
	}

	@Test
	public void supportedLanguageTest() {
		SupportedLanguageResponse response = client.supportedLanguages();
		HashMap<String, String> langs = response.getSupportedLanguages();
		System.out.println("Available languages:");
		if (langs != null) {
			Set<String> keys = langs.keySet();
			if (keys != null) {
				for (String s : keys) {
					System.out.println(s + " : " + langs.get(s));
				}
			}
		}
		Assert.assertEquals(ResponseCode.NO_CODE, response.getCode());
	}

	@Test
	public void translationTest() {
		String textToTranslate = "This text is in English. We will try to translate it into italian.";
		String targetLanguage = "it";

		TranslateTextResponse response = client.translateText(textToTranslate, targetLanguage);

		String[] translatedText = response.getTranslatedText();

		System.out.println("Translated text:");
		if (translatedText != null) {
			for (String t : translatedText) {
				System.out.println(t);
			}
		}
		Assert.assertEquals(ResponseCode.OK, response.getCode());
		assertNotEmpty(response.getTranslatedText()[0]);
	}

	private void assertNotEmpty(String text) {
		Assert.assertNotNull(text);
		Assert.assertNotEquals(text, "");
	}
}
