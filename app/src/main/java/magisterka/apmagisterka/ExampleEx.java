package magisterka.apmagisterka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ExampleEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_ex);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() { // tworzenie obiektu nasluchujacego do listy
            @Override // on item click // obiekt nasluchujacy na liste
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pozycjaWyjsciowa ; // tutaj odnosniki do poczatkujacy cardio zaawansowany (cwiczenia przyklady)
                if(position == 0) // 0 oznacza ze przechodzi do 1 elementu z listy (tj poczatkujacy )
                {
                    pozycjaWyjsciowa= position;
                    Intent intent = new Intent (ExampleEx.this , ExampleListaActivity.class);// utworzyc cwiczneia lista activity
                  intent.putExtra("pozycja",pozycjaWyjsciowa);
                    startActivity(intent);
                }
                if(position == 1) // 0 oznacza ze przechodzi do 2 elementu z listy
                {
                    pozycjaWyjsciowa= position;
                    Intent intent = new Intent (ExampleEx.this , ExampleListaActivity.class);// utworzyc cwiczneia lista activity
                      intent.putExtra("pozycja",pozycjaWyjsciowa);
                    startActivity(intent);
                }
                if(position == 2) // 0 oznacza ze przechodzi do 3 elementu z listy
                {
                    pozycjaWyjsciowa= position;
                    Intent intent = new Intent (ExampleEx.this , ExampleListaActivity.class);// utworzyc cwiczneia lista activity
                       intent.putExtra("pozycja",pozycjaWyjsciowa);
                    startActivity(intent);
                }
                if(position == 3) // 0 oznacza ze przechodzi do 4 elementu z listy
                {
                    pozycjaWyjsciowa= position;
                    Intent intent = new Intent (ExampleEx.this , ExampleListaActivity.class);// utworzyc cwiczneia lista activity
                        intent.putExtra("pozycja",pozycjaWyjsciowa);
                    startActivity(intent);
                }
            }
        };
        ListView listView = (ListView) findViewById(R.id.list_options_examples);
        listView.setOnItemClickListener(itemClickListener); // dodanie obiektu nasluchujacego do naszej listy

    }
}
