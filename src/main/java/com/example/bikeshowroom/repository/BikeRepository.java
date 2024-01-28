package com.example.bikeshowroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.bikeshowroom.model.Bike;

public interface BikeRepository extends JpaRepository<Bike, String> {
    List<Bike> findByBrand(String brand);                                                       // select * bike where brand=?   1. method/function name shoould be camelCase 2.method should start with findBYBRand or findByModel model,brand pojo name
                                                                                                    // after repository write service
    
    @Query(value="select * from tb1_bike where price<=?1", nativeQuery=true)        // the table name in SQL is tb1(one)_bikeTHis IS SQL Query and the syntax should be SQL commands only
    List<Bike> findBikes(int p);                                                 // this method name under sql is your choose no constraint like above List method 
 // two parameter where passed but i removed one to check mileage                                              // after repo go to service
}
