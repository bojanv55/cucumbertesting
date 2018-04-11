package me.vukas;

import me.vukas.domain.Key;

import org.springframework.core.convert.converter.Converter;

/**
 * Automatically convert string param from user when requesting something from
 * rest controller interface e.g. public Market createMarket(@PathVariable Key key)
 */
public class StringToKeyConverter implements Converter<String, Key> {
	@Override
	public Key convert(String s) {
		return Key.of(Integer.parseInt(s));
	}
}
