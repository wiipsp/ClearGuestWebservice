package org.projectx.webservice.dao.impl;

import org.projectx.webservice.dao.CodetypeDAO;
import org.projectx.webservice.to.CodetypeTO;
import org.springframework.stereotype.Repository;

@Repository("codetypeDAO")
public class CodetypeDAOImpl extends BaseDAOImpl<CodetypeTO, String> implements CodetypeDAO{

}
