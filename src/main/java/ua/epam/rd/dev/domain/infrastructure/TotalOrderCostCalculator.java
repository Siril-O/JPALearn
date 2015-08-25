package ua.epam.rd.dev.domain.infrastructure;

import java.util.Map;

import ua.epam.rd.dev.edu.domain.AccumulativeCard;
import ua.epam.rd.dev.edu.domain.Pizza;

public interface TotalOrderCostCalculator {

	public double calculateOrderDiscount(Map<Pizza, Integer> pizzas,
			AccumulativeCard card);

	public double calculateToatalOrderPriceWithoutCardDiscount(
			Map<Pizza, Integer> pizzas);

}
