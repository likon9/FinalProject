package by.epam.finalTask.model.dao;

import by.epam.finalTask.exception.DaoException;
import by.epam.finalTask.model.builder.ContractBuilder;
import by.epam.finalTask.model.entity.Contract;
import by.epam.finalTask.model.entity.ContractStatus;
import by.epam.finalTask.model.entity.User;
import by.epam.finalTask.pool.ConnectionPool;
import by.epam.finalTask.util.IdGenerate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static by.epam.finalTask.model.dao.ColumnName.*;

public class ContractDao {
    private static final Logger logger = LogManager.getLogger();

    private static ContractDao instance;
    public ContractDao(){}

    public static ContractDao getInstance(){
        if (instance == null) {
            instance = new ContractDao();
        }
        return instance;
    }
    //CREATE REGEX
    private static final String CREATE_CONTRACT = """
            INSERT INTO contracts (contract_id, connection_date, users_user_id, tariff_plans_tariff_plan_id, contract_statusid )
            VALUES (?, ?, ?, ?,?)""";
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


    public boolean addContract(Map<String, String> parameters) throws DaoException {
        boolean result = false;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_CONTRACT)) {
            statement.setLong(1,  Long.parseLong(parameters.get(CONTRACT_ID)));
            statement.setTimestamp(2, Timestamp.valueOf((parameters.get(CONNECTION_DATE))));
            statement.setLong(3, Long.parseLong(parameters.get(CONTRACT_USER_ID)));
            statement.setLong(4, Long.parseLong(parameters.get(CONTRACT_TARIFF_PLAN_ID)));
            statement.setLong(5, 1);

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
                    contractBuilder.setConnectionDate(resultSet.getTimestamp(CONNECTION_DATE));
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

    private List<Contract> createContract(ResultSet resultSet) throws SQLException, DaoException {
        List<Contract> contractList = new ArrayList<>();

        while (resultSet.next()) {

            ContractBuilder contractBuilder = new ContractBuilder();
            contractBuilder.setContractId(resultSet.getLong(CONTRACT_ID));
            contractBuilder.setConnectionDate(resultSet.getTimestamp(CONNECTION_DATE));
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

