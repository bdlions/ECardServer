package org.bdlions.manager;

import org.bdlions.db.HibernateUtil;
import org.bdlions.dto.Company;
import org.bdlions.dto.Profile;
import org.bdlions.dto.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nazmul hasan
 */
public class UserManager {

    private final Logger logger = LoggerFactory.getLogger(UserManager.class);
    
    public User getUserByCredential(String identity, String password) {
        User user = null;
        try
        {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createSQLQuery("select {u.*} from user u where email = :email and password = :password")
                    .addEntity("u",User.class)
                    .setString("email", identity)
                    .setString("password", password);
            user = (User)query.uniqueResult();
            transaction.commit();
            session.close();
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            return null;
        }        
        return user;
    }
    
    public User getUserInfoById(int userId)
    {
        User user = null;
        try
        {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createSQLQuery("select {u.*} from user u where id = :id")
                    .addEntity("u",User.class)
                    .setInteger("id", userId);
            user = (User)query.uniqueResult();
            transaction.commit();
            session.close();
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            return null;
        }
        return user;
    }
    
    public Profile getUserProfileById(int userId)
    {
        Profile profile = null;
        try
        {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createSQLQuery("select {p.*} from profile p where user_id = :user_id")
                    .addEntity("p",Profile.class)
                    .setInteger("user_id", userId);
            profile = (Profile)query.uniqueResult();
            transaction.commit();
            session.close();
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            return null;
        }
        return profile;
    }
    
    public Company getUserCompanyById(int userId, int companyId)
    {
        Company company  = null;
        try
        {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            //if we have company id then we can query into company table, otherwise we have to query into profile table to get company id
            if(companyId == 0)
            {
                Query query = session.createSQLQuery("select {p.*} from profile p where user_id = :user_id")
                    .addEntity("p",Profile.class)
                    .setInteger("user_id", userId);
                Profile profile = (Profile)query.uniqueResult();
                companyId = profile.getCompanyId();
            }
            Query query = session.createSQLQuery("select {c.*} from company c where id = :id")
                    .addEntity("c",Company.class)
                    .setInteger("id", companyId);
            company = (Company)query.uniqueResult();
            transaction.commit();
            session.close();
            
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            return null;
        }
        return company;
    }
}
