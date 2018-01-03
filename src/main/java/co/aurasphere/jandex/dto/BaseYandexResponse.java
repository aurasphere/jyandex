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

import java.io.Serializable;

/**
 * Base response from Yandex translate service.
 * 
 * @author Donato Rimenti
 */
public class BaseYandexResponse implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The code.
	 */
	private int code;

	/**
	 * The message.
	 */
	private String message;

	/**
	 * Gets the {@link #code}.
	 *
	 * @return the {@link #code}.
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Sets the {@link #code}.
	 *
	 * @param code the new {@link #code}.
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Gets the {@link #message}.
	 *
	 * @return the {@link #message}.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the {@link #message}.
	 *
	 * @param message the new {@link #message}.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseYandexResponse other = (BaseYandexResponse) obj;
		if (code != other.code)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BaseYandexResponse [code=" + code + ", message=" + message + "]";
	}

}
