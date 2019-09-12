package com.junlaninfo;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;


/**
 *  发送QQ邮件
 *  方式①：发送邮件的简单代码
 *  方式②：发送邮件中添加附件
 *  方式③：发送HTML的邮件格式
 */
public class EmailTest {
 
     //发送邮件的简单代码
	@Test
    public void testSimpleEmail() throws Exception {
        SimpleEmail email = new SimpleEmail(); //创建一个最简单的email对象
        //这里我使用的是QQ，使用的是smtp服务器，需要身份验证，大家如果是使用其它服务器，可以自己去网上进行搜索
        email.setHostName("smtp.qq.com");
        //POP3服务器（端口995）
        //SMTP服务器（端口465或587）。
        email.setSmtpPort(465);
        //验证信息(发送的邮箱地址与密码) 注:这里的密码是授权码
        email.setAuthenticator(new DefaultAuthenticator("413669152@qq.com", "knvmfvcctegmcahh"));
        email.setSSLOnConnect(true); // 是否启用SSL
        email.setFrom("413669152@qq.com"); //发送邮件的地址(和验证信息的地址一样)
        email.setSubject("验证码");  //邮件的标题
        String code=vcode();
        
        email.setMsg("您的验证码是："+code); //邮件的内容
        email.addTo("413669152@qq.com"); //发送给哪一个邮件
        email.send();  //进行邮件发送
    }
 
     //发送邮件中添加附件
	@Test
    public void testEmailAttachment() throws Exception {
        EmailAttachment attachment = new EmailAttachment(); //创建一个附件对象
        attachment.setPath("D:\\package-lock.json");  //放一张项目中的图片(指向真实的附件)
        attachment.setDisposition(EmailAttachment.ATTACHMENT); //完成附件设置
        attachment.setDescription("这张图片是一个..."); //设置附件的描述
        attachment.setName("1.jpg"); //设置附件的名称
        //创建email对象(MultiPartEmail可以操作附件)
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.qq.com");
        email.setSmtpPort(465);
        //验证信息(发送的邮箱地址与密码) 注:这里的密码是授权码
        email.setAuthenticator(new DefaultAuthenticator("413669152@qq.com", "knvmfvcctegmcahh"));
        email.setSSLOnConnect(true); // 是否启用SSL
        email.setFrom("413669152@qq.com"); //发送邮件的地址(和验证信息的地址一样)
        email.addTo("413669152@qq.com");  //发送给哪一个邮件
        email.setSubject("这是一张图片"); //邮件标题
        email.setMsg("我发了一张图片给你看哦！");  //邮件内容
        email.attach(attachment); //把附件加到邮件中
        email.send(); //发送邮件
    }
 
    //发送HTML的邮件格式
    public void testHtml() throws Exception {
        HtmlEmail email = new HtmlEmail(); // 创建可以写Html的email对象
        email.setHostName("smtp.qq.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("xxx@qq.com", "填写你的授权码"));
        email.setSSLOnConnect(true); // 是否启用SSL
        email.setCharset("UTF-8");   //发送的时候如果乱码,配置相应的编码
        email.addTo("xxx@qq.com"); //发送给哪一个邮件
        email.setFrom("xxx@qq.com",  "xx");//xx为发件人名字
        email.setSubject("这里面写HTML，非常厉害");
        //设置HTML的信息
        String url = "https://www.baidu.com/";
        email.setHtmlMsg("<html><h1 style='color:green;'><a href="+url+">www.baidu.com</a></h1>点击进入百度</html>");
        //email.setTextMsg("这个就是很一般的显示"); //也可以配置普通的信息
        email.send();//发送邮件
    }
    /**
	 * 生成6位随机数验证码
	 * @return
	 */
	public static String vcode(){
		String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
	}	
 
}
