package com.lilithsthrone.game.character.body.valueEnums;

import com.lilithsthrone.utils.colours.Colour;
import com.lilithsthrone.utils.colours.PresetColour;

/**
 * @since 0.4.11.6
 * @version 0.4.11.6
 * @author Steffen
 */
public enum BreastSagginess {

	ZERO_FIRM(0, "firm", PresetColour.GENERIC_SIZE_ONE,
			"[npc.Her] [npc.breasts] sit high and taut against [npc.her] chest, so firm that there's no crease beneath them at all, and [npc.her] [npc.nipples] point forwards and slightly upwards.",
			"They've firmed right up, sitting high and taut against your chest with barely a crease beneath them.",
			"[npc.Her] [npc.crotchBoobs] are firm and taut against [npc.her] body, holding their shape without any hint of a downward pull."),

	ONE_NATURAL(1, "natural", PresetColour.GENERIC_SIZE_TWO,
			"[npc.Her] [npc.breasts] rest naturally against [npc.her] chest, their undersides curving gently into the faintest of creases, with [npc.her] [npc.nipples] pointing straight ahead.",
			"They've lost the last of their tautness, and now rest naturally against your chest.",
			"[npc.Her] [npc.crotchBoobs] hang naturally from [npc.her] body, with just a gentle downward curve to their undersides."),

	TWO_DROOPING(2, "drooping", PresetColour.GENERIC_SIZE_THREE,
			"[npc.Her] [npc.breasts] have started to droop under their own weight, their heavy lower halves sinking into a clearly defined crease and tipping [npc.her] [npc.nipples] down at a slight angle.",
			"Their lower halves have grown heavy enough to sink down into a clearly defined crease.",
			"[npc.Her] [npc.crotchBoobs] droop under their own weight, their heavy lower halves pulling down into a clear curve."),

	THREE_LOW_HANGING(3, "low-hanging", PresetColour.GENERIC_SIZE_FOUR,
			"[npc.Her] [npc.breasts] hang low against [npc.her] chest, their undersides settling down onto [npc.her] upper stomach beneath a pronounced crease, leaving [npc.her] [npc.nipples] angled clearly downwards.",
			"They now hang low enough that their undersides settle against your upper stomach.",
			"[npc.Her] [npc.crotchBoobs] hang low and heavy, drawn well away from [npc.her] body by their own weight."),

	FOUR_SAGGING(4, "sagging", PresetColour.GENERIC_SIZE_FIVE,
			"[npc.Her] [npc.breasts] sag heavily down onto [npc.her] belly, resting their full weight across it beneath a deep crease, with [npc.her] [npc.nipples] pointing straight down at the ground.",
			"They now sag right down onto your belly, resting their full weight across it.",
			"[npc.Her] [npc.crotchBoobs] sag heavily downwards, drooping far enough that they sway with every movement [npc.she] [npc.verb(make)]."),

	FIVE_UDDER_LIKE(5, "udder-like", PresetColour.GENERIC_SIZE_FIVE,
			"[npc.Her] [npc.breasts] hang long and heavy like a pair of udders, spilling right down over [npc.her] belly and swaying with every movement, [npc.her] [npc.nipples] aimed steeply down at the ground.",
			"They now hang long and heavy like a pair of udders, spilling down over your belly and swaying with every step.",
			"[npc.Her] [npc.crotchBoobs] hang long and heavy like a dairy cow's udders, dangling far down beneath [npc.her] body and swinging with every step.");

	private int value;
	private String descriptor;
	private Colour colour;
	private String description;
	private String growthDescription;
	private String crotchDescription;

	private BreastSagginess(int value, String descriptor, Colour colour, String description, String growthDescription, String crotchDescription) {
		this.value = value;
		this.descriptor = descriptor;
		this.colour = colour;
		this.description = description;
		this.growthDescription = growthDescription;
		this.crotchDescription = crotchDescription;
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

	/**
	 * @return A second-person sentence describing the breasts having just arrived at this level of sagginess.
	 *  Written for player-facing growth messages, so it uses plain "you" rather than parser tags.
	 */
	public String getGrowthDescription() {
		return growthDescription;
	}

	/** @return A description of crotch-boobs at this level of sagginess, using parser tags. */
	public String getCrotchDescription() {
		return crotchDescription;
	}

	/**
	 * Shape values such as PERKY are statements about how much a breast hangs, not about its actual shape,
	 * so they contradict higher sagginess values. ROUND and POINTY describe a resting shape which no longer
	 * applies once a breast sags severely. Positional shapes (SIDE_SET, WIDE, NARROW) and UDDERS never conflict.
	 * 
	 * @param shape The breast shape to check against this sagginess level.
	 * @return true if the supplied shape contradicts this level of sagginess and should not be used as a descriptor.
	 */
	public boolean isContradictedByShape(BreastShape shape) {
		if(this.value <= ONE_NATURAL.getValue()) {
			return false;
		}
		if(shape==BreastShape.PERKY) {
			return true;
		}
		return this.value >= FOUR_SAGGING.getValue()
				&& (shape==BreastShape.ROUND || shape==BreastShape.POINTY);
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
