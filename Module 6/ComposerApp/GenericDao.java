/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package ComposerApp;
import java.util.List;

public interface GenericDao<E,K> {
    List<E> findAll();
    E findBy(K key);
    void insert(E entity);
} // End GenericDao<E,K>
