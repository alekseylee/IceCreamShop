package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamSalon implements IceCreamSeller{
    private PriceList pricelist;
    private double totalProfit;


    public IceCreamSalon(PriceList pricelist) {
        this.pricelist = pricelist;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {
        if (flavors!=null && flavors.length>0){
            totalProfit += pricelist.getBallPrice() * flavors.length;
        }
        else {
            totalProfit+= pricelist.getBallPrice();
        }
        return new Cone(flavors);

    }

    @Override
    public IceRocket orderIceRocket() {
        totalProfit+=pricelist.getRocketPrice();
        return new IceRocket();
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        totalProfit += pricelist.getMagnumPrice(type);
        return new Magnum(type);
    }

    @Override
    public double getProfit() {
        return totalProfit;
    }

    @Override
    public String toString() {
        return "IceCreamSalon{" +
                "pricelist=" + pricelist +
                ", totalProfit=" + totalProfit +
                '}';
    }
}
