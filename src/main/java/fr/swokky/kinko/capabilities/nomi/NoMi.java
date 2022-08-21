package fr.swokky.kinko.capabilities.nomi;

public class NoMi implements INoMi{
    private String noMi = "aaa";

    @Override
    public void setNoMi(String noMi) {
        this.noMi = noMi;
    }

    @Override
    public String getNoMi() {
        return this.noMi;
    }
}
