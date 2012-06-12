package com.androideity.zxingdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ZXingDemoActivity extends Activity {
	
	private Button btnQR;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btnQR = (Button)findViewById(R.id.btn_qr);
        btnQR.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("com.google.zxing.client.android.SCAN");
		        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
		        startActivityForResult(intent, 0); 				
			}
        	
        });
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
 	   if (requestCode == 0) {
 	      if (resultCode == RESULT_OK) {
 	         String contents = intent.getStringExtra("SCAN_RESULT");
 	         //String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
 	         // Handle successful scan
 	        if(contents.equals("http://androideity.com")){
 	        	Intent i = new Intent(ZXingDemoActivity.this, Logo.class);
 	        	startActivity(i);  
 	         }else{ 
 	        	 //En caso de que sea otro link...
 	         }
 	      } else if (resultCode == RESULT_CANCELED) {
 	         // Handle cancel
 	      }
 	   }
 	}
}