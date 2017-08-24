package com.example.hp.testing;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Hp on 22-08-2017.
 */

class ActivityUtil {
    private Context context;

    public ActivityUtil(Context context) {
        this.context = context;
    }

    public void startMainActivity() {
        context.startActivity(new Intent(context, MainActivity.class));
    }
}
