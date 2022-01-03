package com.upt.cti.aplicatiecomandat.Utilities;

public enum Category {
    FRUITS,
    VEGETABLES,
    ANIMAL_PRODUCTS,
    LACTATE,
    CEREALS,
    OILS,
    OFFERS,
    UNDEFINED;

    public static Category stringToCategory(String category){
        Category itemCategory;
        
        switch(category){
            case "FRUITS":
                itemCategory = Category.FRUITS;
                break;
            case "VEGETABLES":
                itemCategory = Category.VEGETABLES;
                break;
            case "ANIMAL_PRODUCTS":
                itemCategory = Category.ANIMAL_PRODUCTS;
                break;
            case "LACTATE":
                itemCategory = Category.LACTATE;
                break;
            case "CEREALS":
                itemCategory = Category.CEREALS;
                break;
            case "OILS":
                itemCategory = Category.OILS;
                break;
            case "OFFERS":
                itemCategory = Category.OFFERS;
                break;
            default:
                itemCategory = Category.UNDEFINED;
        }
        
        return itemCategory;
    }
}
