/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mercadolibre.cupon.cupon.Controllers;

import co.mercadolibre.cupon.cupon.Models.*;
import co.mercadolibre.cupon.cupon.Services.ICouponService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SenseiRoa
 */
@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    ICouponService couponServiceImpl;

    @PostMapping()
    public ResponseEntity<CouponResponse> coupon(@RequestBody CouponRequest data) {

        Map<String, Float> items = new HashMap<>();
        data.getItem_ids().forEach(a -> {
            float price = this.couponServiceImpl.getPriceItem(a);
            items.put(a, price);
        });
        
        items.entrySet().forEach(i->System.out.println(i.getKey()+" "+i.getValue()));
        List<String> listItems = this.couponServiceImpl.calculate(items, data.getAmount());
        if (listItems.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        float total = items.entrySet()
                .stream()
                .filter(i -> listItems.contains(i.getKey()))
                .map(x -> x.getValue())
                .reduce(0f, Float::sum);

        CouponResponse x = new CouponResponse(listItems, total);

        return new ResponseEntity<>(x, HttpStatus.OK);

    }
}
