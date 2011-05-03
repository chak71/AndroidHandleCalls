package com.akesson;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;


/**
 * A listner that listen for call state. When state change to RINGING a lookup against the webservice at lightsoft that implements www.vemringde.se behind the
 * scenes. The lookup results in a toast with the companyname.
 * 
 * @author Christer Åkesson
 * 
 */

public class PhoneStateListner extends PhoneStateListener {

	private Context context;
	public static final String UNKNOWN = "Unknown";

	
	public PhoneStateListner() {
	};

	public PhoneStateListner(Context context) {
		if (context != null)
			this.context = context;
	}

	@Override
	public void onCallStateChanged(int state, String incomingNumber) {
		switch (state) {
		case TelephonyManager.CALL_STATE_IDLE:
			Log.d(Common.APPLICATION, "IDLE");
			break;
		case TelephonyManager.CALL_STATE_OFFHOOK:
			Log.d(Common.APPLICATION, "OFFHOOK");
			Toast.makeText(context, "På Gående Samtal!!", Toast.LENGTH_LONG).show();
			break;
		case TelephonyManager.CALL_STATE_RINGING:
			Log.d(Common.APPLICATION, "Det ringer!");
			Toast.makeText(context, "Det Ringer!!", Toast.LENGTH_LONG).show();
			break;
		}
	}
}
