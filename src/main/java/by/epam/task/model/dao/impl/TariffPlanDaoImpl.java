package by.epam.task.model.dao.impl;

import by.epam.task.exception.DaoException;
import by.epam.task.model.builder.TariffPlanBuilder;
import by.epam.task.model.dao.TariffPlanDao;
import by.epam.task.model.entity.TariffPlan;
import by.epam.task.model.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static by.epam.task.model.dao.ColumnName.*;

public class TariffPlanDaoImpl implements TariffPlanDao {

    private static final Logger logger = LogManager.getLogger();

    private static TariffPlanDaoImpl instance;

    public TariffPlanDaoImpl(){}

    public static TariffPlanDaoImpl getInstance(){
        if (instance == null) {
            instance = new TariffPlanDaoImpl();
        }
        return instance;
    }

    //CREATE REGEX
    private static final String CREATE_TARIFF_PLAN = """
            INSERT INTO tariff_plans (tariff_plan_id, name_tariff_plan, price, internet_connection_speed)
            VALUES (?, ?, ?, ?)""";
    //FIND REGEX
    private static final String FIND_BY_ID_TARIFF_PLAN = """
            SELECT tariff_plan_id, name_tariff_plan, price,   internet_connection_speed
            FROM tariff_plans
            WHERE tariff_plan_id=?""";
    private static final String FIND_BY_NAME_TARIFF_PLAN = """
            SELECT tariff_plan_id, name_tariff_plan, price,   internet_connection_speed
            FROM tariff_plans
            WHERE name_tariff_plan=?""";
    private static final String FIND_BY_PRICE = """
            SELECT tariff_plan_id, name_tariff_plan, price,   internet_connection_speed
            FROM tariff_plans
            WHERE price=?""";
    private static final String FIND_BY_INTERNET_CONNECTION_SPEED = """
            SELECT tariff_plan_id, name_tariff_plan, price,   internet_connection_speed
            FROM tariff_plans
            WHERE internet_connection_speed=?""";
    private static final String FIND_ALL_TARIFFS = """
            SELECT tariff_plan_id, name_tariff_plan, price,   internet_connection_speed
            FROM tariff_plans
            """;
    private static final String UPDATE_NAME_TARIFF_PLAN = "UPDATE tariff_plans SET name_tariff_plan=? WHERE tariff_plan_id=?";
    private static final String UPDATE_PRICE = "UPDATE tariff_plans SET price=? WHERE tariff_plan_id=?";
    private static final String UPDATE_INTERNET_CONNECTION_SPEED = "UPDATE tariff_plans SET internet_connection_speed=? WHERE tariff_plan_id=?";

    public boolean updateNameTariffPlan(Map<String, String> parameters, Long tariffPlanId) throws DaoException { boolean result = false;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_NAME_TARIFF_PLAN)){

            statement.setString(1, parameters.get(NAME_TARIFF_PLAN));
            statement.setLong(2, tariffPlanId);
            result = statement.executeUpdate()>0;
        } catch (SQLException e){
            logger.error("Error during updating name of tariff plan with id = " + tariffPlanId, e);
            throw new DaoException("Error during updating name of tariff plan with id = " + tariffPlanId, e);
        }
        return result;
    }

    public boolean updatePrice(Map<String, String> parameters, Long tariffPlanId) throws DaoException {
        boolean result = false;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_PRICE)){
            System.out.println(parameters.get(PRICE));
            statement.setString(1, parameters.get(PRICE));
            statement.setLong(2, tariffPlanId);
            result = statement.executeUpdate()>0;
        } catch (SQLException e){
            logger.error("Error during updating price of tariff plan with id = " + tariffPlanId, e);
            throw new DaoException("Error during updating price of tariff plan with id = " + tariffPlanId, e);
        }
        return result;
    }

    public boolean updateInternetConnectionSpeed(Map<String, String> parameters, Long tariffPlanId) throws DaoException {
        boolean result = false;
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_INTERNET_CONNECTION_SPEED)){
            statement.setString(1, parameters.get(NAME_TARIFF_PLAN));
            statement.setLong(2, tariffPlanId);
            result = statement.executeUpdate()>0;
        } catch (SQLException e){
            logger.error("Error during updating internet speed of tariff plan with id = " + tariffPlanId, e);
            throw new DaoException("Error during updating internet speed of tariff plan with id = " + tariffPlanId, e);
        }
        return result;
    }

    public boolean addTariffPlan(Map<String, String> parameters) throws DaoException {
        boolean result = false;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_TARIFF_PLAN)) {

            statement.setLong(1, Long.parseLong(parameters.get(TARIFF_PLAN_ID)));
            statement.setString(2, parameters.get(NAME_TARIFF_PLAN));
            statement.setBigDecimal(3, BigDecimal.valueOf(Double.parseDouble(parameters.get(PRICE))));
            statement.setInt(4, Integer.parseInt(parameters.get(INTERNET_CONNECTION_SPEED)));
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Error during adding tariff plan.", e);
            throw new DaoException("Error during adding tariff plan.", e);
        }
        return result;
    }

    public Optional<TariffPlan> findByIdTariffPlan(Long id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_TARIFF_PLAN)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()){
                Optional<TariffPlan> resultTariffPlan = Optional.empty();
                if (resultSet.next()) {
                    TariffPlanBuilder tariffPlanBuilder = new TariffPlanBuilder();
                    tariffPlanBuilder.setTariffPlanId(resultSet.getLong(TARIFF_PLAN_ID));
                    tariffPlanBuilder.setNameTariffPlan(resultSet.getString(NAME_TARIFF_PLAN));
                    tariffPlanBuilder.setPrice(resultSet.getBigDecimal(PRICE));
                    tariffPlanBuilder.setInternetConnectionSpeed(resultSet.getInt(INTERNET_CONNECTION_SPEED));
                    resultTariffPlan = Optional.of(tariffPlanBuilder.build());
                }
                return resultTariffPlan;
            }
        } catch (SQLException e) {
            logger.error("Error during searching tariff plan by id.", e);
            throw new DaoException("Error during searching tariff plan by id.", e);
        }
    }

    public Optional<TariffPlan> findByNameTariffPlan(String nameTariffPlan) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME_TARIFF_PLAN)) {
            statement.setString(1, nameTariffPlan);
            try (ResultSet resultSet = statement.executeQuery()){
                Optional<TariffPlan> resultTariffPlan = Optional.empty();
                if (resultSet.next()) {
                    TariffPlanBuilder tariffPlanBuilder = new TariffPlanBuilder();
                    tariffPlanBuilder.setTariffPlanId(resultSet.getLong(TARIFF_PLAN_ID));
                    tariffPlanBuilder.setNameTariffPlan(resultSet.getString(NAME_TARIFF_PLAN));
                    tariffPlanBuilder.setPrice(resultSet.getBigDecimal(PRICE));
                    tariffPlanBuilder.setInternetConnectionSpeed(resultSet.getInt(INTERNET_CONNECTION_SPEED));
                    resultTariffPlan = Optional.of(tariffPlanBuilder.build());
                }
                return resultTariffPlan;
            }
        } catch (SQLException e) {
            logger.error("Error during searching user by name tariff plan.", e);
            throw new DaoException("Error during searching user by name tariff plan.", e);
        }
    }

    public List<TariffPlan> findByPrice(BigDecimal price) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_PRICE)) {
            statement.setBigDecimal(1, price);
            try (ResultSet resultSet = statement.executeQuery()){
                return createTariffPlans(resultSet);
            }
        } catch (SQLException e) {
            logger.error("Error during searching tariff plan by price.", e);
            throw new DaoException("Error during searching tariff plan by price.", e);
        }
    }

    public List<TariffPlan> findByInternetConnectionSpeed(int speed) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_INTERNET_CONNECTION_SPEED)) {
            statement.setInt(1, speed);
            try (ResultSet resultSet = statement.executeQuery()){
                return createTariffPlans(resultSet);
            }
        } catch (SQLException e) {
            logger.error("Error during searching tariff plan by internet speed.", e);
            throw new DaoException("Error during searching tariff plan by internet speed.", e);
        }
    }

    public List<TariffPlan> findAllTariffPlan() throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_TARIFFS)) {
            try (ResultSet resultSet = statement.executeQuery()){
                return createTariffPlans(resultSet);
            }
        } catch (SQLException e) {
            logger.error("Error during searching for all tariff plans.", e);
            throw new DaoException("Error during searching for all tariff plans.", e);
        }
    }

    private List<TariffPlan> createTariffPlans(ResultSet resultSet) throws SQLException {
       List<TariffPlan> tariffPlanList = new ArrayList<>();
        while (resultSet.next()) {
            TariffPlanBuilder tariffPlanBuilder = new TariffPlanBuilder();
            tariffPlanBuilder.setTariffPlanId(resultSet.getLong(TARIFF_PLAN_ID));
            tariffPlanBuilder.setNameTariffPlan(resultSet.getString(NAME_TARIFF_PLAN));
            tariffPlanBuilder.setPrice(resultSet.getBigDecimal(PRICE));
            tariffPlanBuilder.setInternetConnectionSpeed(resultSet.getInt(INTERNET_CONNECTION_SPEED));
            tariffPlanList.add(tariffPlanBuilder.build());
        }
        return tariffPlanList;
    }

}
