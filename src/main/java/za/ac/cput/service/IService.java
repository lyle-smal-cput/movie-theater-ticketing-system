/* IService.java
     IService Interface
     Author: SM Rawoot (221075127)
     Date: 25 May 2025 */
package za.ac.cput.service;

public interface IService<T, ID> {
    T create(T t);

    T read(ID id);

    T update(T t);

    boolean delete(ID id);

}
