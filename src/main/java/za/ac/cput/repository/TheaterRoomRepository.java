/* TheaterRoomRepository.java
     Theater Room Repository class
     Author: S Rawoot (221075127)
     Date: 25 May 2025 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.TheaterRoom;

import java.util.List;
@Repository
public interface TheaterRoomRepository extends JpaRepository<TheaterRoom, Long> {

    TheaterRoom findByTheaterRoomId(Long theaterRoomId);
    List<TheaterRoom> findByRoomNumber(int roomNumber);
    List<TheaterRoom> findByCapacity(int capacity);
    List<TheaterRoom> findBySeatsAvailable(int seatsAvailable);
    List<TheaterRoom> findByIs3DSupported(boolean is3DSupported);
    List<TheaterRoom> findByBranchBranchId(Long branchId);
}
