/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mercadolibre.cupon.cupon.Models;

import java.util.List;

/**
 *
 * @author SenseiRoa
 */
public class CouponRequest {
    private List<String> item_ids;
    private float amount;

    public List<String> getItem_ids() {
        return item_ids;
    }

    public void setItem_ids(List<String> item_ids) {
        this.item_ids = item_ids;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CouponRequest{" + "item_ids=" + item_ids + ", amount=" + amount + '}';
    }
    
    
}
