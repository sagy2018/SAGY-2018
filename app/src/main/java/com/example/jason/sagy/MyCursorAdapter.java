package com.example.jason.sagy;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by goa on 23/1/18.
 */

public class MyCursorAdapter extends CursorAdapter {


    public MyCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.notification_layout, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {


        TextView titleView = view.findViewById(R.id.notification_title_textView);
        TextView contentView = view.findViewById(R.id.notification_content_textView);

        String title = cursor.getString(cursor.getColumnIndexOrThrow(ContractClass.Utils.COLUMN_TITLE));
        String content = cursor.getString(cursor.getColumnIndexOrThrow(ContractClass.Utils.COLUMN_CONTENT));

        titleView.setText(title);
        contentView.setText(content);


    }
}
