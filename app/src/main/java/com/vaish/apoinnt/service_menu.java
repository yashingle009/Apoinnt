package com.vaish.apoinnt;


import java.util.List;

class
service_menu {
    public static service_menu get(int groupPosition) {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private List<ServiceItem> items;

    public service_menu(String name, List<ServiceItem> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public List<ServiceItem> getItems() {
        return items;
    }
}




