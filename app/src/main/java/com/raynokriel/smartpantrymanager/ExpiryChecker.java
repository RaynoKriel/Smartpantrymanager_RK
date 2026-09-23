package com.raynokriel.smartpantrymanager;

import android.content.Context;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

//this is just the date checker logic to see if it is 3days to expiry
public class ExpiryChecker {
    public static void checkExpiryDates(Context context, List<PantryItem> pantryItems) {
        LocalDate today = LocalDate.now();
        for (PantryItem item : pantryItems) {
            String expiry = item.getExpiryDate();

            if (expiry == null || expiry.isEmpty()) {
                continue;
            }
            try {
                LocalDate expiryDate = LocalDate.parse(expiry);
                long daysRemaining = ChronoUnit.DAYS.between(today,expiryDate);

                if (daysRemaining >= 0 && daysRemaining <= 3) {
                    NotificationHelper.showExpiryNotification(context, item.getName(),daysRemaining);
                }
            } catch (Exception ignored) {
                //i dont have a spesific error for here just catching failure for now
            }
        }
    }
}