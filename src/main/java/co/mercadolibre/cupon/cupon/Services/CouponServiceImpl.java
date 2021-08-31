/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mercadolibre.cupon.cupon.Services;

import co.mercadolibre.cupon.cupon.Models.DetailItemResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author SenseiRoa
 */
@Service
public class CouponServiceImpl implements ICouponService {

    /**
     * Base URL for querying items in the MercadoLibre api
     */
    private static String URL_API_ITEMS = "https://api.mercadolibre.com/items/";

    @Autowired
    RestTemplate restTemplate;

    /**
     * calculate the highest number of items that can be purchased with a bonus
     *
     * @param items
     * @param amount
     * @return
     */
    @Override
    public List<String> calculate(Map<String, Float> items, Float amount) {

        //ORDER FROM HIGHEST TO LOWEST PRICE
        Map<String, Float> sorted = items
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        List<String> response = new ArrayList<>();
        float total = 0;
        // iterate the items until completing or approaching the amount
        for (Map.Entry<String, Float> entry : sorted.entrySet()) {
            float price = entry.getValue();
            if (price > 0) {
                if (price + total <= amount) {
                    total += price;
                    response.add(entry.getKey());
                } else {
                    break;
                }
            }

        }
        return response;
    }

    /**
     * get the price of an item directly from the mercadolibre api
     *
     * @param item
     * @return
     */
    @Override
    public float getPriceItem(String item) {
        try {
            //request item information
            ResponseEntity<DetailItemResponse> response
                    = restTemplate.getForEntity(URL_API_ITEMS + "{id}", DetailItemResponse.class, item);
            //get price if status is ok
            if (response.getStatusCode() == HttpStatus.OK) {
                System.out.println(response.getBody());
                return response.getBody().getPrice();
            }

        } catch (HttpClientErrorException k1) {
            System.out.println("Http code is not 2XX. The server responded: " + k1.getStatusCode()
                    + " Cause: " + k1.getResponseBodyAsString());
        } catch (RestClientException k) {
            System.out.println("The server didn't respond: " + k.getMessage());
        } catch (Exception ex) {
            System.out.println("General error:" + ex.getMessage());
        }
        return -1;
    }

}
