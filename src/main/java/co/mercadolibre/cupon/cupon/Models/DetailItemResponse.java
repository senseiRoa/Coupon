/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mercadolibre.cupon.cupon.Models;

/**
 *
 * @author SenseiRoa
 */
public class DetailItemResponse {

    private String id;

    private String title;

    private float price;

    private String site_id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return this.price;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getSite_id() {
        return this.site_id;
    }

    @Override
    public String toString() {
        return "DetailItemResponse{" + "id=" + id + ", title=" + title + ", price=" + price + ", site_id=" + site_id + '}';
    }
    
}
