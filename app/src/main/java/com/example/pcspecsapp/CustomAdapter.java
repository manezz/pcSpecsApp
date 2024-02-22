package com.example.pcspecsapp;

import android.adservices.adselection.TestAdSelectionManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context mContext;
    List<PcSpecs> pcSpecsList;

    public CustomAdapter(Context context, List<PcSpecs> pcSpecsList) {
        mContext = context;
        this.pcSpecsList = pcSpecsList;
    }

    @Override
    public int getCount() {
        return pcSpecsList.size();
    }

    @Override
    public Object getItem(int position) {
        return pcSpecsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.activity_listview, parent, false);
        }

        PcSpecs tempPcSpecs = (PcSpecs) getItem(position);

        TextView getAllId = convertView.findViewById(R.id.getAllId);
        TextView getAllName = convertView.findViewById(R.id.getAllName);
        TextView getAllCpu = convertView.findViewById(R.id.getAllCpu);
        TextView getAllGpu = convertView.findViewById(R.id.getAllGpu);
        TextView getAllRam = convertView.findViewById(R.id.getAllRam);
        TextView getAllSsd = convertView.findViewById(R.id.getAllSsd);
        TextView getAllPsu = convertView.findViewById(R.id.getAllPsu);
        TextView getAllMb = convertView.findViewById(R.id.getAllMb);

        getAllId.setText(String.valueOf(tempPcSpecs.getId()));
        getAllName.setText(tempPcSpecs.getName());
        getAllCpu.setText(tempPcSpecs.getCpu());
        getAllGpu.setText(tempPcSpecs.getGpu());
        getAllRam.setText(tempPcSpecs.getRam());
        getAllSsd.setText(tempPcSpecs.getSsd());
        getAllPsu.setText(tempPcSpecs.getPsu());
        getAllMb.setText(tempPcSpecs.getMb());

        return convertView;
    }
}
