package com.alsimon.War3Soundboard.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.alsimon.War3Soundboard.R;

public class UnitHolder extends RecyclerView.ViewHolder {

    private TextView mTextView;

    public UnitHolder(View view) {
        super(view);
        mTextView = (TextView) view.findViewById(R.id.text);
    }

    public void bindItem(String text) {
        mTextView.setText(text);
    }

    @Override
    public String toString() {
        return mTextView.getText().toString();
    }
}