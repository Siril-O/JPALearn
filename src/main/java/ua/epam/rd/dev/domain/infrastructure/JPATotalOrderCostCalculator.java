package ua.epam.rd.dev.domain.infrastructure;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import org.springframework.stereotype.Component;

import ua.epam.rd.dev.edu.domain.AccumulativeCard;
import ua.epam.rd.dev.edu.domain.Pizza;

@Component
public class JPATotalOrderCostCalculator implements TotalOrderCostCalculator{

	private static final int MAX_PIZZA_QUANTITY_IN_ORDER = 10;
	private static final int MIN_PIZZA_QUANTITY_IN_ORDER = 1;
	private static final double MAX_DISCOUNT_VALUE = 0.3;
	private static final double PERCENT_OF_CARD_TOTAL_SUMM_FOR_DISCOUNT = 0.1;

	/*
	 * Order consist of from 1 t o10 pizzas Discount 30% on the most expensive
	 * pizza if amount of pizzas more than 4 Negative Test
	 */

	/*
	 * test lower 4 test quantity biger 4 test one most expensive Pizza test two
	 * most Expensive Pizza
	 */
	@Override
	public double calculateOrderDiscount(Map<Pizza, Integer> pizzas,
			AccumulativeCard card) {

		double totalSummWithoutDiscount = calculateToatalOrderPriceWithoutCardDiscount(pizzas);
		double discount = calculateAccumulativeCartDiscount(card);
		if (Double.compare(discount, totalSummWithoutDiscount
				* MAX_DISCOUNT_VALUE) == 1) {
			discount =  totalSummWithoutDiscount * MAX_DISCOUNT_VALUE;
		}
		return new BigDecimal(discount).setScale(2, RoundingMode.CEILING)
		.doubleValue();
		
	}

	@Override
	public double calculateToatalOrderPriceWithoutCardDiscount(
			Map<Pizza, Integer> pizzas) {
		int pizzaCount = 0;
		double totalPrice = 0;

		for (Map.Entry<Pizza, Integer> entry : pizzas.entrySet()) {

			int quantity = entry.getValue();
			if (quantity <= 0) {
				throw new IllegalArgumentException();
			}

			pizzaCount += quantity;
			totalPrice += entry.getKey().getPrice() * quantity;
		}

		if (pizzaCount < MIN_PIZZA_QUANTITY_IN_ORDER
				|| pizzaCount > MAX_PIZZA_QUANTITY_IN_ORDER) {
			throw new IllegalArgumentException();
		}
		return totalPrice;
	}

	private double calculateAccumulativeCartDiscount(
			AccumulativeCard accumulativeCard) {
		return accumulativeCard.getTotalSumm()
				* PERCENT_OF_CARD_TOTAL_SUMM_FOR_DISCOUNT;
	}
}
