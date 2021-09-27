package by.epam.finalTask.Main;

import by.epam.finalTask.model.dao.ContractDao;

public class Main {

   public static void main(String[] args) throws Exception {
       ContractDao contractDao = new ContractDao();
       Long id = 4560411802945436838l;
       System.out.println(contractDao.findContractByUserId(id));
      // TariffPlanDao tariffPlanDao = new TariffPlanDao();
     //  List<TariffPlan> tariffPlanList = tariffPlanDao.findAll();
    //  System.out.println(tariffPlanList);
    //   RandomString gen = new RandomString(8, ThreadLocalRandom.current());
    //   CodeGenerate gen = new CodeGenerate(ThreadLocalRandom.current());
    //   System.out.println(gen.nextString());
      // MailSender.sendMail("likonpro999@gmail.com","subject","1");



      // UserDao userDao = new UserDao();
     // System.out.println(userDao.findUser("qwerdmin","1"));


     //  Random rd = new Random();
    //   System.out.println(rd.nextLong());
     //  Timestamp ts = Timestamp.from(Instant.now());
      // System.out.println(ts);
   // UserDao userDao = new UserDao();
     /* Map<String, String> parameters3 = new HashMap<>();
        parameters3.put("user_id", "11031");

        parameters3.put("email", "email");
        parameters3.put("login", "email1131");
        parameters3.put("password", "email2");
        parameters3.put("name", "email3");
        parameters3.put("surname", "email4");
        parameters3.put("phone", "1234567");
        parameters3.put("balance", "12.1");
        parameters3.put("registration_date", "2021-08-10 23:51:00.0");



        userDao.add(parameters3);

       Map<String, String> parameters4 = new HashMap<>();
        parameters4.put("name", "daun12");
        userDao.updateName(parameters4,"1");
*/
 // Map<String, String> parameters3 = new HashMap<>();
   //   parameters3.put("email", "000");

      // UserDao userDao = new UserDao();
  //  System.out.println(userDao.findById(11000l));
     //   TariffPlanDao tariffPlanDao = new TariffPlanDao();
     //   Map<String,String> p1 = new HashMap<>();
      ///  p1.put("tariff_plan_id","1");
     // / p1.put("name_tariff_plan","new_name");
      //  p1.put("price","25.0");
     //   p1.put("internet_connection_speed","150");
     //   p1.put("promotions_id_promotion","1");
      //  tariffPlanDao.addTariffPlan(p1);

    //  System.out.println(q);

    }
}

