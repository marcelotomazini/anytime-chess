package com.nullpointergames.anytimechess.layouts;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.nullpointergames.anytimechess.comm.state.State;
import com.nullpointergames.anytimechess.engine.pieces.Piece.Color;
import com.nullpointergames.anytimechess.state.StateManager;
import com.nullpointergames.anytimechess.utils.Messages;
import com.nullpointergames.anytimechess.utils.TelephonyUtils;

import static com.nullpointergames.anytimechess.engine.pieces.Piece.Color.BLACK;
import static com.nullpointergames.anytimechess.engine.pieces.Piece.Color.WHITE;

public class GameStatusLayout extends LinearLayout {

	private TextView textView;
	private StateManager stateManager;
	private String player;
	private State state;

	public GameStatusLayout(Context context) {
		super(context);
        setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

		stateManager = new StateManager(getContext());
		createWelcome();
		setBackgroundColor(android.graphics.Color.WHITE);
	}

	private void createWelcome() {
		addView(new WelcomeView(getContext()), new TableRow.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, new Float(0.50)));
	}

	public void load(String player) {
		createTextView();
		this.player = player;
		refresh();
	}

	private void createTextView() {
		removeAllViews();
		textView = new TextView(getContext());
		textView.setTextColor(android.graphics.Color.BLACK);
		addView(textView);
	}

	public void refresh() {
		state = stateManager.get(player);
		textView.setText(getGameStatus() + "\r\n" + getStatusMessage());
	}

	private String getGameStatus() {
		String playerName = TelephonyUtils.resolvePlayerName(getContext(), player);
		return Messages.getString("game.status", playerName, state.getTurnSequence(), getTurnValue());
	}

	private String getTurnValue() {
		return state.getTurn().getTurnValue() == WHITE ? Messages.getString("white") : Messages.getString("black");
	}

	private String getStatusMessage() {
		Color myColor = stateManager.getMyColor(player);

		if (state.getGame().isCheckmate(myColor))
			return Messages.getString("game.over.lose");

		if (state.getGame().isCheck(myColor))
			return Messages.getString("you.check");

		Color opponentColor = myColor == WHITE ? BLACK : WHITE;

		if (state.getGame().isCheckmate(opponentColor))
			return Messages.getString("game.over.win");

		if (state.getGame().isCheck(opponentColor))
			return Messages.getString("other.check");

		return stateManager.isMyTurn(player) ? Messages.getString("your.turn") : "";
	}
}
