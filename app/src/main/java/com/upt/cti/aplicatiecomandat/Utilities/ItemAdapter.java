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
import android.widget.Toast;

import com.upt.cti.aplicatiecomandat.AuthenticationActivity;
import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.Handlers.CommandHandler;
import com.upt.cti.aplicatiecomandat.MainActivity;
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
            itemHolder.tName = view.findViewById(Constants.ITEM_NAME_FIELD);
            itemHolder.tProvider = view.findViewById(Constants.ITEM_PROVIDER_FIELD);
            itemHolder.tCategory = view.findViewById(Constants.ITEM_CATEGORY_FIELD);
            itemHolder.tCost = view.findViewById(Constants.ITEM_COST_FIELD);
            itemHolder.addButton = view.findViewById(Constants.ADD_ITEM_BUTTON);

            view.setTag(itemHolder);

        } else {
            itemHolder = (ItemHolder) view.getTag();
        }

        final Item item = items.get(position);

        itemHolder.tName.setText(item.getItemName());
        itemHolder.tProvider.setText(item.getItemProvider());
        String cost = item.getItemCost() + " LEI";
        itemHolder.tCost.setText(cost);
        itemHolder.tCategory.setText(item.getItemCategory().toString());
        itemHolder.addButton.setOnClickListener(auxView -> {
            String[] selectedItemCost = itemHolder.tCost.getText().toString().split(" ");

            Item item1 = new Item(itemHolder.tName.getText().toString(),
                                 Double.parseDouble(selectedItemCost[0]),
                                 itemHolder.tProvider.getText().toString(),
                                 Category.stringToCategory(itemHolder.tCategory.getText().toString()));

            if(CommandHandler.addToCart(item1))
                Toast.makeText(context, "Item added to the cart!", Toast.LENGTH_SHORT).show();
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

