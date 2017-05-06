package magisterka.apmagisterka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DiaryMain extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_main);
        listView = (ListView)findViewById(R.id.listview_diary); // referencja do listview diary

    }

    @Override // odniesienie do menu_main dodatkowy item
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);

       return true;
    }

    @Override// aktyw button
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())//switch dla itemu z diary
        {
            case R.id.action_diary_new: // uruchomienie diary przez (<!-- item)
                Intent intent = new Intent(this, DiaryActivity.class);
                startActivity(intent); // uruchamia na editexty z diarymain (zmienic tam NAME NAME )
                break;
        }
        return  true; //bool true
       // return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listView.setAdapter(null);

        ArrayList<Diary> diaries = DiaryTools.returnDiaries(this);

        if(diaries == null || diaries.size()==0)
        {
            Toast.makeText(this,"No notes",Toast.LENGTH_SHORT).show();
        return;
        }else
        {
            DiaryAdapterTool diaryAdapterTool = new DiaryAdapterTool(this,R.layout.diary_elements , diaries);
            listView.setAdapter(diaryAdapterTool);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String s = ((Diary) listView.getItemAtPosition(i)).getDateTime()
                            + DiaryTools.FILE_EXTENSION ; //do pliku zeby po kliknieciu pokazalo
                    Intent intent = new Intent(getApplicationContext(),DiaryActivity.class );
                    intent.putExtra("Diary",s);
                    startActivity(intent);
                }
            });
        }




    }
}
