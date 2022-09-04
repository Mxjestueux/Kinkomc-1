package fr.swokky.kinko.capabilities.nomi;

public class NoMiCapability implements INoMiCapability {
    private String noMi = "";

    @Override
    public void setNoMi(String noMi) {
        this.noMi = noMi;
    }

    @Override
    public String getNoMi() {
        return this.noMi;
    }

}
