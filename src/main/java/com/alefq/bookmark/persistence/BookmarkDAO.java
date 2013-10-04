package com.alefq.bookmark.persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import com.alefq.bookmark.domain.Bookmark;

@PersistenceController
public class BookmarkDAO extends JPACrud<Bookmark, Long> {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<Bookmark> findByHibernateExample(Bookmark bookmark) {
		List<Bookmark> list = null;
		Session session = (Session) getEntityManager().getDelegate();
		Example example = null;
		example = Example.create(bookmark).ignoreCase()
				.enableLike(MatchMode.ANYWHERE).excludeZeroes();
		Criteria crit = session.createCriteria(bookmark.getClass());
		crit.add(example);
		list = crit.list();
		return list;
	}

}
