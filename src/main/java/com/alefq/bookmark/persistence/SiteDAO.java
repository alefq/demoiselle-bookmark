package com.alefq.bookmark.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import com.alefq.bookmark.domain.Site;

@PersistenceController
public class SiteDAO extends JPACrud<Site, Long> {

	private static final long serialVersionUID = 1L;
	

}
