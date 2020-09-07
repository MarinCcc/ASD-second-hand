import java.text.MessageFormat;
import java.util.Properties;

// Class for test MongoDB Connection
public class Connect2mlabExample {

	public static void main(String[] args) throws Exception {
		
		Properties pt = new Properties();
		pt.load(Connect2mlabExample.class.getClassLoader().getResourceAsStream("email_template.properties"));
		String host = pt.getProperty("host");
		String uname = pt.getProperty("uname");
		String password = pt.getProperty("pwd");
		String from = pt.getProperty("from");
		String to = "574811625@qq.com";
		String subject =  pt.getProperty("subject");
		String content1 = "<a href=\"http://localhost:8080/UserServlet?method=active&code={0}\">Click here to active your account</a>";
		String content =  pt.getProperty("content");
		content = MessageFormat.format(content, "1234");
		content1 = MessageFormat.format(content1, "1234");
		System.out.println(content);
		System.out.println(content1);
//		Properties pt = new Properties();
//		Connect2mlabExample c = new Connect2mlabExample();
//		pt.load(c.getClass().getClassLoader().getResourceAsStream("email_template.properties"));
//		String host = pt.getProperty("host");
//		String uname = pt.getProperty("uname");
//		String password = pt.getProperty("pwd");
//		String from = pt.getProperty("from");
//		String to = "574811625@qq.com";
//		String subject =  pt.getProperty("subject");
//		String content =  pt.getProperty("content");
//
//		
//		content = MessageFormat.format(content, UUID.randomUUID());
//		Session session = MailUtils.createSession(host, uname, password);
//		Mail mail = new Mail(from,to,subject,content);
//		try {
//		
//			MailUtils.send(session, mail);
//			
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}
		
//		 ConnectionString connString = new ConnectionString(
//			    "mongodb://marin:a123456@ds019950.mlab.com:19950/heroku_p78k6xgn"
//			);
//			MongoClientSettings settings = MongoClientSettings.builder()
//			    .applyConnectionString(connString)
//			    .retryWrites(false)
//			    .build();
//			MongoClient mongoClient = MongoClients.create(settings);
//			MongoDatabase database = mongoClient.getDatabase("heroku_p78k6xgn");
		
//		    MongoDatabase database = MongoDBUtils.getConnect();
//			MongoCollection<Document> collection = database.getCollection("customer");
////			Bson filter = Filters.eq("email", "marin1@gmail.com");
////			FindIterable findIterable = collection.find(filter);
////			Document document = (Document) findIterable.first();
//			
//			collection.updateOne(Filters.eq("verfityCode", "4DBFC4B9D082404AA76B836446D6124C"), new Document("$set",new Document("status",true)));
//			
//			System.out.println(document);
			
//			Document result = collection.find(new Document("email","marin@gmail.com")).iterator().next();
//			System.out.println(result.getString("password"));
//			Document query = new Document("_id",new ObjectId("5f420d42e7179a2f18dc4bc5"));
//			Document result = collection.find(query).iterator().next();
//			System.out.println(result.getString("email"));
			//get a document which includes _id = 5f420d42e7179a2f18dc4bc5 , then print its email data
//			collection.insertOne(new Document("email","marin2@gmail.com").append("password", "a123456"));
			//insert a new document to customer collection
	}
	
	
	
	
	
}
