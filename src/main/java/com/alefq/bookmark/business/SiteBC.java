package com.alefq.bookmark.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import com.alefq.bookmark.domain.Site;
import com.alefq.bookmark.persistence.SiteDAO;

@BusinessController
public class SiteBC extends DelegateCrud<Site, Long, SiteDAO> {

	private static final long serialVersionUID = 1L;

	public Site getDemoSite() {
		Site site;
		if (findAll().isEmpty()) {
			site = insert(new Site("http://sf.net/projects/demoiselle"));
		} else
		{
			site = findAll().iterator().next();
		}
		return site;
	}

}
