package com.nullpointergames.anytimechess.comm.state;

import static com.nullpointergames.anytimechess.engine.pieces.Piece.Color.WHITE;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.nullpointergames.anytimechess.comm.state.State;

import com.nullpointergames.anytimechess.engine.game.Game;
import com.nullpointergames.anytimechess.engine.pieces.Piece.Color;

public class StateTest {

	private static final String SMS_MESSAGE_VALID = "atchess00001WHITERNBQK1eBNRPPPPPPPP--------------------------------pppppppprnbqk8ebnr";
	private static final Color TURN = WHITE;

	@Rule public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void createState() {
		State state = new State(1, TURN, new Game());
		
		String smsMessage = state.build();
		
		assertEquals("SMS Message", SMS_MESSAGE_VALID, smsMessage);
	}
	
	@Test
	public void createStateWithSMSMessage() {
		State state = new State(SMS_MESSAGE_VALID);
		
		assertEquals("Header", "atchess", state.getHeader());
		assertEquals("TurnSequence", 1, state.getTurnSequence());
		assertEquals("Turn", WHITE, state.getGame().getTurn());
		
		assertEquals("GameState", SMS_MESSAGE_VALID, state.build());
	}

	@Test
	public void dontCreateStateWithNullMessage() {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Invalid State Message");
		
		new State(null);
	}

	@Test
	public void dontCreateStateWithEmptyMessage() {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Invalid State Message");
		
		new State("");
	}
}
