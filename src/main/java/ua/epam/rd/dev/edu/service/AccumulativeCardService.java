package ua.epam.rd.dev.edu.service;

import java.util.List;

import ua.epam.rd.dev.edu.domain.AccumulativeCard;

public interface AccumulativeCardService {

	public Long create(AccumulativeCard card);
	
	public void update(AccumulativeCard card);
	
	public AccumulativeCard findById(Long id);
	
	public List<AccumulativeCard> findAllCards();

}
