/* ITheaterRoomService.java
     ITheaterRoom Service Interface
     Author: SM Rawoot (221075127)
     Date: 25 May 2025 */
package za.ac.cput.service;

import za.ac.cput.domain.TheaterRoom;

import java.util.List;

public interface ITheaterRoomService extends IService<TheaterRoom, Long> {
    List<TheaterRoom> getAll();
}
