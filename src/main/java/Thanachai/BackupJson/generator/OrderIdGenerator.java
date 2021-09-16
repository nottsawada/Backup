//package Thanachai.BackupJson.generator;

//import org.hibernate.HibernateException;
//import org.hibernate.engine.spi.SharedSessionContractImplementor;
//import org.hibernate.id.IdentifierGenerator;

//import java.io.Serializable;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

//public class OrderIdGenerator  implements IdentifierGenerator {
  //  @Override
    //public Serializable generate(SharedSessionContractImplementor session, Object o) throws HibernateException {

      //  Connection connection = session.connection();
        //try{
//
  //          Statement statement = connection.createStatement();
    //        ResultSet rs = statement.executeQuery("select count(*) as Id from backup");
//
  //          if(rs.next()){
//
  ///              long id=rs.getInt(1)+101;
//
  //              return id;
    //        }

  //      }catch (Exception e){

    //        e.printStackTrace();
      //  }


        //return null;
    //}


//}
