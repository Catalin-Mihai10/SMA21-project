package com.upt.cti.aplicatiecomandat.Utilities;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.DataTypes.Item;

import java.util.List;

public class CartItemAdapter extends ArrayAdapter<Item> {

    private Context context;
    private List<Item> items;
    private int layoutResourceId;

    public CartItemAdapter(Context context, int layoutResourceId, List<Item> items){
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
            itemHolder.tName = view.findViewById(Constants.CART_ITEM_NAME_FIELD);
            itemHolder.tCantitate = view.findViewById(Constants.CART_ITEM_QUANTITY_FIELD);
            itemHolder.tCost = view.findViewById(Constants.CART_ITEM_COST_FIELD);
            itemHolder.removeItem = view.findViewById(Constants.REMOVE_ITEM_FROM_CART_BUTTON);

            view.setTag(itemHolder);

        } else {
            itemHolder = (ItemHolder) view.getTag();
        }

        final Item item = items.get(position);

        itemHolder.tName.setText(item.getItemName());
        itemHolder.tCantitate.setText(item.getItemProvider());
        String cost = item.getItemCost() + " LEI";
        itemHolder.tCost.setText(cost);
        itemHolder.removeItem.setOnClickListener(auxView -> {
            //TODO: elimina item-ul din lista cand butonul de remove este apasat!
        });
        return view;
    }

    private static class ItemHolder {
        TextView tName, tCost, tCantitate;
        Button removeItem;
    }
}