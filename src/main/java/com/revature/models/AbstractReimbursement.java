package com.revature.models;

import java.util.Objects;
import com.revature.models.Reimbursement;

/**
 * This AbstractReimbursement class defines a minimum functionality for
 * interacting with reimbursements in the ERS application.
 *
 * All reimbursements in this application must at least have:
 * <ul>
 *     <li>ID</li>
 *     <li>Status</li>
 *     <li>Author</li>
 *     <li>Resolver</li>
 *     <li>Amount</li>
 * </ul>
 *
 * Additional fields can be added to the concrete {@link com.revature.models.Reimbursement} class.
 *
 * @author Center of Excellence
 */
public class AbstractReimbursement {

    protected int reimbursement_id;
    protected int reimbursement_ammount;
    protected String reimbursement_submitted; 
    protected int reimbursement_author_fk;
    protected int reimbursement_status_fk;
    private int reimbursement_type_fk;

    public AbstractReimbursement(String string, String string2, String string3) {
        super();
    }

	public AbstractReimbursement() {
		super();
		
		this.reimbursement_id = reimbursement_id;
		this.reimbursement_ammount = reimbursement_ammount;
		this.reimbursement_submitted = reimbursement_submitted;
		this.reimbursement_author_fk = reimbursement_author_fk;
		this.reimbursement_status_fk = reimbursement_status_fk;
		this.reimbursement_type_fk = reimbursement_type_fk;
	}

	public AbstractReimbursement(int int1, int int2, String string, String string2, String string3, String string4,
			String sql) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AbstractReimbursement [reimbursement_id=" + reimbursement_id + ", reimbursement_ammount="
				+ reimbursement_ammount + ", reimbursement_submitted=" + reimbursement_submitted
				+ ", reimbursement_author_fk=" + reimbursement_author_fk + ", reimbursement_status_fk="
				+ reimbursement_status_fk + ", reimbursement_type_fk=" + reimbursement_type_fk + "]";
	}


	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + reimbursement_ammount;
		result = prime * result + reimbursement_author_fk;
		result = prime * result + reimbursement_id;
		result = prime * result + reimbursement_status_fk;
		result = prime * result + ((reimbursement_submitted == null) ? 0 : reimbursement_submitted.hashCode());
		result = prime * result + reimbursement_type_fk;
		return result;
	}
	
	
	
	
	
	
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractReimbursement other = (AbstractReimbursement) obj;
		if (reimbursement_ammount != other.reimbursement_ammount)
			return false;
		if (reimbursement_author_fk != other.reimbursement_author_fk)
			return false;
		if (reimbursement_id != other.reimbursement_id)
			return false;
		if (reimbursement_status_fk != other.reimbursement_status_fk)
			return false;
		if (reimbursement_submitted == null) {
			if (other.reimbursement_submitted != null)
				return false;
		} else if (!reimbursement_submitted.equals(other.reimbursement_submitted))
			return false;
		if (reimbursement_type_fk != other.reimbursement_type_fk)
			return false;
		return true;
	}

	public int getReimbursement_id() {
		return reimbursement_id;
	}

	public void setReimbursement_id(int reimbursement_id) {
		this.reimbursement_id = reimbursement_id;
	}

	public int getReimbursement_ammount() {
		return reimbursement_ammount;
	}

	public void setReimbursement_ammount(int reimbursement_ammount) {
		this.reimbursement_ammount = reimbursement_ammount;
	}

	public String getReimbursement_submitted() {
		return reimbursement_submitted;
	}

	public void setReimbursement_submitted(String reimbursement_submitted) {
		this.reimbursement_submitted = reimbursement_submitted;
	}

	public int getReimbursement_author_fk() {
		return reimbursement_author_fk;
	}

	public void setReimbursement_author_fk(int reimbursement_author_fk) {
		this.reimbursement_author_fk = reimbursement_author_fk;
	}

	public int getReimbursement_status_fk() {
		return reimbursement_status_fk;
	}

	public void setReimbursement_status_fk(int reimbursement_status_fk) {
		this.reimbursement_status_fk = reimbursement_status_fk;
	}

	public int getReimbursement_type_fk() {
		return reimbursement_type_fk;
	}

	public void setReimbursement_type_fk(int reimbursement_type_fk) {
		this.reimbursement_type_fk = reimbursement_type_fk;
	}

}
