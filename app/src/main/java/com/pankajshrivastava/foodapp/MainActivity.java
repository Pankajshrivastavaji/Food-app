package com.pankajshrivastava.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerCategories;
    RecyclerView recyclerItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerCategories = findViewById(R.id.recycler_categories);
        recyclerItems = findViewById(R.id.recycler_food);

        setCategories();
        setFoodItem(0);


    }


    private void setCategories() {
        List<FoodCategory> data = new ArrayList<>();

        FoodCategory foodCategory = new FoodCategory("Burger",R.drawable.ic_burger);
        FoodCategory foodCategory2 = new FoodCategory("Chicken",R.drawable.ic_chicken);
        FoodCategory foodCategory3 = new FoodCategory("Pizza",R.drawable.ic_pizza);
        FoodCategory foodCategory4 = new FoodCategory("Burger",R.drawable.ic_chicken);

        data.add(foodCategory);
        data.add(foodCategory2);
        data.add(foodCategory3);
        data.add(foodCategory4);

        FoodCategoryAdapter foodCategoryAdapter = new FoodCategoryAdapter(data, MainActivity.this, new FoodCategoryAdapter.OnCategoryClick() {
            @Override
            public void onClick(int pos) {
                setFoodItem(pos);
            }
        });

        recyclerCategories.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL,false));
        recyclerCategories.setAdapter(foodCategoryAdapter);
        foodCategoryAdapter.notifyDataSetChanged();
    }

    private void setFoodItem(int pos){
        List<FoodItem> foodItems = new ArrayList<>();
        switch (pos) {
            case 2:
                FoodItem foodItem = new FoodItem("Pizza with berries",4.5f,1500,R.drawable.pizza01);
                FoodItem foodItem2 = new FoodItem("Brown Pizza on black  ",5f,1000,R.drawable.pizza03);
               // FoodItem foodItem3 = new FoodItem("Pizza two",4f,500,R.drawable.pizza_3);
               // FoodItem foodItem4 = new FoodItem("Pizza",3.5f,500,R.drawable.pizza_4);

                foodItems.add(foodItem);
                foodItems.add(foodItem2);
               // foodItems.add(foodItem3);
                //foodItems.add(foodItem4);
                break;
            case 1:
                FoodItem foodItem5 = new FoodItem("Grilled meat on black",4.5f,2000,R.drawable.chicken01);
                FoodItem foodItem6 = new FoodItem("Roasted chicken ",5f,2500,R.drawable.chicken02);
              //  FoodItem foodItem7 = new FoodItem("Chicken two",4f,500,R.drawable.grill_chicken_3);
               // FoodItem foodItem8 = new FoodItem("Chicken",3.5f,500,R.drawable.grill_chicken_2);

                foodItems.add(foodItem5);
                foodItems.add(foodItem6);
               // foodItems.add(foodItem7);
                //foodItems.add(foodItem8);
                break;
            case 0:
                FoodItem foodItem9 = new FoodItem("Hamburger with vegetables",4.5f,900,R.drawable.burger01);
                FoodItem foodItem10 = new FoodItem("Double-patty cheeseburger",5f,700,R.drawable.burger02);
                //FoodItem foodItem11 = new FoodItem("Burger two",4f,500,R.drawable.burger_two);
              //  FoodItem foodItem12 = new FoodItem("Burger",3.5f,500,R.drawable.burger);
                foodItems.add(foodItem9);
                foodItems.add(foodItem10);
               // foodItems.add(foodItem11);
              //  foodItems.add(foodItem12);
                break;
        }

        FoodAdapter foodAdapter = new FoodAdapter(foodItems);
        recyclerItems.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));

        recyclerItems.setAdapter(foodAdapter);
    }
}