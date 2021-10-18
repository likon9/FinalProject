package by.epam.task.model.dao;

import by.epam.task.exception.DaoException;
import by.epam.task.model.builder.TariffPlanBuilder;
import by.epam.task.model.entity.TariffPlan;
import by.epam.task.model.pool.ConnectionPool;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static by.epam.task.model.dao.ColumnName.*;
import static by.epam.task.model.dao.ColumnName.INTERNET_CONNECTION_SPEED;

/**
 * The interface Tariff plan dao.
 */
public interface TariffPlanDao {

    /**
     * Update name tariff plan boolean.
     *
     * @param parameters   the parameters
     * @param tariffPlanId the tariff plan id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateNameTariffPlan(Map<String, String> parameters, Long tariffPlanId) throws DaoException;

    /**
     * Update price boolean.
     *
     * @param parameters   the parameters
     * @param tariffPlanId the tariff plan id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updatePrice(Map<String, String> parameters, Long tariffPlanId) throws DaoException;

    /**
     * Update internet connection speed boolean.
     *
     * @param parameters   the parameters
     * @param tariffPlanId the tariff plan id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateInternetConnectionSpeed(Map<String, String> parameters, Long tariffPlanId) throws DaoException;

    /**
     * Add tariff plan boolean.
     *
     * @param parameters the parameters
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean addTariffPlan(Map<String, String> parameters) throws DaoException;

    /**
     * Find by id tariff plan optional.
     *
     * @param id the id
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<TariffPlan> findByIdTariffPlan(Long id) throws DaoException;

    /**
     * Find by name tariff plan optional.
     *
     * @param nameTariffPlan the name tariff plan
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<TariffPlan> findByNameTariffPlan(String nameTariffPlan) throws DaoException;

    /**
     * Find by price list.
     *
     * @param price the price
     * @return the list
     * @throws DaoException the dao exception
     */
    List<TariffPlan> findByPrice(BigDecimal price) throws DaoException;

    /**
     * Find by internet connection speed list.
     *
     * @param speed the speed
     * @return the list
     * @throws DaoException the dao exception
     */
    List<TariffPlan> findByInternetConnectionSpeed(int speed) throws DaoException;

    /**
     * Find all tariff plan list.
     *
     * @return the list
     * @throws DaoException the dao exception
     */
    List<TariffPlan> findAllTariffPlan() throws DaoException;
}
