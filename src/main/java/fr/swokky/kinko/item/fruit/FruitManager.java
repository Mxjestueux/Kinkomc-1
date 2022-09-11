package fr.swokky.kinko.item.fruit;

import java.util.HashMap;
import java.util.Map;

public class FruitManager {
    private final Map<String, Class<? extends BaseFruit>> fruits = new HashMap<>();
    private static FruitManager instance;

    public static FruitManager getInstance(){
        if(instance == null){
            instance = new FruitManager();
            instance.registerFruits();
        }
        return instance;
    }

    private void registerFruits(){
        registerFruit("gomugomunomi", GomuNoMi.class);
        registerFruit("merameranomi", MeraNoMi.class);
    }

    private void registerFruit(String key, Class<? extends BaseFruit> fruit){
        fruits.put(key, fruit);
    }

    public Class<? extends BaseFruit> getFruit(String name){
        return fruits.get(name);
    }
}
