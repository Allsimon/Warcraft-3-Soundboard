package com.alsimon.War3Soundboard.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alsimon.War3Soundboard.R;
import com.alsimon.War3Soundboard.controller.SoundPlayer;
import com.alsimon.War3Soundboard.model.Sound;
import com.alsimon.War3Soundboard.model.Unit;
import com.alsimon.War3Soundboard.ui.holder.UnitHolder;
import com.alsimon.War3Soundboard.utils.Logg;
import com.tonicartos.superslim.GridSLM;
import com.tonicartos.superslim.LinearSLM;

import java.util.ArrayList;
import java.util.List;

public class UnitAdapter
        extends RecyclerView.Adapter<UnitHolder> {

    private static final int VIEW_TYPE_HEADER = 0x01;

    private static final int VIEW_TYPE_CONTENT = 0x00;

    private static final int LINEAR = 0;

    private final ArrayList<LineItem> mItems;

    private int mHeaderDisplay;

    private boolean mMarginsFixed;

    private final Context mContext;

    public UnitAdapter(Context context, int headerMode, List<Unit> units) {
        mContext = context;

        mHeaderDisplay = headerMode;

        mItems = new ArrayList<>();
        String lastHeader = "";
        int sectionManager = -1;
        int headerCount = 0;
        int sectionFirstPosition = 0;
        for (int i = 0; i < units.size(); i++) {
            if (!TextUtils.equals(lastHeader, units.get(i).getName())) {
                sectionManager = (sectionManager + 1) % 2;
                sectionFirstPosition = i + headerCount;
                lastHeader = units.get(i).getName();
                headerCount += units.get(i).getSounds().size();
                mItems.add(new LineItem(lastHeader, true, sectionManager, sectionFirstPosition));
            }
            for (Sound sound : units.get(i).getSounds())
                mItems.add(new LineItem(sound.getName(), false, sectionManager, sectionFirstPosition, sound.getResource()));
        }
    }

    @Override
    public UnitHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_HEADER) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.unit_item_header, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.unit_item, parent, false);
        }
        return new UnitHolder(view);
    }

    @Override
    public void onBindViewHolder(UnitHolder holder, int position) {
        final LineItem item = mItems.get(position);
        final View itemView = holder.itemView;

        holder.bindItem(item.text);

        final GridSLM.LayoutParams lp = GridSLM.LayoutParams.from(itemView.getLayoutParams());
        // Overrides xml attrs, could use different layouts too.
        if (item.isHeader) {
            lp.headerDisplay = mHeaderDisplay;
            if (lp.isHeaderInline() || (mMarginsFixed && !lp.isHeaderOverlay())) {
                lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
            } else {
                lp.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            }

            lp.headerEndMarginIsAuto = true;
            lp.headerStartMarginIsAuto = true;
        } else {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SoundPlayer.INSTANCE.play(item.resource);
                }
            });
        }
//        lp.setSlm(item.sectionManager == LINEAR ? LinearSLM.ID : GridSLM.ID);
        lp.setColumnWidth(mContext.getResources().getDimensionPixelSize(R.dimen.nav_drawer));
        lp.setFirstPosition(item.sectionFirstPosition);
        itemView.setLayoutParams(lp);
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).isHeader ? VIEW_TYPE_HEADER : VIEW_TYPE_CONTENT;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    private static class LineItem {

        public int sectionManager;

        public int sectionFirstPosition;

        public boolean isHeader;

        public String text;
        public String resource;

        public LineItem(String text, boolean isHeader, int sectionManager,
                        int sectionFirstPosition) {
            this(text, isHeader, sectionManager, sectionFirstPosition, "");
        }

        public LineItem(String text, boolean isHeader, int sectionManager,
                        int sectionFirstPosition, String resource) {
            this.sectionManager = sectionManager;
            this.sectionFirstPosition = sectionFirstPosition;
            this.isHeader = isHeader;
            this.text = text;
            this.resource = resource;
        }
    }
}