package repositories;

import java.lang.reflect.InvocationTargetException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.beanutils.BeanUtils;

import entities.Tarefa;



@Stateless
public class TarefaRepository {

    @PersistenceContext(unitName = "pu-sqlite")
    private EntityManager em;

    public Tarefa findById(int id) {
        return this.em.find(Tarefa.class, id);
    }

    public boolean hasTarefa(int id) {
        Long count = (Long) this.em.createQuery("SELECT COUNT(j) FROM Tarefa j WHERE j.id = :id")
                .setParameter("id", id)
                .getSingleResult();

        return count > 0;
    }

    public Tarefa save(Tarefa instance) {
    	Tarefa tarefa = this.findById(instance.getId());

        if (tarefa != null) {
            try {
                BeanUtils.copyProperties(tarefa, instance);
                this.em.merge(tarefa);
                return tarefa;
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