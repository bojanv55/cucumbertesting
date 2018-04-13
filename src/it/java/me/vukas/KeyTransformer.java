package me.vukas;

import cucumber.api.Transformer;
import me.vukas.domain.Key;

public class KeyTransformer extends Transformer<Key> {
	@Override
	public Key transform(String s) {
		return Key.of(Integer.parseInt(s));
	}
}
