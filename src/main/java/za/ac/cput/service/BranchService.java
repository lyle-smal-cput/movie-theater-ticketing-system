package za.ac.cput.service;
/* Branch Service.java
     Branch Service class
     Author: S Rasmeni (222906073)
     Date: 25 May 2025 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Branch;
import za.ac.cput.repository.BranchRepository;
import java.util.List;

@Service
public class BranchService implements IBranchService {
    private final BranchRepository repository;

    @Autowired
    public BranchService(BranchRepository repository) {
        this.repository = repository;
    }

    @Override
    public Branch create(Branch branch) {
        return this.repository.save(branch);
    }

    @Override
    public Branch read(String branchId) {
        return this.repository.findById(branchId).orElse(null);
    }

    @Override
    public Branch update(Branch branch) {
        if (this.repository.existsById(branch.getBranchId()))
            return this.repository.save(branch);
        return null;
    }

    @Override
    public boolean delete(String branchId) {
        if (this.repository.existsById(branchId)) {
            this.repository.deleteById(branchId);
            return true;
        }
        return false;
    }

    @Override
    public List<Branch> getAll() {
        return this.repository.findAll();
    }
}
