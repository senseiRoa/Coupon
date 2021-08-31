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
public class CouponResponse {
     private List<String> item_ids;
    private float total;

    public CouponResponse(List<String> item_ids, float total) {
        this.item_ids = item_ids;
        this.total = total;
    }

    
    public List<String> getItem_ids() {
        return item_ids;
    }

    public void setItem_ids(List<String> item_ids) {
        this.item_ids = item_ids;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CouponResponse{" + "item_ids=" + item_ids + ", total=" + total + '}';
    }
    
    

}
