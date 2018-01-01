package pro.nanosystems.listviewsample.data;

import android.provider.BaseColumns;

/**
 * Created by Sayyid Shaban on 28/12/2017.
 * E-mail: sayyid.ls@gmail.com
 */

public class StudentContarct {
    public static final class StudentData implements BaseColumns {

        public static final String TABLE_NAME ="students";
        public static final String NAME = "name";
        public static final String GENDER = "gender";

        public static final int MALE = 0;
        public static final int FEMALE = 1;

        public static final String SQL_CREATE =
                "CREATE TABLE "+ TABLE_NAME + "("+_ID +
                        " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        NAME + " TEXT, "+ GENDER + " INTEGER);";
        public static final String SQL_DELETE = " DROP TABLE IF EXISTS " + TABLE_NAME;

    }
}
