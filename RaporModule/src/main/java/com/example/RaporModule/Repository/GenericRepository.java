package com.example.RaporModule.Repository;

import java.util.List;

public interface GenericRepository<TEntity> {
    /**
     * Add entity to the database
     * @param  Entity It is a generic entity which we can determine it.
     * @throws NullPointerException If entity is null it is going to throw Null Exception
    * */
    public void Add(TEntity Entity);
    /**
     * For delete entity from database by looking id
     * @param  Id Entity's primary key
     * */

    public void DeleteById(Integer Id);
    /**
     * To make modifications about the entity in the database
     * @param Entity It is a generic entity which we can determine it.
     * */
    public void Update(TEntity Entity);
    /**
     * To get one entity by looking id
     * @param Id Entity's primary key
     * */
    public TEntity GetById(Integer Id);
    /**
     * To get list of entity from database
     **/
    public List<TEntity> GetList();
}
