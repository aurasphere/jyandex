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

import java.util.HashMap;

public class SupportedLanguageResponse extends BaseYandexResponse{

	private static final long serialVersionUID = 1L;

	private HashMap<String, String> langs;
	
	private String[] dirs;

	public String[] getDirs() {
		return dirs;
	}

	public void setDirs(String[] dirs) {
		this.dirs = dirs;
	}

	public HashMap<String, String> getLangs() {
		return langs;
	}

	public void setLangs(HashMap<String, String> langs) {
		this.langs = langs;
	}
}
