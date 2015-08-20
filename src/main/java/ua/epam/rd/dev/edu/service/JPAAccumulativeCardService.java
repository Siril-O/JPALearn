package ua.epam.rd.dev.edu.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.epam.rd.dev.edu.domain.AccumulativeCard;
import ua.epam.rd.dev.edu.repository.AccumulativeCardRepository;

@Service
public class JPAAccumulativeCardService implements AccumulativeCardService {

	@Autowired
	private AccumulativeCardRepository cardRepository;

	@Override
	@Transactional
	public Long create(AccumulativeCard card) {
		return cardRepository.create(card);
	}

	@Override
	@Transactional
	public void update(AccumulativeCard card) {
		cardRepository.update(card);
	}

	@Override
	public AccumulativeCard findById(Long id) {
		return cardRepository.findById(id);
	}

	@Override
	public List<AccumulativeCard> findAllCards() {
		return cardRepository.findAllCards();
	}

}
