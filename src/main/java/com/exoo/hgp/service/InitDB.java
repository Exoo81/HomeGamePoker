package com.exoo.hgp.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exoo.hgp.entity.Comment;
import com.exoo.hgp.entity.News;
import com.exoo.hgp.entity.Role;
import com.exoo.hgp.entity.User;
import com.exoo.hgp.entity.UserDetails;
import com.exoo.hgp.repository.CommentRepository;
import com.exoo.hgp.repository.NewsRepository;
import com.exoo.hgp.repository.RoleRepository;
import com.exoo.hgp.repository.UserDetailsRepository;
import com.exoo.hgp.repository.UserRepository;




@Service
public class InitDB {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Autowired
	private NewsRepository newsRepository;
	
	@Autowired
	private CommentRepository commentsRepository;
	
	
	@PostConstruct
	public void init(){
		createDB();
	}
	
	private void createDB(){
		
		/*ROLE*/
		Role adminRole = new Role();
		adminRole.setRoleName("ROLE_ADMIN");
		roleRepository.save(adminRole);
		
		Role playerRole = new Role();
		playerRole.setRoleName("ROLE_PLAYER");
		roleRepository.save(playerRole);
		
		/*USER ADMIN*/
		User adminUser = new User();
		adminUser.setUsername("exoo");
		adminUser.setPassword("klocek12");
		adminUser.setEnabled(true);
		List<Role> adminRolesList = new ArrayList<Role>();
			adminRolesList.add(adminRole);
			adminRolesList.add(playerRole);
		
		adminUser.setRoles(adminRolesList);
		userRepository.save(adminUser);
		
			/*USER ADMIN DETAILS */
			UserDetails adminUserDetails = new UserDetails();
			adminUserDetails.setFirstName("Marcin");
			adminUserDetails.setLastName("P");
			adminUserDetails.setAddress("52 Coill Clocha, Oranmore, Galway");
			adminUserDetails.setEmail("exoodus81@gmail.com");
			adminUserDetails.setPhotoURL("");					//TODO setpgoto in db
			adminUserDetails.setUser(adminUser);
			userDetailsRepository.save(adminUserDetails);
			
		/*USER PLAYER*/
		User player_1 = new User();
		player_1.setUsername("adam");
		player_1.setPassword("123456");
		player_1.setEnabled(true);
			List<Role> player_1_RoleList = new ArrayList<Role>();
			player_1_RoleList.add(playerRole);
			
		player_1.setRoles(player_1_RoleList);
		userRepository.save(player_1);
			
			/*PLAYER 1 USER  DETAILS */
			UserDetails player_1UserDetails = new UserDetails();
			player_1UserDetails.setFirstName("Adam");
			player_1UserDetails.setLastName("C");
			player_1UserDetails.setAddress("125 Dogishka, Galway");
			player_1UserDetails.setEmail("adam@someaddres.com");
			player_1UserDetails.setPhotoURL("");					//TODO setpgoto in db
			player_1UserDetails.setUser(player_1);
			userDetailsRepository.save(player_1UserDetails);
		
		
		User player_2 = new User();
		player_2.setUsername("Lolek");
		player_2.setPassword("123456");
		player_2.setEnabled(true);
			List<Role> player_2_RoleList = new ArrayList<Role>();
			player_2_RoleList.add(playerRole);
			
		player_2.setRoles(player_2_RoleList);
		userRepository.save(player_2);
		
			/*PLAYER 1 USER  DETAILS */
			UserDetails player_2UserDetails = new UserDetails();
			player_2UserDetails.setFirstName("Lolek");
			player_2UserDetails.setLastName("B");
			player_2UserDetails.setAddress("23 DTuam Rd, Galway");
			player_2UserDetails.setEmail("lolek@someaddres.com");
			player_2UserDetails.setPhotoURL("");					//TODO setpgoto in db
			player_2UserDetails.setUser(player_2);
			userDetailsRepository.save(player_2UserDetails);
				
			
		/*CREATING FAKE NEWS*/
		News news_1 = new News();
			news_1.setAuthor(adminUser);
			news_1.setTitle("First Admin news");
			news_1.setNewsTxt("<b>To</b> pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news "
					+ "To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news"
					+ "To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news"
					+ "To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news"
					+ "To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news"
					+ "To pierswzy news To pierswzy news To pierswzy news To pierswzy news"
					+ "To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news "
					+ "To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news"
					+ "To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news"
					+ "To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news"
					+ "To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news"
					+ "To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news"
					+ "To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news"
					+ "To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news To pierswzy news");
			
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd MMM yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss");
			Date publishDate = new Date();
			
			news_1.setPublishDate(publishDate);
			news_1.setEdited(false);
			/*news_1.setPublishDate(sdfDate.format(publishDate));*/
			/*news_1.setPublishTime(sdfTime.format(publishDate));*/
		newsRepository.save(news_1);
				
			//comments to news_1
				Comment comm1_1 = new Comment();
				comm1_1.setAuthor(player_2);
				comm1_1.setCommentText("sdf sfsdf sfs dfsd s sfsf sfr ser s ser sewrew  werwer w we ewr ");
				comm1_1.setNews(news_1);
				comm1_1.setPublishDate(new Date());
				commentsRepository.save(comm1_1);
			//comments to news_1
				Comment comm2_1 = new Comment();
				comm2_1.setAuthor(player_1);
				comm2_1.setCommentText("ok");
				comm2_1.setNews(news_1);
				comm2_1.setPublishDate(new Date());
				commentsRepository.save(comm2_1);
			//comments to news_1
				Comment comm3_1 = new Comment();
				comm3_1.setAuthor(adminUser);
				comm3_1.setCommentText("dsfnsdkl sdfjsdl  sdfjsdl  sdfs df sdf sdfjsl sdfjsljfls sdf sdf");
				comm3_1.setNews(news_1);
				comm3_1.setPublishDate(new Date());
				commentsRepository.save(comm3_1);
	
		
		News news_2 = new News();
		news_2.setAuthor(player_1);
		news_2.setTitle("Playwer 1 news");
		news_2.setNewsTxt("<b>To</b> drugi news przez playera 1 ... <b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ..."
				+ "<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ..."
				+ "<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ..."
				+ "<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ..."
				+ "<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ..."
				+ "<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ..."
				+ "<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ..."
				+ "<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ..."
				+ "<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ..."
				+ "<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ..."
				+ "<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ...<b>To</b> drugi news przez playera 1 ...");
		
			//Date publishDate = new Date();
		
		news_2.setPublishDate(publishDate);
		news_2.setEdited(false);
			/*news_2.setPublishDate(sdfDate.format(publishDate));
			news_2.setPublishTime(sdfTime.format(publishDate));*/
		newsRepository.save(news_2);
		
			//comments to news_2
				Comment comm1_2 = new Comment();
				comm1_2.setAuthor(player_2);
				comm1_2.setCommentText("dupa");
				comm1_2.setNews(news_2);
				comm1_2.setPublishDate(new Date());
				commentsRepository.save(comm1_2);
		//List<Comments> listOfCommentsForNews2 = new ArrayList<Comments>();
			//listOfCommentsForNews2.add(comm1_2);
			
			//news_2.setComments(listOfCommentsForNews2);
		
		
			
		
		News news_3 = new News();
		news_3.setAuthor(player_2);
		news_3.setTitle("Germany election: Merkel wins fourth term, exit polls say");
		news_3.setNewsTxt("German Chancellor Angela Merkel has been re-elected for a fourth term in federal elections, exit polls suggest.Her conservative CDU/CSU a"
				+ "lliance won 32.5% of the vote, remaining the largest party in Germany's parliament, according to the ARD poll.Its outgoing coalition partner, the "
				+ "social democratic SPD, said it would go into opposition after winning 20%.In a result which shocked many, the nationalist AfD was on track to win "
				+ "13.5%, making it the third party.Addressing supporters, Mrs Merkel said she had hoped for a better result and talked about extraordinary challenges"
				+ ".She would listen, she said, to the concerns and anxieties of AfD voters in order to win them back.The numbers mean the SPD, led by Martin Schulz, "
				+ "has fallen to a new post-World War Two low. Mr Schulz said the result was the end of the grand coalition with Mrs Merkel's alliance.It's a difficult"
				+ " and bitter day for social democrats in Germany, he told supporters. We haven't reached our objective.");
		
			//Date publishDate = new Date();
		news_3.setPublishDate(publishDate);
		news_3.setEdited(false);
			/*news_3.setPublishDate(sdfDate.format(publishDate));
			news_3.setPublishTime(sdfTime.format(publishDate));*/
		newsRepository.save(news_3);
		
		
		News news_4 = new News();
		news_4.setAuthor(adminUser);
		news_4.setTitle("Plane random text");
		news_4.setNewsTxt("Lorem ipsum dolor sit amet, consectetur adipiscing elit. At iam decimum annum in spelunca iacet. Hosne igitur laudas et hanc eorum, inquam,"
				+ " sententiam sequi nos censes oportere? Comprehensum, quod cognitum non habet? Duo Reges: constructio interrete. An haec ab eo non dicuntur? "
				+ "Habent enim et bene longam et satis litigiosam disputationem. Sed quid sentiat, non videtis. Nec vero alia sunt quaerenda contra Carneadeam "
				+ "illam sententiam. Iam id ipsum absurdum, maximum malum neglegi.Theophrastus mediocriterne delectat, cum tractat locos ab Aristotele ante "
				+ "tractatos? Qui ita affectus, beatum esse numquam probabis; Summus dolor plures dies manere non potest? An tu me de L. Quae diligentissime "
				+ "contra Aristonem dicuntur a Chryippo.Mihi vero, inquit, placet agi subtilius et, ut ipse dixisti, pressius. Nam et a te perfici istam "
				+ "disputationem volo, nec tua mihi oratio longa videri potest. Ut placet, inquit, etsi enim illud erat aptius, aequum cuique concedere."
				+ " Plane idem, inquit, et maxima quidem, qua fieri nulla maior potest. Isto modo ne improbos quidem, si essent boni viri. Quamquam tu hanc "
				+ "copiosiorem etiam soles dicere. Eam tum adesse, cum dolor omnis absit Idem iste, inquam, de voluptate quid sentit? Respondent "
				+ "extrema primis, media utrisque, omnia omnibus. Sit hoc ultimum bonorum, quod nunc a me defenditur; Primum in nostrane potestate est, "
				+ "quid meminerimus? Sin tantum modo ad indicia veteris memoriae cognoscenda, curiosorum. Nihil acciderat ei, quod nollet, nisi quod anulum,"
				+ " quo delectabatur, in mari abiecerat.Itaque rursus eadem ratione, qua sum paulo ante usus, haerebitis. Sed erat aequius"
				+ " Triarium aliquid de dissensione nostra iudicare. Quae similitudo in genere etiam humano apparet. Non autem hoc: igitur ne "
				+ "illud quidem. Quamvis enim depravatae non sint, pravae tamen esse possunt. Bestiarum vero nullum iudicium puto. Cuius quidem,"
				+ " quoniam Stoicus fuit, sententia condemnata mihi videtur esse inanitas ista verborum. Nummus in Croesi divitiis obscuratur, pars est tamen divitiarum.");
		
			//Date publishDate = new Date();
		news_4.setPublishDate(publishDate);
		news_4.setEdited(false);
		/*news_4.setPublishDate(sdfDate.format(publishDate));
			news_4.setPublishTime(sdfTime.format(publishDate));*/
		newsRepository.save(news_4);
		
		News news_5 = new News();
		news_5.setAuthor(player_1);
		news_5.setTitle("Piaty tytl");
		news_5.setNewsTxt("FlightAware continues to release improvements to the live e-mail and text message flight alerts. Users can receive live updates about "
				+ "flight plan filings (including expected IFR route), departures, arrivals, and diversions.If you don't already use flight alerts, simply click alert me"
				+ " on any flight page (at the top of the tracking box) or visit http://flightaware.com/live/alerts/ to manage your alerts. Make sure that your contact "
				+ "information in your profile is up to date, including your cell phone email address if you wish to receive mobile alerts. If you don't know your"
				+ "phone's email address, click What s my cell phone e-mail address? next to the Mobile E-mail Address form.Thanks for using FlightAware!");
		
			//Date publishDate = new Date();
		news_5.setPublishDate(publishDate);
		news_5.setEdited(false);
		/*news_5.setPublishDate(sdfDate.format(publishDate));
		news_5.setPublishTime(sdfTime.format(publishDate));*/
		newsRepository.save(news_5);
		
	}
}
