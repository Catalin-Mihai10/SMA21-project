package com.upt.cti.aplicatiecomandat.Utilities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.Handlers.CommandHandler;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

    private final Context context;
    private final List<Item> items;
    private final int layoutResourceId;

    public ItemAdapter(Context context, int layoutResourceId, List<Item> items){
        super(context, layoutResourceId,items);

        this.context = context;
        this.items = items;
        this.layoutResourceId = layoutResourceId;
    }

    @SuppressLint("SetTextI18n")
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
            itemHolder.tQuantity = view.findViewById(Constants.ITEM_QUANTITY_FIELD);
            itemHolder.addButton = view.findViewById(Constants.ADD_ITEM_BUTTON);
            itemHolder.addQuantity = view.findViewById(Constants.ADD_QUANTITY);
            itemHolder.subtractQuantity = view.findViewById(Constants.SUBTRACT_QUANTITY);

            view.setTag(itemHolder);

        } else {
            itemHolder = (ItemHolder) view.getTag();
        }

        final Item item = items.get(position);

        itemHolder.tName.setText(item.getItemName());
        itemHolder.tProvider.setText(item.getItemProvider());
        String cost = item.getItemCost() + " LEI";
        itemHolder.tCost.setText(cost);
        itemHolder.tQuantity.setText("Cantitate: " + Constants.DEFAULT_QUANTITY);
        itemHolder.tCategory.setText(item.getItemCategory().toString());
        itemHolder.addButton.setOnClickListener(auxView -> {
            String[] selectedItemCost = itemHolder.tCost.getText().toString().split(" ");
            String[] selectedItemQuantity = itemHolder.tQuantity.getText().toString().split(" ");

            double totalCost = getTotalCost(selectedItemCost[0], selectedItemQuantity[1]);

            Item item1 = new Item(itemHolder.tName.getText().toString(),
                                 totalCost,
                                 itemHolder.tProvider.getText().toString(),
                                 Category.stringToCategory(itemHolder.tCategory.getText().toString()));
            item1.setQuantity(Integer.parseInt(selectedItemQuantity[1]));


            if(CommandHandler.addToCart(item1))
                Toast.makeText(context, "Item added to the cart!", Toast.LENGTH_SHORT).show();
        });
        itemHolder.addQuantity.setOnClickListener(auxView ->{
            String[] currentQuantity = itemHolder.tQuantity.getText().toString().split(" ");

            int newQuantity = Integer.parseInt(currentQuantity[1]);
            ++newQuantity;

            itemHolder.tQuantity.setText("Cantitate: " + newQuantity);

        });
        itemHolder.subtractQuantity.setOnClickListener(auxView ->{
            String[] currentQuantity = itemHolder.tQuantity.getText().toString().split(" ");

            int newQuantity = Integer.parseInt(currentQuantity[1]);

            if(newQuantity > 0) --newQuantity;
            else newQuantity = 0;

            itemHolder.tQuantity.setText("Cantitate: " + newQuantity);

        });
        return view;
    }

    private double getTotalCost(String s, String s1) {
        double selectedCost = Double.parseDouble(s);
        int selectedQuantity = Integer.parseInt(s1);
        return selectedCost * selectedQuantity;
    }

    private static class ItemHolder {
        TextView tName;
        TextView tProvider, tCategory;
        TextView tCost, tQuantity;
        Button addButton, addQuantity, subtractQuantity;
    }
}

