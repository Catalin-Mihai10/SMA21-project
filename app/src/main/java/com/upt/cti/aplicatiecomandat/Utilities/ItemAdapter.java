package com.upt.cti.aplicatiecomandat.Utilities;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.R;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

    private Context context;
    private List<Item> items;
    private int layoutResourceId;

    public ItemAdapter(Context context, int layoutResourceId, List<Item> items){
        super(context, layoutResourceId,items);

        this.context = context;
        this.items = items;
        this.layoutResourceId = layoutResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemHolder itemHolder;
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            itemHolder = new ItemHolder();

            view = inflater.inflate(layoutResourceId, parent, false);
            itemHolder.tName = view.findViewById(R.id.tName);
            itemHolder.tProvider = view.findViewById(R.id.tProvider);
            itemHolder.tCategory = view.findViewById(R.id.tCategory);
            itemHolder.tCost = view.findViewById(R.id.tCost);
            itemHolder.addButton = view.findViewById(R.id.addButtton);

            view.setTag(itemHolder);

        } else {
            itemHolder = (ItemHolder) view.getTag();
        }

        final Item item = items.get(position);

        itemHolder.tName.setText(item.getItemName());
        itemHolder.tProvider.setText(item.getItemProvider());
        itemHolder.tCost.setText(item.getItemCost() + " LEI");
        itemHolder.tCategory.setText(item.getItemCategory().toString());
        itemHolder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }

    private static class ItemHolder {
        TextView tName;
        TextView tProvider, tCategory;
        TextView tCost;
        Button addButton;
    }
}

