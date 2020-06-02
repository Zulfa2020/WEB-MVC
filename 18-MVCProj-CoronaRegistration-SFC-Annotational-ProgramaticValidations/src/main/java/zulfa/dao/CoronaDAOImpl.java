package zulfa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import zulfa.bo.CoronaBO;
@Repository
public class CoronaDAOImpl implements CoronaDAO {
private static final String CORONA_PATIENTS="INSERT INTO CORONA_PATIENTS VALUES(PATID_SEQ.NEXTVAL,?,?,?,?)"; 
	@Autowired
private JdbcTemplate jt;

	
	@Override
	public int insert(CoronaBO bo) {
		int count=0;
		count=jt.update(CORONA_PATIENTS,bo.getPatName(),bo.getAge(),bo.getLocation(),bo.getHospital());
		
		return count;
	}

}
