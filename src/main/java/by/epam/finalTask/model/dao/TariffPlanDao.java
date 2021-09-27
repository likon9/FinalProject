package by.epam.finalTask.model.dao;

import by.epam.finalTask.exception.DaoException;
import by.epam.finalTask.model.builder.TariffPlanBuilder;
import by.epam.finalTask.model.entity.TariffPlan;
import by.epam.finalTask.pool.ConnectionPool;
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

import static by.epam.finalTask.model.dao.ColumnName.*;

public class TariffPlanDao {

    private static final Logger logger = LogManager.getLogger();

    private static TariffPlanDao instance;

    //CREATE REGEX
    private static final String CREATE_TARIFF_PLAN = """
            INSERT INTO tariff_plans (tariff_plan_id, name_tariff_plan, price, internet_connection_speed)
            VALUES (?, ?, ?, ?)""";
    //FIND REGEX

    private static final String FIND_ALL_TARIFFS = """
            SELECT tariff_plan_id, name_tariff_plan, price,   internet_connection_speed
            FROM tariff_plans
            """;
    private static final String FIND_BY_ID = """
            SELECT tariff_plan_id, name_tariff_plan, price,   internet_connection_speed
            FROM tariff_plans
            WHERE tariff_plan_id=?""";


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

    public Optional<TariffPlan> findById(Long id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
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
            logger.error("Error during searching user by id.", e);
            throw new DaoException("Error during searching user by id.", e);
        }
    }

    public List<TariffPlan> findAll() throws DaoException {
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

    private List createTariffPlans(ResultSet resultSet) throws SQLException {
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
