package com.refined.stylish.sanhdieu.presentation.ui.adapter;
import android.widget.ImageView;


import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.refined.stylish.sanhdieu.R;
import com.refined.stylish.sanhdieu.commons.KPBMainIntent;
import com.refined.stylish.sanhdieu.domain.model.OVNNameLauncher;


 

public class NGKObject extends ArrayAdapter<OVNNameLauncher.HQAfter> {

    private final int mResId;
    private OnDeleteItemClickListener mDeleteItemClickListener;

    public NGKObject(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        mResId = resource;
    }

    public void setOnDeleteItemClickListener(OnDeleteItemClickListener listener) {
        mDeleteItemClickListener = listener;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        RConstructor holder;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(mResId, parent, false);
            holder = new RConstructor(view);
            view.setTag(holder);
        }
        else {
            holder = (RConstructor) view.getTag();
        }

        OVNNameLauncher.HQAfter dt = getItem(position);
        if (dt != null) {
            setHolderData(holder, dt);
        }

        return view;
    }

    private void setHolderData(RConstructor holder, OVNNameLauncher.HQAfter info) {
        holder.textName.setText(info.getName());
        holder.textDuration.setText(KPBMainIntent.fromInteger(info.getDuration()));
        if (holder.deleteItemClick == null) {
            holder.deleteItemClick = new HPreferences(info);
            holder.viewDeleteItem.setOnClickListener(holder.deleteItemClick);
        } else {
            holder.deleteItemClick.info = info;
        }
    }

    class RConstructor {
private boolean isScaleSnapImpl = false;
private ArrayList<Double> currSelectionSound_list;



        TextView textName;
        TextView textDuration;
        View viewDeleteItem;

        HPreferences deleteItemClick;

        RConstructor(View view) {
            textName = view.findViewById(R.id.text_name);
            textDuration = view.findViewById(R.id.text_duration);
            viewDeleteItem = view.findViewById(R.id.delete_list_item);
        }


    }

    public interface OnDeleteItemClickListener {

        void onDeleteItemClick(OVNNameLauncher.HQAfter info);

    }

    private class HPreferences implements View.OnClickListener {

        OVNNameLauncher.HQAfter info;

        HPreferences(OVNNameLauncher.HQAfter info) {
            this.info = info;
        }

        @Override
        public void onClick(View v) {
            if (mDeleteItemClickListener != null) {
                mDeleteItemClickListener.onDeleteItemClick(info);
            }
        }
    }
}
