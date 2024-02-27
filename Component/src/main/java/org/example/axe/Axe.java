package org.example.axe;

import org.springframework.stereotype.Component;

@Component
public class Axe {
    public String name;

    public Axe(){
        name = "我是斧头";
    }

    public Axe(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
