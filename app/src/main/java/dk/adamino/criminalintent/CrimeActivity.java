package dk.adamino.criminalintent;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {
    private static final String EXTRA_CRIME_ID = "dk.adamino.criminalIntent.crime_ID";

    public static Intent newIntent(Context packageContext, UUID crimeID) {
        Intent intent = new Intent(packageContext, CrimeActivity.class);
        intent.putExtra(CrimeActivity.EXTRA_CRIME_ID, crimeID);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID crimeId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }
}
