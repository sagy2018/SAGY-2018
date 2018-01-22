package com.example.jason.sagy;

import android.provider.BaseColumns;

/**
 * Created by goa on 22/1/18.
 */

public class ContractClass {

    public final class Utils implements BaseColumns{

        public static final String ID = BaseColumns._ID;
        public static final String TABLE_NAME = "m_table";
        public static final String COLUMN_TITLE = "column_title";
        public static final String COLUMN_CONTENT = "column_content";

    }

}
