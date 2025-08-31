/* ISeatService.java
     Seat Service Interface
     Author: SM Rawoot (221075127)
     Date: 25 May 2025 */
package za.ac.cput.service;

import za.ac.cput.domain.Seat;

import java.util.List;

public interface ISeatService extends IService<Seat, Long> {
    List<Seat> getAll();

}
