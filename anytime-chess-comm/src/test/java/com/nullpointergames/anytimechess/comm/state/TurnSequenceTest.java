package com.nullpointergames.anytimechess.comm.state;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nullpointergames.anytimechess.comm.state.TurnSequence;


public class TurnSequenceTest {

	@Test
	public void createTurnSequence() {
		TurnSequence turnSequence = new TurnSequence(1);
		
		assertEquals("Sequence", 1, turnSequence.getTurnSequence());
	}

	@Test
	public void createTurnSequenceMessage() {
		String messageSequence = "00001";
		
		TurnSequence turnSequence = new TurnSequence(messageSequence, 0);
		
		assertEquals("Sequence", 1, turnSequence.getTurnSequence());
	}

	@Test
	public void buildTurnSequence() {
		TurnSequence turnSequence = new TurnSequence(1);
		
		assertEquals("Sequence build", "00001", turnSequence.build());
	}
}
