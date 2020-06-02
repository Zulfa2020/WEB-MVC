package zulfa.dao;

import java.util.List;

import zulfa.bo.EmployeeBO;

public interface EmployeeDAO {
	
	public  List<EmployeeBO>  getAllEmps();
	public EmployeeBO  getEmpByNo(int eno);
	public  int   updateEmpByNo(EmployeeBO bo);
	public  int  deleteEmpByNo(int no);
	public int insert(EmployeeBO bo)throws Exception;

}
