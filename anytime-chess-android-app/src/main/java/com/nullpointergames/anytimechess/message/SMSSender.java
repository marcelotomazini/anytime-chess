package com.nullpointergames.anytimechess.message;

import android.telephony.SmsManager;
import com.nullpointergames.anytimechess.comm.message.Message;

public class SMSSender {

	public void send(Message message) {
		send(message.getDestination(), message.build());
	}

	private void send(String numero, String comando) {
		SmsManager.getDefault().sendTextMessage(numero, null, comando, null, null);
	}
}
