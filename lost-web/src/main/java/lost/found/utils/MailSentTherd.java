package lost.found.utils;

public class MailSentTherd extends Thread{
	

	String content;
	String reciveUser;
	String theme="四川理工失失物招领注册";
	public MailSentTherd(String c,String r,String clent,String passwd)
	{
		QQMailUtils.setMyEmailAccount(clent);
		QQMailUtils.setMyEmailPassword(passwd);
		content=c;
		reciveUser=r;
		
	}
	public MailSentTherd(String c,String r,String theme,String clent,String passwd)
	{
		QQMailUtils.setMyEmailAccount(clent);
		QQMailUtils.setMyEmailPassword(passwd);
		content=c;
		reciveUser=r;
		this.theme=theme;
	}
	public void run()
	{
	QQMailUtils.sent(reciveUser,content,theme);	
	}
	public static void main(String args[])
	{
		
		
		QQMailUtils.sent("2171319381@qq.com","leirong","232323223");	
		
		
	}
	
}
