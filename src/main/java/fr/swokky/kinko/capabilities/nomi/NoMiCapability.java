package fr.swokky.kinko.capabilities.nomi;

import java.util.ArrayList;

public class NoMiCapability implements INoMiCapability {
    private String noMi = "";
    private ArrayList<Integer> cd = new ArrayList<Integer>();

    @Override
    public void setNoMi(String noMi) {
        this.noMi = noMi;
    }

    @Override
    public String getNoMi() {
        return this.noMi;
    }
}
