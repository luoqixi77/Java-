package com.tiyamati.factory;

import com.tiyamati.pojo.User;
import org.springframework.beans.factory.FactoryBean;

public class UserFactory implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
