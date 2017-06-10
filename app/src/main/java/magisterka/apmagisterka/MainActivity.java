package magisterka.apmagisterka;

import android.content.Intent;

import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

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

    public void onItemClickExamples(View v)
    {
        Intent intent = new Intent(this,ExampleEx.class);
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
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File photo= null;
        Calendar calendar = Calendar.getInstance();
        String nazwaPliku="komorkowyTrenerFoto_"+calendar.get(Calendar.DAY_OF_MONTH)+"_"+calendar.get(Calendar.HOUR_OF_DAY)
                +"_"+calendar.get(Calendar.MINUTE)+"_"+calendar.get(Calendar.SECOND);
        String extend = ".jpg";
        //String filePathPhoto = "";
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        try {
            photo = File.createTempFile(nazwaPliku,extend,file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photo));
        startActivityForResult(intent, 1);
        //
     /*   filePathPhoto=file.getAbsolutePath()+"/"+nazwaPliku+extend;
        Log.d("LOG:",filePathPhoto);chyba delete*/


       /* Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intent, 0);*/
    }
    //aparat funckjonalny xxf wwef
    public void onClickNotePad(View v)
    {
        Intent intent = new Intent(this, DiaryMain.class);
        startActivity(intent);
    }


}
