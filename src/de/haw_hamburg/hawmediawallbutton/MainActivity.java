package de.haw_hamburg.hawmediawallbutton;

import com.google.gson.Gson;

import de.haw_hamburg.hawmediawallbutton.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnTouchListener {

	private Button left,right,up,down,start,reset;
	
	private TextView text_middle;
	private int pitch = 0, roll = 0, boost = 10;
	private boolean start_value = false, reset_value = false;
	private Gson g;
	private String message;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    
        super.onCreate(savedInstanceState);
    	g = new Gson();
        setContentView(R.layout.activity_main);
        left = (Button)findViewById(R.id.button_left);
        left.setOnTouchListener(this);
        right = (Button)findViewById(R.id.button_right);
        right.setOnTouchListener(this);
        up = (Button)findViewById(R.id.button_up);
        up.setOnTouchListener(this);
        down = (Button)findViewById(R.id.button_down);
        down.setOnTouchListener(this);
        start = (Button)findViewById(R.id.button_start);
        start.setOnTouchListener(this);
        reset = (Button)findViewById(R.id.button_reset);
        reset.setOnTouchListener(this);
        text_middle = (TextView)findViewById(R.id.textView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public boolean onTouch(View v, MotionEvent event) {
		start_value = false;
        reset_value = false;
		switch(v.getId()) {
		case R.id.button_left: 
			if (roll > -10) {roll -= 1;}			
			text_middle.setText("left");
			break;
		case R.id.button_right:
			if (roll < 10) {roll -= 1;}
			text_middle.setText("right");
			break;
		case R.id.button_up:
			if (pitch < 10) {pitch += 1;}
			text_middle.setText("up");
			break;
		case R.id.button_down:
			if (pitch > -10) {pitch -= 1;}
			text_middle.setText("down");
			break;
		case R.id.button_start:
			text_middle.setText("start");
			start_value = true;
			break;
		case R.id.button_reset:
			text_middle.setText("reset");
			reset_value = true;
			break;
		default: text_middle.setText("No View Found");
		}
		ControlBag bag = new ControlBag(boost, pitch, roll, reset_value, start_value);
		
		message = g.toJson(bag);
		new SendToActiveMQ("10.0.2.2",12349,"SPACCECORE_INPUT",message);
		
		return false;
	}
}
