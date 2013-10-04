package com.alefq.bookmark.business;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import com.alefq.bookmark.domain.Bookmark;
import com.alefq.bookmark.domain.Site;
import com.alefq.bookmark.persistence.BookmarkDAO;

@BusinessController
public class BookmarkBC extends DelegateCrud<Bookmark, Long, BookmarkDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private SiteBC siteBC;
	
	@Startup
	@Transactional
	public void load() {
		Site masterSite = siteBC.getDemoSite(); 
		if (findAll().isEmpty()) {
			insert(new Bookmark("Demoiselle Portal", "http://www.frameworkdemoiselle.gov.br", masterSite));
			insert(new Bookmark("Demoiselle SourceForge", "http://sf.net/projects/demoiselle", masterSite));
			insert(new Bookmark("Twitter", "http://twitter.frameworkdemoiselle.gov.br", masterSite));
			insert(new Bookmark("Blog", "http://blog.frameworkdemoiselle.gov.br", masterSite));
			insert(new Bookmark("Wiki", "http://wiki.frameworkdemoiselle.gov.br", masterSite));
			insert(new Bookmark("Bug Tracking", "http://tracker.frameworkdemoiselle.gov.br", masterSite));
			insert(new Bookmark("Forum", "http://forum.frameworkdemoiselle.gov.br", masterSite));
			insert(new Bookmark("SVN", "http://svn.frameworkdemoiselle.gov.br", masterSite));
			insert(new Bookmark("Maven", "http://repository.frameworkdemoiselle.gov.br", masterSite));
			insert(new Bookmark("Downloads", "http://download.frameworkdemoiselle.gov.br", masterSite));
		}
	}

	public List<Bookmark> findByExample(Bookmark bookmark) {
		return getDelegate().findByHibernateExample(bookmark);
	}
	
}
