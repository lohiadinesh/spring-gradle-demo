package com.cap.repositories;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

@Repository("baseRepository")
public class BaseRepository {

	@PersistenceContext
	public EntityManager em;

	/**
	 * Save entity.
	 * 
	 * @param entity
	 *            a entity object to be persist, cann't be null or empty
	 */
	public <T> T save(T entity) {
		if (entity != null) {
			em.persist(entity);
			em.flush();
		}
		return entity;
	}

	/**
	 * Merge entity.
	 * 
	 * @param entity
	 *            a entity object to be merge, cann't be null or empty
	 */
	public <T> T merge(T entity) {
		if (entity != null) {
			em.merge(entity);
			em.flush();
		}
		return entity;
	}

	/**
	 * Save list of entities.
	 * 
	 * @param entities
	 *            a list of entities as a List<Object> to be persist, cann't be
	 *            null or empty
	 */
	public <T> List<T> saveAll(List<T> entities) {
		if (entities != null) {
			final List<T> persistEntities = new ArrayList<T>();
			for (T entity : entities) {
				em.persist(entity);
				em.flush();
				persistEntities.add(entity);
			}
			return persistEntities;
		}
		return entities;
	}

	/**
	 * Merge list of entities.
	 * 
	 * @param entities
	 *            a list of entities as a List<Object> to be merge, cann't be
	 *            null or empty
	 */
	public <T> List<T> mergeAll(List<T> entities) {
		if (entities != null) {
			final List<T> mergeEntities = new ArrayList<T>();
			for (T entity : entities) {
				em.merge(entity);
				em.flush();
				mergeEntities.add(entity);
			}
			return mergeEntities;
		}
		return entities;
	}

	/**
	 * Delete entity by the field id.
	 * 
	 * @param entity
	 *            class a entity as a Class<T>, cann't be null or empty
	 * @param idValue
	 *            field id value as a Integer, cann't be null or empty
	 */
	public <T> void delete(Class<T> className, Integer idValue) {
		if (className != null && idValue != null) {
			this.em.remove(this.em.find(className, idValue));
			em.clear();
		}
	}

	/**
	 * Delete all entities by the list of field ids.
	 * 
	 * @param entity
	 *            class a entity as a Class<T>, cann't be null or empty
	 * @param ids
	 *            id as List<Integer>, cann't be null or empty
	 */
	public <T> void delete(Class<T> className, List<Integer> idValue) {
		if (className != null && idValue != null) {
			for (Integer id : idValue) {
				this.em.remove(this.em.find(className, id));
				em.clear();
			}
		}
	}

	/**
	 * Gets entity by the field id.
	 * 
	 * @param entity
	 *            class a entity as a Class<T>, cann't be null or empty
	 * @param id
	 *            field id as a Integer, cann't be null or empty
	 * @return entity as a T
	 */
	public <T> T findById(Class<T> className, BigInteger id) {
		if (className != null && id != null) {
			final T t = em.find(className, id);
			em.clear();
			return t;
		}
		return null;
	}

	/**
	 * Gets all entities or all active entities.
	 * 
	 * @param entity
	 *            class a entity as a Class<T>, cann't be null or empty
	 * @return results entities as a List<T>, true if available else false
	 */
	public <T> List<T> findAll(Class<T> className) {
		if (className != null) {
			final CriteriaBuilder cb = em.getCriteriaBuilder();
			final CriteriaQuery<T> q = cb.createQuery(className);
			final TypedQuery<T> query = em.createQuery(q);
			final List<T> results = query.getResultList();
			em.clear();
			return results != null && results.size() > 0 ? results : null;
		}
		return null;
	}

}
