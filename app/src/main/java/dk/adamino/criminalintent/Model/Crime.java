package dk.adamino.criminalintent.Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 * Created by Adamino.
 */

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private SimpleDateFormat mDateFormat;

    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
        mDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());

    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public String getDateAsString() {
        return mDateFormat.format(mDate);
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
