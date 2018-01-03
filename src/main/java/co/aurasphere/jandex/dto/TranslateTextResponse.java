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
package co.aurasphere.jandex.dto;

import java.util.Arrays;

import co.aurasphere.jandex.Jandex;

/**
 * Response for {@link Jandex#translateText(String, String)}.
 */
public class TranslateTextResponse extends DetectLanguageResponse {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The translated text.
	 */
	private String[] text;

	/**
	 * Gets the {@link #text}.
	 *
	 * @return the {@link #text}.
	 */
	public String[] getText() {
		return text;
	}

	/**
	 * Sets the {@link #text}.
	 *
	 * @param text
	 *            the new {@link #text}.
	 */
	public void setText(String[] text) {
		this.text = text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.jandex.dto.DetectLanguageResponse#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(text);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.aurasphere.jandex.dto.DetectLanguageResponse#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TranslateTextResponse other = (TranslateTextResponse) obj;
		if (!Arrays.equals(text, other.text))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.jandex.dto.DetectLanguageResponse#toString()
	 */
	@Override
	public String toString() {
		return "TranslateTextResponse [text=" + Arrays.toString(text) + "]";
	}

}
