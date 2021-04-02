/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

/**
 *
 * @author stani
 */
public class Clock {
    float cost = 0.0f;
    String brand = "";

    public Clock(float _cost, String _brand) {
        this.cost = _cost;
        this.brand = _brand;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getCost() {
        return cost;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return brand + "(" + cost + "$) ";
    }
}
