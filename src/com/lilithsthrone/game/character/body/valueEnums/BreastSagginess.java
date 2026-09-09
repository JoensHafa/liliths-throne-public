package com.lilithsthrone.game.character.body.valueEnums;

import com.lilithsthrone.utils.colours.Colour;
import com.lilithsthrone.utils.colours.PresetColour;

/**
 * @since 0.4.11.6
 * @version 0.4.11.6
 * @author Steffen
 */
public enum BreastSagginess {

	ZERO_PERKY(0, "perky", PresetColour.GENERIC_SIZE_ONE),
	ONE_NATURAL(1, "natural", PresetColour.GENERIC_SIZE_TWO),
	TWO_SOFT(2, "soft", PresetColour.GENERIC_SIZE_THREE),
	THREE_DROOPING(3, "drooping", PresetColour.GENERIC_SIZE_FOUR),
	FOUR_SAGGING(4, "sagging", PresetColour.GENERIC_SIZE_FIVE),
	FIVE_PENDULOUS(5, "pendulous", PresetColour.GENERIC_SIZE_FIVE);

	private int value;
	private String descriptor;
	private Colour colour;

	private BreastSagginess(int value, String descriptor, Colour colour) {
		this.value = value;
		this.descriptor = descriptor;
		this.colour = colour;
	}

	public int getValue() {
		return value;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public Colour getColour() {
		return colour;
	}

	public static BreastSagginess getSagginessFromInt(int sagginess) {
		for(BreastSagginess bs : BreastSagginess.values()) {
			if(sagginess == bs.getValue()) {
				return bs;
			}
		}
		return ONE_NATURAL;
	}

	public static BreastSagginess getMaximumSagginess() {
		return BreastSagginess.values()[BreastSagginess.values().length-1];
	}
}
