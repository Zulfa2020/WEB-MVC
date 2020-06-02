package zulfa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import zulfa.bo.EmployeeBO;
import zulfa.dao.EmployeeDAO;
import zulfa.dto.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {
private EmployeeDAO dao;

	public EmployeeServiceImpl(EmployeeDAO dao) {
                this.dao = dao;
}

	@Override
	public List<EmployeeDTO> fetchAllEmps() {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=new ArrayList();
		//use  DAO
		listBO=dao.getAllEmps();
		//convert listBO to listDTO
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		});
	return listDTO;
	}//method
	
}

