package ua.epam.rd.dev.edu.domain;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;



import org.junit.Test;

import ua.epam.rd.dev.domain.infrastructure.JPATotalOrderCostCalculator;

public class TotalOrderCostCalculatorTest {

	private static final double DELTA = 0.005;


	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateTotalOrderPricePizzasInOrderQuantityLimitsOutOfRangeThrowException() {
		Map<Pizza, Integer> map = new HashMap<>();
		JPATotalOrderCostCalculator calculator = new JPATotalOrderCostCalculator();
		calculator.calculateToatalOrderPriceWithoutCardDiscount(map);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalculateTotalOrderPriceQuantityOfPizzasLessThanOneThrowException() {
		Map<Pizza, Integer> map = new HashMap<>();
		map.put(new Pizza(), 0);
		JPATotalOrderCostCalculator calculator = new JPATotalOrderCostCalculator();
		calculator.calculateToatalOrderPriceWithoutCardDiscount(map);

	}
	
	
	@Test
	public void testCalculateTotalOrderWithOnePizza() {
		/*
		 * Prepare data and expected result
		 */
		Map<Pizza, Integer> map = new HashMap<>();
		double pizzaPrice = 23.5;
		map.put(new Pizza(1l, "Margo", pizzaPrice, PizzaType.Meat), 1);
		double expectedPrice = 23.5;
		
		/*
		 * Testing
		 */
		JPATotalOrderCostCalculator calculator = new JPATotalOrderCostCalculator();
		double price = calculator.calculateToatalOrderPriceWithoutCardDiscount(map);

		
		/*
		 * compare expected and real
		 */
		
		//assertThat(price, is(closeTo(expectedPrice, 0.03)));
		assertEquals(expectedPrice, price, DELTA );
	}

}
