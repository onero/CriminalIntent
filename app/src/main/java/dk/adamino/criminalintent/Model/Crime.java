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
    private SimpleDateFormat mDateFormat, mTimeFormat;
    private String mSuspect;

    public Crime() {
        this(UUID.randomUUID());
    }

    public Crime(UUID id) {
        mTitle = "";
        mId = id;
        mDate = new Date();
        mDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        mTimeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
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
    public String getTimeAsString() {
        return mTimeFormat.format(mDate);
    }

    public void setDate(Date date) {
        mDate = new Date(date.getYear(), date.getMonth(), date.getDate(), mDate.getHours(), mDate.getMinutes());
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public void setTime(Date date) {
        mDate.setHours(date.getHours());
        mDate.setMinutes(date.getMinutes());
    }

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }

    public String getPhotoFilename() {
        return "IMG " + getId().toString() + ".jpg";
    }
}
