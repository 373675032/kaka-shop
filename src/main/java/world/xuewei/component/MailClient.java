package world.xuewei.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 邮箱工具类
 *
 * @author XUEW
 */
@Component
public class MailClient {

    /**
     * 邮件发送器
     */
    @Autowired
    private JavaMailSenderImpl mailSender;

    /**
     * 邮件发送方
     */
    @Value("${spring.mail.username:}")
    private String fromEmail;

    /**
     * 发送账号密码
     */
    public void sendEmail(String email, String password) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setSubject("咖咖商城-忘记密码");
            helper.setText("<h2 >咖咖商城</h2>" + "您好像忘记了您在咖咖商城的账号密码，没关系，我来告诉您：<br><br>" + "登陆邮箱: <span style='color : red'>" + email + "</span><br>" + "登陆密码: <span style='color : red'>" + password + "</span><br>" + "<hr>" + "<h5 style='color : red'>如果并非本人操作,请忽略本邮件</h5>", true);
            helper.setFrom(fromEmail);
            helper.setTo(email);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(mimeMessage);
    }
}
