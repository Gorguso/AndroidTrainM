package magisterka.apmagisterka;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CwiczOpis extends Activity {


    public static final String EXERCISE = "cwiczenieNr";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cwicz_opis);
       // getWindow().getDecorView().setBackgroundColor(Color.BLACK); // zmienia kolor aktywnosci na black

        int cwiczenieNr = (Integer)getIntent().getExtras().get(EXERCISE);

        //kursor do bazy danych
        try{
            SQLiteOpenHelper sqLiteOpenHelper = new DatabaseSql(this);

            SQLiteDatabase sqLiteDatabase = sqLiteOpenHelper.getReadableDatabase(); // readable bo tylko do odczytu

            Cursor cursor = sqLiteDatabase.query("CWICZENIA",
                    new String[]{"NAZWA", "OPIS", "OBRAZ_ID"},
                    "_id = ?",
                    new String[]{Integer.toString(cwiczenieNr)} // zwraca tylkpo to cwiczenie o okresllonym rekordzie
                    , null,null,null);

            if(cursor.moveToFirst()){//1 rekord w kursorze

                String nazwa = cursor.getString(0);
                String opis = cursor.getString(1);
                int nrZdjecia = cursor.getInt(2);

                TextView nazwaView = (TextView) findViewById(R.id.name);
                nazwaView.setText(nazwa);

                TextView opisView = (TextView)findViewById(R.id.description);
                opisView.setText(opis);
                opisView.setMovementMethod(new ScrollingMovementMethod()); //scroll

                ImageView zdjecieView = (ImageView) findViewById(R.id.photo);
                zdjecieView.setImageResource(nrZdjecia);
                zdjecieView.setContentDescription(nazwa);
            }

            cursor.close(); // zamkniecie kursora i bazy danych
            sqLiteDatabase.close();

        }catch (SQLiteException s)
        {
            Toast msg = Toast.makeText(this, "Database Error blad cwiczOpis", Toast.LENGTH_LONG);
            msg.show();// blad jak baza wysypie
        }

    }
}
