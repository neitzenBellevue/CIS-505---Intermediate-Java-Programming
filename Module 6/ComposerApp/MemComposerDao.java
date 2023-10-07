/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package ComposerApp;
import java.util.List;

public class MemComposerDao implements ComposerDao {
    private List<Composer> composers;

    // This default constructor creates 5 Composer objects and adds them to the composers List.
    public MemComposerDao(){
        Composer comp1 = new Composer();
        Composer comp2 = new Composer();
        Composer comp3 = new Composer();
        Composer comp4 = new Composer();
        Composer comp5 = new Composer();
        composers.add(comp1);
        composers.add(comp2);
        composers.add(comp3);
        composers.add(comp4);
        composers.add(comp5);
    } // End MemComposerDao()

    // This method returns the composers List.
    @Override
    public List<Composer> findAll() {
        return composers;
    } // End findAll()

    /*
     * This method returns a Composer in the composers list that matches the key. If no match it returns null.
     * @param key Integer.
     */
    @Override
    public Composer findBy(Integer key) {
        for(Composer composer : composers){
            if(composer.getId() == key){
                return composer;
            }
        }
        return null; // No instructions were given for what to do if no ID matches. Decided to return null for that scenario.
    } // End findBy(Integer)

    /*
     * This method takes a Composer object and adds it to the composers List.
     * @param entity Composer
     */
    @Override
    public void insert(Composer entity) {
        composers.add(entity);
    } // End insert(Composer)
} // End MemComposerDao
