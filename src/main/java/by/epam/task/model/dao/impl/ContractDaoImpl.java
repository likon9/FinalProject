package by.epam.task.model.dao.impl;

import by.epam.task.exception.DaoException;
import by.epam.task.model.builder.ContractBuilder;
import by.epam.task.model.dao.ContractDao;
import by.epam.task.model.entity.Contract;
import by.epam.task.model.entity.ContractStatus;
import by.epam.task.model.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static by.epam.task.model.dao.ColumnName.*;

public class ContractDaoImpl implements ContractDao {
    private static final Logger logger = LogManager.getLogger();

    private static ContractDaoImpl instance;
    private ContractDaoImpl(){}

    public static ContractDaoImpl getInstance(){
        if (instance == null) {
            instance = new ContractDaoImpl();
        }
        return instance;
    }
    //CREATE REGEX
    private static final String CREATE_CONTRACT = """
            INSERT INTO contracts (connection_date, users_user_id, tariff_plans_tariff_plan_id, contract_statusid )
            VALUES (?, ?, ?,?)""";
    //FIND REGEX
    private static final String FIND_BY_CONTRACT_ID = """
            SELECT contract_id, connection_date, users_user_id, tariff_plans_tariff_plan_id,contract_statusid,tariff_plans.name_tariff_plan,
            tariff_plans.price,tariff_plans.internet_connection_speed, contract_statuses.contract_status 
            FROM contracts
            JOIN users ON contracts.users_user_id   = users.user_id
            JOIN tariff_plans ON contracts.tariff_plans_tariff_plan_id = tariff_plans.tariff_plan_id
            JOIN contract_statuses ON contracts.contract_statusid   = contract_statuses.contract_status_id
            WHERE contract_id =?""";
    private static final String FIND_BY_USER_ID = """
            SELECT contract_id, connection_date, users_user_id, tariff_plans_tariff_plan_id,contract_statusid,tariff_plans.name_tariff_plan,
            tariff_plans.price,tariff_plans.internet_connection_speed, contract_statuses.contract_status 
            FROM contracts
            JOIN users ON contracts.users_user_id   = users.user_id
            JOIN tariff_plans ON contracts.tariff_plans_tariff_plan_id = tariff_plans.tariff_plan_id
            JOIN contract_statuses ON contracts.contract_statusid   = contract_statuses.contract_status_id
            WHERE users_user_id=? AND contract_statusid =?""";
    private static final String FIND_ALL_CONTRACT_BY_USER_ID = """
            SELECT contract_id, connection_date, users_user_id, tariff_plans_tariff_plan_id,contract_statusid,tariff_plans.name_tariff_plan,
            tariff_plans.price,tariff_plans.internet_connection_speed, contract_statuses.contract_status 
            FROM contracts
            JOIN users ON contracts.users_user_id   = users.user_id
            JOIN tariff_plans ON contracts.tariff_plans_tariff_plan_id = tariff_plans.tariff_plan_id
            JOIN contract_statuses ON contracts.contract_statusid   = contract_statuses.contract_status_id
            WHERE users_user_id=?""";
    private static final String FIND_BY_STATUS = """
            SELECT contract_id, connection_date, users_user_id, tariff_plans_tariff_plan_id,contract_statusid,tariff_plans.name_tariff_plan,
            tariff_plans.price,tariff_plans.internet_connection_speed, contract_statuses.contract_status 
            FROM contracts
            JOIN users ON contracts.users_user_id   = users.user_id
            JOIN tariff_plans ON contracts.tariff_plans_tariff_plan_id = tariff_plans.tariff_plan_id
            JOIN contract_statuses ON contracts.contract_statusid   = contract_statuses.contract_status_id
            WHERE contract_statuses.contract_status =?""";
    private static final String FIND_BY_TARIFF_PLAN_ID = """
            SELECT contract_id, connection_date, users_user_id, tariff_plans_tariff_plan_id,contract_statusid,tariff_plans.name_tariff_plan,
            tariff_plans.price,tariff_plans.internet_connection_speed, contract_statuses.contract_status 
            FROM contracts
            JOIN users ON contracts.users_user_id   = users.user_id
            JOIN tariff_plans ON contracts.tariff_plans_tariff_plan_id = tariff_plans.tariff_plan_id
            JOIN contract_statuses ON contracts.contract_statusid   = contract_statuses.contract_status_id
            WHERE  tariff_plans_tariff_plan_id =?""";
    private static final String FIND_BY_TARIFF_PLAN_NAME = """
            SELECT contract_id, connection_date, users_user_id, tariff_plans_tariff_plan_id,contract_statusid,tariff_plans.name_tariff_plan,
            tariff_plans.price,tariff_plans.internet_connection_speed, contract_statuses.contract_status 
            FROM contracts
            JOIN users ON contracts.users_user_id   = users.user_id
            JOIN tariff_plans ON contracts.tariff_plans_tariff_plan_id = tariff_plans.tariff_plan_id
            JOIN contract_statuses ON contracts.contract_statusid   = contract_statuses.contract_status_id
            WHERE tariff_plans.name_tariff_plan =?""";
    private static final String FIND_ALL_CONTRACTS = """
            SELECT contract_id, connection_date, users_user_id, tariff_plans_tariff_plan_id,contract_statusid,tariff_plans.name_tariff_plan,
            tariff_plans.price,tariff_plans.internet_connection_speed, contract_statuses.contract_status 
            FROM contracts
            JOIN users ON contracts.users_user_id   = users.user_id
            JOIN tariff_plans ON contracts.tariff_plans_tariff_plan_id = tariff_plans.tariff_plan_id
            JOIN contract_statuses ON contracts.contract_statusid   = contract_statuses.contract_status_id""";

    private static final String UPDATE_STATUS = "UPDATE contracts SET contract_statusid=? WHERE contract_id=?";

    public boolean updateStatusContract(Map<String, String> parameters, Long contractId) throws DaoException {
        boolean result = false;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_STATUS)){
            statement.setLong(1, 2);
            statement.setLong(2, contractId);
            result = statement.executeUpdate()>0;
        } catch (SQLException e){
            logger.error("Error during updating status of contract with id = " + contractId, e);
            throw new DaoException("Error during updating status of contract with id = " + contractId, e);
        }
        return result;
    }

    public boolean addContract(Map<String, String> parameters) throws DaoException {
        boolean result = false;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_CONTRACT)) {
            statement.setTimestamp(1, Timestamp.valueOf((parameters.get(CONNECTION_DATE))));
            statement.setLong(2, Long.parseLong(parameters.get(CONTRACT_USER_ID)));
            statement.setLong(3, Long.parseLong(parameters.get(CONTRACT_TARIFF_PLAN_ID)));
            statement.setLong(4, 1);
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error during adding contract.", e);
            throw new DaoException("Error during adding contract.", e);
        }
        return result;
    }

    public Optional<Contract> findByContractId(Long contractId) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_CONTRACT_ID)) {
            statement.setLong(1, contractId);
            try (ResultSet resultSet = statement.executeQuery()){
                Optional<Contract> contract = Optional.empty();
                if (resultSet.next()) {
                    ContractBuilder contractBuilder = new ContractBuilder();
                    contractBuilder.setContractId(resultSet.getLong(CONTRACT_ID));
                    contractBuilder.setConnectionDate(LocalDate.parse(resultSet.getString(CONNECTION_DATE)));
                    contractBuilder.setUserId(resultSet.getLong(CONTRACT_USER_ID));
                    contractBuilder.setTariffPlanId(resultSet.getLong(CONTRACT_TARIFF_PLAN_ID));
                    contractBuilder.setTariffPlanName(resultSet.getString(NAME_TARIFF_PLAN));
                    contractBuilder.setTariffPlanPrice(resultSet.getBigDecimal(PRICE));
                    contractBuilder.setTariffPlanSpeed(resultSet.getInt(INTERNET_CONNECTION_SPEED));
                    contractBuilder.setContractStatus(ContractStatus.valueOf(resultSet.getString(CONTRACT_STATUS)));
                    contract = Optional.of(contractBuilder.build());
                }
                return contract;
            }
        } catch (SQLException e) {
            logger.error("Error during searching user by id.", e);
            throw new DaoException("Error during searching user by id.", e);
        }
    }

    public List<Contract> findAllContractByUserId(Long userId) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_CONTRACT_BY_USER_ID)) {
            statement.setLong(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                return createContract(resultSet);
            }
        } catch (SQLException e) {
            logger.error("Error during searching contract by user id.", e);
            throw new DaoException("Error during searching contract by user id.", e);
        }
    }

    public List<Contract> findByStatus(String status) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_STATUS)) {
            statement.setString(1, status);
            try (ResultSet resultSet = statement.executeQuery()) {
                return createContract(resultSet);
            }
        } catch (SQLException e) {
            logger.error("Error during searching contract by status.", e);
            throw new DaoException("Error during searching contract by status.", e);
        }
    }

    public List<Contract> findEffectiveContractByUserId(Long userId) throws DaoException {
            try (Connection connection = ConnectionPool.getInstance().getConnection();
                 PreparedStatement statement = connection.prepareStatement(FIND_BY_USER_ID)) {
                statement.setLong(1, userId);
                statement.setLong(2, 1);
                try (ResultSet resultSet = statement.executeQuery()) {
                    return createContract(resultSet);
                }
            } catch (SQLException e) {
                logger.error("Error during searching contract by user id.", e);
                throw new DaoException("Error during searching contract by user id.", e);
            }
        }

    public List<Contract> findByTariffPlanId(Long tariffPlanId) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_TARIFF_PLAN_ID)) {
            statement.setLong(1, tariffPlanId);
            try (ResultSet resultSet = statement.executeQuery()) {
                return createContract(resultSet);
            }
        } catch (SQLException e) {
            logger.error("Error during searching contract by tariff plan id.", e);
            throw new DaoException("Error during searching contract by tariff plan id.", e);
        }
    }

    public List<Contract> findByTariffPlanName(String tariffPlanName) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_TARIFF_PLAN_NAME)) {
            statement.setString(1, tariffPlanName);
            try (ResultSet resultSet = statement.executeQuery()) {
                return createContract(resultSet);
            }
        } catch (SQLException e) {
            logger.error("Error during searching contract by tariff plan name.", e);
            throw new DaoException("Error during searching contract by tariff plan name.", e);
        }
    }

    public List<Contract> findAll() throws DaoException {

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_CONTRACTS)) {
            try (ResultSet resultSet = statement.executeQuery()){
                return createContract(resultSet);
            }
        } catch (SQLException e) {
            logger.error("Error during searching for all contracts.", e);
            throw new DaoException("Error during searching for all contracts.", e);
        }
    }

    private List<Contract> createContract(ResultSet resultSet) throws SQLException, DaoException {
        List<Contract> contractList = new ArrayList<>();
        while (resultSet.next()) {
            ContractBuilder contractBuilder = new ContractBuilder();
            contractBuilder.setContractId(resultSet.getLong(CONTRACT_ID));
            contractBuilder.setConnectionDate(LocalDate.parse(resultSet.getString(CONNECTION_DATE)));
            contractBuilder.setUserId(resultSet.getLong(CONTRACT_USER_ID));
            contractBuilder.setTariffPlanId(resultSet.getLong(CONTRACT_TARIFF_PLAN_ID));
            contractBuilder.setTariffPlanName(resultSet.getString(NAME_TARIFF_PLAN));
            contractBuilder.setTariffPlanPrice(resultSet.getBigDecimal(PRICE));
            contractBuilder.setTariffPlanSpeed(resultSet.getInt(INTERNET_CONNECTION_SPEED));
            contractBuilder.setContractStatus(ContractStatus.valueOf(resultSet.getString(CONTRACT_STATUS)));
            contractList.add(contractBuilder.build());
        }
        return contractList;
    }
    }

