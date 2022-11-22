package be.intecbrussel.eatables;

public class Magnum implements Eatable{

    private MagnumType type;


    public Magnum() {
    }

    public Magnum(MagnumType type) {
        this.type = type;
    }

    public MagnumType getType() {
        return type;
    }

    @Override
    public void eat() {
        System.out.println("eating magnum " +type);
    }

    public enum MagnumType{
        MILKCHOCOLATE,
        WHITECHOCOLATE,
        BLAСKCHOCOLATE,
        ALPINENUTS,
        ROMAINTICSTRAWBERRIES;
    }

}
