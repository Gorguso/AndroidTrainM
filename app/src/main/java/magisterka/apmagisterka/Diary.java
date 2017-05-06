package magisterka.apmagisterka;

import android.content.Context;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Dawid on 2017-05-04.
 */
//notepad 1 klasa
public class Diary implements Serializable{

    private long mDateTime;
    private String mTitle;
    private String mContent;

    public Diary(String mContent, long mDateTime, String mTitle) {
        this.mDateTime = mDateTime;
        this.mTitle = mTitle;
        this.mContent = mContent;
    }

    public long getDateTime() {
        return mDateTime;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }


    public void setDateTime(long mDateTime) {
        this.mDateTime = mDateTime;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public String getDateTimeFormatted(Context context) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss",
                context.getResources().getConfiguration().locale);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.format(new Date(mDateTime));


    }
}

