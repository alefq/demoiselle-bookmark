package com.alefq.bookmark.view;

import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import com.alefq.bookmark.business.BookmarkBC;
import com.alefq.bookmark.domain.Bookmark;

@ViewController
@NextView("/bookmark_edit.xhtml")
@PreviousView("/bookmark_list.xhtml")
@SessionScoped
public class BookmarkListMB extends AbstractListPageBean<Bookmark, Long> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Logger logger;

	@Inject
	private BookmarkBC bc;

	private Bookmark bookmarkFilter;

	@Override
	protected List<Bookmark> handleResultList() {
		List<Bookmark> list = null;
		logger.info("link:" + getBookmarkFilter().getLink());
		if (getBookmarkFilter().getLink() != null
				&& getBookmarkFilter().getLink().trim().length() > 0) {
			list = bc.findByExample(getBookmarkFilter());
		} else {
			list = bc.findAll();
		}
		return list;
	}

	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter
				.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);

			if (delete) {
				bc.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

	public Bookmark getBookmarkFilter() {
		if (bookmarkFilter == null)
			bookmarkFilter = new Bookmark();
		return bookmarkFilter;
	}

	public void setBookmarkFilter(Bookmark bookmarkFilter) {
		this.bookmarkFilter = bookmarkFilter;
	}
	
	public String handleFilterResultList() {
		clear();
		handleResultList();
		return getCurrentView();
	}

}
