package com.revature.repositories;

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
import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.util.ConnectionFactory;

public class ReimbursementDAO {

    /**
     * Should retrieve a Reimbursement from the DB with the corresponding id or an empty optional if there is no match.
     */
    public Optional<Reimbursement> getById(int id) {
        return Optional.empty();
    }

    /**
     * Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.
     */
    public List<Reimbursement> getByStatus(Status status) {
        return Collections.emptyList();
    }

    /**
     * <ul>
     *     <li>Should Update an existing Reimbursement record in the DB with the provided information.</li>
     *     <li>Should throw an exception if the update is unsuccessful.</li>
     *     <li>Should return a Reimbursement object with updated information.</li>
     * </ul>
     */
    public Reimbursement update(Reimbursement unprocessedReimbursement) {
    	return null;
    }

	public void updateReimbursement(String titleInput, int salaryInput) {
		// TODO Auto-generated method stub
		
	}
	
	 public void insertRemRq(AbstractReimbursement Reim){

	       try(  Connection conn = ConnectionFactory.getConnection()){
	    	   
	    	 
	    	   conn.setAutoCommit (false);
	    	   
	      /* 
	          
	          String sql3 = "INSERT INTO ers_reimbursement_status(status_id , reimbursement_status )"
	    				+ "VALUES(?,?)";
	    				
	          PreparedStatement pps= conn.prepareStatement(sql3);
	          
	          pps.setInt(1, Reim.getReimbursement_id() );
	          pps.setString(2, "PENDING");
	          
	      */    
	          String sql = "INSERT INTO ers_reimbursement(reimbursement_id, reimbursement_ammount,reimbursement_author_fk,reimbursement_status_fk,reimbursement_type_fk )"
	          				+ "VALUES(?,?,?,?,?)";
	          				
	          PreparedStatement ps = conn.prepareStatement(sql);
	          
	  		ps.setInt(1, Reim.getReimbursement_id());
			ps.setInt(2, Reim.getReimbursement_ammount());
		//	ps.setString(3, Reim.getReimbursement_submitted());
			ps.setInt(3, Reim.getReimbursement_author_fk());
			ps.setInt(4, Reim.getReimbursement_status_fk());
			ps.setInt(5, Reim.getReimbursement_type_fk());
	      
	          
	          ps.executeUpdate();
	          
	     
	     //     pps.executeUpdate();   
	     
	          conn.setAutoCommit (true);

	          System.out.println("New Reimb. Request for $" + Reim.getReimbursement_ammount() + " was logged");
	          }catch(Exception e) {
	         //	 System.out.println("Unable to add new Request");
	         	 e.printStackTrace();
	          }
	          }
	    
	   
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

					String sql = "SELECT * FROM ers_reimbursement;";
					rs = statement.executeQuery(sql);	
					List<AbstractReimbursement> searchReim = new ArrayList<>();

					while(rs.next()) {
						 
						//result = Reim.getInt("reimb_id");
						AbstractReimbursement newSearchA = new AbstractReimbursement(
								rs.getString("status_id"),
								rs.getString("reimbursement_status "), sql
								);
								
								
								
								
								
						searchReim.add(newSearchA);
					}
					
					return searchReim;
					
				} catch (SQLException e) {
					System.out.println("Unable to retrive infomation!");
					e.printStackTrace();
				}
			return null;
		}




	public List<AbstractReimbursement> GetReimbursementsbyStatus(String string) {
		
		try {
				Connection conn = ConnectionFactory.getConnection();
				
				ResultSet rs = null;	
				Statement statement = conn.createStatement();

				String sql = "SELECT reimbursement_id,reimbursement_status_fk, reimb_Author,reimbursement_author_fk FROM ers_reimbursement " +
				"WHERE ers_reimbursement_status = ers_reimbursement_status;";		
				
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



	public void reimbursementstatus() {


		try {
				Connection conn = ConnectionFactory.getConnection();
				
				ResultSet rs = null;	
				Statement statement = conn.createStatement();

	 			String sql = "SELECT * FROM  WHERE reimb_status_id;" + "VALUES(?,?,?,?,?,?)";;		
				
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

				String sql = "SELECT * FROM ers_reimbursement; ";		
				
				rs = statement.executeQuery(sql);	
				
				List<AbstractReimbursement> srs = new ArrayList<>();

				while(rs.next()) {
					 
						
						AbstractReimbursement a = new AbstractReimbursement(
								
								rs.getInt("reimbursement_id"),
								rs.getInt("reimbursement_ammount"),
								rs.getString("reimbursement_submitted"),
								rs.getString("reimbursement_author_fk"),
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

	    
	}






	  


