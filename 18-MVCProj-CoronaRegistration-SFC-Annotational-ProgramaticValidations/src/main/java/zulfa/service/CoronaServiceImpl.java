package zulfa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import zulfa.bo.CoronaBO;
import zulfa.dao.CoronaDAO;
import zulfa.dto.CoronaDTO;
@Service
public class CoronaServiceImpl implements CoronaService {
@Autowired
	private CoronaDAO dao;
	
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String register(CoronaDTO dto) {
		int count=0;
		CoronaBO bo=null;
		//convert dto to bo
		bo=new CoronaBO();
		BeanUtils.copyProperties(dto, bo);
		//use DAO
		count=dao.insert(bo);
	
		return count==0?"Patient Registration Failed":"Patient Registration Succeded";
	}

}
