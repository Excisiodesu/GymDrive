package com.mtqn.gymdrive;

public class CommandItem{

    private int imageResource;
    private int count;
    private float price;
    private String name;

    public CommandItem(int imageResource, float price, int count, String name){
        this.imageResource = imageResource;
        this.price = price;
        this.count = count;
        this.name = name;
    }

    public int GetImageResource(){ return imageResource; }
    public int GetCount(){ return count; }
    public float GetPrice(){ return price; }
    public String GetName() {return name; }


    public boolean AddOne(){
        ++count;
        return true;
    }

    public boolean RemoveOne(){
        --count;
        if(count < 0){
            return true;
        }
        return false;
    }
}
