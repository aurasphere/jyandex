[![Travis](https://img.shields.io/travis/aurasphere/jyandex.svg)](https://travis-ci.org/aurasphere/jyandex)
[![Maven Central](https://img.shields.io/maven-central/v/co.aurasphere/jyandex.svg)](http://search.maven.org/#artifactdetails%7Cco.aurasphere%7Cjyandex%7C1.0.0%7Cjar)
[![Javadocs](http://javadoc.io/badge/co.aurasphere/jyandex.svg)](http://javadoc.io/doc/co.aurasphere/jyandex)
[![Maintainability](https://api.codeclimate.com/v1/badges/43d564cf9ee6e93d8391/maintainability)](https://codeclimate.com/github/aurasphere/jyandex/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/43d564cf9ee6e93d8391/test_coverage)](https://codeclimate.com/github/aurasphere/jyandex/test_coverage)
[![Join the chat at https://gitter.im/jyandex/Lobby](https://badges.gitter.im/jyandex/Lobby.svg)](https://gitter.im/jyandex/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Donate](https://img.shields.io/badge/Donate-PayPal-orange.svg)](https://www.paypal.com/donate/?cmd=_donations&business=8UK2BZP2K8NSS)

# Jyandex
A Java library client for Yandex Translate service.

This library offers three services: text translation, text language detection and available languages for translation.
You will need a <a href="https://tech.yandex.com/keys/get/?service=trnsl">free API key</a> in order to use the Yandex API.

## Warning
Starting from August 15, 2020, free API keys aren't issued. For this reason, this project is not tested/maintained anymore.

## Sample Usage

### Dependency

Maven:

    <dependency>
        <groupId>co.aurasphere</groupId>
        <artifactId>jyandex</artifactId>
        <version>1.0.0</version>
    </dependency>

Gradle:

    implementation 'co.aurasphere:jyandex:1.0.0'

### Create a client

    Jyandex client = new Jyandex(apiKey);

(you can get a <a href="https://tech.yandex.com/keys/get/?service=trnsl">free API key here</a>).

### Translate text

Translate a sentence to Italian:

    client.translateText(textToTranslate, Language.ITALIAN);

If you know the original language, you can pass it as an argument for better results (otherwise the language will be guessed). In this case, we are translating an English sentence into Italian:

    client.translateText(textToTranslate, Language.ENGLISH, Language.ITALIAN);

### Detect language

Detect the language of a sentence:

    client.detectLanguage(textToDetect);

You can also pass a list of most-likely languages as hint:

    List<String> hint = Arrays.asList(Language.JAPANESE, Language.ITALIAN, Language.AFRIKAANS);
    client.detectLanguage(textToDetect, hint);

### Supported languages

Get a list of supported languages from Yandex in English:

    client.supportedLanguages();

If you want to display the list in another language (Italian in this case):

    client.supportedLanguages(Language.ITALIAN);

## Useful links

- <a href="https://tech.yandex.com/translate/doc/dg/concepts/About-docpage/">Yandex API reference</a>
- <a href="https://tech.yandex.com/translate/doc/dg/concepts/design-requirements-docpage/">Yandex requirement for translation result's usage</a>
- <a href="https://tech.yandex.com/keys/get/?service=trnsl">Get your free API key</a>

## Contributions
If you want to contribute on this project, just fork this repo and submit a pull request with your changes. Improvements are always appreciated!

## Project status
This project is considered completed and won't be developed further unless I get any specific requests.

## Contacts
You can contact me using my account e-mail or opening an issue on this repo. I'll try to reply back ASAP.

## License
The project is released under the MIT license, which lets you reuse the code for any purpose you want (even commercial) with the only requirement being copying this project license on your project.

<sub>Copyright (c) 2016 Donato Rimenti</sub>
