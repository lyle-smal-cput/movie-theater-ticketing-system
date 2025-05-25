package za.ac.cput.service;
/* Branch Interface Service .java
     Branch Service interface
     Author: S Rasmeni (222906073)
     Date: 25 May 2025 */
import za.ac.cput.domain.Branch;
import za.ac.cput.domain.Flat;

import java.util.List;

public interface IBranchService extends IService<Branch, String> {
    Branch create(Branch branch);
    Branch read(String branchId);
    Branch update(Branch branch);
    boolean delete(String branchId);
    List<Branch> getAll();
}


