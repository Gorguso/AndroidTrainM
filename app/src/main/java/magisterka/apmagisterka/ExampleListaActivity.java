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
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class ExampleListaActivity extends ListActivity {

    private SQLiteDatabase sqLiteDatabase;
    private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listaExample = getListView();

        //odebranie pozycji z cwiczneiaActivity
        Intent intent = getIntent();
        int pozycjaListy = intent.getIntExtra("pozycja",0);
        //Toast.makeText(CwiczeniaListaActivity.this,String.valueOf(pozycjaListy),Toast.LENGTH_LONG).show(); test do wyswietlania usunac


        if (pozycjaListy == 0) {
            try {
                SQLiteOpenHelper sqLiteOpenHelper = new DatabaseSql(this);

                sqLiteDatabase = sqLiteOpenHelper.getReadableDatabase(); // ref do bazy danych

                cursor = sqLiteDatabase.query("EXAMPLE", new String[]{"_id", "NAZWA"}, "KATEGORIA = ?", new String[]{"A"}, null, null, "NAZWA ASC"); // kursor do listview zeby pokazalo nazwe cwiczeni
                //kursor pokazuje nazwe cwiczneia w listView

                CursorAdapter cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[]{"NAZWA"},
                        new int[]{android.R.id.text1}, 0); // adapter simpleCursorAdapter

                listaExample.setAdapter(cursorAdapter);

            } catch (SQLiteException ex) {
                Toast toast = Toast.makeText(this, "example lista activity", Toast.LENGTH_LONG);
                toast.show();
            }

        } else if (pozycjaListy == 1) {
            try {
                SQLiteOpenHelper sqLiteOpenHelper = new DatabaseSql(this);

                sqLiteDatabase = sqLiteOpenHelper.getReadableDatabase(); // ref do bazy danych

                cursor = sqLiteDatabase.query("EXAMPLE", new String[]{"_id", "NAZWA"}, "KATEGORIA = ?", new String[]{"B"}, null, null, "NAZWA ASC"); // kursor do listview zeby pokazalo nazwe cwiczeni
                //kursor pokazuje nazwe cwiczneia w listView

                CursorAdapter cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[]{"NAZWA"},
                        new int[]{android.R.id.text1}, 0); // adapter simpleCursorAdapter

                listaExample.setAdapter(cursorAdapter);
            } catch (SQLiteException ex) {
                Toast toast = Toast.makeText(this, "Database error cwiczenia lsita activity", Toast.LENGTH_LONG);
                toast.show();
            }


        } else if (pozycjaListy == 2) {
            try {
                SQLiteOpenHelper sqLiteOpenHelper = new DatabaseSql(this);

                sqLiteDatabase = sqLiteOpenHelper.getReadableDatabase(); // ref do bazy danych

                cursor = sqLiteDatabase.query("EXAMPLE", new String[]{"_id", "NAZWA"}, "KATEGORIA = ?", new String[]{"C"}, null, null, "NAZWA ASC"); // kursor do listview zeby pokazalo nazwe cwiczeni
                //kursor pokazuje nazwe cwiczneia w listView

                CursorAdapter cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[]{"NAZWA"},
                        new int[]{android.R.id.text1}, 0); // adapter simpleCursorAdapter

                listaExample.setAdapter(cursorAdapter);
            } catch (SQLiteException ex) {
                Toast toast = Toast.makeText(this, "Database error cwiczenia lsita activity", Toast.LENGTH_LONG);
                toast.show();
            }


        }
        else if (pozycjaListy == 3) {
            try {
                SQLiteOpenHelper sqLiteOpenHelper = new DatabaseSql(this);

                sqLiteDatabase = sqLiteOpenHelper.getReadableDatabase(); // ref do bazy danych

                cursor = sqLiteDatabase.query("EXAMPLE", new String[]{"_id", "NAZWA"}, "KATEGORIA = ?", new String[]{"D"}, null, null, "NAZWA ASC"); // kursor do listview zeby pokazalo nazwe cwiczeni
                //kursor pokazuje nazwe cwiczneia w listView

                CursorAdapter cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[]{"NAZWA"},
                        new int[]{android.R.id.text1}, 0); // adapter simpleCursorAdapter

                listaExample.setAdapter(cursorAdapter);
            } catch (SQLiteException ex) {
                Toast toast = Toast.makeText(this, "Database error cwiczenia lsita activity", Toast.LENGTH_LONG);
                toast.show();
            }




        }

        else if (pozycjaListy == 4) {
            try {
                SQLiteOpenHelper sqLiteOpenHelper = new DatabaseSql(this);

                sqLiteDatabase = sqLiteOpenHelper.getReadableDatabase(); // ref do bazy danych

                cursor = sqLiteDatabase.query("EXAMPLE", new String[]{"_id", "NAZWA"}, "KATEGORIA = ?", new String[]{"E"}, null, null, "NAZWA ASC"); // kursor do listview zeby pokazalo nazwe cwiczeni
                //kursor pokazuje nazwe cwiczneia w listView

                CursorAdapter cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[]{"NAZWA"},
                        new int[]{android.R.id.text1}, 0); // adapter simpleCursorAdapter

                listaExample.setAdapter(cursorAdapter);
            } catch (SQLiteException ex) {
                Toast toast = Toast.makeText(this, "Database error cwiczenia lsita activity", Toast.LENGTH_LONG);
                toast.show();
            }




        }

// suplementy

        else if (pozycjaListy == 5) {
            try {
                SQLiteOpenHelper sqLiteOpenHelper = new DatabaseSql(this);

                sqLiteDatabase = sqLiteOpenHelper.getReadableDatabase(); // ref do bazy danych

                cursor = sqLiteDatabase.query("EXAMPLE", new String[]{"_id", "NAZWA"}, "KATEGORIA = ?", new String[]{"F"}, null, null, "NAZWA ASC"); // kursor do listview zeby pokazalo nazwe cwiczeni
                //kursor pokazuje nazwe cwiczneia w listView

                CursorAdapter cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[]{"NAZWA"},
                        new int[]{android.R.id.text1}, 0); // adapter simpleCursorAdapter

                listaExample.setAdapter(cursorAdapter);
            } catch (SQLiteException ex) {
                Toast toast = Toast.makeText(this, "Database error cwiczenia lsita activity", Toast.LENGTH_LONG);
                toast.show();
            }




        }

        else {
            Toast toast = Toast.makeText(this, "Retypo", Toast.LENGTH_LONG);
            toast.show();
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy(); // on destroy zeby zamknac baze i kursor
        cursor.close(); // kursor zamykam tutaj bo musi byc otwarty do przewijania listy
        sqLiteDatabase.close();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        Intent intent = new Intent(ExampleListaActivity.this,ExampleOpis.class);
        intent.putExtra(ExampleOpis.EXERCISE, (int)id); // po kliknieciu na liste przenosi numer excercise do cwiczopis
        startActivity(intent);
    }
}
