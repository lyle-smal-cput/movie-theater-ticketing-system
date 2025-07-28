package za.ac.cput.controller;
/* Branch Controller.java
     Branch Controller class
     Author: S Rasmeni (222906073)
     Date: 25 May 2025 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Branch;
import za.ac.cput.service.BranchService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/branch")
public class BranchController {

    private BranchService service;

    @Autowired
    public BranchController(BranchService service) {this.service = service;}
    @PostMapping("/create")
    public Branch create(@RequestBody Branch branch) {
       return service.create(branch);
    }

    @GetMapping("/read/{branchId}")
    public Branch read(@PathVariable String branchId) {
       return service.read(branchId);
    }

    @PutMapping("/update")
    public Branch update(@RequestBody Branch branch) {
       return service.update(branch);
    }

    @DeleteMapping("/delete/{branchId}")
    public boolean delete(@PathVariable String branchId) {
       return service.delete(branchId);
    }

    @GetMapping("/getAll")
    public List<Branch> getAll() {
      return service.getAll();
    }
}
