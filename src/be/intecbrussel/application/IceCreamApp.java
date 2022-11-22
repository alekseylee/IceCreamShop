package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;

public class IceCreamApp {
    public static void main(String[] args) {
        PriceList priceList= new PriceList();
        IceCreamSeller iceCreamSalon= new IceCreamSalon(priceList);

        Magnum magnum= new Magnum(Magnum.MagnumType.ALPINENUTS);

        IceRocket iceRocket = new IceRocket();

        iceCreamSalon.orderMagnum(Magnum.MagnumType.BLAСKCHOCOLATE).eat();
        iceCreamSalon.orderMagnum(Magnum.MagnumType.ALPINENUTS).eat();
        iceCreamSalon.orderCone(Cone.Flavor.values()).eat();
        iceCreamSalon.orderIceRocket().eat();

        //Eatable  eatable = new Cone(Cone.Flavor.values());
        Cone.Flavor []flavors= {Cone.Flavor.STRACIATELLA, Cone.Flavor.STRAWBERRY, Cone.Flavor.BANANA};
        Cone cone = new Cone(flavors);
        Eatable[]eatables = {iceCreamSalon.orderCone(Cone.Flavor.values()),iceCreamSalon.orderMagnum(Magnum.MagnumType.ALPINENUTS),iceCreamSalon.orderIceRocket()};

        //Eatable []eatables = {iceCreamSalon.orderCone(flavors), iceCreamSalon.orderMagnum(Magnum.MagnumType.ALPINE_NUTS),iceCreamSalon.orderIceRocket()};
        System.out.println("--------------");
        for (Eatable iceCream: eatables){
            iceCream.eat();

        }
        priceList.setMagnumStandardPrice(1.5);
        priceList.setBallPrice(2.5);
        priceList.setRocketPrice(3.0);
        iceCreamSalon.orderMagnum(Magnum.MagnumType.BLAСKCHOCOLATE).eat();
        iceCreamSalon.orderMagnum(Magnum.MagnumType.ALPINENUTS).eat();
        iceCreamSalon.orderCone(Cone.Flavor.values()).eat();
        iceCreamSalon.orderIceRocket().eat();

        System.out.println(iceCreamSalon.getProfit());

        System.out.println(iceCreamSalon);

    }
}