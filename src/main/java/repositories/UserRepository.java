package repositories;

import java.lang.reflect.InvocationTargetException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.beanutils.BeanUtils;

import entities.User;



@Stateless
public class UserRepository {

    @PersistenceContext(unitName = "pu-sqlite")
    private EntityManager em;

    public User findByEmail(String email) {
        return this.em.find(User.class, email);
    }

    public boolean hasUser(String email) {
        Long count = (Long) this.em.createQuery("SELECT COUNT(j) FROM User j WHERE j.email = :email")
                .setParameter("email", email)
                .getSingleResult();

        return count > 0;
    }

    public User save(User instance) {
    	User user = this.findByEmail(instance.getEmail());

        if (user != null) {
            try {
                BeanUtils.copyProperties(user, instance);
                this.em.merge(user);
                return user;
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            this.em.persist(instance);
            return instance;
        }
    }
}