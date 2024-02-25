package com.example.project_1;

public class Item {
        private String name;
        private double price;
        private int imageResourceId;

        public Item(String name, double price, int imageResourceId) {
            this.name = name;
            this.price = price;
            this.imageResourceId = imageResourceId;
        }
        public String getName() {
            return name;
        }

        public  double getPrice(){
            return price;
        }
        public int getImageId(){
            return  imageResourceId;
        }

}