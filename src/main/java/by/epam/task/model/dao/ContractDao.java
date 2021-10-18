package by.epam.task.model.dao;

import by.epam.task.exception.DaoException;
import by.epam.task.model.builder.ContractBuilder;
import by.epam.task.model.entity.Contract;
import by.epam.task.model.entity.ContractStatus;
import by.epam.task.model.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static by.epam.task.model.dao.ColumnName.*;
import static by.epam.task.model.dao.ColumnName.CONTRACT_STATUS;

/**
 * The interface Contract dao.
 */
public interface ContractDao {

    /**
     * Update status contract boolean.
     *
     * @param parameters the parameters
     * @param contractId the contract id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateStatusContract(Map<String, String> parameters, Long contractId) throws DaoException;

    /**
     * Add contract boolean.
     *
     * @param parameters the parameters
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean addContract(Map<String, String> parameters) throws DaoException;

    /**
     * Find by contract id optional.
     *
     * @param contractId the contract id
     * @return the optional
     * @throws DaoException the dao exception
     */
    Optional<Contract> findByContractId(Long contractId) throws DaoException;

    /**
     * Find all contract by user id list.
     *
     * @param userId the user id
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Contract> findAllContractByUserId(Long userId) throws DaoException;

    /**
     * Find by status list.
     *
     * @param status the status
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Contract> findByStatus(String status) throws DaoException;

    /**
     * Find effective contract by user id list.
     *
     * @param userId the user id
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Contract> findEffectiveContractByUserId(Long userId) throws DaoException;

    /**
     * Find by tariff plan id list.
     *
     * @param tariffPlanId the tariff plan id
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Contract> findByTariffPlanId(Long tariffPlanId) throws DaoException;

    /**
     * Find by tariff plan name list.
     *
     * @param tariffPlanName the tariff plan name
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Contract> findByTariffPlanName(String tariffPlanName) throws DaoException;

    /**
     * Find all list.
     *
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Contract> findAll() throws DaoException;

}
