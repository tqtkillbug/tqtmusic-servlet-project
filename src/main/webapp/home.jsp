<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Music Creator</title>
    <meta name="theme-color" content="#000000">
	<meta name="viewport" content="width=device-width , initial-scale=1">
	<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
	<link rel="stylesheet" href="./css/home-css.css">
</head>
<body>

	<div class="main">
		<div class="progress_bar" id="Bar"></div>
		<img src="bgg.jpg" alt="" id="bg">

		<!-- navbar part -->
		<div class="navbar">
			<a href="#" id="logo"><i class='bx bxs-bar-chart-alt-2' ></i>&nbsp;Music</a>
            <a onclick="open_close_menu()" id="responsive_menu"><i class='bx bxs-chevron-down' ></i></a>

			<div class="nav_content">
				<li><a href="#">Home</a></li>
				<li><a href="#top_tracks">Tracks</a></li>
				<li><a href="#user_comments">Comments</a></li>
				<li><a href="#">Contact</a></li>
				<li><a href="#">${user.fullName}</a></li>
			</div>

            <a onclick="menu_action()" id="menu_btn"><i class='bx bx-menu-alt-left'></i></a>
			<div class="side_menu">
				<li><a href="#"><i class='bx bx-category'></i></a></li>
				<li><a href="#"><i class='bx bx-tv'></i></a></li>
				<li><a href="#"><i class='bx bxs-movie-play'></i></a></li>
				<li><a href="#"><i class='bx bxs-message-square-detail'></i></a></li>
				<li><a href="#"><i class='bx bx-merge'></i></a></li>
				<li><a href="#"><i class='bx bxs-cart-add'></i></a></li>
			</div>
		</div>
        
        <!-- tracks part -->
		<div class="top_tracks" id="top_tracks">
			<p id="heading"><i class='bx bxs-playlist'></i>&nbsp;&nbsp;Top Tracks</p>
			<div id="track"></div>
			<c:forEach var = "song" items="${listSong}">
				<c:choose>
					<c:when test="${song.status=='ALIVAIBLE'}">
						<div id="track">
							<img src="<c:out value = "${song.logoPath}"/>" alt="">
							<div id="actions">
								<a href="#"><i class='bx bx-heart' ></i></a>
								<a id="play_pause"><i class='bx bx-play'></i></a>
							</div>
							<audio src="<c:out value = "${song.songPath}"/>" id="music"></audio>
							<div id="song_desc">
								<p><c:out value = "${song.songName}"/></p>
								<p><c:out value = "${song.singerName}"/></p>
								<p id="total_download"><i class='bx bx-download'></i>&nbsp;&nbsp;2000+</p>
								<p id="message">New</p>
							</div>
							<div id="actions_2">
								<p><a href="#"><i class='bx bx-share' ></i></a></p>
								<p><a href="2.mp3" download><i class='bx bx-download'></i></a></p>
							</div>
						</div>
					</c:when>
					<c:otherwise>

					</c:otherwise>
				</c:choose>

			</c:forEach>

		</div>

        <!-- footer part -->
		<div class="footer">
			<a id="logo"><i class='bx bxs-bar-chart-alt-2' ></i>&nbsp;Music</a>
			<div class="social_handle">
				<i class='bx bxl-twitter' ></i>
				<i class='bx bxl-twitch'></i>
				<i class='bx bxl-github' ></i>
			</div>
		</div>

	</div>

  <!-- javascript file -->
  <script >
	  let btn = document.querySelectorAll('#track #play_pause');
let song = document.querySelectorAll('#music');

let song_index = 0;
let song_status = 0;
let index_no;

btn.forEach((btn,index) => {
  btn.addEventListener('click', function(){

  	if (song_index == 1) {
  		document.querySelector(".active_song").pause();
  		document.querySelector(".active_song").classList.remove("active_song");
  		document.querySelector(".active_btn").innerHTML = "<i class='bx bx-play'></i>";
  		document.querySelector(".active_btn").classList.remove("active_btn");
  	}else{
        song_index = 1;
  	}
  	
  	song[index].classList.add("active_song");
    this.classList.add("active_btn");

  	song[index].currentTime = 0;

  	if (song_status == 0) {
  		song[index].play();
  		song_status = 1;
  		setInterval(update_second, 1000);
  		index_no = index;
  		this.innerHTML = "<i class='bx bx-pause'></i>";
  	}else{
  		song[index].pause();
  		this.innerHTML = "<i class='bx bx-play'></i>";
  		song_status = 0;
  	}

  });
});

/*This function will be execute in Every Second*/
 function update_second(){
	if (song[index_no].ended) {
      btn[index_no].innerHTML = "<i class='bx bx-play'></i>";
      clearInterval(update_second);
    }
 }


/*side menu*/
function menu_action(){
	let side_nav = document.querySelector('.side_menu');
    side_nav.classList.toggle("side_nav_active");
}

/*main menu*/
function open_close_menu(){
	let nav_content = document.querySelector('.nav_content');
    nav_content.classList.toggle("active_top_navbar");
}



// Function execute When the user scrolls the page
window.onscroll = () =>{

  var winScroll = document.body.scrollTop || document.documentElement.scrollTop;
  var height = document.documentElement.scrollHeight - document.documentElement.clientHeight;
  var scrolled = (winScroll / height) * 100;
  document.getElementById("Bar").style.width = scrolled + "%";
}


  </script>
</body>
</html>

<!-- by Dev Ideas -->