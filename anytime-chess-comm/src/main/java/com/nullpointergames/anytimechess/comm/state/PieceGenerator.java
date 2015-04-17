package com.nullpointergames.anytimechess.comm.state;

import static java.lang.Character.MAX_RADIX;
import static java.lang.Character.digit;
import com.nullpointergames.anytimechess.engine.pieces.Bishop;
import com.nullpointergames.anytimechess.engine.pieces.EmptyPiece;
import com.nullpointergames.anytimechess.engine.pieces.King;
import com.nullpointergames.anytimechess.engine.pieces.Knight;
import com.nullpointergames.anytimechess.engine.pieces.Pawn;
import com.nullpointergames.anytimechess.engine.pieces.Piece;
import com.nullpointergames.anytimechess.engine.pieces.Queen;
import com.nullpointergames.anytimechess.engine.pieces.Rook;

class PieceGenerator {
	
	public King generateKing(String codeComposite) {
		char[] code = codeComposite.toCharArray();
		
		King king = (King) generatePiece(code[0]);
		
		king.setRow(digit(code[1], MAX_RADIX));
		king.setCol(code[2]);
		
		return king;
	}
	
	public Piece generatePiece(char code) {
		switch (code) {
		case '0':
			return new EmptyPiece();
		
		case 'K':
			return new King().white();
		case 'Q':
			return new Queen().white();
		case 'R':
			return new Rook().white();
		case 'B':
			return new Bishop().white();
		case 'N':
			return new Knight().white();
		case 'P':
			return new Pawn().white();

		case 'k':
			return new King().black();
		case 'q':
			return new Queen().black();
		case 'r':
			return new Rook().black();
		case 'b':
			return new Bishop().black();
		case 'n':
			return new Knight().black();
		case 'p':
			return new Pawn().black();
		}
		
		return null;
	}
	
	public boolean isKing(char c) {
		return c == 'k' || c == 'K';
	}
}
