package zulfa.dao;

import java.util.List;

import zulfa.bo.EmployeeBO;
import zulfa.bo.EmployeeResultBO;

public interface EmployeeDAO {
	
	public List<EmployeeResultBO>  find(EmployeeBO bo);

}