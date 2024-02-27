package org.example.Axe;

public class Axe {
    private String name;
    public Axe(){
        name = "斧子";
    }

    public Axe(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "hello world "+name;
    }
}