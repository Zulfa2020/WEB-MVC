package zulfa.service;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import zulfa.bo.EmployeeBO;
import zulfa.dao.EmployeeDAO;
import zulfa.dto.EmployeeDTO;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	@Qualifier("empDAO")
	private  EmployeeDAO  dao;

	

	@Override
	public List<EmployeeDTO> fetchAllEmps() {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=new ArrayList();
		//use DAO
		listBO=dao.getAllEmps();
		//convert listBO to listDTO
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		
		return listDTO;
	}//method



	@Override
	public EmployeeDTO fetchEmpByNo(int no) {
		EmployeeBO bo=null;
		EmployeeDTO dto=null;
		//use DAO
		bo=dao.getEmpByNo(no);
		//convet bo to dto
		 dto=new EmployeeDTO();
		 BeanUtils.copyProperties(bo, dto);
		return dto;
	}



	@Override
	public String modifyEmpByNo(EmployeeDTO dto) {
		int count=0;
		EmployeeBO bo=null;
		//convert dto to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use DAO
		count=dao.updateEmpByNo(bo);
		
		return (count==0)?"Employee updation failed" : "Employee updation succedded";
	}
	
	@Override
	public String removeEmpByNo(int no) {
		int count=0;
		//use DAO
		count=dao.deleteEmpByNo(no);
		return (count==0)?"Employee deletion failed" : "Employee deletion succedded";
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String register(EmployeeDTO dto)throws Exception {
		int count=0;
		EmployeeBO bo=null;
		//convert dto to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use DAO
		count=dao.insert(bo);
	
		return count==0?"Employee Registration Failed":"Employee Registration Succeded";
	}

}//class