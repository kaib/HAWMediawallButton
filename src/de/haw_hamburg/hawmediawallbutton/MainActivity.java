package de.haw_hamburg.hawmediawallbutton;

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

	private Button left,right,up,down;
	private TextView text_middle;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left = (Button)findViewById(R.id.button_left);
        left.setOnTouchListener(this);
        right = (Button)findViewById(R.id.button_right);
        right.setOnTouchListener(this);
        up = (Button)findViewById(R.id.button_up);
        up.setOnTouchListener(this);
        down = (Button)findViewById(R.id.button_down);
        down.setOnTouchListener(this);
        text_middle = (TextView)findViewById(R.id.textView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public boolean onTouch(View v, MotionEvent event) {
		switch(v.getId()) {
		case R.id.button_left: 
			new SendToActiveMQ();
			text_middle.setText("left");
			break;
		case R.id.button_right:
			new SendToActiveMQ();
			text_middle.setText("right");
			break;
		case R.id.button_up:
			new SendToActiveMQ();
			text_middle.setText("up");
			break;
		case R.id.button_down:
			new SendToActiveMQ();
			text_middle.setText("down");
			break;
		default: text_middle.setText("No View Found");
		}
		
		return false;
	}
}
