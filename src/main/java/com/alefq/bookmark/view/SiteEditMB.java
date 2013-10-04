package com.alefq.bookmark.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import com.alefq.bookmark.business.SiteBC;
import com.alefq.bookmark.domain.Site;

@ViewController
@PreviousView("./site_list.jsf")
public class SiteEditMB extends AbstractEditPageBean<Site, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SiteBC siteBC;
	
	@Override
	@Transactional
	public String delete() {
		this.siteBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.siteBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.siteBC.update(getBean());
		return getPreviousView();
	}
	
	@Deprecated
	protected void handleLoad() {
		setBean(handleLoad(getId()));
	}

	@Override
	protected Site handleLoad(Long bookmarkId) {
		return this.siteBC.load(bookmarkId);
	}

}