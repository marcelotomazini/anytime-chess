package com.nullpointergames.anytimechess.layouts;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.LinearLayout;

import com.nullpointergames.anytimechess.comm.message.GiveUp;
import com.nullpointergames.anytimechess.message.SMSSender;
import com.nullpointergames.anytimechess.state.StateManager;
import com.nullpointergames.anytimechess.utils.Alerts;
import com.nullpointergames.anytimechess.utils.Alerts.SureListener;
import com.nullpointergames.anytimechess.utils.Messages;

public class ButtonsLayout extends LinearLayout {

    private String player;
    private Alerts alerts;

    public ButtonsLayout(Context context) {
        super(context);
        setBackgroundColor(android.graphics.Color.WHITE);

        alerts = new Alerts(getContext());
    }

    public void load(String player) {
        this.player = player;
        createButtons();
    }

    private void createButtons() {
        removeAllViews();
        createButton("refresh.move", new RefreshListener());
        createButton("give.up", new GiveUpListener());
    }

    private void createButton(String key, SureListener listener) {
        Button button = new Button(getContext());
        button.setText(Messages.getString(key));
        button.setOnClickListener(alerts.createConfirmListener(listener));
        addView(button);
    }

    private class RefreshListener implements SureListener {
        @Override
        public void onClick(DialogInterface arg0, int arg1) {
            StateManager stateManager = new StateManager(getContext());
            if (stateManager.isMyTurn(player))
                return;

            stateManager.refresh(player);
            alerts.displayBundleMessage("move.sent");
        }
    }

    private class GiveUpListener implements SureListener {
        @Override
        public void onClick(DialogInterface arg0, int arg1) {
            new StateManager(getContext()).clear(player);
            sendGiveUp();
        }

        private void sendGiveUp() {
            GiveUp giveUp = new GiveUp(player);
            new SMSSender().send(giveUp);
            alerts.displayBundleMessage("you.give.up");
        }
    }
}
