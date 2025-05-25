package za.ac.cput.service;

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


