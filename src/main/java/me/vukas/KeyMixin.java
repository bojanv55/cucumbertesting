package me.vukas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class KeyMixin {
	/**
	 * Add new constructor in runtime to Key.class which accepts int value property
	 * This will allow deserialization/serialization of json for Key class that has not public constructors
	 */
	@JsonCreator
	public KeyMixin(@JsonProperty int value){}
}
