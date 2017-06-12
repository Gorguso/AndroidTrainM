package magisterka.apmagisterka;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class DiaryActivity extends AppCompatActivity {

    private Diary diarySaved;
    private EditText diaryTitleText;
    private String diaryFile;
    private EditText diaryContentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        diaryTitleText = (EditText)findViewById(R.id.diary_title); // ref do editext z listview diary
        diaryContentText = (EditText)findViewById(R.id.diary_content);

        diaryFile = getIntent().getStringExtra("Diary");
        if(diaryFile != null && !diaryFile.isEmpty())
        {
            diarySaved = DiaryTools.returnDiary(this,diaryFile);
            if(diarySaved != null)
            {
                diaryTitleText.setText(diarySaved.getTitle());
                diaryContentText.setText(diarySaved.getTitle());
            }
        }


    }

    private void zapisDiary ()
    {
Diary diary;

        if(diarySaved == null)
        {
             diary = new Diary( diaryContentText.getText().toString(),System.currentTimeMillis(),diaryTitleText.getText().toString());

        }else
        {
             diary = new Diary( diaryContentText.getText().toString(),diarySaved.getDateTime(),diaryTitleText.getText().toString());

        }

        if(DiaryTools.zapiszDiary(this,diary))
        {
            Toast.makeText(this,getApplicationContext().getResources().getString(R.string.notatkaZapis),Toast.LENGTH_SHORT).show(); // refer to strings
            finish();
        }else
        {
            Toast.makeText(this,"BLAD zapisu notatki",Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//click on save or delete item
        switch (item.getItemId())
        {
            case R.id.zapis_diary:

            zapisDiary();

                break;

            case  R.id.usuniecie_diary:

                usuniecieDiary();

                break;
        }



        return true ;
    }

    private void usuniecieDiary() {
        if(diarySaved == null)
        {
            finish();
        }
        else
        {// usuwanie dialog pytanie
            AlertDialog.Builder dialog = new AlertDialog.Builder(this).setTitle("Uwaga!").setMessage("Usunac " + diaryTitleText.getText().toString()+"?")
                    .setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            DiaryTools.removeItem(getApplicationContext(),diarySaved.getDateTime()+DiaryTools.FILE_EXTENSION);
                            Toast.makeText(getApplicationContext(),"Usunieto", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }).setNegativeButton("Nie",null).setCancelable(false);  //null bo nie musimy obslugiwac tego
dialog.show();

        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) { // overload dla przycisku zapis item
        getMenuInflater().inflate(R.menu.menu_new_diary,menu);
        return true;
    }


}
