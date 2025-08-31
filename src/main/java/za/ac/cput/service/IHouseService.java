package za.ac.cput.service;
/* House Interface Service .java
     House Service interface
     Author: S Rasmeni (222906073)
     Date: 25 May 2025 */
import za.ac.cput.domain.House;
import java.util.List;

public interface IHouseService extends IService<House, Long> {
    List<House> getAll();
}
