package magisterka.apmagisterka;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dawid on 2016-11-03.
 */
public class DatabaseSql extends SQLiteOpenHelper {//pomocnik sql

    private static final String DB_NAME = "bazaCwiczenia"; // nazwa bazy
    private static final int DB_VERSION = 1; // nr bazy


    public DatabaseSql(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    //pomocnik sql
    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE CWICZENIA (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
    + "NAZWA TEXT, "
    + "OPIS TEXT, "
    + "OBRAZ_ID INTEGER);");

        addSqlElement(db,"Wyciskanie neutralne","Nalezy sie polozyc :"
        ,R.drawable.cwiczenie1);
        addSqlElement(db,"Wyciskanie inne","Nalezy sie polozyc :"
                ,R.drawable.cwiczenie1);

        /*zdruga tabela pod barki
    db.execSQL("CREATE TABLE CWICZENIA2 (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "NAZWA TEXT, "
            + "OPIS TEXT, "
            + "OBRAZ_ID INTEGER);");
        addSqlElement(db,"Wyciskanie barki","Nalezy sie polozyc i na barki", R.drawable.cwiczenialogo);
*/
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public static void addSqlElement(SQLiteDatabase db, String nazwa, String opis, int obrazId) // metoda do dodawania elementow do sql
    {
        // Do zapisywania danych (w zasadzie do przekazywania ich do zapytania) służy klasa ContentValues.
        // Za pomocą metod put(…) umieszczamy w niej pary klucz-wartość
        // (gdzie klucz jest nazwą kolumny w naszej tabeli).
        // Następnie cały zbiór takich wartości (w postaci obiektu ContentValues)
        // przekazujemy do metody insert(…). Zwraca ona id ostatnio zapisanego wiersza, lub -1 w wypadku błędu
        ContentValues values = new ContentValues();
        values.put("NAZWA", nazwa);
        values.put("OPIS", opis);
        values.put("OBRAZ_ID",obrazId);
        db.insert("CWICZENIA", null , values);
    }

}
