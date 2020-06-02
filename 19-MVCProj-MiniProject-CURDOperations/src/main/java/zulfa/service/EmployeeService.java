package zulfa.service;

import java.util.List;

import zulfa.dto.EmployeeDTO;

public interface EmployeeService {
	
	public  List<EmployeeDTO>  fetchAllEmps();
	public  EmployeeDTO   fetchEmpByNo(int no);
	public  String   modifyEmpByNo(EmployeeDTO dto);
	public   String   removeEmpByNo(int no);
	public String register(EmployeeDTO dto)throws Exception;

}