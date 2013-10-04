package com.alefq.bookmark.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.alefq.bookmark.business.SiteBC;
import com.alefq.bookmark.domain.Site;

@ViewController
@NextView("./site_edit.jsf")
@PreviousView("./site_list.jsf")
public class SiteListMB extends AbstractListPageBean<Site, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SiteBC siteBC;
	
	@Override
	protected List<Site> handleResultList() {
		return this.siteBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				siteBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}