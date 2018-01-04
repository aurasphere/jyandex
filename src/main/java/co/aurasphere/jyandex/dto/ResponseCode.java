/*
* MIT License
* 
* Copyright  = c) 2016 Donato Rimenti
* 
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files  = the "Software"; to deal
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

/**
 * Represents a response code from Yandex Translate service.
 * 
 * @author Donato Rimenti
 */
public class ResponseCode {

	/**
	 * No response code was returned by the Yandex API.
	 */
	public final static int NO_CODE = 0;

	/**
	 * Operation completed successfully.
	 */
	public final static int OK = 200;

	/**
	 * Invalid API key.
	 */
	public final static int INVALID_API_KEY = 401;

	/**
	 * Blocked API key.
	 */
	public final static int BLOCKED_API_KEY = 402;

	/**
	 * Exceeded the daily limit on the amount of translated text.
	 */
	public final static int DAILY_LIMIT_EXCEEDED = 404;

	/**
	 * Exceeded the maximum text size.
	 */
	public final static int MAXIMUM_TEXT_SIZE_EXCEEDED = 413;

	/**
	 * The text cannot be translated.
	 */
	public final static int CANNOT_TRANSLATE_TEXT = 422;

	/**
	 * The specified translation direction is not supported.
	 */
	public final static int TRANSLATION_DIRECTION_NOT_SUPPORTED = 501;

	/**
	 * Instantiates a new ResponseCode.
	 */
	private ResponseCode() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResponseCode []";
	}
}