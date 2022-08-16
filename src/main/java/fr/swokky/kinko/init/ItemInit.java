package fr.swokky.kinko.init;

import fr.swokky.kinko.item.fruit.GomuNoMi;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static List<Item> ITEMS = new ArrayList<Item>();

    public static final Item GOMU_NO_MI = new GomuNoMi("gomu_no_mi");
}
