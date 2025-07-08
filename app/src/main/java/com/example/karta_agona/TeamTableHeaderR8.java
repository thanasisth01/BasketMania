package com.example.karta_agona;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.codecrafters.tableview.TableHeaderAdapter;

public class TeamTableHeaderR8 extends TableHeaderAdapter {

    private String[] headers;
    private int paddingLeft = 0;
    private int paddingTop = 10;
    private int paddingRight = 0;
    private int paddingBottom = 10;
    private int textSize = 17;
    private int typeface = Typeface.BOLD;
    private int textColor = 0x99000000;
    private int gravity = Gravity.CENTER;


    public TeamTableHeaderR8(Context context, String[] headers) {
        super(context);
        this.headers = headers;
    }

    @Override
    public View getHeaderView(int columnIndex, ViewGroup parentView) {
        TextView textView = new TextView(getContext());

        if (columnIndex < headers.length) {
            textView.setText(headers[columnIndex]);
        }

        textView.setGravity(gravity);
        textView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        textView.setTypeface(textView.getTypeface(), typeface);
        textView.setTextColor(textColor);
        textView.setEllipsize(null);
        textView.setTextSize(textSize);
        //textView.setSingleLine(true);

        return textView;
    }

    public void setPaddings(final int left, final int top, final int right, final int bottom) {
        paddingLeft = left;
        paddingTop = top;
        paddingRight = right;
        paddingBottom = bottom;
    }

    /**
     * Sets the gravity of the text inside the header cell.
     * @param gravity The gravity of the text inside the header cell.
     */
    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    /**
     * Sets the padding that will be used on the left side for all table headers.
     *
     * @param paddingLeft The padding on the left side.
     */
    public void setPaddingLeft(final int paddingLeft) {
        this.paddingLeft = paddingLeft;
    }

    /**
     * Sets the padding that will be used on the top side for all table headers.
     *
     * @param paddingTop The padding on the top side.
     */
    public void setPaddingTop(final int paddingTop) {
        this.paddingTop = paddingTop;
    }

    /**
     * Sets the padding that will be used on the right side for all table headers.
     *
     * @param paddingRight The padding on the right side.
     */
    public void setPaddingRight(final int paddingRight) {
        this.paddingRight = paddingRight;
    }

    /**
     * Sets the padding that will be used on the bottom side for all table headers.
     *
     * @param paddingBottom The padding on the bottom side.
     */
    public void setPaddingBottom(final int paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    /**
     * Sets the text size that will be used for all table headers.
     *
     * @param textSize The text size that shall be used.
     */
    public void setTextSize(final int textSize) {
        this.textSize = textSize;
    }

    /**
     * Sets the typeface that will be used for all table headers.
     *
     * @param typeface The type face that shall be used.
     */
    public void setTypeface(final int typeface) {
        this.typeface = typeface;
    }

    /**
     * Sets the text color that will be used for all table headers.
     *
     * @param textColor The text color that shall be used.
     */
    public void setTextColor(final int textColor) {
        this.textColor = textColor;
    }
}
