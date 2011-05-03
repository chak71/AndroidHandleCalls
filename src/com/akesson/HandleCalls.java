package com.akesson;

import com.akesson.LifeService;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

/**
 * 
 * @author Christer Åkesson
 *
 */
public class HandleCalls extends Activity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        startService(new Intent(this, LifeService.class));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	
    	if (keyCode == KeyEvent.KEYCODE_MENU) {
            // Do Stuff
    	  	Toast.makeText(this, "Menu button", Toast.LENGTH_LONG).show(); 
        } 
    	
    	if (keyCode == KeyEvent.KEYCODE_BACK) {
            // Do Stuff
    	  	Toast.makeText(this, "Back button", Toast.LENGTH_LONG).show(); 
        } 
    	
        return true;
    }
}