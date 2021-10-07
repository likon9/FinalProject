package by.epam.finalTask.model.service;

import by.epam.finalTask.exception.DaoException;
import by.epam.finalTask.exception.ServiceException;
import by.epam.finalTask.model.entity.Contract;
import by.epam.finalTask.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ContractService {

    boolean addContract(Map<String, String> parameters) throws ServiceException;

    boolean updateStatusContract(Map<String, String> parameters, Long contractId) throws ServiceException;

    Optional<Contract> findByContractId(Long userId) throws ServiceException;

    List<Contract> findEffectiveContractByUserId(Long userId) throws ServiceException;

    List<Contract> findAllContractByUserId(Long userId) throws ServiceException;

    List<Contract> findByStatus(String status) throws ServiceException;

    List<Contract> findByTariffPlanId(Long tariffPlanId) throws ServiceException;

    List<Contract> findByTariffPlanName(String tariffPlanName) throws ServiceException;

    List<Contract> findAll() throws ServiceException;
}
