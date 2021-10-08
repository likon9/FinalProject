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

public interface ContractDao {

    boolean updateStatusContract(Map<String, String> parameters, Long contractId) throws DaoException;

    boolean addContract(Map<String, String> parameters) throws DaoException;

    Optional<Contract> findByContractId(Long contractId) throws DaoException;

    List<Contract> findAllContractByUserId(Long userId) throws DaoException;

    List<Contract> findByStatus(String status) throws DaoException;

    List<Contract> findEffectiveContractByUserId(Long userId) throws DaoException;

    List<Contract> findByTariffPlanId(Long tariffPlanId) throws DaoException;

    List<Contract> findByTariffPlanName(String tariffPlanName) throws DaoException;

    List<Contract> findAll() throws DaoException;

}
