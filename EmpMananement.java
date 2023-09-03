package JDBC;
import java.util.*;
import java.sql.*;
public class EmpMananement {
	
	static void EmpMan()throws Exception 
	{
		
		Scanner sc=new Scanner(System.in);
		String user="system";
		String pass="123";
		
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
		Statement st=con.createStatement();
//		String query="Create table Empl(id int, Emp_Name varchar(20), Salary number)";
//		st.executeUpdate(query);
//		System.out.println("Succesfull");
//		con.close();
		
		for(int i=0;i<=4;i++)
		{
			System.out.println("\n \n 1.Add Employee \n2.Update Employee \n3.Delete Record \n4.view Data \n5.Exte");
			int ch=sc.nextInt();
			if(ch==5)
			{
				System.out.println("Thanks for Visiting Application");
				break;
			}
		
		
		switch (ch)
		{
			case 1:
				PreparedStatement ps=con.prepareStatement("Insert into Empl values(?,?,?)");
				System.out.println("Enter the Employee Id : ");
				int id=sc.nextInt();
				System.out.println("Enter the Empoloyee Name :");
				String name=sc.next();
				System.out.println("Enter the Eployee Salary : ");
				int sal=sc.nextInt();
				
				
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setInt(3, sal);
				int rs=ps.executeUpdate();
				if(rs>0)
				{
					System.out.println("Succesfully Added one Employee ");
					System.out.println("id \t Name \t \t` Salaray");
					System.out.println(id+"\t"+name+"\t"+"\t "+sal);
					
				}				
				con.close();
				break;
				
			case 2:
				System.out.println("Enter the Employee Id You wont to Update the data");
				int uid=sc.nextInt();
//				System.out.println("What update for employee \n1.ID \n2.Name \n3.Salary \n4.exit");
//				int ch1=sc.nextInt();
				PreparedStatement ps1;
				int res;
				for(int j=0;j<4;j++)
				{
					System.out.println("What update for employee \n1.ID \n2.Name \n3.Salary \n4.exit");
					int ch1=sc.nextInt();

					
				
					if(ch1==4)
					{
						break;
					}
						switch (ch1)
						{
							case 1:
								ps1=con.prepareStatement("Update Empl set id=? where id=?");
								System.out.println("Enter Employee Id ");
								int id1=sc.nextInt();
								ps1.setInt(1, id1);
								ps1.setInt(2,uid);
								res=ps1.executeUpdate();
								if(res>0)
								{
									System.out.println("Succesfully Update Id \n\n");
								}
								ps1.close();
								break;
							case 2:
								ps1=con.prepareStatement("Update Empl set Emp_Name=? where id=?");
								System.out.println("Enter Employee Name");
								String name1=sc.next();
								ps1.setString(1, name1);
								ps1.setInt(2, uid);
								int res1 = ps1.executeUpdate();
								if(res1>0)
								{
									System.out.println("Succesfully Update Name \n\n");
								}
						 
								ps1.close();
								break;
							case 3:
								ps1=con.prepareStatement("Update Empl set salary=? where id=?");
								System.out.println("Enter Employee Salary");
								int sal1=sc.nextInt();
					    
								ps1.setInt(1, sal1);
								ps1.setInt(2, uid);
								int res2=ps1.executeUpdate();
								if(res2>0)
								{
									System.out.println("Succesfully updated Salary \n\n");
								}
								ps1.close();
								break;
						}
				}
				
			case 3:
				PreparedStatement ps2=con.prepareStatement("Delete from Empl where id=?");
				System.out.println("Enter the Employee id for delet the record");
				int eid=sc.nextInt();
				ps2.setInt(1, eid);
				
				int r1=ps2.executeUpdate();
				if(r1>0)
				{
					System.out.println("succesfully deleted record \n\n");
				}
				con.close();
				break;
				
			case 4:
				Statement stmt=con.createStatement();
				String sql="Select *from Empl";
	
				ResultSet r4=stmt.executeQuery(sql);
				System.out.println("EMP_ID \tEMP_Name \tEMP_Salary");
				while(r4.next())
				{
					int id4=r4.getInt("ID");
					String name4=r4.getString("EMP_NAME");
					int  sal4=r4.getInt("Salary");
					
					System.out.print(id4+"\t");
					System.out.print(name4+"\t\t    ");
					System.out.print(sal4+"\n");
				}
				
		}
		con.close();
		}
	}

	public static void main(String[] args)throws Exception ,SQLException{
		// TODO Auto-generated method stub

		EmpMananement.EmpMan();
		

	}

}
