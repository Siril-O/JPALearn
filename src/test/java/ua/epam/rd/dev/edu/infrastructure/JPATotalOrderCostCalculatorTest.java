package ua.epam.rd.dev.edu.infrastructure;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import ua.epam.rd.dev.edu.domain.AccumulativeCard;
import ua.epam.rd.dev.edu.domain.Pizza;
import ua.epam.rd.dev.edu.domain.PizzaType;
import ua.epam.rd.dev.edu.infrastructure.JPATotalOrderCostCalculator;

public class JPATotalOrderCostCalculatorTest {

	private static final double DELTA = 0.005;

	@Test(expected = IllegalArgumentException.class)
	public void testCalculateTotalOrderPricePizzasInOrderQuantityLimitsOutOfRangeThrowException() {
		Map<Pizza, Integer> map = new HashMap<>();
		JPATotalOrderCostCalculator calculator = new JPATotalOrderCostCalculator();
		calculator.calculateTotalOrderPriceWithoutCardDiscount(map);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalculateTotalOrderPriceQuantityOfPizzasLessThanOneThrowException() {
		Map<Pizza, Integer> map = new HashMap<>();
		map.put(new Pizza(), 0);
		JPATotalOrderCostCalculator calculator = new JPATotalOrderCostCalculator();
		calculator.calculateTotalOrderPriceWithoutCardDiscount(map);

	}

	@Test
	public void testCalculateTotalOrderWithTwoSamePizzas() {
		Map<Pizza, Integer> map = new HashMap<>();
		double firstPizzaPrice = 23.5;
		map.put(new Pizza(1l, "Margo", firstPizzaPrice, PizzaType.Meat), 2);
		double expectedPrice = 47;

		JPATotalOrderCostCalculator calculator = new JPATotalOrderCostCalculator();
		double total = calculator
				.calculateTotalOrderPriceWithoutCardDiscount(map);

		assertEquals(expectedPrice, total, DELTA);
	}

	@Test
	public void testCalculateTotalOrderWithTwoDifferentPizzas() {
		Map<Pizza, Integer> map = new HashMap<>();
		double firstPizzaPrice = 23.5;
		double secondPizzaPrice = 24.5;
		map.put(new Pizza(1l, "Margo", firstPizzaPrice, PizzaType.Meat), 1);
		map.put(new Pizza(2l, "King", secondPizzaPrice, PizzaType.Meat), 1);
		double expectedPrice = 48;

		JPATotalOrderCostCalculator calculator = new JPATotalOrderCostCalculator();
		double total = calculator
				.calculateTotalOrderPriceWithoutCardDiscount(map);

		assertEquals(expectedPrice, total, DELTA);
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
		double price = calculator
				.calculateTotalOrderPriceWithoutCardDiscount(map);

		/*
		 * compare expected and real
		 */

		// assertThat(price, is(closeTo(expectedPrice, 0.03)));
		assertEquals(expectedPrice, price, DELTA);
	}

	@Test
	public void testCalculateOrderDiscountDiscountIsBigerThanMax() {

		Map<Pizza, Integer> map = new HashMap<>();
		double pizzaPrice = 223.5;
		Pizza pizza = mock(Pizza.class);
		when(pizza.getPrice()).thenReturn(pizzaPrice);
		map.put(pizza,1);
		
		AccumulativeCard card = mock(AccumulativeCard.class);
		when(card.getTotalSumm()).thenReturn(Double.valueOf(1000d));
		
		double expectedDiscount = 67.05;

		JPATotalOrderCostCalculator calculator = new JPATotalOrderCostCalculator();
		double discount = calculator.calculateOrderDiscount(map, card);

		assertEquals(expectedDiscount, discount, DELTA);
	}
	
	@Test
	public void testCalculateOrderDiscountDiscountIsLessThenMax() {

		Map<Pizza, Integer> map = new HashMap<>();
		double pizzaPrice = 223.5;
		Pizza pizza = mock(Pizza.class);
		when(pizza.getPrice()).thenReturn(pizzaPrice);
		map.put(pizza,1);
		

		AccumulativeCard card = mock(AccumulativeCard.class);
		when(card.getTotalSumm()).thenReturn(Double.valueOf(332d));
		
		double expectedDiscount = 33.21;

		JPATotalOrderCostCalculator calculator = new JPATotalOrderCostCalculator();
		double discount = calculator.calculateOrderDiscount(map, card);

		assertEquals(expectedDiscount, discount, DELTA);
	}
}
