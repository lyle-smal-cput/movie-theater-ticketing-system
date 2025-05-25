package za.ac.cput.repository;
/* BranchRepository.java
     Branch Repository interface
     Author: S Rasmeni (222906073)
     Date: 25 May 2025 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, String> {
    Branch findByLocation(String location);
    Branch findByNumberOfTheaterRooms(int numberOfTheaterRooms);
}
