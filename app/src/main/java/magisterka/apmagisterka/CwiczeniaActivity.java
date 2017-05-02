package magisterka.apmagisterka;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CwiczeniaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cwiczenia);


        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() { // tworzenie obiektu nasluchujacego do listy
            @Override // on item click // obiekt nasluchujacy na liste
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pozycjaWyjsciowa ;
                if(position == 0) // 0 oznacza ze przechodzi do 1 elementu z listy (tj klatka)
                {//tutaj sa pozycje z listView tj biceps klatka itd dodajac position == X dodajemy odnosnik do nowej kategori, trzeba wtedy dodac w databaseSql,
                    pozycjaWyjsciowa= position;
                    Intent intent = new Intent (CwiczeniaActivity.this , CwiczeniaListaActivity.class);// utworzyc cwiczneia lista activity
                    intent.putExtra("pozycja",pozycjaWyjsciowa);
                    startActivity(intent);
                }
                // proba przejscia do 2 elementu z listy
                if(position == 1)
                {//barki
                    pozycjaWyjsciowa= position;
                    Intent intent = new Intent (CwiczeniaActivity.this, CwiczeniaListaActivity.class/* klasa z drugimi cwiczeniami  */ );
                    intent.putExtra("pozycja",pozycjaWyjsciowa);
                            startActivity(intent);
                }
                if(position == 2)
                {//plecy
                    pozycjaWyjsciowa= position;
                    Intent intent = new Intent (CwiczeniaActivity.this, CwiczeniaListaActivity.class/* klasa z drugimi cwiczeniami  */ );
                    intent.putExtra("pozycja",pozycjaWyjsciowa);
                    startActivity(intent);
                }
                if(position == 3)
                {//triceps
                    pozycjaWyjsciowa= position;
                    Intent intent = new Intent (CwiczeniaActivity.this, CwiczeniaListaActivity.class/* klasa z drugimi cwiczeniami  */ );
                    intent.putExtra("pozycja",pozycjaWyjsciowa);
                    startActivity(intent);
                }
                if(position == 4)
                {//biceps
                    pozycjaWyjsciowa= position;
                    Intent intent = new Intent (CwiczeniaActivity.this, CwiczeniaListaActivity.class/* klasa z drugimi cwiczeniami  */ );
                    intent.putExtra("pozycja",pozycjaWyjsciowa);
                    startActivity(intent);
                }
                if(position == 5)
                {//brzuch
                    pozycjaWyjsciowa= position;
                    Intent intent = new Intent (CwiczeniaActivity.this, CwiczeniaListaActivity.class/* klasa z drugimi cwiczeniami  */ );
                    intent.putExtra("pozycja",pozycjaWyjsciowa);
                    startActivity(intent);
                }
                if(position == 6) //nogi last
                {
                    pozycjaWyjsciowa= position;
                    Intent intent = new Intent (CwiczeniaActivity.this, CwiczeniaListaActivity.class/* klasa z drugimi cwiczeniami  */ );
                    intent.putExtra("pozycja",pozycjaWyjsciowa);
                    startActivity(intent);
                }
            }
        };
        ListView listView = (ListView) findViewById(R.id.list_options_cwiczenia);
    listView.setOnItemClickListener(itemClickListener); // dodanie obiektu nasluchujacego do naszej listy

    }

}

