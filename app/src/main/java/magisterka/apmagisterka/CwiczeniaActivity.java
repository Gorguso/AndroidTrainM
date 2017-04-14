package magisterka.apmagisterka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class CwiczeniaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cwiczenia);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() { // tworzenie obiektu nasluchujacego do listy
            @Override // on item click // obiekt nasluchujacy na liste
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) // 0 oznacza ze przechodzi do 1 elementu z listy (tj klatka)
                {
                    Intent intent = new Intent (CwiczeniaActivity.this , CwiczeniaListaActivity.class);// utworzyc cwiczneia lista activity
                    startActivity(intent);
                }
                // proba przejscia do 2 elementu z listy
                if(position == 1)
                {
                    Intent intent = new Intent (CwiczeniaActivity.this, CwiczeniaListaActivity.class/* klasa z drugimi cwiczeniami  */ );
                            startActivity(intent);
                }
            }
        };
        ListView listView = (ListView) findViewById(R.id.list_options_cwiczenia);
    listView.setOnItemClickListener(itemClickListener); // dodanie obiektu nasluchujacego do naszej listy
    }

}

