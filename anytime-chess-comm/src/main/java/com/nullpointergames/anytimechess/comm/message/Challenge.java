package com.nullpointergames.anytimechess.comm.message;


public class Challenge extends HandShake {

	/*
	 * ░░░▄█▀▀░░▄▄▄▄▄▄▄░░░░░░░▄███▄░░░░
	 * ░▄█▀░░▄█▀▀░▄▄▄░░▀█▄░░▄▀░░░░░█▄░░
	 * ██▀░░░██░░░███░░░█▀░░█░░███░░██░
	 * █░░░░░▀█▄▄▄▄▄▄▄▄█▀░░░▀▄░▀▀▀░░███
	 * ░░░░░░░░░▀▀▀▀▀▀░░░░░░░░▀▀████▀▀█
	 * ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▀
	 * ░░░░░░░░░░░░░░░░░░▄▄▄▄████▄░░░░░
	 * ░░░░░░░░░░░░░░▄███▀▀▀░░▄█▀░░░░░░
	 * ░░░░░░░░░░░░░░░░░░░░░░▀▀░▄░░░░░▄
	 * ░░░░░░░░░░░░░░░░░░▀▀▀▄░░█▀░░░░░█
	 * █░░░░░░░░░░░░░░░░░░░░░▀██░░░░░██
	 * ▀█▄░░░░░░░░░░░░░░░░░░░░░▀██░▄█▀░
	 * ░░▀█▄░░░░░░░░░░░░░░░░░░░░░███▀░░
	 * ░░░░▀█▄▄░░░░░░░░░░░░░░░░▄███░░░░
	 * ░░░░░░▀▀██▄▄▄▄▄▄▄▄▄▄▄██▀▀░░█░░░░
	 * ░░░░░░░░░░░▀▀▀▀████▀▀██▄▄▄█▀░░░░
	 */
	
	public static final String CHALLENGE_TYPE = "CH";
	private static final String MESSAGE = "Hey you! %s is challenging you to play AnytimeChess!";
	private static final String MESSAGE_WITHOUT_PLAYER = "Hey you! This is an challenge to play AnytimeChess!";
	
	private String playerName;

	public Challenge(String homeName, String destination) {
		super(destination);
		playerName = homeName;
	}

	@Override
	protected String buildMessage() {
		if (playerName == null)
			return MESSAGE_WITHOUT_PLAYER;
		return String.format(MESSAGE, playerName);
	}

	@Override
	protected String handShakeType() {
		return CHALLENGE_TYPE;
	}
}
