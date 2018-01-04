/*
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
package co.aurasphere.jyandex;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import co.aurasphere.jyandex.dto.DetectLanguageResponse;
import co.aurasphere.jyandex.dto.Language;
import co.aurasphere.jyandex.dto.SupportedLanguageResponse;
import co.aurasphere.jyandex.dto.TranslateTextResponse;
import co.aurasphere.jyandex.dto.TranslationFormat;

/**
 * Main class of the Jyandex library. It offers access to the Yandex translate
 * service API.
 * 
 * @author Donato Rimenti
 */
public class Jyandex {

	/**
	 * The client used to issue requests to Yandex.
	 */
	private Client client;

	/**
	 * The Yandex API KEY. You can get one for free <a
	 * href=https://tech.yandex.com/keys/get/?service=trnsl>here</a>.
	 */
	private String apiKey;

	/**
	 * The Yandex services base endpoint.
	 */
	private final static String BASE_ENDPOINT = "https://translate.yandex.net/api/v1.5/tr.json";

	/**
	 * Path of the supported languages service.
	 */
	private static final String SUPPORTED_LANGUAGES_PATH = "getLangs";

	/**
	 * Path of the translate text service.
	 */
	private static final String TRANSLATE_TEXT_PATH = "translate";

	/**
	 * Path of the detect language service.
	 */
	private static final String DETECT_LANGUAGE_PATH = "detect";

	/**
	 * Parameter used to send the API key to the Yandex API.
	 */
	private static final String API_KEY_PARAMETER = "key";

	/**
	 * Parameter used to specify in which language the detected languages should
	 * be returned by {@link #supportedLanguages(String)}.
	 */
	private static final String UI_PARAMETER = "ui";

	/**
	 * Parameter used to send a language to the Yandex API.
	 */
	private static final String LANGUAGE_PARAMETER = "lang";

	/**
	 * Parameter used to send text to the Yandex API.
	 */
	private static final String TEXT_PARAMETER = "text";

	/**
	 * Parameter used to send a list of probable text languages in detecting the
	 * language to the Yandex API.
	 */
	private static final String HINT_PARAMETER = "hint";

	/**
	 * Parameter used to send the translation format to the Yandex API.
	 */
	private static final String FORMAT_PARAMETER = "format";

	/**
	 * Instantiates a new Jyandex.
	 *
	 * @param apiKey
	 *            the {@link #apiKey}
	 */
	public Jyandex(String apiKey) {
		this.client = ClientBuilder.newClient();
		this.apiKey = apiKey;
	}

	/**
	 * Detects the language of the specified text.
	 *
	 * @param text
	 *            the text to detect the language for
	 * @return a response containing the detected language
	 */
	public DetectLanguageResponse detectLanguage(String text) {
		return detectLanguage(text, null);
	}

	/**
	 * Detects the language of the specified text.
	 *
	 * @param text
	 *            the text to detect the language for
	 * @param hint
	 *            list of the most likely languages (they will be given
	 *            preference when detecting the text language)
	 * @return a response containing the detected language. This parameter is
	 *         optional
	 * @see Language
	 */
	public DetectLanguageResponse detectLanguage(String text, List<String> hint) {
		WebTarget target = makeRequest(DETECT_LANGUAGE_PATH).queryParam(TEXT_PARAMETER, text);

		// Builds the hint string if any hint is passed.
		if (hint != null && !hint.isEmpty()) {
			StringBuilder hintBuilder = new StringBuilder();
			for (String s : hint) {
				if (!s.isEmpty()) {
					hintBuilder.append(s).append(",");
				}
			}
			hintBuilder.setLength(hintBuilder.length() - 1);
			target.queryParam(HINT_PARAMETER, hintBuilder.toString());
		}

		return target.request().get().readEntity(DetectLanguageResponse.class);
	}

	/**
	 * Translates text to the specified language.
	 *
	 * @param text
	 *            the text to translate
	 * @param to
	 *            the translation direction. You can set it in either of the
	 *            following ways:
	 * 
	 *            <ul>
	 *            <li>As a pair of language codes separated by a hyphen
	 *            (“from”-“to”). For example, en-ru indicates translating from
	 *            English to Russian.</li>
	 *            <li>As the target language code (for example, ru). In this
	 *            case, the service tries to detect the source language
	 *            automatically.</li>
	 *            </ul>
	 * @return the translated text
	 * @see Language
	 */
	public TranslateTextResponse translateText(String text, String to) {
		return translateText(text, null, to, TranslationFormat.PLAIN);
	}

	/**
	 * Translates text to the specified language.
	 *
	 * @param text
	 *            the text to translate
	 * @param from
	 *            the original language. This parameter is optional
	 * @param to
	 *            the translation direction. You can set it in either of the
	 *            following ways:
	 * 
	 *            <ul>
	 *            <li>As a pair of language codes separated by a hyphen
	 *            (“from”-“to”). For example, en-ru indicates translating from
	 *            English to Russian. <strong>In this case, the
	 *            <code>from</code> parameter must be null.</strong></li>
	 *            <li>As the target language code (for example, ru). In this
	 *            case, the service tries to detect the source language
	 *            automatically.</li>
	 *            </ul>
	 * @return the translated text
	 * @see Language
	 */
	public TranslateTextResponse translateText(String text, String from, String to) {
		return translateText(text, from, to, TranslationFormat.PLAIN);
	}

	/**
	 * Translates text to the specified language.
	 *
	 * @param text
	 *            the text to translate
	 * @param from
	 *            the original language. This parameter is optional
	 * @param to
	 *            the translation direction. You can set it in either of the
	 *            following ways:
	 * 
	 *            <ul>
	 *            <li>As a pair of language codes separated by a hyphen
	 *            (“from”-“to”). For example, en-ru indicates translating from
	 *            English to Russian. <strong>In this case, the
	 *            <code>from</code> parameter must be null.</strong></li>
	 *            <li>As the target language code (for example, ru). In this
	 *            case, the service tries to detect the source language
	 *            automatically.</li>
	 *            </ul>
	 * @param format
	 *            whether to return plain text or HTML
	 * @return the translated text
	 * @see Language
	 */
	public TranslateTextResponse translateText(String text, String from, String to, TranslationFormat format) {

		// Builds the translation direction if needed.
		String targetLanguage;
		if (from != null) {
			targetLanguage = Language.buildTranslationDirection(from, to);
		} else {
			targetLanguage = to;
		}

		return makeRequest(TRANSLATE_TEXT_PATH).queryParam(TEXT_PARAMETER, text)
				.queryParam(LANGUAGE_PARAMETER, targetLanguage).queryParam(FORMAT_PARAMETER, format.name()).request()
				.get().readEntity(TranslateTextResponse.class);
	}

	/**
	 * Gets a list of translation directions supported by the service. The
	 * returned languages names are in english.
	 *
	 * @return a list of supported languages
	 */
	public SupportedLanguageResponse supportedLanguages() {
		return supportedLanguages(Language.ENGLISH);
	}

	/**
	 * Gets a list of translation directions supported by the service. The
	 * returned languages names are in the language specified as argument.
	 *
	 * @param language
	 *            in the response, supported languages are listed in the langs
	 *            field with the definitions of the language codes. Language
	 *            names are output in the language corresponding to the code in
	 *            this parameter
	 * @return a list of supported languages
	 * @see Language
	 */
	public SupportedLanguageResponse supportedLanguages(String language) {
		return makeRequest(SUPPORTED_LANGUAGES_PATH).queryParam(UI_PARAMETER, language).request().get()
				.readEntity(SupportedLanguageResponse.class);
	}

	/**
	 * Creates a base request for the Yandex API.
	 * 
	 * @param path
	 *            the service to invoke
	 * @return a base request for the Yandex API
	 */
	private WebTarget makeRequest(String path) {
		return client.target(BASE_ENDPOINT).path(path).queryParam(API_KEY_PARAMETER, apiKey);
	}
}
