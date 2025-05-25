/* SeatRepository.java
     Seat Repository class
     Author: SM Rawoot (221075127)
     Date: 25 May 2025 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Seat;

import java.util.List;
@Repository
public interface SeatRepository extends JpaRepository<Seat, String> {

    Seat findBySeatId(String seatId);
    List<Seat> findBySeatNumber(int seatNumber);
    List<Seat> findByIsAvailable(boolean isAvailable);
    List<Seat> findByTheaterRoomId(String theaterRoomId);
}
