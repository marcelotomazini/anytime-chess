package com.nullpointergames.anytimechess.engine.game.response;

import com.nullpointergames.anytimechess.engine.game.Move;



public class KingIsUnderAttackResponse extends MoveResponse {
	public KingIsUnderAttackResponse() {
		super(Move.Type.KINGISUNDERATTACK);
	}
}
