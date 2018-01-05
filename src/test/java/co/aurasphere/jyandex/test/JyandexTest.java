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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.aurasphere.jyandex.Jyandex;
import co.aurasphere.jyandex.dto.DetectLanguageResponse;
import co.aurasphere.jyandex.dto.Language;
import co.aurasphere.jyandex.dto.ResponseCode;
import co.aurasphere.jyandex.dto.SupportedLanguageResponse;
import co.aurasphere.jyandex.dto.TranslateTextResponse;
import co.aurasphere.jyandex.dto.TranslationFormat;

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
	 * Name of the environment variable which holds the Yandex API key.
	 */
	private static final String API_KEY_ENV_VARIABLE = "YandexApiKey";

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		String apiKey = System.getenv(API_KEY_ENV_VARIABLE);
		client = new Jyandex(apiKey);
	}

	/**
	 * Tests {@link Jyandex#detectLanguage(String)}.
	 */
	@Test
	public void testDetectLanguage() {
		String textToDetect = "This is an English text. The response should be 'en'. Feel free to change this text to try out for yourself.";
		DetectLanguageResponse response = client.detectLanguage(textToDetect);

		// Checks the result.
		Assert.assertNotNull("Response is null!", response);
		Assert.assertEquals("Unexpected response code!", ResponseCode.OK, response.getCode());
		assertNotEmpty("Detected language", response.getDetectedLanguage());
	}

	/**
	 * Tests {@link Jyandex#detectLanguage(String, java.util.List)}.
	 */
	@Test
	public void testDetectLanguageWithHint() {
		String textToDetect = "Questa volta proviamo a trovare il linguaggio di un testo in italiano.";
		List<String> hint = Arrays.asList(Language.JAPANESE, Language.ITALIAN, Language.AFRIKAANS, "", null,
				Language.ENGLISH);
		DetectLanguageResponse response = client.detectLanguage(textToDetect, hint);

		// Checks the result.
		Assert.assertNotNull("Response is null!", response);
		Assert.assertEquals("Unexpected response code!", ResponseCode.OK, response.getCode());
		assertNotEmpty("Detected language", response.getDetectedLanguage());

		// Test by passing a null hint.
		response = client.detectLanguage(textToDetect, null);

		// Checks the result.
		Assert.assertNotNull("Response is null!", response);
		Assert.assertEquals("Unexpected response code!", ResponseCode.OK, response.getCode());
		assertNotEmpty("Detected language", response.getDetectedLanguage());

		// Test by passing an empty list.
		response = client.detectLanguage(textToDetect, new ArrayList<String>());

		// Checks the result.
		Assert.assertNotNull("Response is null!", response);
		Assert.assertEquals("Unexpected response code!", ResponseCode.OK, response.getCode());
		assertNotEmpty("Detected language", response.getDetectedLanguage());
	}

	/**
	 * Tests {@link Jyandex#supportedLanguages()}.
	 */
	@Test
	public void testSupportedLanguages() {
		SupportedLanguageResponse response = client.supportedLanguages();

		// Checks the result.
		Assert.assertNotNull("Response is null!", response);
		Assert.assertEquals("Unexpected response code!", ResponseCode.NO_CODE, response.getCode());
		Assert.assertNotNull("Supported languages are null!", response.getSupportedLanguages());
		Assert.assertNotNull("Supported directions are null!", response.getSupportedDirections());
		Assert.assertNotEquals("No supported languages returned!", 0, response.getSupportedLanguages().size());
		Assert.assertNotEquals("No supported directions returned!", 0, response.getSupportedDirections().length);
	}

	/**
	 * Tests {@link Jyandex#translateText(String, String)}.
	 */
	@Test
	public void testTranslation() {
		String textToTranslate = "This text is in English. We will try to translate it into italian.";
		TranslateTextResponse response = client.translateText(textToTranslate, Language.ITALIAN);

		// Checks the result.
		Assert.assertNotNull("Response is null!", response);
		Assert.assertEquals("Unexpected response code!", ResponseCode.OK, response.getCode());
		Assert.assertNotNull("Translated text array is null!", response.getTranslatedText());
		Assert.assertNotNull("Translated text array is empty!", response.getTranslatedText().length);
		assertNotEmpty("Translated text", response.getTranslatedText()[0]);
	}

	/**
	 * Tests {@link Jyandex#translateText(String, String, String)}.
	 */
	@Test
	public void testTranslationWithFrom() {
		String textToTranslate = "This text is in English. We will try to translate it into italian.";
		TranslateTextResponse response = client.translateText(textToTranslate, Language.ENGLISH, Language.ITALIAN);

		// Checks the result.
		Assert.assertNotNull("Response is null!", response);
		Assert.assertEquals("Unexpected response code!", ResponseCode.OK, response.getCode());
		Assert.assertNotNull("Translated text array is null!", response.getTranslatedText());
		Assert.assertNotNull("Translated text array is empty!", response.getTranslatedText().length);
		assertNotEmpty("Translated text", response.getTranslatedText()[0]);
	}

	/**
	 * Tests {@link Jyandex#translateText(String, String, String,
	 * co.aurasphere.jyandex.dto.TranslationFormat))}.
	 */
	@Test
	public void testTranslationAsHtml() {
		String textToTranslate = "This text is in English. We will try to translate it into italian.";
		TranslateTextResponse response = client.translateText(textToTranslate, Language.ENGLISH, Language.ITALIAN,
				TranslationFormat.HTML);

		// Checks the result.
		Assert.assertNotNull("Response is null!", response);
		Assert.assertEquals("Unexpected response code!", ResponseCode.OK, response.getCode());
		Assert.assertNotNull("Translated text array is null!", response.getTranslatedText());
		Assert.assertNotNull("Translated text array is empty!", response.getTranslatedText().length);
		assertNotEmpty("Translated text", response.getTranslatedText()[0]);
	}

	/**
	 * Utility method used to test that a string is not null and not empty.
	 * 
	 * @param fieldName
	 *            the field name, used for printing an error message if needed
	 * @param string
	 *            the string to check
	 */
	private void assertNotEmpty(String fieldName, String string) {
		Assert.assertNotNull(fieldName + " is null!", string);
		Assert.assertNotEquals(fieldName + " is empty!", string, "");
	}
}
