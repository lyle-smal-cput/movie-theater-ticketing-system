/* TheaterRoomService.java
     Theater Room Service class
     Author: SM Rawoot (221075127)
     Date: 25 May 2025 */
package za.ac.cput.service;

import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.TheaterRoom;
import za.ac.cput.repository.TheaterRoomRepository;

import java.util.List;
@Service
public class TheaterRoomService implements ITheaterRoomService{

    private ITheaterRoomService service;
    @Autowired
    private TheaterRoomRepository repository;

    @Override
    public TheaterRoom create(TheaterRoom theaterRoom) {
        return this.repository.save(theaterRoom);
    }

    @Override
    public TheaterRoom read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public TheaterRoom update(TheaterRoom theaterRoom) {
        return this.repository.save(theaterRoom);
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        return true;
    }

    @Override
    public List<TheaterRoom> getAll() {
        return this.repository.findAll();
    }
}
