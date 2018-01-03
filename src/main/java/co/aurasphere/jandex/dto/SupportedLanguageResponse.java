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
import java.util.HashMap;

import co.aurasphere.jandex.Jandex;

/**
 * Response for {@link Jandex#supportedLanguages()}.
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
	private HashMap<String, String> langs;

	/**
	 * The supported directions.
	 */
	private String[] dirs;

	/**
	 * Gets the {@link #dirs}.
	 *
	 * @return the {@link #dirs}.
	 */
	public String[] getDirs() {
		return dirs;
	}

	/**
	 * Sets the {@link #dirs}.
	 *
	 * @param dirs
	 *            the new {@link #dirs}.
	 */
	public void setDirs(String[] dirs) {
		this.dirs = dirs;
	}

	/**
	 * Gets the {@link #langs}.
	 *
	 * @return the {@link #langs}.
	 */
	public HashMap<String, String> getLangs() {
		return langs;
	}

	/**
	 * Sets the langs.
	 *
	 * @param langs
	 *            the {@link #langs}.
	 */
	public void setLangs(HashMap<String, String> langs) {
		this.langs = langs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.jandex.dto.BaseYandexResponse#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(dirs);
		result = prime * result + ((langs == null) ? 0 : langs.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.jandex.dto.BaseYandexResponse#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SupportedLanguageResponse other = (SupportedLanguageResponse) obj;
		if (!Arrays.equals(dirs, other.dirs))
			return false;
		if (langs == null) {
			if (other.langs != null)
				return false;
		} else if (!langs.equals(other.langs))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.aurasphere.jandex.dto.BaseYandexResponse#toString()
	 */
	@Override
	public String toString() {
		return "SupportedLanguageResponse [langs=" + langs + ", dirs=" + Arrays.toString(dirs) + "]";
	}
}
