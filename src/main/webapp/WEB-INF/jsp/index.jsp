index dashboard

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../tiles/taglib.jsp" %>


<c:url var="firstUrl" value="/news/1.html" />
<c:url var="lastUrl" value="/news/${deploymentNews.totalPages}.html" />
<c:url var="prevUrl" value="/news/${currentIndex - 1}.html" />
<c:url var="nextUrl" value="/news/${currentIndex + 1}.html" />


<div class="page-header">

	<a class="width-45 margin-5 btn btn-xlg btn-primary btn-poker-blue" href='<spring:url value="/news/add_news.html" />'>
		<i class="poker-red-icon fa fa-pencil-square-o fa-lg"></i>
		<span class="bigger-110 margin-5">Add news</span> 
	</a>

	<button class="width-45 margin-5 btn btn-xlg btn-primary btn-poker-blue">
		<i class="poker-red-icon fa fa-question-circle fa-lg"></i> 
		<span class="bigger-110 margin-5">Add survey</span>
	</button>
</div>

<c:forEach items="${newsList}" var="news">
	<div class="poker-news-panel">
		<p class="news-title poker-green">${news.title}</p>
		<p class="news-info-main">
			Posted by: ${news.author.username} &nbsp;&nbsp;&nbsp;&nbsp; 
			<span class="news-info-side smaller-80"><i class="fa fa-calendar"
				aria-hidden="true">&nbsp;&nbsp;</i>${news.publishDate} &nbsp;&nbsp;
				<i class="fa fa-clock-o" aria-hidden="true">&nbsp;</i>${news.publishTime}
			</span>
		</p>
		<hr class="hr-news">
		<p class="news-text">${news.newsTxt}</p>
		
		<hr class="hr-news">
		
		<p class="news-comment">
			<a class="poker-blue" data-toggle="collapse" href="#collapse-${news.id}" aria-expanded="false" aria-controls="collapseExample"> 
				<i class="fa fa-comments" aria-hidden="true">&nbsp</i>See comments
			<br>
			<i class="fa fa-angle-double-down" aria-hidden="true"></i>
			</a>
			
		</p>
		<div class="collapse" id="collapse-${news.id}">
			<div class="card card-block">
				Anim pariatur cliche
				reprehenderit, enim eiusmod high life accusamus terry richardson ad
				squid. Nihil anim keffiyeh helvetica, craft beer labore wes anderson
				cred nesciunt sapiente ea proident.
			</div>
		</div>
	</div>
</c:forEach>


<!-- PAGINATION -->

<c:if test="${deploymentDailyReports.totalPages != 0}">
	<div class="text-center">
		<nav class="pagination">
		
			<!-- first and next button -->
 			<c:choose>
			<c:when test="${currentIndex == 1 }">
				<a class="btn btn-pagination disabled" href="#"><span aria-hidden="true">&laquo;</span></a>
				<a class="btn btn-pagination disabled" href="#">&lt;</a>
				<!-- <a class="disapled" href="#" class="prev">&lt;&lt;</a>
				<a class="disapled" href="#" class="prev">&lt;</a> -->
				<!-- <li class="disabled"><a href="#"><span aria-hidden="true">&larr;</span></a></li>
				<li class="disabled"><a href="#">&laquo;</a></li> -->
			</c:when>
			<c:otherwise>
			<a href="${firstUrl}"><span aria-hidden="true">&larr;</span></a>
			<a href="${prevUrl}">&laquo;</a>
				<li><a href="${firstUrl}"><span aria-hidden="true">&larr;</span></a></li>
				<li><a href="${prevUrl}">&laquo;</a></li>
			</c:otherwise> 
		</c:choose>
		
		
		<!-- for each page results -->
		<c:forEach var="i" begin="${beginIndex }" end="${endIndex }">
			<c:url var="pageUrl" value="/news/${i}.html" />
			<c:choose>
				<c:when test="${i == currentIndex }">
					<a class="active" href="${pageUrl}"> <c:out
								value="${i}" />
					</a>
				</c:when>
				<c:otherwise>
					<a href="${pageUrl }"> <c:out value="${i}" />
					</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		
		<!-- last and previous button -->
		<c:choose>
			<c:when test="${currentIndex == deploymentNews.totalPages}">
				<a class="btn btn-pagination disabled"" href="#">&gt;</a>
				<a class="btn btn-pagination disabled"" href="#">Older <span
						aria-hidden="true">&raquo;</span></a>
			</c:when>
			<c:otherwise>
				<a href="${nextUrl}">&raquo;</a>
				<a href="${lastUrl}">Older <span aria-hidden="true">&rarr;</span></a>
			</c:otherwise>
		</c:choose>
		
      <!-- <a href="index.html" class="prev">&lt;</a> -->
      <!-- <a href="index.html">1</a>
      <a href="index.html">2</a>
      <a href="index.html">3</a>
      <span>4</span>
      <a href="index.html">5</a>
      <a href="index.html" class="next">&gt;</a> -->
    	</nav>
	<ul class="pagination">
		<!-- first and next button -->
		<c:choose>
			<c:when test="${currentIndex == 1 }">
				<li class="disabled"><a href="#"><span aria-hidden="true">&larr;</span></a></li>
				<li class="disabled"><a href="#">&laquo;</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${firstUrl}"><span aria-hidden="true">&larr;</span></a></li>
				<li><a href="${prevUrl}">&laquo;</a></li>
			</c:otherwise>
		</c:choose>

		<!-- for each page results -->
		<c:forEach var="i" begin="${beginIndex }" end="${endIndex }">
			<c:url var="pageUrl" value="/news/${i}.html" />
			<c:choose>
				<c:when test="${i == currentIndex }">
					<li class="active"><a href="${pageUrl}"> <c:out
								value="${i}" />
					</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageUrl }"> <c:out value="${i}" />
					</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<!-- last and previous button -->
		<c:choose>
			<c:when test="${currentIndex == deploymentNews.totalPages}">
				<li class="disabled"><a href="#">&raquo;</a></li>
				<li class="disabled"><a href="#">Older <span
						aria-hidden="true">&rarr;</span></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${nextUrl}">&raquo;</a></li>
				<li><a href="${lastUrl}">Older <span aria-hidden="true">&rarr;</span></a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
</c:if> --%>



