package com.example.TravellingApp.util;

public enum Country {
    UNKNOWN(0),
    ROMANIA(1),
    GREECE(2),
    ITALY(3),
    SPAIN(4),
    HUNGARY(5),
    GERMANY(6),
    NORWAY(7),
    FRANCE(8),
    JAPAN(9),
    PORTUGAL(10);


    int id;

    Country(int id) {
        this.id = id;
    }


    public Country convertCountryById( int id){

        for (Country c : Country.values()) {
            if(id==c.id)
                return c;
        }
         return Country.UNKNOWN;
    }
}
