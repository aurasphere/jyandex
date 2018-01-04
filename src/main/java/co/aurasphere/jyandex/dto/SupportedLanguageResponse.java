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
package co.aurasphere.jyandex.dto;

import java.util.Arrays;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

import co.aurasphere.jyandex.Jyandex;
import co.aurasphere.jyandex.util.IgnoreForTestCoverage;

/**
 * Response for {@link Jyandex#supportedLanguages()}.
 * 
 * @author Donato Rimenti
 */
public class SupportedLanguageResponse extends BaseYandexResponse {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The supported languages.
	 */
	@JsonProperty("langs")
	private HashMap<String, String> supportedLanguages;

	/**
	 * The supported directions.
	 */
	@JsonProperty("dirs")
	private String[] supportedDirections;

	/**
	 * Gets the {@link #supportedDirections}.
	 *
	 * @return the {@link #supportedDirections}.
	 */
	public String[] getSupportedDirections() {
		return supportedDirections;
	}

	/**
	 * Sets the {@link #supportedDirections}.
	 *
	 * @param supportedDirections
	 *            the new {@link #supportedDirections}.
	 */
	public void setSupportedDirections(String[] supportedDirections) {
		this.supportedDirections = supportedDirections;
	}

	/**
	 * Gets the {@link #supportedLanguages}.
	 *
	 * @return the {@link #supportedLanguages}.
	 */
	public HashMap<String, String> getSupportedLanguages() {
		return supportedLanguages;
	}

	/**
	 * Sets the langs.
	 *
	 * @param supportedLanguages
	 *            the {@link #supportedLanguages}.
	 */
	public void setSupportedLanguages(HashMap<String, String> supportedLanguages) {
		this.supportedLanguages = supportedLanguages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.jyandex.dto.BaseYandexResponse#hashCode()
	 */
	@Override
	@IgnoreForTestCoverage
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(supportedDirections);
		result = prime * result + ((supportedLanguages == null) ? 0 : supportedLanguages.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.jyandex.dto.BaseYandexResponse#equals(java.lang.Object)
	 */
	@Override
	@IgnoreForTestCoverage
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SupportedLanguageResponse other = (SupportedLanguageResponse) obj;
		if (!Arrays.equals(supportedDirections, other.supportedDirections))
			return false;
		if (supportedLanguages == null) {
			if (other.supportedLanguages != null)
				return false;
		} else if (!supportedLanguages.equals(other.supportedLanguages))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.jyandex.dto.BaseYandexResponse#toString()
	 */
	@Override
	@IgnoreForTestCoverage
	public String toString() {
		return "SupportedLanguageResponse [langs=" + supportedLanguages + ", dirs="
				+ Arrays.toString(supportedDirections) + "]";
	}
}
