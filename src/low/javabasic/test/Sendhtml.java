/*
 * @(#) aa.java 2014-4-23
 * 
 * Copyright 2010 NetEase.com, Inc. All rights reserved.
 */
package low.javabasic.test;

/*
 * Copyright (c) 1998-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

/**
 * Demo app that shows how to construct and send a single part html message.
 * Note that the same basic technique can be used to send data of any type.
 *
 * @author John Mani
 * @author Bill Shannon
 * @author Max Spivak
 */

public class Sendhtml {

	private static final String sender = "xxx@xx.com";
	private static Properties props;
	private static Authenticator auth;
	private static String nick;

	static {
		props = new Properties();
		// 创建信件服务器
		props.put("mail.smtp.host", "");
		props.put("mail.smtp.auth", "true");
		props.put("mail.transport.protocol", "smtp");
		auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("user", "pass");
			}
		};
		try {
			nick = javax.mail.internet.MimeUtility.encodeText("text");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean sendMail(String to, String subject, String html, String[] filePath) {

		try {

			Session session = Session.getInstance(props, auth);
			// session.setDebug(true);
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(sender));

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

			// msg.setRecipients(Message.RecipientType.CC,InternetAddress.parse(cc,
			// false));

			msg.setSubject(subject);

			MimeBodyPart contentBody = new MimeBodyPart();
			contentBody.setDataHandler(new DataHandler(new ByteArrayDataSource(html, "text/html")));

			MimeMultipart allPart = new MimeMultipart("mixed");
			allPart.addBodyPart(contentBody);
			if (filePath != null) {
				for (String file : filePath) {
					MimeBodyPart attachmentPart = new MimeBodyPart();
					FileDataSource fds = new FileDataSource(file);
					attachmentPart.setDataHandler(new DataHandler(fds));
					attachmentPart.setFileName(fds.getName());
					allPart.addBodyPart(attachmentPart);
				}
			}
			msg.setContent(allPart);

			msg.setHeader("X-Mailer", nick);
			msg.setSentDate(new Date());

			// send the thing off
			Transport.send(msg);
			// logger.info("Mail was sent:" + to + " successfully.");
			return true;
		} catch (Exception e) {
			// logger.error(e);
		}
		return false;
	}

	public static void main(String[] args) {
		Sendhtml s = new Sendhtml();
		// String[] ss = { "/Users/test/Shell/1.sql" };
		s.sendMail("test@xx.com", "test", "gg", null);
	}
}