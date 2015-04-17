package com.nullpointergames.anytimechess.message;

import android.content.Context;
import android.telephony.SmsMessage;

import com.nullpointergames.anytimechess.comm.message.GiveUp;
import com.nullpointergames.anytimechess.comm.message.HandShake;
import com.nullpointergames.anytimechess.state.StateManager;
import com.nullpointergames.anytimechess.utils.Notifications;

import static com.nullpointergames.anytimechess.utils.TelephonyUtils.filterNumber;

public class MessageManager {

	private Context context;

	public MessageManager(Context context) {
		this.context = context;
	}

	public void routeMessage(SmsMessage sms) {
		String player = filterNumber(sms.getOriginatingAddress());
		String message = sms.getMessageBody();

		if (message.contains(HandShake.HEADER))
			new HandShakeManager(context).resolve(player, message);
		else if (message.contains(GiveUp.HEADER))
			giveup(player);
		else
			update(player, message);
	}

	private void giveup(String player) {
		new StateManager(context).clear(player);
		new Notifications(context).notifyGiveUp(player);
	}

	private void update(String player, String message) {
		new StateManager(context).update(player, message);
		new Notifications(context).notifyNewMove(player);
	}
}
