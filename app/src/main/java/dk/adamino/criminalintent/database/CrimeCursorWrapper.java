package dk.adamino.criminalintent.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import dk.adamino.criminalintent.Model.Crime;
import dk.adamino.criminalintent.database.CrimeDBSchema.CrimeTable;

/**
 * Created by Adamino.
 */

public class CrimeCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(CrimeTable.Cols.TITLE));
        String date = getString(getColumnIndex(CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        Date parsedDate = new Date();
        try {
             parsedDate = formatter.parse(date);
        } catch (ParseException e) {
            Log.e("DB", e.getMessage());
        }
        crime.setDate(parsedDate);
        crime.setSolved(isSolved != 0);

        return crime;
    }
}
