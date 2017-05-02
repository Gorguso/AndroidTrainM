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

    //klatka //A(klatka) B(barki) C(plecy) D(Triceps) E(Biceps) F(brzuch) (G)nogi

    //pomocnik sql
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CWICZENIA (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAZWA TEXT, "
                + "OPIS TEXT, "
                + "OBRAZ_ID INTEGER, "
                + "KATEGORIA TEXT);");

        db.execSQL("CREATE TABLE EXAMPLE (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAZWA TEXT, "
                + "OPIS TEXT, "
                + "OBRAZ_ID INTEGER, "
                + "KATEGORIA TEXT);");

    //klatka
        addSqlElement(db,"Wyciskanie klatka plaskie","Nalezy sie polozyc :"
                ,R.drawable.cwiczenie1,"A");
        addSqlElement(db,"Wyciskanie klatka ujemne","Nalezy sie polozyc :"
                ,R.drawable.cwiczenie1,"A");
        addSqlElement(db,"Wyciskanie klatka dodatnie","Nalezy sie polozyc :"
                ,R.drawable.cwiczenie1,"A");
        addSqlElement(db,"rozpietki","Nalezy sie polozyc :"
                ,R.drawable.cwiczenie1,"A");

        //barki
        addSqlElement(db,"Wyciskanie barki","Nalezy sie poloasxasazyc :"
                ,R.drawable.cwiczenie1,"B");
        addSqlElement(db,"unoszenie hantli na przód","Nalezy sie poloasxasazyc :"
                ,R.drawable.cwiczenie1,"B");

        //plecy
        addSqlElement(db,"Martwy ciag","Unoszenie sztangi z ziemi"
                ,R.drawable.cwiczenie1,"C");

        //triceps
        addSqlElement(db,"wyciskanie sztangi na wasko","Nalezy sie poloasxasazyc :"
                ,R.drawable.cwiczenie1,"D");

        //Biceps
        addSqlElement(db,"Uginanie ramion na modlitewniku","Nalezy sie poloasxasazyc :"
                ,R.drawable.cwiczenie1,"E");

        //brzuch
        addSqlElement(db,"Spinki","Nalezy sie poloasxasazyc :"
                ,R.drawable.cwiczenie1,"F");

        //nogi
        addSqlElement(db,"przysiady","Nalezy sie poloasxasazyc :"
                ,R.drawable.cwiczenie1,"G");

        //przykladowe cwiczenia !

//tutaj dodaje sie elementy do drugiej bazy przykladowe cwiczenia
        addSqlElementExample(db,"Pierwsze","1Mam XXnadzieje ze inna",R.drawable.cwiczenialogo,"A");
        addSqlElementExample(db,"Drugie","2Mam XXnadzieje ze inna",R.drawable.cwiczenialogo,"A");
        addSqlElementExample(db,"Trzecie","3Mam XXnadzieje ze inna",R.drawable.cwiczenialogo,"A");
        addSqlElementExample(db,"Czwarte","4Mam XXnadzieje ze inna",R.drawable.cwiczenialogo,"A");
        addSqlElementExample(db,"Pierwsze","1Mam XXnadzieje ze inna",R.drawable.cwiczenialogo,"B");
        addSqlElementExample(db,"Drugie","2Mam XXnadzieje ze inna",R.drawable.cwiczenialogo,"B");
        addSqlElementExample(db,"Trzecie","3Mam XXnadzieje ze inna",R.drawable.cwiczenialogo,"B");
        addSqlElementExample(db,"Czwarte","4Mam XXnadzieje ze inna",R.drawable.cwiczenialogo,"B");
        addSqlElementExample(db,"Pierwsze","1Mam XXnadzieje ze inna",R.drawable.cwiczenialogo,"C");
        addSqlElementExample(db,"Drugie","2Mam XXnadzieje ze inna",R.drawable.cwiczenialogo,"C");
        addSqlElementExample(db,"Trzecie","3Mam XXnadzieje ze inna",R.drawable.cwiczenialogo,"C");
        addSqlElementExample(db,"Czwarte","4Mam XXnadzieje ze inna",R.drawable.cwiczenialogo,"C");
        addSqlElementExample(db,"Pierwsze","1Mam XXnadzieje ze inna",R.drawable.cwiczenialogo,"D");
        addSqlElementExample(db,"Drugie","2Mam XXnadzieje ze inna",R.drawable.cwiczenialogo,"D");
        addSqlElementExample(db,"Trzecie","3Mam XXnadzieje ze inna",R.drawable.cwiczenialogo,"D");
        addSqlElementExample(db,"Czwarte","4Mam XXnadzieje ze inna",R.drawable.cwiczenialogo,"D"); // tutaj kategorie trzeba zmienci tez w exampleListaActivity
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public static void addSqlElement(SQLiteDatabase db, String nazwa, String opis, int obrazId, String kategoria) // metoda do dodawania elementow do sql
    {
        ContentValues values = new ContentValues();
        values.put("NAZWA", nazwa);
        values.put("OPIS", opis);
        values.put("OBRAZ_ID",obrazId);
        values.put("KATEGORIA", kategoria);
        db.insert("CWICZENIA", null , values);
    }
    public static void addSqlElementExample(SQLiteDatabase db, String nazwa, String opis, int obrazId, String kategoria) // metoda do dodawania elementow do sql
    {
        ContentValues values = new ContentValues();
        values.put("NAZWA", nazwa);
        values.put("OPIS", opis);
        values.put("OBRAZ_ID",obrazId);
        values.put("KATEGORIA", kategoria);
        db.insert("EXAMPLE", null , values);
    }

}