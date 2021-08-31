/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mercadolibre.cupon.cupon.Services;

import java.util.List;
import java.util.Map;

/**
 *
 * @author SenseiRoa
 */
public interface ICouponService {
    List<String> calculate(Map<String, Float> items, Float amount);
    float getPriceItem(String item);
}
