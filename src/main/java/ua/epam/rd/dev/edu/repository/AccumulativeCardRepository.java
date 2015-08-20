package ua.epam.rd.dev.edu.repository;

import java.util.List;

import ua.epam.rd.dev.edu.domain.AccumulativeCard;

public interface AccumulativeCardRepository {

	public Long create(AccumulativeCard card);
	
	public void update(AccumulativeCard card);
	
	public AccumulativeCard findById(Long id);
	
	public List<AccumulativeCard> findAllCards();
}
