package zz.haut.tieasy.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author Qin
 * @date 2017/4/1.
 * @describe
 */

public class DataStorageUtil {

        public static void putString(Context context, String key, String value) {
            SharedPreferences sp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(key, value);
            editor.commit();
        }
        public static String getString(Context context, String key, String defaultValue) {
            SharedPreferences sp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
            return sp.getString(key, defaultValue);
        }

}
