package org.example;

public class DependencyBean {
    InjectionBean injectionBean;

    public DependencyBean(InjectionBean injectionBean) {
        this.injectionBean = injectionBean;
    }
}
