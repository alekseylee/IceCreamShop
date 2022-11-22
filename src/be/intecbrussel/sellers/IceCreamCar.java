package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamCar implements IceCreamSeller {
    private PriceList priceList;
    private Stock stock;
    private double profit;

    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {
        Cone cone = prepareCone(flavors);

        if (flavors != null && flavors.length > 0) {
            profit += priceList.getBallPrice() * flavors.length;
        } else {
            profit += priceList.getBallPrice();
        }
        return new Cone(flavors);
    }

    private Cone prepareCone(Cone.Flavor[] flavors) {
        if (stock.getCones() == 0 || stock.getBalls() == 0) {
            throw new NoMoreIceCreamException();
        }

        if (stock.getBalls() >= flavors.length) {
            stock.setCones(stock.getCones() - 1);
            stock.setBalls(stock.getBalls() - flavors.length);
            return new Cone();

        } else {
            System.out.println("You have not...");
            throw new NoMoreIceCreamException();
        }

    }


    @Override
    public IceRocket orderIceRocket() {
        IceRocket iceRocket = prepareIceRocket();
        profit += priceList.getRocketPrice();
        return new IceRocket();
    }

    private IceRocket prepareIceRocket() {
        if (stock.getIceRockets() == 0) {
            throw new NoMoreIceCreamException();
        }
        stock.setIceRockets(stock.getIceRockets() - 1);
        return new IceRocket();
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        Magnum magnum = prepareMagnum(type);
        profit += priceList.getMagnumPrice(type);
        return new Magnum(type);
    }

    private Magnum prepareMagnum(Magnum.MagnumType type) throws NoMoreIceCreamException {
        if (stock.getMagni() == 0) {
            throw new NoMoreIceCreamException();
        }
        stock.setMagni(stock.getMagni() - 1);
        return new Magnum();
    }

    @Override
    public double getProfit() {
        return profit;
    }
}
