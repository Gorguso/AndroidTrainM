package magisterka.apmagisterka;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Dawid on 2017-05-04.
 */

public class DiaryTools {
//saving serializacja
    public static final String FILE_EXTENSION = ".bin" ;

    public static boolean zapiszDiary(Context context, Diary diary) // zapis na dysk
    {
        String fileName = String.valueOf(diary.getDateTime()) + FILE_EXTENSION ;

        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;

        try{
            fileOutputStream = context.openFileOutput(fileName , context.MODE_PRIVATE);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(diary);
            objectOutputStream.close();
        }catch (IOException exception)
        {
exception.printStackTrace();
            return false;
        }


        return true;
    }

    public static Diary returnDiary(Context context, String s)
    {

        File file = new File(context.getFilesDir(), s);
        Diary diary;
        if(file.exists())
        {
            FileInputStream fileInputStream;
            ObjectInputStream objectInputStream;

            try{
                fileInputStream = context.openFileInput(s);
                objectInputStream = new ObjectInputStream(fileInputStream);

                diary = (Diary) objectInputStream.readObject();

                objectInputStream.close();
                fileInputStream.close();


            }catch (IOException | ClassNotFoundException exception)
            {
                exception.printStackTrace();
                return null;
            }
            return diary;
        }
        return null;

    }//do zwrotu po liscie

public static ArrayList<Diary> returnDiaries(Context context)
{
    ArrayList<Diary> diaries = new ArrayList<>();
    File files = context.getFilesDir();
    ArrayList<String> arrayList = new ArrayList<>();

    for(String s : files.list())
    {
        if(s.endsWith(FILE_EXTENSION))
        {
            arrayList.add(s);
        }
    }

    FileInputStream fileInputStream ;
    ObjectInputStream fileOutputStream ;

    for(int x = 0 ; x < arrayList.size(); x++)
    {
        try{

            fileInputStream = context.openFileInput(arrayList.get(x));
            fileOutputStream = new ObjectInputStream(fileInputStream);

            diaries.add((Diary)fileOutputStream.readObject());

            fileInputStream.close();
            fileOutputStream.close();


        }catch (IOException | ClassNotFoundException exception)
        {
            exception.printStackTrace();
            return null;
        }
    }

return diaries;


}


    public static void removeItem(Context context, String s) {
        File file = context.getFilesDir();
        File fileEx = new File(file,s);

        if(fileEx.exists())
        {
            fileEx.delete();
        }
    }//item delete
}
