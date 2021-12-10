package by.epam.task.validator;

import by.epam.task.model.entity.TariffPlan;
import by.epam.task.model.validator.TariffPlanValidator;
import by.epam.task.model.validator.UserValidator;
import jakarta.xml.bind.ValidationException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TariffPlanValidatorTest {

    @Test(groups = "validator" , priority = 26)
    public void nameTariffIsNullValidatorTest() throws ValidationException {
        boolean result = TariffPlanValidator.getInstance().isNameValid(null);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 27)
    public void incorrectNameTariffValidatorTest() throws ValidationException {
        String name = "      ";
        boolean result = TariffPlanValidator.getInstance().isNameValid(name);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 26)
    public void shorterThanCorrectNameTariffValidatorTest() throws ValidationException {
        String name = "t1";
        boolean result = TariffPlanValidator.getInstance().isNameValid(name);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 26)
    public void longerThanCorrectNameTariffValidatorTest() throws ValidationException {
        String name = "newTariffPlanNewTariffPlanNewTariffPlanNewTariffPlan";
        boolean result = TariffPlanValidator.getInstance().isNameValid(name);
        assertFalse(result);
    }

    @Test(groups = "validator" , priority = 26)
    public void correctNameTariffValidatorTest() throws ValidationException {
        String name = "Тариф план";
        boolean result = TariffPlanValidator.getInstance().isNameValid(name);
        assertTrue(result);
    }
}
