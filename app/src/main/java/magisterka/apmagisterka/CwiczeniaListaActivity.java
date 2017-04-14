package magisterka.apmagisterka;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class CwiczeniaListaActivity extends ListActivity{

    private SQLiteDatabase sqLiteDatabase;
    private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listaCwiczen = getListView();

        try{
            SQLiteOpenHelper sqLiteOpenHelper = new DatabaseSql(this);

            sqLiteDatabase = sqLiteOpenHelper.getReadableDatabase(); // ref do bazy danych

            cursor = sqLiteDatabase.query("CWICZENIA", new String[]{"_id", "NAZWA"}, null,null,null,null,null); // kursor do listview zeby pokazalo nazwe cwiczenia

            CursorAdapter cursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,cursor,new String[]{"NAZWA"},
                    new int[]{android.R.id.text1},0); // adapter simpleCursorAdapter

            listaCwiczen.setAdapter(cursorAdapter);

        }catch (SQLiteException ex){
            Toast toast = Toast.makeText(this,"Database error cwiczenia lsita activity", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy(); // on destroy zeby zamknac baze i kursor
        cursor.close();
        sqLiteDatabase.close();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        Intent intent = new Intent(CwiczeniaListaActivity.this,CwiczOpis.class);
        intent.putExtra(CwiczOpis.EXERCISE, (int)id);
        startActivity(intent);
    }
}
