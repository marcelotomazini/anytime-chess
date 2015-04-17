package com.nullpointergames.anytimechess.engine.game.response;

import com.nullpointergames.anytimechess.engine.game.Move;



public class CantMoveResponse extends MoveResponse {
	public CantMoveResponse() {
		super(Move.Type.CANTMOVE);
	}
}
