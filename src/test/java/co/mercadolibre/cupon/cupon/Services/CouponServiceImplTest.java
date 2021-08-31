package co.mercadolibre.cupon.cupon.Services;

import co.mercadolibre.cupon.cupon.Models.DetailItemResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author SenseiRoa
 */
@RunWith(SpringRunner.class)
public class CouponServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    CouponServiceImpl couponServiceImpl = new CouponServiceImpl();

    public CouponServiceImplTest() {
    }

    
    /**
     * Test of calculate method, of class CouponServiceImpl.
     */
    @Test
    public void testCalculate() {
        System.out.println("calculate");
        
        Map<String, Float> items = new HashMap<>();
        items.put("MLA1", 100f);
        items.put("MLA2", 210f);
        items.put("MLA3", 260f);
        items.put("MLA4", 80f);
        items.put("MLA5", 90f);
        Float amount = 500f;
        List<String> expResult = Arrays.asList("MLA4", "MLA5", "MLA1", "MLA2");
        List<String> result = couponServiceImpl.calculate(items, amount);
        assertEquals(expResult, result);

    }

    /**
     * Test of getPriceItem method, of class CouponServiceImpl.
     */
    @Test
    public void testGetPriceItem() {
        System.out.println("getPriceItem");
        String item = "MLA917496925";
         DetailItemResponse d = new DetailItemResponse();
        d.setPrice(2966.7F);
        Mockito
                .when(restTemplate.getForEntity(
                        "https://api.mercadolibre.com/items/"+"{id}", DetailItemResponse.class,item))
                .thenReturn(new ResponseEntity(d, HttpStatus.OK));
        
        
        float expResult = 2966.7F;
        float result = couponServiceImpl.getPriceItem(item);
        assertEquals(expResult, result, 0.0);

    }

}
