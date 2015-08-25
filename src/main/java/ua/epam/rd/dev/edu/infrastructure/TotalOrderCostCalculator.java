package ua.epam.rd.dev.edu.infrastructure;

import java.util.Map;

import ua.epam.rd.dev.edu.domain.AccumulativeCard;
import ua.epam.rd.dev.edu.domain.Pizza;

public interface TotalOrderCostCalculator {

	public double calculateOrderDiscount(Map<Pizza, Integer> pizzas,
			AccumulativeCard card);

	public double calculateTotalOrderPriceWithoutCardDiscount(
			Map<Pizza, Integer> pizzas);

}
