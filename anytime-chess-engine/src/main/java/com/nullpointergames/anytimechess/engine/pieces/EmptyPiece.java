package com.nullpointergames.anytimechess.engine.pieces;

import java.util.List;

import com.nullpointergames.anytimechess.engine.game.Game;
import com.nullpointergames.anytimechess.engine.game.Move;
import com.nullpointergames.anytimechess.engine.game.response.MoveResponse;


public class EmptyPiece extends Piece {

	@Override
	protected char _code() {
		return '0';
	}

	@Override
	public MoveResponse canMove(final Move move, final Game game, final Piece pieceTo) {
		return null;
	}

	@Override
	public List<Move> moves(final char col, final int row, final Game game) {
		return null;
	}
}
