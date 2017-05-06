package magisterka.apmagisterka;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Dawid on 2017-05-04.
 */

public class DiaryAdapterTool extends ArrayAdapter<Diary>{

//adapter d pokazywania po zapisaniu wiadomosci na liscie
    public DiaryAdapterTool(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Diary> diaries) {
        super(context, resource, diaries);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView == null)
        {
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.diary_elements,null);
        }
        Diary diary = getItem(position);
        if(diary != null)
        {

            TextView t1 = (TextView) convertView.findViewById(R.id.diary_elements_list1);
            TextView t2 = (TextView) convertView.findViewById(R.id.diary_elements_list2);
            TextView t3 = (TextView) convertView.findViewById(R.id.diary_elements_list3);
            t1.setText(diary.getTitle());

            t2.setText(diary.getDateTimeFormatted(getContext()));

            if(diary.getContent().length()>50)
            {
                t3.setText(diary.getContent().substring(0,50));
            }else
            {
                t3.setText(diary.getContent());
            }
        }
return convertView;//adapter d pokazywania po zapisaniu wiadomosci na liscie
    }
}
