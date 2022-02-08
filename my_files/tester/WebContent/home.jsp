<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">
<style>
* {
box-sizing: border-box;
font-family: "Lucida Sans", sans-serif;

}



.header {
color: rgb(0, 0, 0);
display: inline-block;
text-align: center;
width:100%;

}


.bg {
	
color: slategrey;
width: 100%;
background-image: url("https://i.ibb.co/XzdT8G5/back4.png");
text-align: center;
background-size: 100%;

font-size: 25px;
}

.logo {
width: 7%;

}
.rights{
background-color: MediumSlateBlue;
color: black;
text-align: center;
width:100%;
margin-top: 8%;
padding-bottom:1%;

}
.rights2{
color: brown;
width:100%;
margin: 0%;

}

.media{
margin: 0%;
display: inline-block;
text-align: right;
font-size:20px;
background-color: MediumSlateBlue;
width:100%;
color: white;



}


.footer {
width: 100%;
padding: 0%;
text-align: left;
display: inline-block;


font-size: 25px;
}

.media img{
width:30px;
height:30px;
border-radius: 5px;
}


a:link,
a:visited {
text-align: center;
display: inline-block;
padding: 15px ;
color: black;
text-decoration: none;
}

a:hover,
a:active {

cursor: pointer;

}

.rows {
padding: 10px;
font-size: 2px;
width: 100%;
display: flex;

}

.register {
text-align: center;
width: 100%;
padding: 0px;
margin-top: 0px;
}

.registerbg {
width:99,9%;
background-image: url("https://i.ibb.co/XzdT8G5/back4.png");
padding: 0%;
margin: 0%;
}

.row {
font-size: 20px;
width: 30%;
margin-left:35%;
border-radius:10px;
color: MediumSlateBlue;
text-align: center;
background-color: mintcream;
margin-top: 0%;
}

.regrow {
font-size: 20px;
width: 30%;
color: MediumSlateBlue;
text-align: center;
background-color: mintcream;
margin-left:35%;
border-radius:20px;
padding-bottom:9%;

}


.button {
border: none;
color: white;
padding: 9px;
text-align: center;
text-decoration: none;
display: inline-block;
font-size: 20px;
background-color: MediumPurple;
border-radius: 5px;

}


.button:hover {
background-color: firebrick;
cursor: pointer;

}

.button:active {
background-color: brown;
box-shadow: 0 5px #666;
transform: translateY(4px);
}




.background h1{
text-align: center;
}
.row3 {
padding-top: 1%;
padding-bottom: 1%;
padding-left: 1%;
padding-right: 1%;
font-size: 10%;
width:100%;
background-color: rgb(243, 214, 171);
color: black;
display: flex;

border-radius: 8px;

}


</style>
<title>Local Cinema</title>
</head>


<body>
	
    <div class="header ">
     <div class="rows " >
    <div class="footer ">
        	<img class="logo" src="https://i.ibb.co/VDngS9Z/logo.png   "/>
    
        <a href="home.jsp ">Home </a>

 

            <a href="register ">Register </a>
    

          
       </div>
    </div>
    </div>
                
    
    <div class="bg"  >
        <h2>Welcome to the</h2>
        <h2> Local Cinema!</h2> 
    
   
       
        <div class ="row ">
  		<form action="<%=request.getContextPath()%>/home" method="post">
            <br>Username:<br>
            <input type="text" id="nick" name="username" required>
            <div class="wrapper">
                <br>Password:
                <br><input type="password" id="password2" name="password" required><br>
              </div>
               <div class="rights2">
                 <h6>New here?
                <a href="register " >Sign Up!
                </a></h6>
            </div>
                <input type="submit" class="button" value="submit" name="submit">            <br><br>
        </form>
        </div>
        <br><br>
   
    <div class="rights">
</div>
        <div class="media">
        follow us!
        
        <a target="_blank" href="http://www.facebook.com/">
            <img src="https://i.ibb.co/6419RPn/fb.png"/>

          </a>
          <a target="_blank" href="http://www.instagram.com/">
            <img src="https://i.ibb.co/XbWFwq4/insta.png" />
          </a>
          <a target="_blank" href="http://www.twitter.com/">
<img src="https://i.ibb.co/tMwzCHp/twitter.png"/>          </a>
        </div>
    </div>
</body>
</html>