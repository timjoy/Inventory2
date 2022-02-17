package com.example.Inventory2;

//import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Item{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String locationInStore;

    //this constructor is just for JPA
    protected Item() {
    }

    public Item(String name, String locationInStore) {
        this.name = name;
        this.locationInStore = locationInStore;
    }

    //method to print out the item's properties
    @Override
    public String toString() {
        return String.format(
                "Item[id=%d, name='%s', locationInStore='%s']",
                id, name, locationInStore);
    }

    public Long getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getLocationInStore(){
        return locationInStore;
    }
}
