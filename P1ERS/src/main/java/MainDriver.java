import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.dao.ReimbursementDaoHib;
import com.example.dao.UsersDao;
import com.example.dao.UsersDaoHib;
import com.example.model.Reimbursement;
import com.example.model.ReimbursementStatus;
import com.example.model.ReimbursementType;
import com.example.model.UserRoles;
import com.example.model.Users;
import com.example.services.UserServices;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UsersDaoHib uDao = new UsersDaoHib();
		UserServices uServ = new UserServices(uDao);
		
		Users u = uServ.signIn("BasilisJosue7988", "password");
		System.out.println(u);
		
		/*
		ReimbursementType t = new ReimbursementType();
		
		ReimbursementStatus s = new ReimbursementStatus();
		
		
		ReimbursementDaoHib aDao = new ReimbursementDaoHib();
		
		
		UserRoles ur = new UserRoles(1, "EMPLOYEE");
		UserRoles ur1 = new UserRoles(2, "FINANCE_MANAGER");
		//List<Reimbursement> tList = new ArrayList<Reimbursement>();
		//tList.add(a1);
		Users u = new Users("Josh", "Stanley", "jstanley@mail.com", "password", ur );
	   // rDao.getRoleId();
		uDao.create(u);
		
		Users u2 = new Users("Jojo", "Gray", "jgray@mail.com", "password", ur1 );
				   // rDao.getRoleId();
		uDao.create(u2);
		
		Users u3 = new Users( "Josue", "Basilis", "jbas@mail.com", "password", ur1 );
							  
								
		uDao.create(u3);					
				ReimbursementType t1 = new ReimbursementType(4, "OTHER");
				
				ReimbursementType t2 = new ReimbursementType(1, "TRAVEL");
				ReimbursementType t3 = new ReimbursementType(3, "LODGING");
				ReimbursementType t4 = new ReimbursementType(2, "FOOD");
				
				ReimbursementStatus s1 = new ReimbursementStatus(2, "DENIED");
				
				ReimbursementStatus s2 = new ReimbursementStatus(3, "APPROVED");
				ReimbursementStatus s3 = new ReimbursementStatus(1, "PENDING");
				//int amount, Date createDate, Date updateDate, String des, Users re,
				//ReimbursementStatus status, ReimbursementType type
				Reimbursement a1 = new Reimbursement(555, "Hungry", u3, u, s3, t2);
				aDao.create(a1);
				
				//Reimbursement a2 = new Reimbursement();
				//aDao.create(a2);
				
				//Reimbursement a3 = new Reimbursement();
				//aDao.create(a3);
				
				//Users u1 = new Users(77, "Joseph", "Bats", "jbas@mail.com", "password", new UserRoles(2, "FINANCE_MANAGER"));
				   // rDao.getRoleId();
					
						//	uDao.create(u1);
						//	Users u2 = new Users(75, "Jonah", "Bats", "jbas@mail.com", "password", new UserRoles(2, "FINANCE_MANAGER"));
							   // rDao.getRoleId();
								
							//			uDao.create(u2);
	//	a1.getReimbId()s.getStatusId();
		/*
		UserRoles r2 = new UserRoles("Finance Manager");
		
		rList = new ArrayList<Reimbursement>();
		rList.add(a2);
		rList.add(a1);
		Users u2 = new Users(2, "Josu", "Basilis", "jbas@mail.com", "password", r2, rList  );
		uDao.create(u2);
		
		rList = new ArrayList<Reimbursement>();
		rList.add(a3);
		Users u3 = new Users(3, "Jos", "Basilis", "jbas@mail.com", "password", r1, rList );
		uDao.create(u3);
		
		rList = new ArrayList<Reimbursement>();
		rList.add(a2);
		Users u4 = new Users(4, "Jo", "Basilis", "jbas@mail.com", "password", r2, rList );
		uDao.create(u4);
*/		
	}

}
