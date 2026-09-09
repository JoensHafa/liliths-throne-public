package com.lilithsthrone.game.character.body.valueEnums;

import com.lilithsthrone.utils.colours.Colour;
import com.lilithsthrone.utils.colours.PresetColour;

/**
 * @since 0.4.11.6
 * @version 0.4.11.6
 * @author Steffen
 */
public enum BreastSagginess {

	ZERO_PERKY(0, "perky", PresetColour.GENERIC_SIZE_ONE,
			"[npc.Her] [npc.breasts] sit high and tight against [npc.her] chest, so firm that there's barely any crease beneath them at all, and [npc.her] [npc.nipples] point proudly forwards and slightly upwards."),

	ONE_NATURAL(1, "natural", PresetColour.GENERIC_SIZE_TWO,
			"[npc.Her] [npc.breasts] rest naturally on [npc.her] chest, their undersides curving gently down into a faint crease, with [npc.her] [npc.nipples] pointing straight ahead."),

	TWO_SOFT(2, "soft", PresetColour.GENERIC_SIZE_THREE,
			"[npc.Her] [npc.breasts] carry a soft, weighty droop, their lower halves sinking into a clearly defined crease and tipping [npc.her] [npc.nipples] down at a noticeable angle."),

	THREE_LOW_HANGING(3, "low-hanging", PresetColour.GENERIC_SIZE_FOUR,
			"[npc.Her] [npc.breasts] hang low and heavy, their undersides pressing down against [npc.her] upper stomach and folding into a deep crease, leaving [npc.her] [npc.nipples] angled steeply towards the floor."),

	FOUR_SAGGING(4, "heavily-sagging", PresetColour.GENERIC_SIZE_FIVE,
			"[npc.Her] [npc.breasts] sag right down onto [npc.her] belly, resting their full weight there beneath a deep crease, with [npc.her] [npc.nipples] pointing straight down at the ground."),

	FIVE_NAVEL_BRUSHING(5, "navel-brushing", PresetColour.GENERIC_SIZE_FIVE,
			"[npc.Her] [npc.breasts] hang long and heavy over [npc.her] stomach, spilling down past [npc.her] navel and swaying with every movement, [npc.her] [npc.nipples] aimed steeply down at the ground.");

	private int value;
	private String descriptor;
	private Colour colour;
	private String description;

	private BreastSagginess(int value, String descriptor, Colour colour, String description) {
		this.value = value;
		this.descriptor = descriptor;
		this.colour = colour;
		this.description = description;
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

	public String getDescription() {
		return description;
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
