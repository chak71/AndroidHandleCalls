package com.akesson;

import com.akesson.PhoneStateListner;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;


/**
 * 
 * @author Christer Åkesson
 *
 */
public class LifeService extends Service {
	
	private static final String TAG = "LifeService";
	private PhoneStateListner phoneListener = null;
	private TelephonyManager telephonyManager;
	
    // This is the object that receives interactions from clients.  See
    // RemoteService for a more complete example.
    private final IBinder binder = new LocalBinder();
		
	 /**
     * Class for clients to access.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with
     * IPC.
     */
    public class LocalBinder extends Binder {
    	LifeService getService() {
            return LifeService.this;
        }
    }
    
	@Override
	public void onCreate() {
		super.onCreate();

		Log.d(TAG, "onCreate");
		
		phoneListener = new PhoneStateListner(this);
		telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		telephonyManager.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);
	
	}
	
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.
        return START_STICKY;
    }
    
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "onDestroy");
	}
	
	@Override
	public void onStart(Intent intent, int startid) {
		Log.d(TAG, "onStart");
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}	
}
