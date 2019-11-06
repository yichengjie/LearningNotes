package com.yicj.factorybean.factory;

import com.yicj.factorybean.entity.Car;
import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {
    @Override
    public Car getObject() throws Exception {
        Car car = new Car() ;
        car.setMaxSpeed(260);
        car.setBrand("宝马");
        car.setPrice(500000);
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
