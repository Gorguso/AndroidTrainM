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
        addSqlElement(db,"Wyciskanie sztangi na ławce neutralnej","Kładziemy się na ławce tak, by nogi ugięte" +
                        " były pod kątem prostym i przylegały do podłoża. Uchwyt sztangi pod kątem prostym względem ramienia, mocno spiąć łopatki. " +
                        "Podczas wyjmowania sztangi z uchwytu należy wziąć wdech i opuścić sztangę nie dotykając klatki. Centymetr nad klatką należy zacząć unosić sztangę w górę przy jednoczesnym wypuszczaniu" +
                        " powietrza"
                ,R.drawable.klatkaprostasztanga,"A");

        addSqlElement(db, "Wyciskanie sztangi na lawce ujemnej","Kładziemy się na ławce pochylonej w dół pod kątem 30-45 stopni tak, by nogi ugięte" +
                        " były pod kątem prostym i były zaparte w celu uniknięcia zsunięcia z ławki. Uchwyt sztangi pod kątem prostym względem ramienia, mocno spiąć łopatki. " +
                        " Podczas wyjmowania sztangi z uchwytu należy wziąć wdech i opuścić sztangę nie dotykając klatki. Centymetr nad klatką należy zacząć unosić sztangę w górę przy jednoczesnym wypuszczaniu" +
                        " powietrza. Ćwiczenie można wykonywać również za pomocą hantli"
                ,R.drawable.klatkaujemnesztanga,"A");

        addSqlElement(db,"Wyciskanie sztangi na lawce dodatniej",
                "Kładziemy się na ławce pochylonej w górę pod kątem od 30-45stopni tak, by nogi ugięte" +
                        " były pod kątem prostym i przylegały do podłoża. Uchwyt sztangi pod kątem prostym względem ramienia, mocno spiąć łopatki. " +
                        " Podczas wyjmowania sztangi z uchwytu należy wziąć wdech i opuścić sztangę nie dotykając klatki. Centymetr nad klatką należy zacząć unosić sztangę w górę przy jednoczesnym wypuszczaniu" +
                        " powietrza Ćwiczenie można wykonywać również za pomocą hantli, Należy szczególnie uważać przy wyjmowaniu sztangi ze stojaka"
                ,R.drawable.klatkagorasztanga,"A");

        addSqlElement(db,"Rozpietki hantlami","Cwiczenie można wykonywać na ławce o skosie dodatnim, neutralnym oraz ujemnym. Nalezy położyć się na ławce o odpowiednim skosie," +
                        "Hantle unosimy ku górze a następnie lekko uginamy rece w łokciach. Hantle opuszczamy w dół rozkładając ręce na boki, uważając przy tym aby nie zmieniać kąta" +
                        "ułożenia łokci. Po wykonaniu pełnego rozciągnięcia należy rozpocząć unosić z powrotem hantle ku górze przy jednoczesnym wydechu. Wykonując to ćwiczenie należy " +
                        "dobrać odpowiedni, mniejszy ciężary niż w przypadku wyciskania, ażeby zachować odpowiednią technikę"
                ,R.drawable.rozpietki,"A");

        addSqlElement(db,"Przenoszenie sztangielki w lezeniu","Nalezy sie polozyc w poprzek ławki poziomej tak aby odcinek piersiowy podparty był siediskiem ławki" +
                        "W tym ćwiczeniu trzymamy jeden hantel obiema rękoma nad głową. Trzymając nad sobą hantel należy lekko zgiąć ramiona w łokciach a następnie " +
                        "rozpocząć opuszczanie hantla za siebie pilnując przy tym ażeby nie zmienić kąta zgięcia w łokciu. Po wykonaniu pełnego rozciagnięcia należy unieść hantel z powrotem nad " +
                        "siebie. Ćwiczneie to rozwija mięsnie zębate klatki piersiowej. Należy uważać na odpowiedni ciężar ażeby zachować odpowiednią technikę"
                ,R.drawable.przenoszeniehantlanadglowa,"A");

        addSqlElement(db,"Krzyzowanie linek wyciagu gornego","Należy stanąć po środku bramy, pomiędzy dwoma górnymi wyciągami. Trzymając chwyty górnego wyciągu należy lekko się " +
                        "pochylić do przodu, następnie należy ściągać chwytami ręce przed siebie. Technika zbliżona do rozpiętek. Należy zachować odpowiedni ciężar ażeby nie wyciskać cięzaru, tylko rozciągać" +
                        "mięśne klatki piersiowej"
                ,R.drawable.krzyzowanielinekgornych,"A");

        addSqlElement(db,"Krzyzowanie linek wyciagu dolnego","Należy stanąć po środku bramy, pomiędzy dwoma dolnymi wyciągami. Trzymając chwyty dolnego wyciągu należy lekko" +
                        "pochylić się do przodu. Trzymane chwyty należy ściągać przed siebie uważając ażeby nie zmieniać kątą pomiędzy łokciami. Należy zachować odpowiedni ciężar oraz stabilną postawę "
                ,R.drawable.linkikrzyzowedolklatka,"A");

        addSqlElement(db,"Cwiczenia na maszynie","Ćwicząc na siłowni zazwyczaj należy zastosować się do instrukcji dołączonej do urządzenia. W przypadku braku w zależności od rodzaju maszyny, " +
                        "należy się odpowiednio położyc, ustawić uchwyty na odpowiedniej odległości oraz odpowiednio dobrać ciężar. Ćwicząc na maszynie należy zwrócić uwagę" +
                        "na odpowiednie rozłożenie ciężaru oraz odpowiednio ustawiony kąt chwytów oraz siedziska"
                ,R.drawable.maszynaklatka,"A");

        addSqlElement(db,"Siodemkowanie","Cwiczenie to najlepiej wykonywać sztangą na ławce poziomej. Należy położyc się tak aby nogi były ułożone pod kątem prostym" +
                        "żeby przylegały do podłoża. Należy chwycić sztangę tak ażeby po jej opuszczeniu pomiędzy ramieniem a przedramieniem był kąt prosty. " +
                        "Opusczając sztangę bierzemy głęboki wdech, następnie sztangę unosimy do połowy ruchu po czym znowu opuszczamy. Wypuszczamy powietrze i wkonujemy pełne wyciskanie "
                ,R.drawable.siodemkowanieklatka,"A");

        //barki
        addSqlElement(db,"Wyciskanie sztangi nad głowę stojąc","Należy stanąć w lekkim rozkroku, wypchnąc klatkę ku przodowi." +
                        "Unosząc sztangę nad głowę należy kontrolować płynność ruchu, nie należy się bujać. Sztangę opuszcza się do lini uszu,, nie niżej ażeby nie uszkodzić stawów barkowych. Istnieje możliwość wyciskania sztangi zza głowy, jednak zalecana" +
                        "jest wyjątkowa ostrożność, ze względu na duże obciążenie stawu barkowego." +
                        "Dla początkujących zalecane jest wykonywanie ćwiczenia na siedząco.(Można również wykonywać hantlami)"
                ,R.drawable.wyciskaniestojacprzedglowa,"B");
        addSqlElement(db,"Wyciskanie sztangi nad głowę siedząc","Należy pilnować pozycji i zachowywać naturalną krzywiznę kręgosłupa." + "Unosząc sztangę nad głowę należy kontrolować płynność ruchu, nie należy się bujać. " +
                        "Sztangę opuszcza się do lini uszu,, nie niżej ażeby nie uszkodzić stawów barkowych. (Można wykonywać na suwnicy oraz hantlami)"

                ,R.drawable.wyciskaniesiedzacprzedglowa,"B");
        addSqlElement(db,"Unoszenie hantli bokiem","Można wykonywać stojąc i siedząc. Trzymając hantle, należy wypchnąc klatkę" +
                        "ku przodowi. Ręce nieco ugiąć w łokciach. Unosząc ku górze hantle należy pilnować aby łokcie były wyżej niż dłonie. Unosimy do momentu kiedy łokcie będą na wysokosci barków. Następnie powoli należy opuścić hantle w dół wypuszczając" +
                        "przy tym powietrze"
                ,R.drawable.unoszeniebokbarki,"B");
        addSqlElement(db,"Wiosłowanie","Stojąc w lekkim rozkroku należy się pochylić pamiętając o zachowaniu prostego grzbietu(Nie wolno się garbić). Sztangę należy chwycić szeroko nachwytem. Uginając łokcie należy następnie " +
                        "przyciągać trzymaną sztangę do klatki piersiowej. Kiedy sztanga znajdzie się około 2cm od klatki piersiowej należy chwilę przytrzymać ciężar a następnie biorąc wydech powoli go opuścić"
                ,R.drawable.wioslowaniebarki,"B");

        addSqlElement(db,"Unoszenie w przód","Można wykonywać za pomocą hantli lub sztangi. Stojąc w lekkim rozkroku należy chwycić ciężar tak aby był na szerokości lini barkowej. Następnie należy podnieść ciężar na wysokość lini barkowej, nie wyżej i lekko przytrzymać." +
                        "Następnie biorąc wydech powoli opuścić trzymany hantel lub sztangę. Cwiczenie to można również wykonywać na siedząco, ważny jest odpowiedni ciężar aby uniknąc bujania się."
                ,R.drawable.unoszeniesztangiprzod,"B");
        addSqlElement(db,"Unoszenie hantli w opadzie","Zalecane wykonywanie siedząc na ławce. Trzymając hantle należy pochylić tułów ku przodowi oraz lekko zgiąć ręce w łokciach. Hantle należy unosić za siebie, (na boki) spinając przy tym łopatki. W momencie maksymalnego spięcia " +
                        "należy przytrzymać chwilę ciężar po czym biorąc wydech powoli go opuścić. Istotnym jest odpowiedni (zazwyczaj mniejszy) ciężar, który pozwoli zachować odpowiednią technikę i wyizolowanie tylnego aktonu barkowego. Duży ciężar spowoduje " +
                        "pracę innych mięśni niż tylny akton barku."
                ,R.drawable.unoszeniewopadzie,"B");
        //plecy
        addSqlElement(db,"Martwy ciag","Należy stanąć naprzeciwko sztangi w lekkim rozkroku. Następnie trzeba ugiąc nogi w kolanach pamiętając o naturalnej krzywiźnie kręgosłupa. Sztangę należy złapać nachwytem szerzej niż położenie stóp, oraz wypiąć przed siebie klatkę.  " +
                        "Następnie należy wziąć oddech i rozpocząć unoszenie sztangi ku górze zachowująć naturalną krzywiznę kręgosłupa. Sztangę unosimy blisko ciała. W momencie wyprostowania należy ściągnąc barki do tyłu oraz rozpocząć opuszczanie ciężaru ku dołowi" +
                        "Należy odpowiednio dobrać ciężar oraz pamiętać o zachowywaniu odpowiedniej pozycji."
                ,R.drawable.martwyciag,"C");

        addSqlElement(db,"Wiosłowanie hantli","Jedną ręką i kolanem należy oprzeć się o ławkę ustawioną na płasko. Drugą ręką należy wziąć hantel tak aby był on równolegle ułożony względem nas. Biorąc wdech należy unieść hantel przy ciele w górę, jednocześnie" +
                        "zmieniając kąt ramienia. W fazie końcowej należy spiąć łopatki oraz rozpocząć powolne opuszczanie ciężaru w dół z jednoczesnym wypuszczaniem powietrza."
                ,R.drawable.wioslohantleplecy,"C");
        addSqlElement(db,"Wyprosty na ławce rzymskiej","Należy ułożyć się na ławce, pamiętając o zaparciu się nogami o tylny uchwyt. Następnie należy ręce ułożyc na klatce piersiowej, wziąć wdech i rozpocząć opuszczanie się w dół, następnie należy " +
                        "rozpocząć unoszenie ku górze z jednoczesnym wypuszczaniem powietrza. W celu zwiększenia obciążenia można trzymać przy ciele talerz z ciężarem podczas wykonywania ćwiczenia. Cwiczenie to wzmacnia mięśnie głębokie odcinka lędźwiowego."
                ,R.drawable.rzymskaledzwia,"C");
        addSqlElement(db,"Wiosłowanie sztangą","Należy stanąć naprzeciwko sztangi w lekkim rozkroku. Następnie trzeba ugiąc nogi w kolanach pamiętając o naturalnej krzywiźnie kręgosłupa. Sztangę należy złapać nachwytem szerzej niż położenie stóp, oraz wypiąć przed siebie klatkę." +
                        "Następnie biorąc wdech, należy unieść sztangę do brzucha. W momencie kontaktu sztangi z brzuchem należy rozpocząć powolne jej opuszczanie. Istotne jest, aby kontrolować ustawienie kręgosłupa i nie robic tzw. kociego grzbietu. "
                ,R.drawable.wioslowanieplecy,"C");
        addSqlElement(db,"Podciaganie na drążku","Stojąc pod drążkiem, należy go szeroko złapać. Trzymając należy wypiąć klatkę przed siebie a tułów odchylić do tyłu.Przy jednoczesnym wdechu należy rozpocząć ruch unoszenia się w górę do momentu kiedy drążek" +
                        " znajdzie się na wysokości oczu. Następnie wypuszczając powietrze należy rozpocząć powolne opuszczanie się. Podciągać można się nachwytem lub podchwytem. "
                ,R.drawable.podciaganiedrazek,"C");
        //triceps

        addSqlElement(db,"Wyciskanie wąskie sztangi","Kładziemy się na ławce tak, by nogi ugięte" +
                        " były pod kątem prostym i przylegały do podłoża. Sztangę złapać na szerokość trochę mniejszą niż szerokość barków, mocno spiąć łopatki. " +
                        "Podczas wyjmowania sztangi z uchwytu należy wziąć wdech i opuścić sztangę nie dotykając klatki. Centymetr nad klatką należy zacząć unosić sztangę w górę przy jednoczesnym wypuszczaniu" +
                        " powietrza. Nie należy łapać sztangi zbyt wąsko ponieważ uszkadza to nadgarstki"
                ,R.drawable.wyciskwaskietriceps,"D");
        addSqlElement(db,"Francuskie wyciskanie hantli jednorącz","Można wykonywać na stojąco lub siedząco. W jednej ręce należy trzymać hantel. Obie ręce podnosimy w górę. Rękę bez hantla zginamy w łokciu pod kątem 90 stopni i opieramy o rękę z hantlem w celu " +
                        "stabilizacji. Następnie drugą ręką rozpoczynamu opuszczanie hantla w dół za siebię z jednoczesnym wdechem. W momencie maksymalnego rozciągnięcia mięśnia rozpoczynamy unoszenie hantla ku górze z jednoczesnym wydechem. Cwiczenie robimy naprzemiennie" +
                        " lewą i prawą ręką np. po 10 powtórzeń na każdą."
                ,R.drawable.francuskiejednoracz,"D");
        addSqlElement(db,"Francuskie wyciskanie hantla dwurącz","Można wykonywać na stojąco lub siedząco. W obu rękach należy trzymać hantel. Unosimy go w górę nad głowę. Następnie rozpoczynamu opuszczanie hantla w dół za siebię z jednoczesnym wdechem." +
                        " W momencie maksymalnego rozciągnięcia mięśnia rozpoczynamy unoszenie hantla ku górze z jednoczesnym wydechem. Lokcie skierowane do przodu. Ważne jest utrzymanie stabilnej postawy oraz pewne trzymanie hantla."
                ,R.drawable.francuskiedwuracz,"D");
        addSqlElement(db,"Prostowanie ramion na wyciągu","Należy stanąc przodem do wyciągu, w lekkim rozkroku. Następnie należy złapać rączki chwytów i pochylić się lekko w przód. Ręce wysunąc przed siebie." +
                        "Teraz należy ściągać obiema rękoma linki wyciągu w dół przy jednoczesnym wdechu. W momencie maksymalnego wyprostowania przytrzymac chwilę a następnie z jednoczesnym wydechem powrócić" +
                        " ku górze. Ważne aby pracować jedynie przedramionami, nie całymi rękoma."
                ,R.drawable.tricepslinkigorny,"D");
        addSqlElement(db,"Pompki na poręczach","Należy stanąć pomiędzy poręczami a następnie trzymając się poręczy, unieść ciało w górę. Ręce muszą przylegać do ciała. Następnie należy wziąć wdech i opuścić się " +
                        "w dół uginając ręce w łokciach. W momencie kiedy w łokciach będzie kąt 90 stopni należy przy jenoczesnym wydechu rozpocząć powrót do pozycji wyjściowej."
                ,R.drawable.szwedzkie,"D");

        //Biceps
        addSqlElement(db,"Uginanie ramion na modlitewniku","Należy ustawić odpowiednią wysokość modlitewnika a następnie usiąść. Ramiona położyc na oparciu i chwycić sztangę podchwytem. Następnie z jednoczesnym " +
                        "wdechem należy podnieść sztangę do momentu kiedy pomiędzy przedramieniem a łokciem będzie kąt prosty. Wypuszczając powietrze następnie należy opuścić sztangę w dół.  " +
                        "Opuszczając w dół należy uważać aby nie wykonywać przeprostu stawu łokciowego."
                ,R.drawable.modlitewnik,"E");

        addSqlElement(db,"Uginanie ramion młotkowo na wyciągu","Należy stanąc przodem do wyciągu, w lekkim rozkroku. Następnie należy złapać rączki chwytów, klatkę wypiąć do przodu. Ręce wysunąc przed siebie." +
                        "Teraz należy przy jednoczesnym wdechu rozpocząć przyciąganie linek w górę. W momencie kiedy kąt między przedramieniem a bicepsem będzie około 90 stopni przytrzymac chwilę a" +
                        " następnie z jednoczesnym wydechem powrócić" +
                        " w dół. Ważne aby pracować jedynie przedramionami, nie całymi rękoma."
                ,R.drawable.linkibicepsdol,"E");

        addSqlElement(db,"Uginanie ramion ze sztangą","Należy chwycić sztangę tak aby łokcie przylegały do ciała, wypiąć klatkę piersiową. Następnie biorąc wdech należy rozpocząć unoszenie sztangi do momentu" +
                        " kiedy pomiędzy przedramieniem a bicepsem będzie kąt okolo 90 stopni. Chwilę przytrzymać a następnie z jednoczesnym wydechem powrócić w dół. Unikać przeprostu stawu."
                ,R.drawable.uginanieramionstojacsztanga,"E");
        addSqlElement(db,"Uginanie ramion hantlami","Hantle należy trzymać równolegle względem ciała, nachwytem. Klatkę piersiową wysunąć lekko do przodu. Trzymając łokcie blisko ciała, biorąc wdech należy rozpocząć " +
                        "unoszenie hantli w górę do momentu uzyskania kąta prostego między bicepsem a przedramieniem. Po chwili powrócić wykonując wydech do pozycji startowej. Ważne aby łokcie cały czas przylegały do ciała"
                ,R.drawable.uginanieramionhantlestojac,"E");
        addSqlElement(db,"Uginanie ramion na wyciągu górnym","Należy stanąć pomiędzy dwoma górnymi wyciągami. Następnie wziąć chwyty wyciągu i lekko wysunąć się do przodu. Przy jednoczesnym wdechu należy przyciągać wyciągi do siebie w linii poziomej." +
                        "W momencie maksymalnego spięcia przy jednoczesnym wydechu należy powoli powrócić do pozycji startowej. Należy pilnować ażeby w trakcie ściągania chwytów pracować jedynie bicepsami."
                ,R.drawable.sciaganiewyciagugornego,"E");



        //brzuch
        addSqlElement(db,"Spinki brzucha","Nalezy sie położyc na płaskiej powierzchni, ugiąć nogi w kolanach do mniej więcej kąta prostego. Ręce położyć na klatce piersiowej.Przy jednoczesnym wdechu należy " +
                        "wykonać skłon tłowia do momentu kiedy poczuje się spięcie mięśnie brzucha. Następnie przy jednoczesnym wydechu należy powrócić do pozycji startowej. Nie ma potrzeby unoszenia całego ciała" +
                        " w górę, należy jedynie spinać mięśnie brzucha."
                ,R.drawable.spinki,"F");
        addSqlElement(db,"Unoszenie nóg wisząc","Nalez stanąć pod drążkiem a następnie go chwycić. Wisząc luźno na drążku należy rozpocząć unoszenie nóg przed siebie, " +
                        "zginając je jednocześnie w kolanach, najwyżej jak się da. Unosząc nogi należy uważać ażeby się nie bujać. Następnie z jednoczesnym wydechem powoli opuścić nogi w dół "
                ,R.drawable.unoszenienogbrzuch,"F");
        addSqlElement(db,"Nożyce","Nalezy sie położyc na płaskiej powierzchni. Ręce wzdłuż tłowia. Następnie należy unieść obie nogi wyprostowane w górę i unosić je naprzemiennie. Nogi unosimy pionowo w górę i w dół."
                ,R.drawable.nozyce,"F");




        //nogi
        addSqlElement(db,"Wypchnięcia na suwnicy","Należy ustawić fotel suwnicy odpowiednio pod nasz wzrost. Następnie należy oprzec stopy o platformę do wypychania. Po ustawieniu odpowiedniego ciężaru, należy rozpocząć" +
                        " wypychanie ciężaru przed siebie biorąc przy tym wdech. W momencie pełnego wyprostu należy jednocześnie wykonując wydech opuszczać platformę z powrotem do pozycji startowej"
                ,R.drawable.wypychaniesuwnica,"G");
        addSqlElement(db,"Przywodzenie nóg","Należy usiąśc na fotelu maszyny. Następnie w zależności od stopnia rozciągnięcia ustawić szerokość uchwytów na nogi. Po ustawieniu ich należy rozpocząć przyciąganie " +
                        "ich do środka z jednoczesnym wdechem. Następnie wypuszczając powietrze należy powrócić do pozycji startowej. "
                ,R.drawable.przywodzenie,"G");
        addSqlElement(db,"Odwodzenie nóg","Należy usiąśc na fotelu maszyny. Następnie ustawić uchwyty tak aby przylegały do nóg. Jednocześnie biorąc wdech należy wypychać nogi w bok. Przytrzymać w fazie największego" +
                        "rozepchnięcia a następnie z jednoczesnym wydechem powrócić do pozycji startowej."
                ,R.drawable.odwodzenie,"G");
        addSqlElement(db,"Prostowanie nóg na maszynie","Nalez odpowiedni ustawić siedzisko oraz oparcie nóg. Nogi zaprzeć o oparcie a następnie przy jednoczesnym wydechu rozpocząć unoszenie nóg aż do pełnego wyprostu." +
                        " Następnie przy jednoczesnym wydechu opuścić nogi w dół. Należy kontrolować stabilną pozycję na siedzisku."
                ,R.drawable.prostowanienog,"G");



        //przykladowe cwiczenia !

//tutaj dodaje sie elementy do drugiej bazy WSKAZOWKI!

 //<item>Plany treningowe poczatkujacy</item>A
        addSqlElementExample(db,"Przykładowy trening ogólnorozwojowy","Trening 2/3 razy w tygodniu. \n Rozgrzewka 15 minut. \n1.Podciąganie na drążku 3serie po 10 powtórzeń" +
                "\n2.Wyciskanie sztangi na ławce płaskiej 3 serie po 15 powtórzeń. \n3. Prostowanie nóg na maszynie 3 serie 15 powtórzeń \n4.Uginanie ramion ze sztangą 3 serie po 15 powtórzeń" +
                "\n5.Francuskie wyciskanie hantli jednorącz 3 serie 15 powtórzeń \n6. Unoszenie hantli bokiem 3 serie 15 powtórzeń \n Po skończonym treningu warto zadbać o odpowiednie rozciągnięcie." +
                " Ciężary do ćwiczeń wybieramy indywidualnie, pamiętając o odpowiedniej technice.",R.drawable.cwiczenialogo,"A");

        addSqlElementExample(db,"Przykładowy trening FBW","Trening FBW - Full Body Workout, oznacza trening całego ciała, można wykonywać 3 razy w tygodniu." +
                "\nRozgrzewka 15 minut. \n1.Wyciskanie sztangi na ławce ujemnej 3 serie po 12 powtórzeń. \n2.Wiosłowanie sztangą na plecy 3 serie po 12 powtórzeń. \n3.Unoszenie hantli bokiem 3 serie " +
                "\n4.Wypechnięcia nóg na suwnicy 4 serie po 10 powtórzeń. \n5. Uginanie ramion na modlitewniku 3 serie po 10 powtórzeń. \n6.Prostowanie ramion na wyciągu 3 serie po 12 powtórzeń." +
                "\n7. Nożyce na brzuch 3 serie po maksymalną ilość powtórzeń \n Po skończonym treningu warto zadbać o odpowiednie rozciągnięcie." +
                " Ciężary do ćwiczeń wybieramy indywidualnie, pamiętając o odpowiedniej technice.",R.drawable.cwiczenialogo,"A");

        addSqlElementExample(db,"Przykładowy trening SPLIT ","Split oznacza trening dzielony w którym w zależności od dnia wykonujemy określoną partię ciała, na przykład klatkę piersiową i biceps." +
                "\nRozgrzewka 15 minut. \nPONIEDZIALEK \n1. Wyciskanie sztangi na ławce neutralnej 3 serie po 12 powtórzeń \n2. Wyciskanie sztangi na ławce dodatniej 3 serie po 12 powtórzeń." +
                "\n 3. Rozpiętki hantlami na ławce poziomej 4serie po 12 powtórzeń \n4. Uginanie ramion ze sztangą na biceps 4 serie po 12 powtórzeń " +
                "\n5. Uginanie ramion na modlitewniku 4 serie po 12 powtórzeń. \n6. uginanie ramion na wyciągu 4 serie po 10 powtórzeń. \n7.Spinki brzucha 3 serie po maksymalną ilość powtórzeń." +
                "\nSRODA\n1. Wypchnięcia nóg na suwnicy 3 serie po 12 powtórzeń. \n2. Prostowanie nóg na maszynie 3 serie po 10 powtórzeń. \n3. Przywodzenie nóg 3 serie po 10 powtórzeń." +
                "\n4. Wyciskanie wąskie sztangi 4 serie po 12 powtórzeń. \n5. Francuskie wyciskanie hantli jednorącz 3 serie po 14 powtórzeń \nPIĄTEK \n 1.Wiosłowanie sztangą na plecy 3serie po 12 powtórzeń." +
                "\n2. Podciąganie na drążku 3 serie po 10 powtórzeń. \n3.Wyprosty na ławce rzymskiej 4serie po 10 powtórzeń. \n4. Unoszenie hantli w przód na barki 4serie po 12 powtórzeń." +
                "\n5. Wyciskanie sztangi nad głowę 4 serie po 12 powtórzeń \n6. Unoszenie nóg wisząc 3 serie po maksymalną liczbę powtórzeń ",R.drawable.cwiczenialogo,"A");

   //     <item>Plany treningowe zaawansowany</item>B
        addSqlElementExample(db,"Przykładowy trening SPLIT","Odpowiednia 20 minutowa rozgrzewka przed każdym treningiem. \nPONIEDZIALEK \n1.Wyciskanie sztangi na ławce neutralnej 3serie  12-10-8 powtórzeń zwiększając ciężar \n2.Wyciskanie sztangi na ławce dodatniej " +
                "3serie 12-10-8 powtórzeń zwiększając ciężar co serię. \n3.Rozpiętki hantlami na ławce poziomej 4 serie po 12 powtórzeń \n4.Uginanie ramion ze sztangą stojąc 4 serie " +
                "14-12-10-8 powtórzeń zwiększając ciężar. \n5.Uginanie ramion hantlami 4 serie po 10 powtórzeń \n6. Uginanie ramion na wyciągu \n7.Spinki brzucha 4 serie maksymalna ilość powtórzeń" +
                "\nSRODA \n1. Martwy ciąg 4 serie po 12-10-8-6 powtórzeń, zwiększając ciężar co serię. \n2.Podciąganie na drążku 4 serie po 10 powtórzeń. \n3. Wyprosty na ławce rzymskiej 4 serie po 10 powtórzeń." +
                "\n4.Wyciskanie wąskie sztangi 4 serie 12-10-8-6 powtórzeń. \n5.Francuskie wyciskanie hantla dwurącz 4serie po 12 powtórzeń. \n6.Prostowanie ramion na wyciągu 4serie po 10 powtórzeń." +
                "\nPIĄTEK \n 1.Wypchnięcia nóg na suwnicy 4 serie po 12 powtórzeń. \n2.Prostowanie nóg na maszynie 4 serie po 10 powtórzeń. \n3. Przywodzenie nóg 4 serie po 12 powtórzeń." +
                "\n 4.Wyciskanie sztangi nad głowę siedząc 4 serie 12-10-8-6 powtórzeń. \n5. Unoszenie hantli w opadzie 4 serie po 12 powtórzeń \n6.Unoszenie hantli w przód 4 serie po 10 powtórzeń.",R.drawable.cwiczenialogo,"B");
        addSqlElementExample(db,"Trening Push Pull","Trening ten polega na podzieleniu dni treningowch na takie w których robimy najpierw ćwiczenia wypychające a następnie przyciągające." +
                "\n Trening przyciągający \n1. Martwy ciąg 5 serii po 5 powtórzeń. \n2. Uginanie ramion ze sztangą 6 serii po 5 powtórzeń \n3.Wiosłowanie sztangą 5 serii po 5 powtórzeń. \n4.Podciąganie na drążku 5 serii po 5 powtórzeń" +
                "\nTrening Wypychający \n 1.Wyciskanie sztangi na ławce poziomej 5 serii po 5 powtórzeń \n2.Wyciskanie sztangi nad głowę siedząc 4 serie po 6 powtórzeń. \n3.Pompki na poręczach 5 serii po 10 powtórzeń \n4.Wypchnięcia nóg na suwnicy 5 serii po 10 powtórzeń. ",R.drawable.cwiczenialogo,"B");

        addSqlElementExample(db,"Plan treningowy 5x5","Plan ten jest przeznaczony przedewszystkim w celu zwiększenia siły. Polega na wyciskaniu ciężarów w 5 seriach po 5 powtórzeń. Kładzie się nacisk na duże ciężary. Trening podzielony na dwa dni," +
                ", można wykonywać na przykład w poniedziałek i czwartek, tak aby była przerwa około 4 dni między jednym treningiem a drugim." +
                "\nTrening ten można podzielić na dwa dni. \nDzien pierwszy cięższy\n 1. Wyciskaie sztangi płaskiej 5 serii 5 powtórzeń \n2. Martwy ciąg 5 serii po 5 powtórzeń" +
                "\n3.Wiosłowanie sztangą 5 serii po 5 powtórzeń \n4.Pompki na poręczach 5 serii po 5 powtórzeń. \n5.Wypchnięcia nóg na suwnicy 5 serii po 5 powtórzeń" +
                "\nDzien drugi lżejszy \n 1.Prostowanie nóg na maszynie 3 serie po 8 powtórzeń \n2. Wyciskanie wąskie sztangi 3 serie po 10 powtórzeń \n3. Uginanie ramion na modlitewniku 3 serie po 8 powtórzeń" +
                "\n4. Unoszenie hantli bokiem 3 serie po 8 powtórzeń \n5. Spinki brzucha 4 serie po 12 powtórzeń ",R.drawable.cwiczenialogo,"B");




     //   <item>Cardio</item>C
        addSqlElementExample(db,"Co to jest CARDIO","Trening cardio, jest to trening wytrzymałościowy. Często stosowany jest w celu szybkiego pozbycia się zbędnej tkanki tłuszczowej." +
                "\nW trakcie wykonywania treningu cardio ważne jest odpowiednie tętno. Tętno w trakcie trwania wysiłku powinno wynosić około 60% tętna maksymalnego. W trakcie wykonywania cardio, " +
                "przydatne jest korzystanie z opaski mierzącej puls, lub w przypadku niektórych maszyn, na przykład rowerki stacjonarne, korzystanie z wbudowanych pulsometrów. W trakcie trwania " +
                "treningu należy zadbać o odpowiednie nawodnienie organizmu. Przed rozpoczęciem treningu należy przeprowadzić minimum 10 minutową rozgrzewkę. Trening cardio powinien trwać minimum pół godziny," +
                "2-3 razy w tygodniu.",R.drawable.cwiczenialogo,"C");
        addSqlElementExample(db,"Przykłady CARDIO","Przykładowe treningi cardio." +
                "\n1. Jazda na rowerze, na przykład na rowerze stacjonarnym." +
                "\n2. Bieganie, należy zadbać o odpowiednie amortyzujące obuwie" +
                "\n3. Pływanie, wpływa również korzystanie na stawy" +
                "\n4. Nordic Walking, chodzenie z kijami angażuje całe ciało, ważne jest jednak zachowanie odpowiedniej techniki chodu." +
                "\n5. Skakanie na skakance, ważne jest wcześniejsze rozgrzanie stawów.   ",R.drawable.cwiczenialogo,"C");
       // <item>Zlote rady</item>D
        addSqlElementExample(db,"Motywacja","Motywacja oraz cierpliwość w sportach sylwetkowych jest niezwykle ważna. Istotnym jest to, aby się nie zniechęcić do wykonywanego sportu " +
                "z powodu początkowo małych efektów. Wraz z rosnącym doświadczeniem oraz odpowiednim wykonywaniem ćwiczeń efekty napewno się pojawią. W przypadku rozpoczęcia treningów warto wykonać sobie" +
                " zdjęcie przed rozpoczęciem uprawiania sportu, oraz sukcesywnie co jakis okres czasu, na prrzykład co pół roku wykonywać nowe zdjęcie i porównywac efekty.",R.drawable.cwiczenialogo,"D");
        addSqlElementExample(db,"Dieta","W przypadku sportów sylwetkowych odpowiednia dieta jest niezwykle ważna. W zależności od celu, czy to budowania masy mięśniowej czy redukowania tkanki tłuszczowej " +
                ", dieta powinna zawierać odpowiednio nadwyżkę kaloryczną lub ten być na ujemnym bilansie kalorycznym. Odpowiednie odżywianie jest niezwykle ważne w trakcie intensywnych treningów " +
                "ze względu na tracone w wyniku ćwiczeń składniki. ",R.drawable.cwiczenialogo,"D");
        addSqlElementExample(db,"Odpoczynek","W przypadku sportów sylwetkowych ale i nie tylko odpoczynek stanowi bardzo ważny element dnia. W trakcie odpoczynku mięsnie się regenerują i rosną." +
                " Ważne jest aby nie doprowadzić do przetrenowania w skutek którego można czuć się źle oraz stracić motywację do dalszych treningów." +
                " Odpoczynek jest ważny również w celu uniknięcia kontuzji ze względu na przetrenowane, zmęczone mięsnie. Odpoczynek oznacza również sen, o który warto zadbać.",R.drawable.cwiczenialogo,"D");

        //<item>Rozgrzewka</item>E
        addSqlElementExample(db,"Istota rozgrzewki","Nigdy nie należy zapominać o odpowiednim przygotowaniu do wykonywania ćwiczeń. Dobre rozgrzanie mięśni przed treningiem " +
                "może pozwolić uniknąć kontuzji, oraz może polepszyć efekty treningu. Rozgrzewka stanowi wstęp oraz przygotowanie do dalszego siłowego treningu. Powinna trwać minimum 15 minut." +
                "W trakcie wykonywania rozgrzewki należy dużą uwagę skupić na to aby rozgrzać stawy i mięśnie które w głównej mierze będą brały udział w treningu siłowym." +
                "Na przykład wykonując trening nóg, ważne jest aby odpowiedno rozgrzać między innymi stawy kolanowe oraz mięśnie nóg.",R.drawable.cwiczenialogo,"E");
        addSqlElementExample(db,"Rozciąganie","Rozciąganie inaczej nazywane stretching. Rozciąganie może stanowić element rozgrzewki a także powinno być wykonywane po treningu." +
                "Prawidłowe rozciąganie pozwala uniknąc kontuzji ze względu na wzmocnienie ścięgien. Rozciąganie może być też ciekawą formą odpoczynku podczas której rozluźniają się mięśnie. ",R.drawable.rozciaganie,"E");
        addSqlElementExample(db,"Wygląd rozgrzewki","W trakcie wykonywania rozgrzewki nie należy brać dużych ciężarów. Rozgrzewka stanowi dopiero wstęp do dalszego treningu na większych ciężarach. " +
                "W trakcie wykonywania rozgrzewki należy odpowiednio rozruszać nasze stawy. Można to zrobić wykonując wszelkiego rodzaju krążenia, na przykład krążenia głową, ramion, barków, " +
                "nadgarstków czy tez tułowia. W ramach wykonywania rozgrzewki można również wykonać krótkie ćwiczenia aerobowe, na przykład 5 minut jazdy na rowerze lub orbitreku." +
                "Przed rozpoczęciem treningu warto również pierwsze ćwiczenia wykonywać na małych ciężarach lub samym gryfem. Na przykład wykonując wyciskanie sztangi na ławce, " +
                "warto się położyć i kilka razy samym gryfem bez obciążenia wykonać kilka pełnych ruchów. ",R.drawable.cwiczenialogo,"E");

      //  <item>Suplementy</item>F FFFFFFFFFFFFFFFFFFFF
        addSqlElementExample(db,"Kreatyna","1.Jest to jeden z najpopularniejszych suplementów diety wśród osób ćwiczących. Pomaga budować siłę i masę mięśni. Jego zadaniem jest" +
                "gromadzenie energii ATP w mięśniach. Najpopularniejszą jest kreatyna typu monohydrat, wiąże on i zatrzymuje wodę w komórkach. Nie jest to suplement" +
                "dla osób posiadających problemy z nerkami \n2.Kreatynę należy przyjmować zgodnie z zaleceniami producenta. Najczęściej w cyklach 8-12 tygodni " +
                "przestrzegając przy tym odpowiedniej diety. Należy pamiętać o odpowiednim nawadnianiu organizmu.   ",R.drawable.koks,"F");
        addSqlElementExample(db,"Bialko","Białko jest podstawowym składnikiem budulcowym mięśni. Wspomaganie się suplementami białkowymi jest wymagane jedynie wtedy, gdy nie jesteśmy w stanie dostarczyć jego odpowiednią" +
                " ilość w diecie. Przed rozpoczęciem suplementacji tym produktem należy się upewnić co do stanu naszego zdrowia. Ilość spożywanego białka zależy od indywidualnej diety osoby trenującej. ",R.drawable.koks,"F");
        addSqlElementExample(db,"Gainer","Gainer jest suplementem składającym się zazwyczaj z węglowodanów i białek. Najczęściej węglowodanów jest więcej, około 70% niż białek, których jest okolo 20-30%." +
                "Gainery stosowane są zazwyczaj w momencie kiedy osoba trenująca, chcąca osiągnąć większą masę mięśniową ma z tym problem lub nie może dostarczyć wymaganych składników w stosowanej diecie" +
                "Gainery często nazywane są odżywkami białkowo-węglowodanowymi. W przypadku odpowiedniej diety, suplementacja tego typu odżywkami nie jest wymagana.",R.drawable.koks,"F");
        addSqlElementExample(db,"BCAA","BCAA są to aminokwasy których zadaniem jest między innymi działanie antykataboliczne. Oprócz tego BCAA, przyspiesza regenrację mięśni oraz może przyczynić się" +
                " do zmniejszenia zmęczenia. Ilość przyjmowanego suplementu jest kwestią indywidualną, należy stosować się do zaleceń producenta odnośnie zalecanego spożycia. BCAA często oprócz formy w proszku," +
                "można spotkać w puszkach wymieszane już, gotowe do spożycia.",R.drawable.koks,"F");
        addSqlElementExample(db,"ZMA","Jest to suplement stanowiący połączenie trzech składników. Składa się on z magnezu, cynku oraz witaminy B6. Jest to suplement przeznaczony dla osób u których" +
                " w diecie nie ma odpowiedniej dziennej zalecanej dawki do spożycia. W przypadku stosowania diety bogatej w te pierwiastki, suplementacja tym produktem nie jest wymagana." +
                " Osobiście stosując ten suplement zauważyłem szybszą regenerację organizmu oraz poprawę snu.  ",R.drawable.koks,"F");
        addSqlElementExample(db,"PRE workouty","PRE-Workouty, inaczej nazywane odżywkami przedtreningowymi. Jest to grupa suplementów diety stosowana przed treningiem. Najczęściej około 30 minut przed" +
                " rozpoczęciem wysiłku fizycznego. W składzie zawierają one najczęściej takie produkty jak: kofeina, tauryna, beta-alanina, kreatyna, aminokwasy BCAA. Ich zadaniem " +
                "jest pobudzenie nas w czasie wykonywania treningu. W przypadku tych suplementów niezwykle ważne jest przestrzeganie zaleceń producenta odnośnie prawidłowego zażywania. ",R.drawable.koks,"F");
        addSqlElementExample(db,"AAKG","Jest to suplement stanowiący połączenie dwóch składników, takich jak arginina oraz kwasu glutarowego. Posiada podobnie jak aminokwasy BCAA działanie antykataboliczne." +
                " AAKG wpływa pozytywnie na rozwój mięśni oraz wzrost siły. Należy stosowac suplement ten zgodnie z zaleceniami producenta. ",R.drawable.koks,"F");



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