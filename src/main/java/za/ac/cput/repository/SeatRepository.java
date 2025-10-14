/* SeatRepository.java
     Seat Repository class
     Author: SM Rawoot (221075127)
     Date: 25 May 2025 */
package za.ac.cput.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Seat;
import za.ac.cput.domain.TheaterRoom;

import java.util.List;
@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findSeatsByTheaterRoom_TheaterRoomIdAndIsAvailable(Long theaterRoomId, boolean isAvailable);
    @Modifying
    @Transactional
    @Query("UPDATE Seat s SET s.isAvailable = :isAvailable WHERE s.id = :id")
    int updateSeatAvailability(@Param("id") Long id, @Param("isAvailable") boolean isAvailable);
}
