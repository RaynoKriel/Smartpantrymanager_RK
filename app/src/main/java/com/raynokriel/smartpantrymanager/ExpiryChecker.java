package com.raynokriel.smartpantrymanager;

import android.content.Context;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

//Checks pantry items and warns if any item expires within 3 days.
 public class ExpiryChecker {

    public static void checkExpiryDates(Context context,List<PantryItem> pantryItems) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
        Date today = new Date();

        for (PantryItem item : pantryItems) {
            String expiry = item.getExpiryDate();
            if (expiry == null || expiry.isEmpty()) {
                continue;
            }
            try {
                Date expiryDate = format.parse(expiry);
                if (expiryDate == null) {continue;}
                long diffMillis = expiryDate.getTime() - today.getTime();
                long daysRemaining = TimeUnit.MILLISECONDS.toDays(diffMillis);

                if (daysRemaining >= 0 && daysRemaining <= 3) {
                    Toast.makeText(context,"Expiry Warning: " + item.getName()
                            + " expires in " + daysRemaining + " day(s).",Toast.LENGTH_LONG).show();
                    return;
                }

            } catch (Exception ignored) {
            }
        }
    }
}