package javastudy25days.Day08;

/*
�������ݿ�Ĳ�����
�����ǣ��û���Ϣ
1.�������ݿ⡣JDBC Hibernate
2.�������ݿ�
	c	create
	r	read
	u	update
	d	delete
3.�ر����ݿ�����

*/
interface UserInfoDao
{
	public void add();
	public void delete();
}


class UserInfoByJDBC implements UserInfoDao
{
	public void add(/*User user*/)
	{
		/*
		1.JDBC�������ݿ⡣
		2.ʹ��sql�������������
		3.�ر�����

		 */
	}
	public void delete(/*User user*/)
	{
		/*
		1.JDBC�������ݿ⡣
		2.ʹ��sql������ɾ������
		3.�ر�����

		 */
	}
}

class UserInfoByHibernate implements UserInfoDao
{
	public void add(/*User user*/)
	{
		/*


		1.Hibernate�������ݿ⡣
		2.ʹ��sql�������������
		3.
		 */
	}
	public void delete(/*User user*/)
	{
		/*
		1.Hibernate�������ݿ⡣
		2.ʹ��sql������ɾ������
		3.�ر�����

		 */
	}
}

class DBOperate
{
	public static void main(String[] args)
	{
		
		//UserInfoByJDBC ui = new UserInfoByJDBC();
		//UserInfoByHibernate ui = new UserInfoByHibernate();
		UserInfoDao ui = new UserInfoByJDBC();
		ui.add();
		ui.delete();
	}
}