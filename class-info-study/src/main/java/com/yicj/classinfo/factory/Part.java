package com.yicj.classinfo.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Part {
    static List<Factory<? extends Part>> partFactories =
            new ArrayList<Factory<? extends Part>>() ;
    static {
        partFactories.add(new FuelFilter.Factory()) ;
        partFactories.add(new AirFilter.Factory()) ;
        partFactories.add(new CabinAirFilter.Factory()) ;
        partFactories.add(new OilFilter.Factory()) ;
        partFactories.add(new FanBelt.Factory()) ;
        partFactories.add(new PowerSteeringBelt.Factory()) ;
        partFactories.add(new GeneratorBelt.Factory()) ;
    }

    private static Random rand = new Random(47) ;
    public static Part createRandom(){
        int n = rand.nextInt(partFactories.size()) ;
        return partFactories.get(n).create() ;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() ;
    }
}

class Filter extends Part{}

class FuelFilter extends Filter {
   static {
       System.out.println("class FuelFilter init");
   }
    public static class Factory
            implements com.yicj.classinfo.factory.Factory<FuelFilter> {
       static {
           System.out.println("class FuelFilter.Factory init");
       }
        public FuelFilter create(){
            return new FuelFilter() ;
        }
    }
}

class AirFilter extends Filter{
    static {
        System.out.println("class AirFilter init");
    }
    public static class Factory
            implements com.yicj.classinfo.factory.Factory<AirFilter> {
        static {
            System.out.println("class AirFilter.Factory init");
        }
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter{
    static {
        System.out.println("class CabinAirFilter init");
    }
    public static class Factory
            implements com.yicj.classinfo.factory.Factory<CabinAirFilter> {
        static {
            System.out.println("class CabinAirFilter.Factory init");
        }
        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter{
    static {
        System.out.println("class OilFilter init");
    }
    public static class Factory
            implements com.yicj.classinfo.factory.Factory<OilFilter> {
        static {
            System.out.println("class OilFilter.Factory init");
        }
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part {}

class FanBelt extends Belt{
    static {
        System.out.println("class FanBelt init");
    }
    public static class Factory
            implements com.yicj.classinfo.factory.Factory<FanBelt> {
        static {
            System.out.println("class FanBelt.Factory init");
        }
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt{
    static {
        System.out.println("class GeneratorBelt init");
    }
    public static class Factory
            implements com.yicj.classinfo.factory.Factory<GeneratorBelt> {
        static {
            System.out.println("class GeneratorBelt.Factory init");
        }
        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt{
    static {
        System.out.println("class PowerSteeringBelt init");
    }
    public static class Factory implements com.yicj.classinfo.factory.Factory<PowerSteeringBelt> {
        static {
            System.out.println("class PowerSteeringBelt.Factory init");
        }
        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}





