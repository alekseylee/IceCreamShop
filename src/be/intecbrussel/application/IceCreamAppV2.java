package be.intecbrussel.application;


import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamCar;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;
import be.intecbrussel.sellers.Stock;

public class IceCreamAppV2 {
    public static void main(String[] args) {
        PriceList priceList= new PriceList();
        Stock stock01 = new Stock();
        IceCreamSeller iceCreamCar= new IceCreamCar(priceList,stock01);


        stock01.setCones(2);
        stock01.setIceRockets(3);
        stock01.setMagni(1);

        iceCreamCar.orderIceRocket().eat();
        iceCreamCar.orderIceRocket().eat();
        iceCreamCar.orderIceRocket().eat();
        //iceCreamCar.orderIceRocket().eat();

        iceCreamCar.orderMagnum(Magnum.MagnumType.BLAСKCHOCOLATE).eat();
        //iceCreamCar.orderMagnum(Magnum.MagnumType.ALPINENUTS).eat();

        iceCreamCar.orderCone(Cone.Flavor.values()).eat();
        iceCreamCar.orderCone(Cone.Flavor.values()).eat();
        // iceCreamCar.orderCone(Cone.Flavor.values()).eat();





    }

}
