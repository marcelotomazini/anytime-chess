package com.nullpointergames.anytimechess.comm.message;

import com.nullpointergames.anytimechess.comm.state.State;

public class StateMessage implements Message {
	
	private String destination;
	private State state;

	public StateMessage(String destination, State state) {
		this.destination = destination;
		this.state = state;
	}

	@Override
	public String build() {
		return state.build();
	}

	@Override
	public String getDestination() {
		return destination;
	}
}
