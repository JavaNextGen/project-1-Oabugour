package com.revature.models;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.revature.models.AbstractReimbursement;
import com.revature.models.Status;
import com.revature.util.ConnectionFactory;

/**
 * This concrete Reimbursement class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>Description</li>
 *     <li>Creation Date</li>
 *     <li>Resolution Date</li>
 *     <li>Receipt Image</li>
 * </ul>
 *
 */
public class Reimbursement extends AbstractReimbursement {

    public Reimbursement(int i, Status pending, User gENERIC_EMPLOYEE_1, Object object, double d) {
        super();
    }

    /**
     * This includes the minimum parameters needed for the {@link com.revature.models.AbstractReimbursement} class.
     * If other fields are needed, please create additional constructors.
     */


    public void insertRemRq(double amount , int author, int reimbid , int reimbus_id){

        try{
     	   Connection conn = ConnectionFactory.getConnection();
     	   conn.setAutoCommit (false);
     	   
            
	          String sql3 = "INSERT INTO ers_reimbursement_status(status_id serial, reimbursement_status )"
	    				+ "VALUES(?,?)";
      				
            PreparedStatement newUserSt2 = conn.prepareStatement(sql3);
            
            newUserSt2.setInt(1, reimbus_id );
            newUserSt2.setString(2, "PENDING");
           
     	   
	          String sql2 = "INSERT INTO ers_reimbursement(reimbursement_id, reimbursement_ammount,reimbursement_submitted,reimbursement_author_fk,reimbursement_status_fk,reimbursement_type_fk )"
        				+ "VALUES(?,?,?,?,?,?)";
           				
           PreparedStatement newUserSt = conn.prepareStatement(sql2);
           
           newUserSt.setInt(1, reimbus_id);
           newUserSt.setInt(2, reimbid);
           newUserSt.setInt(3, author);
           newUserSt.setDouble(4, amount);
          
           
           newUserSt2.executeUpdate();   
           newUserSt.executeUpdate();
        
           conn.setAutoCommit (true);

           System.out.println("New Reimb. Request for $" + amount + " was logged");
           }catch(Exception e) {
          //	 System.out.println("Unable to add new Request");
          	 e.printStackTrace();
           }
           }
     
    ////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public void UpdateRemRq(String newStatus, int requst_id, int new_Status_id){
    	
       try{Connection conn = ConnectionFactory.getConnection();
 	   conn.setAutoCommit (false);

          String sql3 = "UPDATE ers_reimbursement SET  )"
          				+ "reimb_status_id = ?, WHERE reimb_id = ?; ";
          				
          PreparedStatement newAppr = conn.prepareStatement(sql3);
          
          newAppr.setInt(1, new_Status_id);
          newAppr.setInt(2, requst_id);
          
         
          
	         String sql4 = "UPDATE ers_reimbursement_status SET  )"
	  				+ "reimbursement_status = ?, WHERE status_id serial = ? ; ";
   				
          PreparedStatement newAppr2 = conn.prepareStatement(sql4);
   
          newAppr2.setString(1, newStatus);
          newAppr2.setInt(2, requst_id);
          
         // newAppr2.executeUpdate();
         // newAppr.executeUpdate();
   
          conn.setAutoCommit (true);
   
          System.out.println("Reimburement" + requst_id + " was " + newStatus);
          
          }catch(Exception e) {
         	 System.out.println("Unable to update info");
          	 e.printStackTrace();

          }
       }
    /*
     * ******************
     */
    
    
 public List<AbstractReimbursement> GetReimbursementsbyId(int reimbursement_id) {
 	
 		try {
 			Connection conn = ConnectionFactory.getConnection();
 			
 			ResultSet rs = null;	
 			Statement statement = conn.createStatement();

			String sql = "SELECT reimbursement_id,ers_reimbursement_status, reimbursement_author_fk ,reimbursement_ammount FROM ers_reimbursement " +
			"WHERE reimbursement_id = '"+reimbursement_id+"';";			
 			
 			rs = statement.executeQuery(sql);	
 			List<AbstractReimbursement> searchReim = new ArrayList<>();

 			while(rs.next()) {
 				 
 				//result = Reim.getInt("reimb_id");
 				AbstractReimbursement a = new AbstractReimbursement(
					
						rs.getInt("reimbursement_id"),
						rs.getInt("reimbursement_ammount"),
						rs.getString("reimbursement_submitted"),
						rs.getString("reimbursement_author_fk "),
						rs.getString("reimbursement_status_fk"),
						rs.getString("reimbursement_type_fk"), sql
						);
						
 						
 				searchReim.add(a);
 			}
 			
 			return searchReim;
 			
 		} catch (SQLException e) {
 			System.out.println("Unable to retrive infomation!");
 			e.printStackTrace();
 		}
 	return null;
 }



 public List<AbstractReimbursement> GetReimbursementsbyStatus(int ers_reimbursement_status) {
 	
 	try {
 			Connection conn = ConnectionFactory.getConnection();
 			
 			ResultSet rs = null;	
 			Statement statement = conn.createStatement();

			String sql = "SELECT reimbursement_id,reimbursement_status_fk, reimb_Author,reimbursement_author_fk FROM ers_reimbursement " +
			"WHERE ers_reimbursement_status = '"+ers_reimbursement_status+"';";	
 			
 			rs = statement.executeQuery(sql);	
 			
 			List<AbstractReimbursement> srs = new ArrayList<>();

 			while(rs.next()) {
 				 
 					
 					AbstractReimbursement a = new AbstractReimbursement(
							rs.getInt("reimbursement_id"),
							rs.getInt("reimbursement_ammount"),
							rs.getString("reimbursement_submitted"),
							rs.getString("reimbursement_author_fk "),
							rs.getString("reimbursement_status_fk"),
							rs.getString("reimbursement_type_fk"), sql
 							);
 					srs.add(a);
 				}
 				
 				return srs;
 			
 		} catch (SQLException e) {
 			System.out.println("unable to retrive infomation!");
 			e.printStackTrace();
 		}
 	return null;
 }



 public void GetReimbursementsAll2() {


 	try {
 			Connection conn2 = ConnectionFactory.getConnection();
 			
 			ResultSet rs = null;	
 			Statement statement = conn2.createStatement();

			String sql = "SELECT reimbursement_id,reimbursement_status_fk, reimbursement_author_fk,reimbursement_ammount  FROM ers_reimbursement " +
			"WHERE ers_reimbursement_status = 1 ;";		
 			
 			rs = statement.executeQuery(sql);	
 			
 			List<AbstractReimbursement> searchReim = new ArrayList<>();

 			while(rs.next()) {
 				 
 					
 					AbstractReimbursement a = new AbstractReimbursement(
							rs.getInt("reimbursement_id"),
							rs.getInt("reimbursement_ammount"),
							rs.getString("reimbursement_submitted"),
							rs.getString("reimbursement_author_fk "),
							rs.getString("reimbursement_status_fk"),
							rs.getString("reimbursement_type_fk"), sql
							);
							
 							
 					searchReim.add(a);
 				}
 				
 				//return searchReim;
 			
 		} catch (SQLException e) {
 			System.out.println("unable to retrive infomation!");
 			e.printStackTrace();
 		}
 	//return null;
 }



 public List<AbstractReimbursement> GetReimbursementsAll() {


 	try {
 			Connection conn = ConnectionFactory.getConnection();
 			
 			ResultSet rs = null;	
 			Statement statement = conn.createStatement();

 			String sql = "SELECT reimbursement_id serial,reimbursement_status_fk, reimbursement_author_fk,reimbursement_ammount FROM ers_reimbursement " +
 			"WHERE reimb_status_id = 1 ;";		
 			
 			rs = statement.executeQuery(sql);	
 			
 			List<AbstractReimbursement> searchReim = new ArrayList<>();

 			while(rs.next()) {
 				 
 					
 					AbstractReimbursement newSearchA = new AbstractReimbursement(
							rs.getInt("reimbursement_id"),
							rs.getInt("reimbursement_ammount"),
							rs.getString("reimbursement_submitted"),
							rs.getString("reimbursement_author_fk "),
							rs.getString("reimbursement_status_fk"),
							rs.getString("reimbursement_type_fk"), sql
							);
							
 							
 					searchReim.add(newSearchA);
 				}
 				
 				return searchReim;
 			
 		} catch (SQLException e) {
 			System.out.println("unable to retrive infomation!");
 			e.printStackTrace();
 		}
 	return null;
 }




 public int maximumReimbId() {
 	int resultz = 0; 

 		try {
 		Connection conn2 = ConnectionFactory.getConnection();
 		
 		ResultSet rs = null;	
 		Statement statement = conn2.createStatement();
 		
 		String sql = "SELECT max(reimb_id) as reimbus_id FROM ers_reimbursement;";		
 		
 		rs = statement.executeQuery(sql);	

 		while(rs.next()) {
 			resultz = rs.getInt("reimbus_id");
 		}

 		return resultz;

 	} catch (SQLException e) {
 		System.out.println("Something went wrong selecting employees!");
 		e.printStackTrace();
 	}

 return resultz;
 }

 public int getId() {
 	// TODO Auto-generated method stub
 	return 0;
 }

     
 }






   






