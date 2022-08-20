package fr.swokky.kinko.capabilities.nomi;

public class NoMi implements INoMi{

    protected String noMi;

    public NoMi(){
        this.noMi = null;
    }

    @Override
    public String getNoMi() {
        return this.noMi;
    }

    @Override
    public void setNoMi(String noMi) {
        this.noMi = noMi;
    }
}
