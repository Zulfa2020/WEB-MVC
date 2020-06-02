package zulfa.service;

import java.util.List;

import zulfa.dto.EmployeeDTO;
import zulfa.dto.EmployeeResultDTO;

public interface EmployeeService {
   public List<EmployeeResultDTO>  search(EmployeeDTO dto);
}
