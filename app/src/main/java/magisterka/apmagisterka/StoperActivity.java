package magisterka.apmagisterka;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

public class StoperActivity extends AppCompatActivity {

    private int second = 0 ;
    private boolean run;
    private boolean notRun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stoper);
    if(savedInstanceState != null)
    {
        second = savedInstanceState.getInt("second");
        run = savedInstanceState.getBoolean("run");
        notRun = savedInstanceState.getBoolean("notRun");
    }
        stoper();
    }

    @Override
    protected void onPause() {
        super.onPause();
        notRun = run;
        run = false;
    }

    public void onClickStoperFinish(View v)
    {
        finish();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if(notRun)
        {
            run = true;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("second",second);
        outState.putBoolean("run",run);
        outState.putBoolean("notRun",notRun);

    }
    public void onStoperClickStart(View v)
    {
        run=true;

    }
    public void onStoperClickStop(View v)
    {
        run=false;
    }
    public void onStoperClickReset(View v)
    {
        run = true;
        second = 0 ;
    }

    private void stoper()
    {
        final TextView stoperView = (TextView)findViewById(R.id.text_view_stoper);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {


                int sec = second%60;
             //  int milisec = second%600 ;
                int minutes = (second%3600)/60;
                int hours = second/3600;
                String time = String.format("%d:%02d:%02d",hours,minutes,sec);//+ String.format("%02d",milisec);
                stoperView.setText(time);
                if(run)
                {
                    second++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
}
