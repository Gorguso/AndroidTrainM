package magisterka.apmagisterka;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exitButton(View v)
    {
        System.exit(0);
    }

    public void onClickCwiczenia(View v)
    {
        Intent intent = new Intent(this,CwiczeniaActivity.class);
        startActivity(intent);
    }


    public void onClickStoper(View v)
    {
        Intent intent = new Intent(this,StoperActivity.class);
        startActivity(intent);
    }
    public void onClickBmi(View v)
    {
        Intent intent = new Intent(this,BmiActivity.class);
        startActivity(intent);
    }
    //aparat
    public void onClickAparat(View v)
    {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }
    //aparat funckjonalny xxf wwef
}
