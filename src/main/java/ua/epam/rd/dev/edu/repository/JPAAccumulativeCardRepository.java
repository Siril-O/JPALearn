package ua.epam.rd.dev.edu.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.epam.rd.dev.edu.domain.AccumulativeCard;

@Repository
public class JPAAccumulativeCardRepository implements AccumulativeCardRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Long create(AccumulativeCard card) {
		em.persist(card);
		return card.getId();
	}

	@Override
	public void update(AccumulativeCard card) {
		em.merge(card);		
	}

	@Override
	public AccumulativeCard findById(Long id) {
		return em.find(AccumulativeCard.class, id);
	}

	@Override
	public List<AccumulativeCard> findAllCards() {
		TypedQuery<AccumulativeCard> query = em.createQuery("SELECT c FROM AccumulativeCard c",
				AccumulativeCard.class);
		return query.getResultList();
		
	}

}
